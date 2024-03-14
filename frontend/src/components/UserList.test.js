import { render } from '@testing-library/react';
import UserList from '../components/UserList';
import { Provider } from '../context/users';

test('UserList component renders correctly', () => {
  const { getByText } = render(
    <Provider>
      <UserList />
    </Provider>
  );

  expect(getByText('User List')).toBeInTheDocument();
});
