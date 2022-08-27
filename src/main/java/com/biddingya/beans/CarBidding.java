package com.biddingya.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.biddingya.beans.*;

@Entity
@Table(name = "car_bidding")
public class CarBidding {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int biddingId;
	 @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name="car_id")
	 private Car car;
	 
	private String bidderName;
	private String biddingPrice;
	private String biddingDate;
	public CarBidding (){}
	public CarBidding(int biddingId, Car car, String bidderName, String biddingPrice, String biddingDate) {
		super();
		this.biddingId = biddingId;
		this.car = car;
		this.bidderName = bidderName;
		this.biddingPrice = biddingPrice;
		this.biddingDate = biddingDate;
	}
	public int getBiddingId() {
		return biddingId;
	}
	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public String getBiddingPrice() {
		return biddingPrice;
	}
	public void setBiddingPrice(String biddingPrice) {
		this.biddingPrice = biddingPrice;
	}
	public String getBiddingDate() {
		return biddingDate;
	}
	public void setBiddingDate(String biddingDate) {
		this.biddingDate = biddingDate;
	}
	@Override
	public String toString() {
		return "CarBidding [biddingId=" + biddingId + ", car=" + car + ", bidderName=" + bidderName + ", biddingPrice="
				+ biddingPrice + ", biddingDate=" + biddingDate + "]";
	}
	
	

}
