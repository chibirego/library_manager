package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Library;
import com.example.entity.Log;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
	public List<Log> findByReturnDateIsNull();
}