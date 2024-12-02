/* eslint-disable no-unused-vars */
/*import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap styles
import PropTypes from 'prop-types'; // Import PropTypes
import React, { useState } from 'react';
import '../Login.css'; // Custom styles for the Login page

const Login = ({ onLoginSuccess }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/admin/login', { username, password });
            onLoginSuccess(response.data); // Pass admin info to parent (AdminApp)
        } catch (err) {
            setError('Invalid username or password');
        }
    };

    return (
        <div className="login-container">
            <div className="login-form-container">
                <h2 className="login-heading">Admin Login</h2>
                {error && <div className="alert alert-danger">{error}</div>}
                <form onSubmit={handleLogin} className="login-form">
                    <div className="form-group">
                        <label className="form-label">Username</label>
                        <input 
                            type="text" 
                            className="form-control"
                            placeholder="Enter username" 
                            value={username} 
                            onChange={(e) => setUsername(e.target.value)} 
                            required 
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label">Password</label>
                        <input 
                            type="password" 
                            className="form-control"
                            placeholder="Enter password" 
                            value={password} 
                            onChange={(e) => setPassword(e.target.value)} 
                            required 
                        />
                    </div>
                    <button type="submit" className="btn btn-primary submit-btn">Sign In</button>
                </form>
                <div className="login-footer">
                    <label className="checkbox-wrap">
                        Remember Me
                        <input type="checkbox" checked />
                        <span className="checkmark"></span>
                    </label>
                    <a href="#" className="forgot-password">Forgot Password?</a>
                </div>
            </div>
        </div>
    );
};

// Add PropTypes validation for the onLoginSuccess prop
Login.propTypes = {
    onLoginSuccess: PropTypes.func.isRequired, // onLoginSuccess must be a function and is required
};

export default Login;
*/