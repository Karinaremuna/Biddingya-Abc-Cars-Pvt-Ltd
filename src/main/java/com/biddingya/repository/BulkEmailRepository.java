package com.biddingya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biddingya.beans.BulkEmail;

@Repository
public interface BulkEmailRepository extends JpaRepository<BulkEmail, Integer> {

}
