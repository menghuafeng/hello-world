package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{

	public List<Girl> findByAge(Integer age);
}
