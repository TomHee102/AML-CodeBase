import React, { useState, useEffect } from 'react';
import { getProfile, updateProfile } from '../services/UserService';

function Profile() {
  const [profile, setProfile] = useState(null);
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    fetchProfile();
  }, []);

  const fetchProfile = async () => {
    try {
      const userId = localStorage.getItem('userId'); // Assume you store userId in localStorage after login
      const response = await getProfile(userId);
      setProfile(response.data);
    } catch (error) {
      alert('Failed to fetch profile: ' + error.response.data);
    }
  };

  const handleChange = (e) => {
    setProfile({ ...profile, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updateProfile(profile.id, profile);
      setIsEditing(false);
    } catch (error) {
      alert('Failed to update profile: ' + error.response.data);
    }
  };

  if (!profile) return <div>Loading...</div>;

  return (
    <div>
      {isEditing ? (
        <form onSubmit={handleSubmit}>
          <input type="text" name="firstName" value={profile.firstName} onChange={handleChange} />
          <input type="text" name="lastName" value={profile.lastName} onChange={handleChange} />
          <input type="email" name="email" value={profile.email} onChange={handleChange} />
          <button type="submit">Save</button>
          <button type="button" onClick={() => setIsEditing(false)}>Cancel</button>
        </form>
      ) : (
        <div>
          <p>First Name: {profile.firstName}</p>
          <p>Last Name: {profile.lastName}</p>
          <p>Email: {profile.email}</p>
          <button onClick={() => setIsEditing(true)}>Edit</button>
        </div>
      )}
    </div>
  );
}

export default Profile;

