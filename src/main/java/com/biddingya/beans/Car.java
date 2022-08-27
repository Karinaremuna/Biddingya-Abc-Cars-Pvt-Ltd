package com.biddingya.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int carId;
 private String carModel;
 private String carMake;
 private String carYear;
 private String carPrice;
 private String carBodyStyle;
 private String carColor;
 private String carVIN;
 private String carCondition;
 
 public Car() {
	 
 }

public Car(int carId, String carModel, String carMake, String carYear, String carPrice, String carBodyStyle,
		String carColor, String carVIN, String carCondition) {
	super();
	this.carId = carId;
	this.carModel = carModel;
	this.carMake = carMake;
	this.carYear = carYear;
	this.carPrice = carPrice;
	this.carBodyStyle = carBodyStyle;
	this.carColor = carColor;
	this.carVIN = carVIN;
	this.carCondition = carCondition;
}

public int getCarId() {
	return carId;
}

public void setCarId(int carId) {
	this.carId = carId;
}

public String getCarModel() {
	return carModel;
}

public void setCarModel(String carModel) {
	this.carModel = carModel;
}

public String getCarMake() {
	return carMake;
}

public void setCarMake(String carMake) {
	this.carMake = carMake;
}

public String getCarYear() {
	return carYear;
}

public void setCarYear(String carYear) {
	this.carYear = carYear;
}

public String getCarPrice() {
	return carPrice;
}

public void setCarPrice(String carPrice) {
	this.carPrice = carPrice;
}

public String getCarBodyStyle() {
	return carBodyStyle;
}

public void setCarBodyStyle(String carBodyStyle) {
	this.carBodyStyle = carBodyStyle;
}

public String getCarColor() {
	return carColor;
}

public void setCarColor(String carColor) {
	this.carColor = carColor;
}

public String getCarVIN() {
	return carVIN;
}

public void setCarVIN(String carVIN) {
	this.carVIN = carVIN;
}

public String getCarCondition() {
	return carCondition;
}

public void setCarCondition(String carCondition) {
	this.carCondition = carCondition;
}

@Override
public String toString() {
	return "Car [carId=" + carId + ", carModel=" + carModel + ", carMake=" + carMake + ", carYear=" + carYear
			+ ", carPrice=" + carPrice + ", carBodyStyle=" + carBodyStyle + ", carColor=" + carColor + ", carVIN="
			+ carVIN + ", carCondition=" + carCondition + "]";
}
 
}
