package com.proyect.springboot.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class PersonAudit {
	
	@Column(name = "create_at")
	private LocalDateTime creaAt;
	
	@Column(name = "update_at")
	private LocalDateTime updateAt;

	public LocalDateTime getCreaAt() {
		return creaAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setCreaAt(LocalDateTime creaAt) {
		this.creaAt = creaAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist
	public void prePersist() {
		System.out.println("Evento del ciclo de vida del entity pre-persist");
		this.creaAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		System.out.println("Evento del ciclo de vida del entity pre-update");
		this.updateAt = LocalDateTime.now();
	}
}
