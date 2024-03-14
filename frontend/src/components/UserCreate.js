import { useState } from "react"
import useUsersContext from "../hooks/use-users-contexts";
const UserCreate = ( ) => {
    const [create,setCreate] = useState(false);
    const {createUser} = useUsersContext()
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phoneNumber, setPhoneNumber] = useState(1234567890);
    const [status, setStatus] = useState('Active');
    const [birthDate, setBirthDate] = useState('1990-01-01');
    const [address, setAddress] = useState('');
    const createNewUser = () => {
        setCreate(!create);
    }
    const handleFirstName = (event) => {
        setFirstName(event.target.value);
      };
      const handleLastName = (event) => {
        setLastName(event.target.value);
      };
      const handleEmail = (event) => {
        setEmail(event.target.value);
      };
      const handlePhoneNumber = (event) => {
        setPhoneNumber(Number(event.target.value));
      };
      const handleStatus = (event) => {
        setStatus(event.target.value);
      };
    
      const handleBirthDate = (event) => {
        setBirthDate(event.target.value);
      };
    
      const handleAddress = (event) => {
        setAddress(event.target.value);
      };
    const resetValues = () => {
        setFirstName('');
        setLastName('');
        setEmail('');
        setPhoneNumber(1234567890);
        setStatus('Active');
        setBirthDate('1990-01-01');
        setAddress('');
        setCreate(false);

    }
    const handleSubmit = (event) => {
        event.preventDefault();
        createUser({firstName,lastName,email,phoneNumber,status,birthDate,address});
        resetValues() //empty out the text field ,once the user submit 
    }
    return (
        <div className="user-create">
            <h3>Add a user</h3>
            {create ? ( <div><form onSubmit={handleSubmit}>
                <label>First Name</label>
                <input className="input" value={firstName} onChange={handleFirstName} />
                <label>Last Name</label>
                <input className="input" value={lastName} onChange={handleLastName} />
                <label>Email</label>
                <input className="input" value={email} onChange={handleEmail} />
                <label>phoneNumber</label>
                <input className="input" value={phoneNumber} type="tel" onChange={handlePhoneNumber} />
                <label>Status</label>
                <select value={status} onChange={handleStatus}>
                    <option value="Active">Active</option>
                    <option value="Inactive">Inactive</option>
                </select>
                <label>Birth Date</label>
                <input className="input" value={birthDate} type="date" onChange={handleBirthDate} />
                <label>Address</label>
                <textarea className="input" value={address} onChange={handleAddress}></textarea>
                <button type="submit">Submit</button>
            </form>
            <button onClick={resetValues}>Cancel</button>
            </div>) : (
        <button onClick={() => setCreate(true)}>Create User</button>
      )}
        </div>
    )
}
export default UserCreate