package com.josmejia2401.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import com.josmejia2401.dto.TaskDTO;
import com.josmejia2401.models.TaskModel;

public class TaskMapper {
	public static TaskModel convertDTOToModel(TaskDTO object) {
		List<TaskModel> modelChild = new ArrayList<>();
		if (object.getChildId() != null && !object.getChildId().isEmpty()) {
			for (TaskDTO dto : object.getChildId()) {
				modelChild.add(TaskMapper.convertDTOToModel(dto));
			}
		}
		return new TaskModel(object.getId(), object.getName(), object.getDescription(), object.getDuration(),
				object.getStatus(), modelChild);
	}

	public static TaskDTO convertModelToDTO(TaskModel object) {
		List<TaskDTO> modelChild = new ArrayList<>();
		if (object.getChildId() != null && !object.getChildId().isEmpty()) {
			for (TaskModel dto : object.getChildId()) {
				modelChild.add(TaskMapper.convertModelToDTO(dto));
			}
		}
		return new TaskDTO(object.getId(), object.getName(), object.getDescription(), object.getDuration(),
				object.getStatus(), modelChild);
	}
}
