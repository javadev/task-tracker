# task-tracker
The Task tracker application

# The task
Make a task tracker.

Ability to build reports, the number of tasks is estimated 100k +.

Use any (Spring, Spring Boot ...)? frameworks, databases, etc. at your discretion.

It is enough to sketch the abstract structure of the application.

There is an external service that stores additional information about the user (rating for example 1..3). (For example REST)

Elements:

- Department.
- User (name, department id).
- Task. (Creation date, name, description, author, artist, status)
- Comments to the task (may be from different users).
- Attachments to the task (any files).

REST methods needed:

- Receiving a list of tasks (the ability to filter by department + sorting by date of creation). Should return full information by department, user (including rating. If service with additional information is not available, default value).
- Getting details of a specific task (comments, attachments).
- Create a task.
- Task changes (status, executor).
- Adding a comment.
- Delete comment.

Database schema:
[![Screen short](https://github.com/javadev/task-tracker/raw/main/task_tracker.png)](https://github.com/javadev/task-tracker/)

Sessions:

Register new user:

```
POST
http://localhost:8001/auth/signup

{"name":"user2","username":"user2","email":"test2@mail.com","password":"ctt252ctlo","user":"U"}
```

User login:

```
POST
http://localhost:8001/auth/signin
{"username":"user2","password":"ctt252ctlo"}
```

Response:

```
{"username":"user2","uid":1,"authorities":[{"authority":"ROLE_USER"}],"id":1,"tokenType":"Bearer","accessToken":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMiIsImlhdCI6MTYxMTczNDE4MiwiZXhwIjoxNjExODIwNTgyfQ.oPe3MOvi3AXgh8o76At9q4rl-INBwmim8wWoCoTZkY8s0krzuFiKtly6i94cfeHt3KUF_x6eoZszMy-ub2cnrQ"}
```

Create new department:

```
POST
http://localhost:8001/createDepartment/1

Origin: http://localhost:8000
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMiIsImlhdCI6MTYxMTczMzM2MCwiZXhwIjoxNjExODE5NzYwfQ.Y_jGdqwrg__KJyS6gCb0XFcp8meYUV0OrzNh_6CeIN72_OJ6kQWCBBwgkkqi31-r3P1-UKV4-OuDjCkhX-RwZg

{"users":[1],"name":"department1","description":"<p>Department1</p>","admin":1}
```

Create new task:

```
POST
http://localhost:8001/createTask

Origin: http://localhost:8000
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMiIsImlhdCI6MTYxMTczMzM2MCwiZXhwIjoxNjExODE5NzYwfQ.Y_jGdqwrg__KJyS6gCb0XFcp8meYUV0OrzNh_6CeIN72_OJ6kQWCBBwgkkqi31-r3P1-UKV4-OuDjCkhX-RwZg

{"user":[1],"task":{"name":"Task1","startTime":"2021-01-27 09:45","endTime":"2021-02-03 09:45","description":"<p>Task1</p>","createdBy":1,"program":1,"modifiedBy":1,"status":"created","modifiedTime":"2021-01-27 09:45","createdTime":"2021-01-27 09:45"}}
```

Add comment for task:

```
POST
http://localhost:8001/addTaskComment/1/1/6

Origin: http://localhost:8000
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMiIsImlhdCI6MTYxMTczMzM2MCwiZXhwIjoxNjExODE5NzYwfQ.Y_jGdqwrg__KJyS6gCb0XFcp8meYUV0OrzNh_6CeIN72_OJ6kQWCBBwgkkqi31-r3P1-UKV4-OuDjCkhX-RwZg

{"comment":"<p>Comment 3</p>"}
```

