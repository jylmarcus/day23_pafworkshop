package paf.visa.day23_pafworkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.visa.day23_pafworkshop.model.Order;
import paf.visa.day23_pafworkshop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    
    @Autowired
    OrderService orderSvc;

    @GetMapping("/total/{id}")
    public ResponseEntity<List<Order>> getOrderById(@PathVariable Integer id) {
        List<Order> orders = orderSvc.getOrderById(id);
        if(orders.isEmpty()) {
            //something about errors
        }

        return ResponseEntity.ok().body(orders);
    }
}
