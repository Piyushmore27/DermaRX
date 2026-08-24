import React from 'react'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Login from './pages/Login';
import Register from './pages/Register';
import { AuthProvider } from './context/AuthContext';
import AppRoutes from './routes/AppRoutes';



function App() {
  
  return (
    <AuthProvider>
      <AppRoutes/>

    
    </AuthProvider>
    
  )
}

export default App
