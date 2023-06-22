package paf.visa.day23_pafworkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.visa.day23_pafworkshop.model.OrderList;
import paf.visa.day23_pafworkshop.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    OrderService orderSvc;
    
    @GetMapping("/")
    public String getIndex(Model model) {
        List<Integer> orderIds = orderSvc.getOrderIds();
        model.addAttribute("orderList", orderIds);
        return "order";
    }

    @GetMapping("/order/total/")
    public String getOrder(@RequestParam(name="orderId") String orderId, Model model) {
        OrderList orders = new OrderList();
        orders.setOrderList(orderSvc.getOrderById(orderId));
        model.addAttribute("orderList", orders.getOrderList());
        return "showOrders";
    }
}
