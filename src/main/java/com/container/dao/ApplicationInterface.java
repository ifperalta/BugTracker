package com.container.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.container.beans.ListProjects;
import com.container.beans.Projects;

public interface ApplicationInterface {
	public List<ListProjects> getAllProjects();
	public Projects loadEntry(int id);
	public int insertProjects(Projects project);
	public Boolean update(String id, String projectname) throws SQLException;
	public boolean archiveProject(String id) throws SQLException;
	public int storeCredentials(String user, String firstname, String lastname, String pass, String email, String active, String token) throws SQLException;
	public boolean verifyToken(String token) throws SQLException;
	public int updatePassword(String email, String hashedPass) throws SQLException;
	public ResultSet loadUsers(String token) throws SQLException;
}
