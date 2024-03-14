# Project Name

## Introduction

This project is a full-stack application consisting of a frontend and a backend component. The frontend is built with [React](https://reactjs.org/) and the backend is built with [Spring Boot](https://spring.io/projects/spring-boot). Both components are containerized using Docker and can be easily deployed together using Docker Compose.

## Prerequisites

Before running the application, ensure that you have Docker and Docker Compose installed on your system. You can download and install Docker Desktop from [here](https://www.docker.com/products/docker-desktop).

## Running the Application
`If you want to run full stack application run the below command `(or) else if you want to run independent service follow the backend and frontend documents to start respective service`

```bash
   sh run-full-stack.sh
```
### Backend


### Backend

1. Navigate to the `backend` directory:

   ```bash
   cd backend
   ```
Build and start the backend service using Docker Compose:
```bash
docker-compose up -d
```
This command will create and start a Docker container for the Spring Boot application, along with a MySQL database container. The backend service will be accessible at http://localhost:8080.
### Frontend
Navigate to the frontend directory:
```bash
cd ../frontend
```
Update the hostUrl environment variable in the docker-compose.yml file located in the frontend directory. Set it to the URL of your backend service. For example:
```yaml
environment:
  - hostUrl=http://backend-service:8080
```


Build and start the frontend service using Docker Compose:
```bash
docker-compose up -d
```
This command will create and start a Docker container for the React frontend application. The frontend service will be accessible at http://localhost:3000.
Accessing the Application

Once both the backend and frontend services are running, you can access the application by navigating to http://localhost:3000 in your web browser.

Stopping the Application

To stop the application and shut down the Docker containers, you can use the following command:

```bash
docker-compose down
```
This command will stop and remove the containers created by Docker Compose.

### Additional Notes

Make sure that the backend service is started before the frontend, as the frontend relies on the backend API endpoints.
You can customize the Docker Compose configuration and environment variables as needed for your specific setup.
