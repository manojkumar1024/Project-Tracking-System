package com.todolist.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.dto.ProjectDto;
import com.todolist.todolist.model.Project;
import com.todolist.todolist.repository.ProjectRepositoryService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepositoryService projectRepositoryService;
	
	@Override
	public Project saveProject(ProjectDto projectDto) {
		try {
			
			Project project = new Project();
			project.setId(projectDto.getId());
			project.setProjectId(projectDto.getProjectId());
			project.setProjectName(projectDto.getProjectName());
			project.setProjectCode(projectDto.getProjectCode());
			project.setProjectDescription(projectDto.getProjectDescription());
			project.setStartDate(projectDto.getStartDate());
			project.setEndDate(projectDto.getEndDate());
			return projectRepositoryService.save(project);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Project> getAllProject(){
		try {
			return projectRepositoryService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<>();
		}
	}
}
