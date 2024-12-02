import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register } from '../services/UserService';

function Register() {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
    firstName: '',
    lastName: '',
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await register(formData);
      alert('Registration successful. Please check your email for verification.');
      navigate('/login');
    } catch (error) {
      alert('Registration failed: ' + error.response.data);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="email" name="email" value={formData.email} onChange={handleChange} placeholder="Email" required />
      <input type="password" name="password" value={formData.password} onChange={handleChange} placeholder="Password" required />
      <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} placeholder="First Name" required />
      <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} placeholder="Last Name" required />
      <button type="submit">Register</button>
    </form>
  );
}

export default Register;

