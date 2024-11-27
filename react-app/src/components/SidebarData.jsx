/* eslint-disable no-unused-vars */
import React from "react";
import '../App.css';
import HomeIcon from "../assets/Home.png";
import SearchIcon from "../assets/Search.png";
import AccountIcon from "../assets/account_circle.png";

export const SidebarData = [
    {
        title: "Home",
        icon: <img className="icon" src={HomeIcon} alt="icon" />,
        link: "/home"
    },
    {
        title: "Search",
        icon: <img className="icon" src={SearchIcon} alt="icon" />,
        link: "/search"
    },
    {
        title: "Account",
        icon: <img className="icon" src={AccountIcon} alt="icon" />,
        link: "/account"
    }
]