package com.ty.sportclubboot.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDateTime entrySlot;
	private LocalDateTime exitSlot;
	private String status;
	@OneToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getEntrySlot() {
		return entrySlot;
	}

	public void setEntrySlot(LocalDateTime entrySlot) {
		this.entrySlot = entrySlot;
	}

	public LocalDateTime getExitSlot() {
		return exitSlot;
	}

	public void setExitSlot(LocalDateTime exitSlot) {
		this.exitSlot = exitSlot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
