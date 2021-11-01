package com.deliveryapp.deliverytimecalculator.restaurant.dish;

public abstract class DishType {

	private double preparationTime;
	private int slotConsumption;

	public abstract double getPreparationTime();
	public abstract int getSlotsConsumed();
}
