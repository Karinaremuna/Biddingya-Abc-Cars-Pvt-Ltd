package com.biddingya.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biddingya.beans.Car;
import com.biddingya.beans.User;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findByCarModel (String search);
	@Query(value = "SELECT * FROM car WHERE car_make LIKE %:search% OR car_model LIKE %:search% OR car_body_style LIKE %:search%", nativeQuery = true)
    List<Car> findByCarModelContain(@Param("search")String search);
}
