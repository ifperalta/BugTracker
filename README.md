# BugTracker

This project web app is derived from a project management software called Jira. The tool can help keep track of project progress and improve workflow within a development team in task distribution.

Design Patterns
There are three design patterns we have implemented. 
Singleton Pattern,  State Pattern and Proxy Pattern

Web App  Structure

MVC Pattern
The app is using the MVC pattern. All frontend elements are separated from the Dao, Servlet and Bean directories.

Frontend
The front end of this app is using Bootstrap CSS. 

Backend 
The backend code are divided into three directories.

/Dao
It contains all the database queries for the four features. 
Each java file contains methods to execute CRUD operations.

/Bean
It contains all classes that encapsulate objects into a single object.  Properties are manipulated with getter and setter methods. All four features have designated java files inside the bean directory.

/Servelets
This directory contains all the servlets.

MySql Database
Implemented 6 tables namely profile, tblprojects, tblrole, tblteam, tblticket and tblusers.
