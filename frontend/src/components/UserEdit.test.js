import { render, fireEvent, waitFor } from '@testing-library/react';
import UserEdit from '../components/UserEdit';

test('UserEdit component renders correctly', () => {
  const { getByLabelText } = render(
    <UserEdit user={{ firstName: 'John', lastName: 'Doe', email: 'john@example.com', phoneNumber: '1234567890' }} />
  );

  expect(getByLabelText('firstName')).toBeInTheDocument();
  expect(getByLabelText('lastName')).toBeInTheDocument();
  expect(getByLabelText('email')).toBeInTheDocument();
});

test('UserEdit component updates user correctly', async () => {
  const onSubmit = jest.fn();
  const { getByLabelText, getByText } = render(
    <UserEdit user={{ firstName: 'John', lastName: 'Doe', email: 'john@example.com', phoneNumber: '1234567890' }} onSubmit={onSubmit} />
  );

  fireEvent.change(getByLabelText('firstName'), { target: { value: 'Jane' } });
  fireEvent.change(getByLabelText('lastName'), { target: { value: 'Smith' } });
  fireEvent.change(getByLabelText('email'), { target: { value: 'jane@example.com' } });

  fireEvent.click(getByText('Save'));

  await waitFor(() => {
    expect(onSubmit).toHaveBeenCalled();
  });
});
