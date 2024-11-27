/* eslint-disable no-unused-vars */
import React from 'react';
import { FaExchangeAlt, FaFilm, FaHome, FaSignOutAlt, FaUsers } from 'react-icons/fa'; // Import React Icons
import { Link } from 'react-router-dom';
import "../AdminSidebar.css"; // Custom styles for the sidebar
import { SidebarDataAdmin } from './SidebarDataAdmin'; // Import sidebar data

function AdminSidebar() {
  return (
    <div className="admin-sidebar">
      {/* Profile Section */}
      <div className="profile-section text-center p-3">
        <div
          className="icon-placeholder d-flex justify-content-center align-items-center bg-light text-dark mx-auto rounded-circle"
          style={{
            width: "60px",
            height: "60px",
            fontSize: "24px",
            fontWeight: "bold",
          }}
        >
          AN
        </div>
        <div className="profile-name mt-2 fw-bold">Admin Name</div>
        <div className="profile-email text-muted" style={{ fontSize: "14px" }}>
          admin@example.com
        </div>
        <div className="profile-city text-muted" style={{ fontSize: "14px" }}>
          Sheffield, UK
        </div>
      </div>

      {/* Sidebar List */}
      <ul className="sidebar-list mt-4">
        {SidebarDataAdmin.map((item, index) => (
          <li key={index} className="sidebar-item">
          
              <Link to={item.link} className="text-decoration-none">
                {item.title === "Dashboard" && <FaHome className="sidebar-icon" />}
                {item.title === "Display Media" && <FaFilm className="sidebar-icon" />}
                {item.title === "Profile" && <FaUsers className="sidebar-icon" />}
                {item.title === "Media Transfer" && <FaExchangeAlt className="sidebar-icon" />}
                {item.title === "Logout" && <FaSignOutAlt className="sidebar-icon" />}
                {item.title}
              </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AdminSidebar;
