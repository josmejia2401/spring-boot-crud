package com.josmejia2401.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josmejia2401.Application;
import com.josmejia2401.dto.TaskDTO;
import com.josmejia2401.exceptions.CustomException;
import com.josmejia2401.models.TaskModel;
import com.josmejia2401.repository.TaskRepository;
import com.josmejia2401.utils.Status;
import com.josmejia2401.utils.mapper.TaskMapper;

@Service
public class TaskService implements ITaskService {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(TaskService.class);
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<TaskDTO> getAll(String name) {
		List<TaskDTO> resuls = new ArrayList<>();
		if (name != null) {
			this.taskRepository.findByName(name).forEach((final TaskModel model) -> {
				resuls.add(TaskMapper.convertModelToDTO(model));
			});
		} else {
			this.taskRepository.findAll().forEach((final TaskModel model) -> {
				resuls.add(TaskMapper.convertModelToDTO(model));
			});
		}
		return resuls;
	}

	@Override
	public TaskDTO getById(Long id) {
		Optional<TaskModel> task = this.taskRepository.findById(id);
		if (task.isPresent()) {
			return TaskMapper.convertModelToDTO(task.get());
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		this.taskRepository.deleteById(id);
	}

	@Override
	public void update(TaskDTO task) {
		TaskDTO newTrask = this.getById(task.getId());
		if (newTrask == null) {
			return;
		}
		Status status = Status.findById((int) task.getStatus().getId());
		if (status == null) {
			throw new CustomException("Status not found");
		}
		newTrask.setDescription(task.getDescription());
		newTrask.setDuration(task.getDuration());
		newTrask.setName(task.getName());
		TaskModel tModel = TaskMapper.convertDTOToModel(newTrask);
		this.taskRepository.saveAndFlush(tModel);
	}

	@Override
	public TaskDTO create(TaskDTO task) {
		LOGGER.info(task.toString());
		TaskModel model = TaskMapper.convertDTOToModel(task);
		
		model = this.taskRepository.save(model);
		return TaskMapper.convertModelToDTO(model);
	}
}
