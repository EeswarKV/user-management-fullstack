#!/bin/bash

# Navigate to the backend directory
cd backend || exit
# Run Docker Compose for the backend
docker-compose up -d
# Navigate to the frontend directory
cd ../frontend || exit
# Run Docker Compose for the frontend
docker-compose up -d

