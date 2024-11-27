/* eslint-disable no-unused-vars */
import React from "react";
import "../App.css";
import { SidebarData } from './SidebarData';

function Sidebar() {
    return (
        <div className="Sidebar">
            <div className="logo"></div>
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