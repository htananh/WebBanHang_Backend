package com.tananh.service;

import java.util.List;

import com.tananh.exception.OrderException;
import com.tananh.model.Address;
import com.tananh.model.OrderPr;

import com.tananh.model.User;

public interface OrderService {

	public OrderPr createOrder(User user, Address address);
	public OrderPr findOrderByid(Long id);
	public List<OrderPr> UserOrderHistory(Long userId);
	
	public OrderPr placedOrder(Long orderId) throws OrderException;
	public OrderPr comfirmedOrder(Long orderId)throws OrderException;
	public OrderPr shippedOrder(Long orderId)throws OrderException;
	public OrderPr deviveredOrder(Long orderId)throws OrderException;
	public OrderPr cancledOrder(Long orderId)throws OrderException;
	
	public List<OrderPr> getAllOrder();
	public String deleteOrder(Long orderId)throws OrderException;
}
