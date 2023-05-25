package com.uni.baker.controller;

import com.uni.baker.entity.Category;
import com.uni.baker.entity.Order;
import com.uni.baker.service.CategoryService;
import com.uni.baker.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public String showAllCategories(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/list";
    }
    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") Long id, Model model) {
        Order editOrder = orderService.getOrderById(id);
        model.addAttribute("orders", orderService.getAllOrders());
        if(editOrder != null) {
            model.addAttribute("order", editOrder);
            return "admin/order/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editOrder(@ModelAttribute("order") Order updatedOrder) {
        orderService.updateOrder(updatedOrder);
        return "redirect:/admin/order";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderForm(@PathVariable("id") Long id, Model model) {
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }
}
