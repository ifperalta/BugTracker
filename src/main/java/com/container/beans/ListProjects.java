package com.container.beans;

public class ListProjects {
	private String project_name;
	private int id;
	
	public void setProjectID(int id) {
		this.id = id;
	}

	public int getProjectID() {
		return id;
	}
	
	public void setProjectName(String project_name) {
		this.project_name = project_name;
	}

	public String getProjectName() {
		return project_name;
	}
	
}
