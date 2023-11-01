package com.example.form;

import java.time.LocalDateTime;

public class LogForm {

	private Integer libraryId;
	
	private Integer userId;
	
	private Integer id;
	
	private LocalDateTime rentDate;
	
	private LocalDateTime returnDate;
	
	private LocalDateTime returnDueDate;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLibraryId() {
		return this.libraryId;
	}
	
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getRentDate() {
		return this.rentDate;
	}
	
	public void setRentDate(LocalDateTime rentDate) {
		this.rentDate = rentDate;
	}
	
	public LocalDateTime getReturnDate() {
		return this.returnDate;
	}
	
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	
	public LocalDateTime getReturnDueDate() {
		return this.returnDueDate;
	}
	
	public void setReturnDueDate(LocalDateTime returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
}