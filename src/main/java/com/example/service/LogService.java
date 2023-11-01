package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Log;
import com.example.repository.LogRepository;

@Service
public class LogService {
	
	private final LogRepository logRepository;
	
	@Autowired
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	public List<Log> findAll() {
		return this.logRepository.findAll();
	}
	
	public List<Log> findByReturnDateIsNull() {
		return this.logRepository.findByReturnDateIsNull();
	}
	
	public Log findById(Integer libraryId) {
		Optional<Log> optionalLog = this.logRepository.findById(libraryId);
		Log log = optionalLog.get();
		return log;
	}
}
