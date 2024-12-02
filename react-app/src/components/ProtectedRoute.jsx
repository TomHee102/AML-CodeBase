import React from 'react';
import { Navigate } from 'react-router-dom';

function ProtectedRoute({ children }) {
  const token = localStorage.getItem('token'); // Check for the auth token

  if (!token) {
    return <Navigate to="/login" replace />; // Redirect to login if no token
  }

  return children; // Render the protected component
}

export default ProtectedRoute;
