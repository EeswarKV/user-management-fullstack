
# User Management API

This API allows you to manage user data.

## Endpoints

### Get All Users

```bash
curl --location 'https://usermanagement-46lh.onrender.com/api/users'
```
### Get User by ID
```bash

curl --location 'https://usermanagement-46lh.onrender.com/api/users/1'
```
### Create User
```bash

curl --location --request POST 'https://usermanagement-46lh.onrender.com/api/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fristName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "status": "Active",
    "phoneNumber": 1234567890,
    "birthDate": "1990-01-01",
    "address": "123 Main St, Anytown, USA"
}'
```
### Update User by ID
```bash
curl --location --request PUT 'https://usermanagement-46lh.onrender.com/api/users/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "fristName": "John",
    "lastName": "Doe",
    "email": "john.doe@gmail.com",
    "status": "Active",
    "phoneNumber": 1234567890,
    "birthDate": "1990-01-01",
    "address": "123 Main St, Anytown, USA"
}'
```
### Delete User
```bash
curl --location --request DELETE 'https://usermanagement-46lh.onrender.com/api/users/1'
```


This README provides an overview of the available endpoints along with example curl commands to interact with the API. 