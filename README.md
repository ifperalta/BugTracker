# BugTracker

This project web app is derived from a project management software called Jira. The tool can help keep track of project progress and improve workflow within a development team in task distribution.

Design Patterns<br />
There are three design patterns we have implemented - Singleton Pattern,  State Pattern and Proxy Pattern

<b>Web App  Structure</b> <br />

<b>MVC Pattern</b><br />
The app is using the MVC pattern. All frontend elements are separated from the Dao, Servlet and Bean directories.
<br /><br />

Frontend<br />
The front end of this app is using Bootstrap CSS. <br /><br />

Backend <br />
The backend code are divided into three directories.<br /><br />

/Dao<br />
It contains all the database queries for the four features. Each java file contains methods to execute CRUD operations.<br /><br />

/Bean<br /> 
It contains all classes that encapsulate objects into a single object.  Properties are manipulated with getter and setter methods. All four features have designated java files inside the bean directory.<br /><br />

/Servelets<br />
This directory contains all the servlets.<br /><br />

MySql Database<br />
Implemented 6 tables namely profile, tblprojects, tblrole, tblteam, tblticket and tblusers.<br /><br />
