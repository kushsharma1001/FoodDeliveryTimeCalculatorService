package com.deliveryapp.deliverytimecalculator.restaurant.order;

import com.deliveryapp.deliverytimecalculator.restaurant.dish.DishType;

public class Order {

	private int orderId;
	private DishType[] customerOrders;
	private double distance;

	public Order(int orderId, DishType[] customerOrders, double distance) {
		super();
		this.orderId = orderId;
		this.customerOrders = customerOrders;
		this.distance = distance;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public DishType[] getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(DishType[] customerOrders) {
		this.customerOrders = customerOrders;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}