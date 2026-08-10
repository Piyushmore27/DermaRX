import React from 'react'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Login from './pages/Login';
import Register from './pages/Register';

const router = createBrowserRouter(
  [
    {
      path:"/",
      element:
      <>
      <Navbar/>
      <Home/>
      </>
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


function App() {
  
  return (
    <RouterProvider router={router} className="bg-green-200"  >
        <Navbar/>
      </RouterProvider>
  )
}

export default App
