package com.deliveryapp.deliverytimecalculator.restaurant;

import com.deliveryapp.deliverytimecalculator.restaurant.dish.DishType;
import com.deliveryapp.deliverytimecalculator.restaurant.order.Order;

public class Restaurant {

	private String name;
	private short slots;
	private final int MAX_ORDER_DELIVERY_TIME_ALLOWED;
	private final int distanceToTimeUnit;

	public Restaurant(String name, short slots) {
		this.name = name;
		this.slots = slots;
		this.MAX_ORDER_DELIVERY_TIME_ALLOWED = 150;
		this.distanceToTimeUnit = 8;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getSlots() {
		return slots;
	}

	public void setSlots(short slots) {
		this.slots = slots;
	}

	/*
	 * Input: Order from a customer with orderId, Distance of customer from
	 *        restaurant, Dishes needed to be delivered. 
	 * Output: Total time needed to deliver items to the customer. 
	 *         returns PreparationTime + travelTimeToDeliverFood (in minutes)
	 */
	public double getOrderDeliveryTime(Order customerOrder) {
		double travelTimeToDeliverFood = customerOrder.getDistance() * distanceToTimeUnit;
		if (travelTimeToDeliverFood > MAX_ORDER_DELIVERY_TIME_ALLOWED) {
			return -1;
		}

		DishType[] customerItems = customerOrder.getCustomerOrders(); // All items ordered by a customer in 1 order.
		
		if(slots<customerItems[0].getSlotsConsumed()) {
			return -1;
		}
		double preparationtime = customerItems[0].getPreparationTime(); // Initialize preparation time with time taken to
																		// prepare 1st item.
		slots -= customerItems[0].getSlotsConsumed(); //Mark restaurant slots occupied for 1st item.

		for (int i = 1; i < customerItems.length; i++) {
			if (slots < customerItems[i].getSlotsConsumed()) { // All items ordered by customer needs more than DEFAULT
																// slots of 7
				return -1;
			}
			preparationtime += customerItems[i].getPreparationTime() - customerItems[0].getPreparationTime();
			slots -= customerItems[i].getSlotsConsumed();
			if(preparationtime > MAX_ORDER_DELIVERY_TIME_ALLOWED) {//Order preparation is taking longer than restaurant limits.
				return -1;
			}
		}
		
		return preparationtime + travelTimeToDeliverFood;
	}
	
	public boolean isDeliveryTimeWithinThreshold(double time) {
		return time != -1;
	}

}
