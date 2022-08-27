package com.biddingya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biddingya.beans.Car;
import com.biddingya.beans.CarBidding;

@Repository
public interface CarBiddingRepository extends JpaRepository<CarBidding, Integer>{
	@Query(value = "SELECT * FROM car_bidding WHERE car_id= :search ", nativeQuery = true)
    List<CarBidding> findByCarBiddingContain(@Param("search")int search);

}
