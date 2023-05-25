package com.uni.baker.service;

import com.uni.baker.entity.Order;
import com.uni.baker.repository.ICategoryRepository;
import com.uni.baker.repository.IOrderRepository;
import com.uni.baker.utils.SlugUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id)
    {
        return orderRepository.findById(id).orElse(null);
    }
    public Order save(Order order)
    {
        return orderRepository.save(order);
    }


    public void deleteOrder(Long id)
    {
        orderRepository.deleteById(id);
    }
    public void updateOrder(Order order)
    {
        save(order);
    }
}
