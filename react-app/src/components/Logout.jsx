/* eslint-disable no-unused-vars */
// Logout.jsx
import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom'; // To navigate programmatically
import '../Logout.css'; // Optional: for specific styles

const Logout = () => {
  const navigate = useNavigate(); // Hook to navigate programmatically

  useEffect(() => {
    // Clear the authentication data or token when logging out
    localStorage.removeItem('authToken'); // Assuming you store a token in localStorage
    // Redirect to login page after logout
    setTimeout(() => {
      navigate('/login'); // Redirects after 2 seconds
    }, 20000); // Delay of 2 seconds for better UX
  }, [navigate]);

  return (
    <div className="logout-container">
      <div className="logout-content">
        <h1 className="logout-header">You have successfully logged out!</h1>
        <p className="logout-message">You will be redirected to the login page shortly.</p>
        <button className="logout-btn" onClick={() => navigate('/login')}>
          Go to Login
        </button>
      </div>
    </div>
  );
};

export default Logout;
