/* eslint-disable no-unused-vars */
import React from "react";
import "../App.css";
import { SidebarData } from './SidebarData';
import LibraryIcon from "../assets/Library.svg";

function Sidebar() {
    return (
        <div className="Sidebar">
            <div className="logoContainer"><img className="logo" src={LibraryIcon} alt="icon"/>
                <div>Advanced Media Library</div>
            </div>
            <ul className="SidebarList">
                {SidebarData.map((value, key) => {
                    return (<li 
                        key={key} 
                        className="row"
                        id={window.location.pathname == value.link ? "active" : ""}
                        onClick={() => {
                            window.location.pathname = value.link
                            }}
                        >
                        <div>{value.icon}{value.title}</div>
                    </li>);
                })}
            </ul>
        </div>
    )
}

export default Sidebar;