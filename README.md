# Bug Buster

A web app is inpired by a popular project management software called Jira. I built this tool to learn Java OOP and Design Patterns. The main feature is the project tracker and task distribution. It can handle multiple users by assigned to different user roles. 

## Table of Contents

- Architecture
- Features
- Backend
- Database
- Design Patterns
- Installation

## Architecture
The app is built using the Model-View-Controller (MVC) pattern and the frontend is built using Bootstrap CSS.

## Backend
The backend code is divided into three directories:

- Dao: Contains all the database queries for the four features. Each java file contains methods to execute CRUD operations.
- Bean: Contains all classes that encapsulate objects into a single object. Properties are manipulated with getter and setter methods. All four features have designated java files inside the bean directory.
- Servelets: Contains all the servlets.

## MySql Database
It uses a MySQL database with 6 tables:
- profile
- tblprojects
- tblrole
- tblteam
- tblticket
- tblusers

## Design Patterns
There are three design patterns we have implemented - 
- Singleton Patter
- State Pattern 
- Proxy Pattern

## Installation
To run the app locally, follow these steps:
- Clone this repository
- Open the project in your favorite IDE
- Create a MySQL database and update the db.properties file with your database credentials
- Build and run the project

## Demo
![alt text](https://raw.githubusercontent.com/ifperalta/BugTrackerv1.0/master/src/Chrome-Demo.gif)

