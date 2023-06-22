package paf.visa.day23_pafworkshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import paf.visa.day23_pafworkshop.model.Order;
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
        HttpEntity<String> entity = new HttpEntity<String>("parameters");
        ResponseEntity<List<Order>> result = template.exchange(API_URL + "/" + orderId, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Order>>(){});
        return result.getBody();

    }

    public List<Integer> getOrderIds() {
        return orderRepository.getAllOrderIds();
    }
}
