/* eslint-disable no-unused-vars */
import React from 'react';
import {
  Route,
  BrowserRouter as Router,
  Routes
} from "react-router-dom";
import './App.css';
import ListMediaComponent from './components/ListMediaComponent';
import Sidebar from './components/Sidebar';

function Home(){
  return (
    <div>
      <h1>
        Home
      </h1>
    </div>
  )
}

function App(){

  return (
    <Router>
      <div className='App'>
        <Sidebar />
        <Routes>
          <Route path="/home" element={<Home/>}/>
          <Route path="/search" element={<ListMediaComponent/>}/>
          <Route path="/account" element={<Home/>}/>
        </Routes>
      </div>
    </Router>
  )
}

export default App;