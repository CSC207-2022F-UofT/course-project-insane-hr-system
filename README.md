# Insane HR system

This project is aimed to give company a fantastic solution of employee, project and task management. Employee and project manager are able to see their current tasks and projects, and manage their tasks and projects. Department head can check every member's work in his department. 

# System Setup

In order to make sure our program and tests works, please go to ***preference -> Build, Execution, Deployment -> Build Tools -> Gradle***.
Then change the BUILD AND RUN USING to ***IntelliJ IDEA***, and RUN TESTS USING to ***Gradle(Default)***.


# How to use our software

Begin by logging into the system by entering a username and password and hitting the login button.
If the entered username and password corresponds to a user in the system, 
you will be presented with a screen showing

- visual feature 1
...
- visual feature n

with the following functionality

- use case 1
...
- use case n

if the username and password do not correspond to a user in the system, 
you will be presented to a screen allowing you to return to the login screen.


# Main Features

1.  LoginScreen / Login use-case
  Presents a login screen with Insane-HR-System logo prompting the user to enter username and password.
  If the corresponding user exists, builds the appropriate screen.
  Otherwise, sends user to a login failure page, where they can return to the login screen.

2. Enroll Employee
  - To enroll an employee, you need to be the CEO. Please Log in as CEO (username: test, password: test)
  - Press the ***Enroll Employee*** button
  - In the new screen, enter the new employee's name. The name has to be fist name [space] last name. For example, Zeyu Zhang
  - If the name field is blank, the error message will show up.
  - Select the department that you want to put the employee in, and the position that you want to assign the employee.
  - After press the enroll button, the new employee button will show up.
  - Now, we can use the username and password to log in as the new employee.
  - After login as the new employee and press the go to department button, we can see that this employee has been included in the department member list.
  - note: by system default, the CEO is in the test Dpt, so CEO can only see the department member in the test Dpt. To see the members in Other department, 
  - you need to log in as a member of that department. 


# Design Pattern

-  Builder
-  Factory
-  Observer
-  Facade
-  Strategy

# Contribution

-  Kunlong Wu
-  Zeyu Zhang


