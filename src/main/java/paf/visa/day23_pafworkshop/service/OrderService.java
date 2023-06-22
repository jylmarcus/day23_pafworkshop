package paf.visa.day23_pafworkshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import paf.visa.day23_pafworkshop.model.Order;
import paf.visa.day23_pafworkshop.model.OrderList;
import paf.visa.day23_pafworkshop.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    private final String API_URL = "http://localhost:4000/order/total";

    public List<Order> getOrderById(Integer id) {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getOrderById(String orderId) {
        RestTemplate template = new RestTemplate();
        OrderList result = template.getForObject(API_URL + "/" + orderId, OrderList.class);
        return result.getOrderList();

    }

    public List<Integer> getOrderIds() {
        return orderRepository.getAllOrderIds();
    }
}
