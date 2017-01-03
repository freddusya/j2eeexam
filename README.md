# J2EE Test Exam

Background:

1. Our client is implementing timesheet tracking application
2. Every morning, each employee has to perform check-in, and at end of the day, check-out
3. Every 1st of the month, team lead will login to see the table showing check-in/out time for each employee working under him/her 

Task:

1. Fork the project
2. Run in your local J2EE container (Jetty/Wildly/Tomcat). Ensure that at least you can run http://localhost:8080/j2eeexam-0.0.1-SNAPSHOT/ (I am using Jetty)
3. Change to this URL http://localhost:8080/j2eeexam-0.0.1-SNAPSHOT/login.ctc, this login page.
4. Make the login page working and landing page after login is a simple page, showing 2 button, to check-in and out. Do not need to use database, just use textfile or application scope variable to store the timesheet for each staff.
5. Make login page and dashboard page also working for team lead to see the timesheet summary

Assumption:

1. No database required
2. Two staff users and one team lead user

Reference:

* http://crunchify.com/simplest-spring-mvc-hello-world-example-tutorial-spring-model-view-controller-tips/
* https://docs.spring.io/docs/Spring-MVC-step-by-step/


Author: fkarnagi@gmail.com

