import {  useState } from 'react';

import useUsersContext from '../hooks/use-users-contexts';
function UserEdit({ user,onSubmit }) {
  const [firstName, setFirstName] = useState(user.firstName);
  const [lastName, setLastName] = useState(user.lastName);
  const [email, setEmail] = useState(user.email);
  const [phoneNumber, setPhoneNumber] = useState(user.phoneNumber);
   const {editUserById} = useUsersContext()

  const handleFirstName = (event) => {
    setFirstName(event.target.value);
  };
  const handleLastName = (event) => {
    setLastName(event.target.value);
  };
  const handleEmail = (event) => {
    setEmail(event.target.value);
  };
  // const handlephoneNumber = (event) => {
  //   setphoneNumber(event.target.value);
  // };

  const handleSubmit = (event) => {
    event.preventDefault();
    onSubmit()
    editUserById(user.id,firstName,lastName,email,phoneNumber)
  };

  return (
    <form onSubmit={handleSubmit} className="user-edit">
      <label>firstName</label>
      <input className="input" value={firstName} onChange={handleFirstName} />
      <label>lastName</label>
      <input className="input" value={lastName} onChange={handleLastName} />
      <label>email</label>
      <input className="input" value={email} onChange={handleEmail} />
      {/* <label>phoneNumber</label>
      <input className="input" value={phoneNumber} type="tel"  onChange={handlephoneNumber} /> */}

      <button className="button is-primary">Save</button>
    </form>
  );
}

export default UserEdit;
