package com.arghya.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arghya.practice.model.Student;

public interface MyRepository extends JpaRepository<Student,Integer> {
	

}
