package com.reconnectHer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reconnectHer.module.ContactUs;
@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs, Integer> {

}
