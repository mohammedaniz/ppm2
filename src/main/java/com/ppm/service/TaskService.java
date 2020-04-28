package com.ppm.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppm.entity.TaskE;
import com.ppm.model.Response;
import com.ppm.model.Task;
import com.ppm.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskRepository repo;
	
	
	public Response getTaskDetailsByTaskId(String taskId) {
		Response response = new Response();
		try {
			
			Optional<TaskE> task = repo.findById(Long.parseLong(taskId));
			
			if(task.isPresent()) {
				response.setCode("200");
				response.setMessage("Succesffully saved the task");
				response.setStatus("SUCCESS");
				response.setCustomObject(task);
			}else {
				response.setCode("500");
				response.setMessage("Internal Server error");
				response.setStatus("FAILED");
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" EXCETPION CAIGHT IN SAVETASKDETAILS() OF TASKSERVICE");
		}
	}
	
	public Response saveTaskDetails(Task task) {
		Response response = new Response();
		try {
			TaskE newTask = new TaskE();
			newTask.setDescription(task.getDescription());
			newTask.setEndDate(task.getEndDate());
			newTask.setStartDate(task.getStartDate());
			newTask.setStatus(task.getStatus());
			newTask.setTaskName(task.getName());
			
			TaskE savedTask = repo.save(newTask);
			if(savedTask.getTaskId() == newTask.getTaskId()) {
				response.setCode("200");
				response.setMessage("Succesffully saved the task");
				response.setStatus("SUCCESS");
			}else {
				response.setCode("500");
				response.setMessage("Internal Server error");
				response.setStatus("FAILED");
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" EXCETPION CAIGHT IN SAVETASKDETAILS() OF TASKSERVICE");
		}
	}
	
	public Response getAllTaskDetails() {
		Response response = new Response();
		try {
			
			
			Iterable<TaskE> tasks = repo.findAll();
			if(tasks != null) {
				response.setCode("200");
				response.setMessage("Succesffully saved the task");
				response.setStatus("SUCCESS");
				response.setCustomObject(tasks);
			}else {
				response.setCode("500");
				response.setMessage("Internal Server error");
				response.setStatus("FAILED");
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" EXCETPION CAIGHT IN SAVETASKDETAILS() OF TASKSERVICE");
		}
	}
}
