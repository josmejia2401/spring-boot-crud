package com.josmejia2401.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class PriorityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty(message = "Name may not be empty")
	@NotNull(message = "Name may not be null")
	@Column(name = "name")
	private String name;

	@NotEmpty(message = "Description may not be empty")
	@NotNull(message = "Description may not be null")
	@Column(name = "description")
	private String description;

	public PriorityModel() {

	}

	public PriorityModel(long id) {
		super();
		this.id = id;
	}

	
	public PriorityModel(long id,
			@NotEmpty(message = "Name may not be empty") @NotNull(message = "Name may not be null") String name,
			@NotEmpty(message = "Description may not be empty") @NotNull(message = "Description may not be null") String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
