# Insane HR system

This project is aimed to give companies a fantastic solution of employee, project and task management. Employee and project manager are able to see their current tasks and projects, and manage their tasks and projects. Department head can check every member's work in his department. 

# System Setup

In order to make sure our program and tests works, please go to ***preference -> Build, Execution, Deployment -> Build Tools -> Gradle***.
Then change the BUILD AND RUN USING to ***IntelliJ IDEA***, and RUN TESTS USING to ***Gradle(Default)***.


# How to Use

In our database (main -> database -> HR_DB.sqlite -> employees), there are some test users. 
You may log in as any of the existing users by the username and password. (username: test, password: test)

# Main Features

### LoginScreen / Login use-case
  - to login, simply enter the username and password of a user in the database and press login.
  - if the username and password correspond to a user in the database, you will be presented with a screen displaying the appropriate features.
  - otherwise, you will be brought to a login failure screen that will allow you to try again.

### Enroll Employee
  - To enroll an employee, you need to be the CEO. Please Log in as CEO (username: test, password: test)
  - Press the ***Enroll Employee*** button
  - In the new screen, enter the new employee's name. The name has to be fist name [space] last name. For example, Zeyu Zhang
  - If the name field is blank, the error message will show up.
  - Select the department that you want to put the employee in, and the position that you want to assign the employee.
  - After press the enroll button, the new employee information will show up.
  - Now, we can use the username and password to log in as the new employee.
  - After login as the new employee and press the go to department button, we can see that this employee has been included in the department member list.
  - note: by system default, the CEO is in the test Dpt, so CEO can only see the department member in the test Dpt. To see the members in Other department, you need to log in as a member of that department. 

### Leave Request
- Employees can request for different types of leave and specify the dates they are on leave.
- Every one of the employee's superiors (e.g., project managers, department heads) will be asked to approve/deny the request.
- The employee will be placed "On Leave" if all superiors approved the request.
- The employee's number of vacation days remaining will be updated appropriately.

### Rank Employees
- For each user that belongs to a department they can see how all members except for the department head are ranked in the department. 
- The highest ranked employees are at the top of the screen while the lowest ranked employees are at the bottom.

### Complete Task
- In employee's screen, user can select the finished task and go to the task page.
<img width="348" alt="selected button" src="https://user-images.githubusercontent.com/98726309/206615126-ec191ff2-123f-435e-aaa5-fc1ac216371b.png">

- In the task page, employee can use "complete task" button to submit their task.

- After press complete button, the program will ask you to double check in order to avoid submitting other tasks by mistake.
<img width="322" alt="submit button" src="https://user-images.githubusercontent.com/98726309/206615561-6ca2e178-b5b7-4f1c-9018-af10f47f0113.png">

- Only task with "OPEN" status can be submitted.

- After submittion, the status of task will become "CLOSED".

### Create Task
- In the Project screen, if the current user is the project manager of teh selected project, they will be able to create a new task under this projct, by clicking the button at teh bottom left of the screen.
- To create the task, the user needs to type in the name of the task, the description of the task, and enter the ID of the employee to assign the newly created task to. After entering the required input, the user can click on the "create" button to create the task.

### Check Profile Validation
- 

# Test Coverage

-  LeaveRequestInteractor
-  ReviewRequestInteractor
-  Rank Employees Use Case
-  Observer in LeaveRequest entities
-  Check Profile Use Case
-  Enroll Employee use case
-  Project Manager Task Initialization use case


# Design Patterns

-  Builder
-  Factory
-  Observer
-  Facade
-  Strategy

# Contribution

-  Kunlong Wu: Role package in entity to handle with Role of user, user/organization entity initialization. Check Profile Validation Use case with the View + ViewModel of all file screen. SalaryCalculator(Only Use case layer, haven't finished)

-  Zeyu Zhang: Controller, presenter, data access, UI, use case and test for employee enrollment; Use case layer for add department, and delete employee. 
-  Tim Lan
-  Josh Lunger
-  Hao Bao
-  Gayatri (Tara) Chakkithara
-  Jian Wang

