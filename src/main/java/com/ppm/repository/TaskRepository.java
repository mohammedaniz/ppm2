package com.ppm.repository;

import org.springframework.data.repository.CrudRepository;

import com.ppm.entity.TaskE;

public interface TaskRepository extends CrudRepository<TaskE, Long> {

}
