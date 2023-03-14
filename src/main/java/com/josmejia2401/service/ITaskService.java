package com.josmejia2401.service;

import java.util.List;

import com.josmejia2401.dto.TaskDTO;

public interface ITaskService {

	public List<TaskDTO> getAll(String name);
	
	public TaskDTO getById(Long id);

	public void deleteById(Long id);

	public void update(TaskDTO task);

	public TaskDTO create(TaskDTO task);
}
