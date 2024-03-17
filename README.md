## CRUD PROJECT Java / Postgresql

This project is completely build using JAVA. 
We are currently using Postgressql as a database. 
To build and prepare the project must follow step by step below. 

Observation: It is highly recomended to open this project with IntellijIdea.
I develop the project with this IDE, and must of the instalation requires
you to use it (or to have some advance knowledge and be a super user)

## Preparing DB
After you clone the project, you must upload a docker container. 
Which means you must have installer either docker desktop, or CLI. 

Within the same directory where the project is, there is a docker-compose.yml
file that will upload the container and create the DB. 
The docker compose, contains information also to create a container for
pgAdmin, for psotgresql. 

Run this command from the project directory:

```bash
docker-compose up -d
```
The -d will run the command on the background. 
