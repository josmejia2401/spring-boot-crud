package com.josmejia2401.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class StatusDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull(message = "id may not be empty")
	private long id;

	private String name;

	private String description;

	public StatusDTO() {

	}

	public StatusDTO(long id) {
		super();
		this.id = id;
	}

	public StatusDTO(@NotNull(message = "id may not be empty") long id, String name, String description) {
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
		return "StatusDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}