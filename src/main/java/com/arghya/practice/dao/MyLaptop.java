package com.arghya.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arghya.practice.model.Laptop;

public interface MyLaptop extends JpaRepository<Laptop,Integer>{

}
