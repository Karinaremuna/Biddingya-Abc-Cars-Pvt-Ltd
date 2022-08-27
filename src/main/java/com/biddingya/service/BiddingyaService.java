package com.biddingya.service;

import java.util.List;
import java.util.Optional;

import com.biddingya.beans.BulkEmail;
import com.biddingya.beans.Car;
import com.biddingya.beans.CarBidding;
import com.biddingya.beans.User;

public interface BiddingyaService {
	public String addUser(User us);
	public List<User> showAll();
	public List<User> showuser(String name);
	public void deleteUserData(int id);
	public User searchUser(int id);
	public void saveUser(User user);
	public String updtUser(User us);
	public User ulogin(String username);
//	CAR
	public String addCar(Car car);
	public List<Car> showCars();
	public List<Car> showcar(String carModel);
	public void saveCar(Car car);
	public Car uCar(int carId);
	public void deleteCarData(int id);
	public String updtCar(Car cars);
	public Car searchCar(int id);
//	BULK EMAIL
	public String addBulkEmail(BulkEmail bulkemail);
	public List<BulkEmail> showBulkEmail();
	public void sendBulkEmail(String recipients, String subject, String emailMessage );
	public void saveBulk(BulkEmail bulkemail);
//	BIDDING CAR
	public String addBidding(CarBidding carbidding);
	public List<CarBidding> showBidding(int search);
	public void saveBidding(CarBidding carbidding);
	public CarBidding uBidding(int biddingId);
	public void deleteCarBiddingData(int id);
	public String updtCarBidding(CarBidding carbiddings);
	public CarBidding searchCarBidding(int id);
	
	
}
