package com.josmejia2401.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private StatusDTO status;

	@NotNull(message = "priority may not be empty")
	private PriorityDTO priority;

	private List<TaskDTO> childId;

	public TaskDTO() {

	}

	public TaskDTO(long id,
			@NotEmpty(message = "Name may not be empty") @NotNull(message = "Name may not be null") String name,
			@NotEmpty(message = "Description may not be empty") @NotNull(message = "Description may not be null") String description,
			@NotNull(message = "Duration may not be empty") int duration,
			@NotNull(message = "Status may not be empty") StatusDTO status,
			@NotNull(message = "priority may not be empty") PriorityDTO priority, List<TaskDTO> childId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.status = status;
		this.priority = priority;
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

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public PriorityDTO getPriority() {
		return priority;
	}

	public void setPriority(PriorityDTO priority) {
		this.priority = priority;
	}

	public List<TaskDTO> getChildId() {
		return childId;
	}

	public void setChildId(List<TaskDTO> childId) {
		this.childId = childId;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+ ", status=" + status + ", priority=" + priority + ", childId=" + childId + "]";
	}

}
