package com.biddingya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biddingya.beans.BulkEmail;
import com.biddingya.beans.Car;
import com.biddingya.beans.CarBidding;
import com.biddingya.beans.User;
import com.biddingya.exception.BiddingyaNotFoundException;
import com.biddingya.repository.BulkEmailRepository;
import com.biddingya.repository.CarBiddingRepository;
import com.biddingya.repository.CarRepository;
import com.biddingya.repository.UserRepository;

import ch.qos.logback.classic.Logger;


@Service("myservice")
public class BiddingyaServiceImp implements BiddingyaService {
	private PasswordEncoder passwordencoder;
	@Autowired
	UserRepository userrepo;
	@Autowired
	private JavaMailSender  sendmail;
	@Autowired
	BulkEmailRepository bulkrepo;
	@Autowired
	CarRepository carrepo;
	@Autowired
	CarBiddingRepository carbidrepo;
	@Autowired
	public BiddingyaServiceImp(PasswordEncoder encoder) {
		this.passwordencoder=encoder;
	}
	@Override
	public String addUser(User us) {
		us.setRole("USER");
		us.setPassword(passwordencoder.encode(us.getPassword()));
		 userrepo.save(us);
		 return "DATA ADDED";
	}
	@Override
	public List<User> showAll() {
		List<User> showAll=userrepo.findAll();
		return showAll;
	}
	

	@Override
	public List<User> showuser(String name) {
		List<User> showuser=userrepo.findByUsernameContaining(name);
		return showuser;
	}


	@Override
	public void deleteUserData(int id) {
		this.userrepo.deleteById(id);
	}

	@Override
	public User searchUser(int id) {
		Optional<User> userData=userrepo.findById(id);
		User ud=userData.get();
		return ud;
	}

	@Override
	public void saveUser(User user) {
		this.userrepo.save(user);
		
	}

	@Override
	public String updtUser(User us) {
		userrepo.save(us);
		 return "DATA ADDED";
	}

	@Override
	public User ulogin(String username) {
		User vallogin = userrepo.findByUsername(username);
		return vallogin;
	}

	@Override
	public String addCar(Car car) {	
		carrepo.save(car);
		return "car added";
	}

	@Override
	public List<Car> showCars() {
		List<Car> showCars=carrepo.findAll();
		return showCars;
	}

	@Override
	public void saveCar(Car car) {
		this.carrepo.save(car);
		
	}

	@Override
	public Car uCar(int carId) {
		Optional<Car>valcar = carrepo.findById(carId);
		Car car = valcar.get();
		return car;
	}
	@Override
	public void deleteCarData(int id) {
		this.carrepo.deleteById(id);
		
	}
	@Override
	public String updtCar(Car cars) {
		carrepo.save(cars);
		 return "DATA ADDED";
	}
	@Override
	public Car searchCar(int id) {
		Optional<Car> carData=carrepo.findById(id);
		Car jd=carData.get();
		return jd;
	}
	@Override
	public String addBidding(CarBidding carbidding) {
		carbidrepo.save(carbidding);
		return "bidding added";
	}
	@Override
	public List<CarBidding> showBidding(int search) {
		List<CarBidding> showCarBiddings=carbidrepo.findByCarBiddingContain(search);
		return showCarBiddings;
	}
	@Override
	public void saveBidding(CarBidding carbidding) {
		this.carbidrepo.save(carbidding);
		
	}
	@Override
	public CarBidding uBidding(int biddingId) {
		Optional<CarBidding>valcarbidding = carbidrepo.findById(biddingId);
		CarBidding carbidding = valcarbidding.get();
		return carbidding;
	}
	@Override
	public void deleteCarBiddingData(int id) {
		this.carrepo.deleteById(id);
		
	}
	@Override
	public String updtCarBidding(CarBidding carbiddings) {
		carbidrepo.save(carbiddings);
		 return "DATA ADDED";
	}
	@Override
	public CarBidding searchCarBidding(int id) {
		Optional<CarBidding> carBiddingData=carbidrepo.findById(id);
		CarBidding jd=carBiddingData.get();
		return jd;
	}
	@Override
	public String addBulkEmail(BulkEmail bulkemail) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void sendBulkEmail(String recipients, String subject, String emailMessage) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipients);
		message.setSubject(subject);
		message.setText(emailMessage);
		
		sendmail.send(message);
		System.out.println("Email has successfully send to" + recipients);
		
	}

	@Override
	public List<BulkEmail> showBulkEmail() {
		List<BulkEmail> allBulkEmails = bulkrepo.findAll();
		return allBulkEmails;
	
	}
	@Override
	public void saveBulk(BulkEmail bulkemail) {
		bulkrepo.save(bulkemail);
	}

	@Override
	public List<Car> showcar(String carModel) {
		List<Car> showcar=carrepo.findByCarModelContain(carModel);
		return showcar;
	}



	

	


}
