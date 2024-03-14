import UserShow from "./UserShow"
import useUsersContext from "../hooks/use-users-contexts"

const UserList = () => {
    const {users} = useUsersContext()
    const renderUsers = () =>  users.map((eachUser) => {
            return (<UserShow user={eachUser} key={eachUser.id} className="user-show" ></UserShow>)
        })
    
    
    return (
        <div className="user-list">
            {renderUsers()}
        </div>
    )
}
export default UserList