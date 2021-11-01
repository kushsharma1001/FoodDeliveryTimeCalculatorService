package com.deliveryapp.deliverytimecalculator.restaurant.dish;

public class Appetizer extends DishType {
	
	private double preparationTime;
	private int slotConsumption;
	
	public Appetizer(int preparationTime, int slotConsumption) {
		super();
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
