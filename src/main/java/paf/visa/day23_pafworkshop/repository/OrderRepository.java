package paf.visa.day23_pafworkshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.visa.day23_pafworkshop.model.Order;

@Repository
public class OrderRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String selectOrderById = "select ord.id as id, ord.order_date as order_date, " + 
    "ord.customer_id as customer_id, ordd.product_id as product_id, " + 
    "ordd.quantity*ordd.unit_price*(1-ordd.discount) as total, " +
    "ordd.quantity*prod.standard_cost as cost_price from orders ord " +
    "join order_details ordd on ord.id = ordd.order_id " + 
    "join products prod on prod.id = ordd.product_id " +
    "where ord.id = ?";

    private final String selectAllOrderIds = "select distinct ord.id as id from orders ord " +
    "join order_details ordd on ord.id = ordd.order_id " + 
    "join products prod on prod.id = ordd.product_id ";

    public List<Order> getOrderById(Integer id){
        return jdbcTemplate.query(selectOrderById, BeanPropertyRowMapper.newInstance(Order.class), id);
    }

    public List<Integer> getAllOrderIds() {
        return jdbcTemplate.queryForList(selectAllOrderIds, Integer.class);
    }
}
