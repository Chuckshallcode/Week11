package projects.service;

import java.util.List;

import projects.dao.ProjectsDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
	private ProjectsDao projectDao = new ProjectsDao();
	
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}
		
	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow();
	}
	
	public void modifyProjectDetails(Project projectId) {
		if(!projectDao.modifyProjectDetails(projectId)) {
			throw new DbException("Project with ID=" + projectId + " does not exitst.");
		}
	}

	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			
		}
		throw new DbException("Project with ID=" + projectId + " does not exitst.");		
	}
}
