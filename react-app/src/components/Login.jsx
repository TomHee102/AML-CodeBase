import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../services/UserService';

function Login() {
  const [credentials, setCredentials] = useState({ email: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await login(credentials);
      localStorage.setItem('token', response.data.token);
      navigate('/profile');
    } catch (error) {
      alert('Login failed: ' + error.response.data);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="email" name="email" value={credentials.email} onChange={handleChange} placeholder="Email" required />
      <input type="password" name="password" value={credentials.password} onChange={handleChange} placeholder="Password" required />
      <button type="submit">Login</button>
    </form>
  );
}

export default Login;

