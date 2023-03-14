package com.josmejia2401.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskDTO {

	private long id;

	@NotEmpty(message = "Name may not be empty")
	@NotNull(message = "Name may not be null")
	private String name;

	@NotEmpty(message = "Description may not be empty")
	@NotNull(message = "Description may not be null")
	private String description;

	@NotNull(message = "Duration may not be empty")
	private int duration;

	@NotNull(message = "Status may not be empty")
	private int status;

	private List<TaskDTO> childId;

	public TaskDTO() {

	}

	public TaskDTO(long id,
			@NotEmpty(message = "Name may not be empty") @NotNull(message = "Name may not be null") String name,
			@NotEmpty(message = "Description may not be empty") @NotNull(message = "Description may not be null") String description,
			@NotNull(message = "Duration may not be empty") int duration,
			@NotNull(message = "Status may not be empty") int status, List<TaskDTO> childId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.status = status;
		this.childId = childId;
	}

	public List<TaskDTO> getChildId() {
		return childId;
	}

	public void setChildId(List<TaskDTO> childId) {
		this.childId = childId;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
