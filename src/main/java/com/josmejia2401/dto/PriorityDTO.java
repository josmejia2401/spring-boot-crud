package com.josmejia2401.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PriorityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "id may not be empty")
	@Min(value = 1, message = "ID should not be less than 1")
	@Max(value = 4, message = "ID should not be greater than 4")
	private long id;

	private String name;

	private String description;

	public PriorityDTO() {

	}

	public PriorityDTO(long id) {
		super();
		this.id = id;
	}

	public PriorityDTO(@NotNull(message = "id may not be empty") long id, String name, String description) {
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

	@Override
	public String toString() {
		return "PriorityDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
