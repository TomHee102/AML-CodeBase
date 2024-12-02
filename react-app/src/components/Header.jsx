import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header style={{ backgroundColor: '#007bff', padding: '10px 0', color: 'white' }}>
      <div className="container" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <h1 style={{ margin: 0 }}>User Management</h1>
        <nav>
          <Link to="/" style={{ color: 'white', marginRight: '15px', textDecoration: 'none' }}>Home</Link>
          <Link to="/login" style={{ color: 'white', marginRight: '15px', textDecoration: 'none' }}>Login</Link>
          <Link to="/register" style={{ color: 'white', textDecoration: 'none' }}>Register</Link>
        </nav>
      </div>
    </header>
  );
}

export default Header;

