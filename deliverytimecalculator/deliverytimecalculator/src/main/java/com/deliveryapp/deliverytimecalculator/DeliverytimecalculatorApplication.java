package com.deliveryapp.deliverytimecalculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deliveryapp.deliverytimecalculator.restaurant.Restaurant;
import com.deliveryapp.deliverytimecalculator.restaurant.dish.Appetizer;
import com.deliveryapp.deliverytimecalculator.restaurant.dish.DishType;
import com.deliveryapp.deliverytimecalculator.restaurant.dish.MainCourse;
import com.deliveryapp.deliverytimecalculator.restaurant.order.Order;

@SpringBootApplication
public class DeliverytimecalculatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeliverytimecalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		short restaurantMaxSlots = 7;
		Restaurant restaurant = new Restaurant("Mojo Jojo", restaurantMaxSlots);
		
		DishType appetizer = new Appetizer(17, 1);
		DishType mainCourse = new MainCourse(29, 2);
		
		Order[] liveOrders = getCustomerLiveOrders(appetizer, mainCourse);
		
		for(Order customerOrder: liveOrders) {
			double deliveryTime = restaurant.getOrderDeliveryTime(customerOrder);
			if(!restaurant.isDeliveryTimeWithinThreshold(deliveryTime)) {
				System.out.println("Order " + customerOrder.getOrderId() + " is denied because the restaurant cannot accommodate it.");
			}
			else {
				System.out.println("Order " + customerOrder.getOrderId() + " will get delivered in " + deliveryTime + " minutes.");
			}
			restaurant.setSlots(restaurantMaxSlots);
		}
		
	}

	private Order[] getCustomerLiveOrders(DishType appetizer, DishType mainCourse) {
		Order order1 = new Order(12, new DishType[] {appetizer, appetizer}, 5);
		Order order2 = new Order(21, new DishType[] {appetizer, mainCourse}, 1);
		Order order3 = new Order(32, new DishType[] {mainCourse}, 0.1);
		Order order4 = new Order(14, new DishType[] {mainCourse, mainCourse, mainCourse, mainCourse, appetizer, appetizer, appetizer}, 10);
		Order order5 = new Order(22, new DishType[] {appetizer}, 3);
		return new Order[] {order1, order2, order3, order4, order5};
	}

}
