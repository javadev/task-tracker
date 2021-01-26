# task-tracker
Task tracker application

# The task
Make a task tracker.

Ability to build reports, the number of tasks is estimated 100k +.

Use any (Spring, Spring Boot ...)? frameworks, databases, etc. at your discretion.

It is enough to sketch the abstract structure of the application.

There is an external service that stores additional information about the user (rating for example 1..3). (For example REST)

Elements:

Department.
User (name, department id).
Task. (Creation date, name, description, author, artist, status)
Comments to the task (may be from different users).
Attachments to the task (any files).

REST methods needed:

- Receiving a list of tasks (the ability to filter by department + sorting by date of creation). Should return full information by department, user (including rating. If service with additional information is not available, default value).
- Getting details of a specific task (comments, attachments).
- Create a task.
- Task changes (status, executor).
- Adding a comment.
- Delete comment.

Database schema:
[![Screen short](https://github.com/javadev/task-tracker/raw/main/task_tracker.png)](https://github.com/javadev/task-tracker/)
