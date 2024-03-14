import { render, fireEvent } from '@testing-library/react';
import UserShow from '../components/UserShow';
import { Provider } from '../context/users';

test('UserShow component renders correctly', () => {
  const user = {
    id: 1,
    firstName: 'John',
    lastName: 'Doe',
    email: 'john@example.com',
    status: 'Active',
    phoneNumber: '1234567890',
  };

  const { getByText } = render(
    <Provider>
      <UserShow user={user} />
    </Provider>
  );

  expect(getByText('Name: John Doe')).toBeInTheDocument();
  expect(getByText('email: john@example.com')).toBeInTheDocument();
});

test('UserShow component handles delete button correctly', () => {
  const user = {
    id: 1,
    firstName: 'John',
    lastName: 'Doe',
    email: 'john@example.com',
    status: 'Active',
    phoneNumber: '1234567890',
  };

  const { getByText } = render(
    <Provider>
      <UserShow user={user} />
    </Provider>
  );

  fireEvent.click(getByText('Delete'));

  expect(getByText('Are you sure you want to delete this user?')).toBeInTheDocument();
});
