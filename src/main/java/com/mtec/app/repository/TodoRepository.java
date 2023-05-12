package com.mtec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtec.app.controller.model.Task;

public interface TodoRepository extends JpaRepository<Task, Long>{

}
