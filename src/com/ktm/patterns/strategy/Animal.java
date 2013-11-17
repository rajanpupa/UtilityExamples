package com.ktm.patterns.strategy;

public abstract class Animal {
	public String name;
	public int height;
	public int weight;
	
	Flys flyingObject;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	public void setWeight(int Weight){
		this.weight = Weight;
	}
	public int getWeight(){
		return weight;
	}
	
	public void fly(){
		flyingObject.fly();
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal bird = new Peacock();
		
		dog.fly();
		bird.fly();
	}
}
