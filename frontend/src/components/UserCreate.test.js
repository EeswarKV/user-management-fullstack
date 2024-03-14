import { render, fireEvent, waitFor } from '@testing-library/react';
import UserCreate from '../components/UserCreate';
import { Provider } from '../context/users';

test('UserCreate component renders correctly', () => {
  const { getByText, getByLabelText } = render(
    <Provider>
      <UserCreate />
    </Provider>
  );

  expect(getByText('Add a user')).toBeInTheDocument();
  expect(getByText('Create User')).toBeInTheDocument();
});

test('UserCreate component handles form submission correctly', async () => {
  const { getByText, getByLabelText } = render(
    <Provider>
      <UserCreate />
    </Provider>
  );

  fireEvent.change(getByLabelText('First Name'), { target: { value: 'John' } });
  fireEvent.change(getByLabelText('Last Name'), { target: { value: 'Doe' } });
  fireEvent.change(getByLabelText('Email'), { target: { value: 'john@example.com' } });
  fireEvent.change(getByLabelText('phoneNumber'), { target: { value: '1234567890' } });

  fireEvent.click(getByText('Submit'));

  await waitFor(() => {
    expect(getByText('Add a user')).toBeInTheDocument();
  });
});
