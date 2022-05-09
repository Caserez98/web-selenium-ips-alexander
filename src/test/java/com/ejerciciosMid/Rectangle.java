package com.ejerciciosMid;


public class Rectangle {
	private double width;
	private double length;
	
	Rectangle(double width, double length){
		if(width<0 && length<0) {
			this.length=0;
			this.width=0;
		}else {
			this.length=length;
			this.width=width;
		}
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
	public double getArea() {
		return this.getLength()*this.getWidth();
	}
	
}