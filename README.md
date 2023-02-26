# Bug Buster

A web app is inpired by a popular project management software called Jira. I built this tool to learn Java OOP and Design Patterns. The main feature is the project tracker and task distribution. It can handle multiple users by assigned to different user roles. 

<b>Architecture</b><br />
The app is using the MVC pattern.
<br />

<b>Frontend</b><br />
The front end of this app is using Bootstrap CSS. <br />

<b>Backend</b><br />
The backend code are divided into three directories.<br />

<b>/Dao</b><br />
It contains all the database queries for the four features. Each java file contains methods to execute CRUD operations.<br />

<b>/Bean</b><br /> 
It contains all classes that encapsulate objects into a single object.  Properties are manipulated with getter and setter methods. All four features have designated java files inside the bean directory.<br />

<b>/Servelets</b><br />
This directory contains all the servlets.<br />

<b>MySql Database</b><br />
Implemented 6 tables namely profile, tblprojects, tblrole, tblteam, tblticket and tblusers.<br /><br />

<b>Design Patterns</b><br />
There are three design patterns we have implemented - <b>Singleton Pattern,  State Pattern and Proxy Pattern</b>
<br /><br />
