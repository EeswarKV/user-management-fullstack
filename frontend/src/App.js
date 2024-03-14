import React, { useContext } from "react"
import { useEffect } from "react"
import UserList from "./components/UserList"
import UserCreate from "./components/UserCreate"

import UsersContext from "./context/users"
const App = () => {

    const {fetchUsers} = useContext(UsersContext)
   
    useEffect(()=>{
        fetchUsers();
    },[])
    
    return (
        <div className="app">
            <h1>Users List</h1>
            <UserList ></UserList>
            <UserCreate ></UserCreate>
        </div>
    )
}

export default App