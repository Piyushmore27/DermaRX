import React from 'react'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Navbar from '../components/Navbar'
import Home from '../pages/Home';
import Login from '../pages/Login';
import Register from '../pages/Register';
import Layout from '../components/Layout';

function AppRoutes() {
    
const router = createBrowserRouter(
  [
    {
      path:"/",
      element:
      
      <Layout/>,
      children: [
                {
                    index: true,
                    element: <Home />
                }
            ]
      
    },
    {
      path:"/login",
      element:
      <>
      <Login/>
      </>
    },
    {
      path:"/register",
      element:
      <>
      <Register/>
      </>
    }
  ]
)
 return <RouterProvider router={router} />;
}

export default AppRoutes
