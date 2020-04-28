package com.ppm.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.model.Response;
import com.ppm.model.Task;
import com.ppm.service.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<?> getAllTasks(){
		Response response = taskService.getAllTaskDetails();
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "{taskId}",method = RequestMethod.GET)
	public ResponseEntity<?> findTaskByIdController(@RequestParam ("taskId") String taskId){
		Response reponse = taskService.getTaskDetailsByTaskId(taskId);
		return new ResponseEntity<Object>(reponse,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ResponseEntity<?> saveAllTasks(@Valid @RequestBody Task task,BindingResult result){
		if(result.hasErrors()) {
			Map<String,String> errors = new HashMap<String,String>();
			for (FieldError error : result.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		}else {
			Response  resp = taskService.saveTaskDetails(task);
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value = "{id}/update",method = RequestMethod.GET)
	public ResponseEntity<?> updateTaskByTaskIdController(){
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllTaskIdController(){
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = ":id/delete",method = RequestMethod.GET)
	public ResponseEntity<?> deleteTaskByTaskIdController(){
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
