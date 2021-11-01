package com.deliveryapp.deliverytimecalculator.restaurant.dish;

public class MainCourse extends DishType {
	
	private double preparationTime;
	private int slotConsumption;
	
	public MainCourse(double preparationTime, int slotConsumption) {
		this.preparationTime = preparationTime;
		this.slotConsumption = slotConsumption;
	}

	@Override
	public double getPreparationTime() {
		return preparationTime;
	}

	@Override
	public int getSlotsConsumed() {
		return slotConsumption;
	}
}
