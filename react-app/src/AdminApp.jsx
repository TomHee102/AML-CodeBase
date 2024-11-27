/* eslint-disable no-unused-vars */
import React from "react";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import './AdminSidebar.css';
import AdminHome from './components/AdminHome';
import AdminSidebar from './components/AdminSidebar';
import DisplayMedia from './components/DisplayMedia';
import Logout from './components/Logout';
import MediaTransferForm from './components/MediaTransferForm';

function AdminApp() {
  return (
    <Router>
      <div className="App">
        <AdminSidebar />
        <div className="main-content">
          <Routes>
            <Route path="/dashboard" element={<AdminHome />} />
            <Route path="/display-media" element={<DisplayMedia />} />
            <Route path="/media-transfer" element={<MediaTransferForm />} />
            <Route path="/logout" element={<Logout />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default AdminApp;
