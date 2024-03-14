import {  useState } from "react"
import UserEdit from "./UserEdit"

import useUsersContext from "../hooks/use-users-contexts"
const UserShow = ({user}) => {
    const [showEdit,setEdit]=useState(false)
    const [showDeleteConfirmation, setShowDeleteConfirmation] = useState(false)
    const {deleteUserById} = useUsersContext()
    const handleDeleteClick = () => {
        setShowDeleteConfirmation(true)
    }
    
    const editUser = () => {
        setEdit(!showEdit);
    }
    const handleSubmit = () =>{
        setEdit(false); // after editing and pressing enter , the UserEdit component should not be shown any more
    }
    const confirmDelete = () => {
        deleteUserById(user.id)
        setShowDeleteConfirmation(false)
    }

    const cancelDelete = () => {
        setShowDeleteConfirmation(false)
    }
    let {firstName,lastName,email,status,phoneNumber} = user
    let content = firstName+" "+lastName
    if(showEdit){
        content=<UserEdit user={user} onSubmit={handleSubmit}></UserEdit>
    }
    return (
        <div className="user-show">
            {user.id} 
            <h3>Name: {content} </h3>
       
            <p>email: {email}</p>
            <p>status: {status}</p>
            <p>phoneNumber: {phoneNumber}</p>
            <img alt="users" src={`https://picsum.photos/seed/${user.id}/300/200`}></img>
            <div className="actions">
                <button className="delete" onClick={handleDeleteClick}></button>
                <button className="edit" onClick={editUser}></button>
            </div>
            {showDeleteConfirmation && (
                <div className="delete-confirmation">
                    <p>Are you sure you want to delete this user?</p>
                    <button onClick={confirmDelete}>Confirm</button>
                    <button onClick={cancelDelete}>Cancel</button>
                </div>
            )}
        </div>
    )
}
export default UserShow