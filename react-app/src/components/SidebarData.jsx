import React from "react";
import '../App.css'
import HomeIcon from "../assets/Home.png"
import SearchIcon from "../assets/Search.png"
import AccountIcon from "../assets/account_circle.png"

export const SidebarData = [
    {
        title: "Home",
        icon: <img className="icon" src={HomeIcon} alt="icon" />,
        link: "/Index"
    },
    {
        title: "Search",
        icon: <img className="icon" src={SearchIcon} alt="icon" />,
        link: "/Search"
    },
    {
        title: "Account",
        icon: <img className="icon" src={AccountIcon} alt="icon" />,
        link: "/Search"
    }
]