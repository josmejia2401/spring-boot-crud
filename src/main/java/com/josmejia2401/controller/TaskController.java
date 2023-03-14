package com.josmejia2401.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josmejia2401.dto.TaskDTO;
import com.josmejia2401.exceptions.CustomException;
import com.josmejia2401.service.ITaskService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TaskController {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(TaskController.class);

	@Autowired
	ITaskService taskService;

	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDTO>> getAll(@RequestParam(required = false) String name) {
		try {
			List<TaskDTO> models = this.taskService.getAll(name);
			if (models == null || models.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<TaskDTO>>(models, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("TaskController.getAll", e);
			throw new CustomException("Internal error", e);
		}
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO> getTasklById(@PathVariable("id") long id) {
		try {
			TaskDTO tutorialData = this.taskService.getById(id);
			if (tutorialData != null) {
				return new ResponseEntity<>(tutorialData, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error("TaskController.getTasklById", e);
			throw new CustomException("Internal error", e);
		}
	}

	@PostMapping("/tasks")
	public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO tutorial) {
		try {
			TaskDTO item = this.taskService.create(tutorial);
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("TaskController.createTask", e);
			throw new CustomException("Internal error", e);
		}
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable("id") long id, @Valid @RequestBody TaskDTO tutorial) {
		try {
			TaskDTO tutorialData = this.taskService.getById(id);
			if (tutorialData != null) {
				this.taskService.update(tutorial);
				tutorial.setId(id);
				return new ResponseEntity<TaskDTO>(tutorial, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error("TaskController.updateTask", e);
			throw new CustomException("Internal error", e);
		}
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") long id) {
		try {
			TaskDTO tutorialData = this.taskService.getById(id);
			if (tutorialData != null) {
				this.taskService.deleteById(id);
				return new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error("TaskController.deleteTask", e);
			throw new CustomException("Internal error", e);
		}
	}
}
