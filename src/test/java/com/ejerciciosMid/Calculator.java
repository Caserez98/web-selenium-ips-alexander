package com.ejerciciosMid;

public class Calculator {
	Floor floor;
	Carpet carpet;
	
	Calculator(Floor floor, Carpet carpet){
		this.carpet=carpet;
		this.floor=floor;
	}
	
	public double getTotalCost() {
		double totalCost=carpet.getCost()*floor.getArea();
		return totalCost;
	}
	
}
