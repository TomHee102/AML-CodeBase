import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/users';

export const register = (userData) => axios.post(`${REST_API_BASE_URL}/register`, userData);

export const login = (credentials) => axios.post(`${REST_API_BASE_URL}/login`, credentials);

export const verifyEmail = (token) => axios.get(`${REST_API_BASE_URL}/verify?token=${token}`);

export const getProfile = (userId) => axios.get(`${REST_API_BASE_URL}/profile/${userId}`);

export const updateProfile = (userId, profileData) => axios.put(`${REST_API_BASE_URL}/profile/${userId}`, profileData);

export const logout = () => {
  localStorage.removeItem('token');
};


