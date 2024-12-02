import React, { useEffect, useState } from 'react';
import { useLocation, Link } from 'react-router-dom';
import { verifyEmail } from '../services/UserService';

function VerifyEmail() {
  const [message, setMessage] = useState('');
  const location = useLocation();

  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const token = params.get('token');
    if (token) {
      verifyEmailToken(token);
    } else {
      setMessage('No verification token found');
    }
  }, [location]);

  const verifyEmailToken = async (token) => {
    try {
      const response = await verifyEmail(token);
      setMessage(response.data);
    } catch (error) {
      setMessage('Email verification failed: ' + error.response.data);
    }
  };

  return (
    <div>
      <h2>Email Verification</h2>
      <p>{message}</p>
      <Link to="/login">Go to Login</Link>
    </div>
  );
}

export default VerifyEmail;

