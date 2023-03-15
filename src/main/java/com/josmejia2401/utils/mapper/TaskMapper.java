package com.josmejia2401.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import com.josmejia2401.dto.PriorityDTO;
import com.josmejia2401.dto.StatusDTO;
import com.josmejia2401.dto.TaskDTO;
import com.josmejia2401.models.PriorityModel;
import com.josmejia2401.models.StatusModel;
import com.josmejia2401.models.TaskModel;

public class TaskMapper {
	public static TaskModel convertDTOToModel(TaskDTO object) {
		List<TaskModel> modelChild = new ArrayList<>();
		if (object.getChildId() != null && !object.getChildId().isEmpty()) {
			for (TaskDTO dto : object.getChildId()) {
				modelChild.add(TaskMapper.convertDTOToModel(dto));
			}
		}
		TaskModel model = new TaskModel(object.getId(), object.getName(), object.getDescription(), object.getDuration(),
				null, null, modelChild);
		if (object.getStatus() != null) {
			StatusModel status = new StatusModel(object.getStatus().getId());
			model.setStatus(status);
		}
		if (object.getPriority() != null) {
			PriorityModel priority = new PriorityModel(object.getPriority().getId());
			model.setPriority(priority);
		}
		return model;
	}

	public static TaskDTO convertModelToDTO(TaskModel object) {
		List<TaskDTO> modelChild = new ArrayList<>();
		if (object.getChildId() != null && !object.getChildId().isEmpty()) {
			for (TaskModel dto : object.getChildId()) {
				modelChild.add(TaskMapper.convertModelToDTO(dto));
			}
		}

		TaskDTO model = new TaskDTO(object.getId(), object.getName(), object.getDescription(), object.getDuration(),
				null, null, modelChild);
		if (object.getStatus() != null) {
			StatusDTO status = new StatusDTO(object.getStatus().getId());
			model.setStatus(status);
		}
		if (object.getPriority() != null) {
			PriorityDTO priority = new PriorityDTO(object.getPriority().getId());
			model.setPriority(priority);
		}

		return model;
	}
}
