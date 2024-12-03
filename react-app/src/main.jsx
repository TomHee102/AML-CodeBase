import 'bootstrap/dist/css/bootstrap.min.css';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import AdminApp from './AdminApp.jsx';
import App from './App.jsx';
import './index.css';
const isAdmin = false;
createRoot(document.getElementById('root')).render(
  <StrictMode>
   {isAdmin ? <AdminApp /> : <App />}
  </StrictMode>,
)
