package com.josmejia2401.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class TaskModel {

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

	@NotNull(message = "Duration may not be empty")
	@Column(name = "duration")
	private int duration;

	@NotNull(message = "Status may not be empty")
	@Column(name = "status")
	private int status;

	@OneToMany
	@JoinColumn(name = "child_id", nullable = true)
	private List<TaskModel> childId;

	public TaskModel() {

	}

	public TaskModel(long id,
			@NotEmpty(message = "Name may not be empty") @NotNull(message = "Name may not be null") String name,
			@NotEmpty(message = "Description may not be empty") @NotNull(message = "Description may not be null") String description,
			@NotNull(message = "Duration may not be empty") int duration,
			@NotNull(message = "Status may not be empty") int status, List<TaskModel> childId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.status = status;
		this.childId = childId;
	}

	public List<TaskModel> getChildId() {
		return childId;
	}

	public void setChildId(List<TaskModel> childId) {
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
