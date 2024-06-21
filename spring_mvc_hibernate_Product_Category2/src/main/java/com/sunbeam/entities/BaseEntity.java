package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDate createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	public BaseEntity(Long id, LocalDate createdOn, LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	

}
