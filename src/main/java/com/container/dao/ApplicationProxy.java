package com.container.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import com.container.beans.Cache;
import com.container.beans.ListProjects;
import com.container.beans.Projects;

public class ApplicationProxy implements ApplicationInterface {
	
	ApplicationDao ap;
	Cache <List<ListProjects>> c = null;
	Cache <ResultSet> cache = null;
	public ApplicationProxy() {
		ap = new ApplicationDao();
	}
	
	@Override
	public List<ListProjects> getAllProjects() {
		
		if(c != null && c.getCache() != null) {
			return c.getCache();
		}
		else {
			List<ListProjects> projects = ap.getAllProjects();
			c = new Cache<>(projects, new Date(),1);
			return projects;
		}
	}

	@Override
	public Projects loadEntry(int id) {
		return ap.loadEntry(id);
	}

	@Override
	public int insertProjects(Projects project) {
		// TODO Auto-generated method stub
		return ap.insertProjects(project);
	}

	@Override
	public Boolean update(String id, String projectname) throws SQLException {
		// TODO Auto-generated method stub
		return ap.update(id, projectname);
	}

	@Override
	public boolean archiveProject(String id) throws SQLException {
		// TODO Auto-generated method stub
		return ap.archiveProject(id);
	}

	@Override
	public int storeCredentials(String user, String firstname, String lastname, String pass, String email,String active, String token)
			throws SQLException {
		// TODO Auto-generated method stub
		return ap.storeCredentials(user, firstname, lastname, pass, email, active, token);
	}

	@Override
	public boolean verifyToken(String token) throws SQLException {
		// TODO Auto-generated method stub
		return ap.verifyToken(token);
	}

	@Override
	public int updatePassword(String token, String hashedPass) throws SQLException {
		// TODO Auto-generated method stub
		return ap.updatePassword(token, hashedPass);
	}

	@Override
	public ResultSet loadUsers(String token) throws SQLException {
		return ap.loadUsers(token);
	}

}
