# Insane HR system

This project is aimed to give companies a fantastic solution of employee, project and task management. Employee and project manager are able to see their current tasks and projects, and manage their tasks and projects. Department head can check every member's work in his department. 

# System Setup

In order to make sure our program and tests works, please go to ***preference -> Build, Execution, Deployment -> Build Tools -> Gradle***.
Then change the BUILD AND RUN USING to ***IntelliJ IDEA***, and RUN TESTS USING to ***Gradle(Default)***.


# How to Use

In our database (main -> database -> HR_DB.sqlite -> employees), there are some test users. 
You may log in as any of the existing users by the username and password. (username: test, password: test)
Some login user that can try:
username  passward
User in Test Department
test  test
employee  pass1

User in Physics Department
Wuuu0000  123
LLLL0000  LLLL0000
Newt0000  Newt0000
SSSS0000  SSSS0000

Moreover, you can create any employee by CEO.
and create any project 



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
- This use case let users can see their own screen that contain all current task and project and their information after login. And will provide corresponding functionality that we allow that user can use. For instance, when employee login, he will see a screen with his name, and his basic information, and his current task, current project and a button that can go to any of the task and project that is exhibit, and at the bottom of the screen, there will be a button named "Leave Request" and a button named "Go to Department" so employee can require a leave or check the department profile. 

Based on different login user, screen will have different appearance and will provide different functionality. 

This use case also dealling with the organization profile screen, i.e., the screen of Department file, Project file, and Task file. After user click the botton provided in their use profile screen named "go to selected task/project" they can go the organization file they selected in the list. The organization file contain the member of the organization. For department file, it also contain a table of projects that is in that department. For project file, it also contain a table of task that is in that project. Moreover, the task/project/member that shown in the organization profile is related to the user who are watching. If the user that has no relation with organization or the member, he will no see them, unless the watcher is the superviser of the memeber or organization. 

Through organization file, users can check other user file. This is a natural and useful functionality for company cooperation. Employees and project manager can check what projects and tasks that other employees are doing. In addition, members can only see CEO's basic information, and can only see task and project of prject manager that is related to them. There are still other authorization is considered to fitting the real situation. 

The screen in this use case has enable the observer design pattern, but since we still not connect it to the database, the changes of database still can not immitiately reflect in the screen. However, as long as we implement database observer design pattern part, we can have the auto refresh screen immidiately. 

# Test Coverage

-  LeaveRequestInteractor
-  ReviewRequestInteractor
-  Observer in LeaveRequest entities
-  Check Profile Use Case
-  Enroll Employee use case
-  Project Manager Task Initialization use case


# Design Patterns

-  Builder
we have screen builder in check profile use case. Although the class screenBuilder is not a pure builder, it still contain the design pattern of builder.
-  Factory
User Factory, Role Factory, Project Factory,... in the entity. 
-  Observer
The UI of check profile use case use observer to connect view model and the view place in presenter\viewModel.
-  Facade
-  Strategy
The Request model of Check profile use case uses strategy to dealling with different input type place in use_case\check_profile_validation.

# Contribution

-  Kunlong Wu: Role package in entity to handle with Role of user, user/organization entity initialization. Check Profile Validation Use case with the View + ViewModel of all file screen. SalaryCalculator(Only Use case layer, haven't finished)

-  Zeyu Zhang: Controller, presenter, data access, UI, use case and test for employee enrollment; Use case layer for add department, and delete employee. 
-  Tim Lan
-  Josh Lunger
-  Hao Bao
-  Gayatri (Tara) Chakkithara : Database, DAOs, Rank Employees Use Case, Rank Employees Interface Adapters, RankEmployeesScreen and RankEmployeesDataAccess. 
-  Jian Wang

