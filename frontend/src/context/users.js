import { createContext, useState } from "react";
import axios from "axios"
const hostUrl = process.env.REACT_APP_HOST_URL||"http://localhost:8080"; 

const UsersContext = createContext();
function Provider({children}){
    const [users, setUsers] = useState([])
    const fetchUsers = async () => {
        const response = await axios.get(`${hostUrl}/api/users`)
        setUsers(response.data)
    }
    const deleteUserById = async (id) => {
        await axios.delete(`${hostUrl}/api/users/${id}`)
        setUsers(users.filter((user) => user.id !== id))
    }

    const createUser = async (userdetails) => {
        const response = await axios.post(`${hostUrl}/api/users`, {
           ...userdetails
        })
        const updatedUsers = [...users, response.data]

        setUsers(updatedUsers)
    }
    const editUserById = async (id, firstName,lastName,email,phoneNumber) => {
        const responce = await axios.put(`${hostUrl}/api/users/${id}`, {
            firstName,
            lastName,
            email,
            phoneNumber
        })
        console.log(responce)
        const updatedUsers = users.map(user => {
            if (user.id === id) {
                return { ...user, ...responce.data }
            }
            return user
        })
        setUsers(updatedUsers);
    }
    const valueToShare = {
        users,
        createUser,
        fetchUsers,
        deleteUserById,
        editUserById
    }
    return <UsersContext.Provider value={valueToShare}>
        {children}
    </UsersContext.Provider>
}
export default UsersContext
export {Provider}