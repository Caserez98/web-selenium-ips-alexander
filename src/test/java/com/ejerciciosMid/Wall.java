package com.ejerciciosMid;

public class Wall {
	private double width;
	private double height;
	
	Wall(){
		
	}
	Wall(double width, double height){
		if(width<0 && height<0) {
			this.width=6.0;
			this.height=0.0;
		}else {
			this.height=height;
			this.width=width;	
		}
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return this.getHeight() * this.getWidth();
	}
	
}