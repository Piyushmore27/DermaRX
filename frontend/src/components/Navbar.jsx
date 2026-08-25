import React, { useState } from 'react'
import '../css/Navbar.css'

import logo from '../assets/dermaLogo.png';
import MainButton from './MainButton';
import { useNavigate } from 'react-router-dom';

import { useAuth } from '../context/AuthContext';

function Navbar() {
    const navigate = useNavigate();
    
    const { user,isLogin,logout } = useAuth();

    const handleLogin = () =>  {
        navigate("/login");
    }
  return (
    <div className='w-full flex justify-center items-center absolute top-5 z-20'>
        <div className="nav text-sm font-medium flex items-center justify-between w-250 border border-neutral-200 shadow-lg bg-white/80 px-4 py-4 rounded-4xl">
            <div className="left px-2 py-1">
                <img src={logo} width={120} height={100} />
            </div>
            <div className="center flex justify-between w-100 px-2 py-1">
                <p className='text-black hover:text-neutral-600 cursor-pointer'>Medicine</p>
                <p className='text-black hover:text-neutral-600 cursor-pointer'>Healthcare</p>
                <p className='text-black hover:text-neutral-600 cursor-pointer'>Doctor Consult</p>
                <p className='text-black hover:text-neutral-600 cursor-pointer'>Offers</p>
            </div>
            <div className="right px-4">
               {
                isLogin ? (
                     <MainButton title={user?.username}  className={' border-2 border-sky-200 rounded-2xl px-4 py-2 w-fit flex gap-2 text-center bg-[#80D9EB]  hover:border-[#5acae0] font-bold text-text-secondary  cursor-pointer '} svg={<svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#19859b"><path d="M236.83-284.48q51-37.87 112.87-59.24 61.87-21.37 130.3-21.37t131.15 22.22q62.72 22.22 112.02 58.96 33.31-41.57 51.68-90.46 18.37-48.89 18.37-105.63 0-129.61-91.81-221.41-91.8-91.81-221.41-91.81t-221.41 91.81q-91.81 91.8-91.81 221.41 0 56.17 18.09 105.06 18.09 48.9 51.96 90.46Zm140.28-191.78q-41.63-41.35-41.63-102.61t41.63-102.89q41.63-41.63 102.89-41.63t102.89 41.63q41.63 41.63 41.63 102.89t-41.63 102.61Q541.26-434.91 480-434.91t-102.89-41.35ZM480-60.78q-86.96 0-163.35-32.91-76.39-32.92-133.22-89.74-56.82-56.83-89.74-133.22Q60.78-393.04 60.78-480t32.91-163.35q32.92-76.39 89.74-133.22 56.83-56.82 133.22-89.74 76.39-32.91 163.35-32.91t163.35 32.91q76.39 32.92 133.22 89.74 56.82 56.83 89.74 133.22 32.91 76.39 32.91 163.35t-32.91 163.35q-32.92 76.39-89.74 133.22-56.83 56.82-133.22 89.74Q566.96-60.78 480-60.78Zm93.78-120.09q43.61-14.09 82.61-40.83-40.13-27.3-82.33-41.1-42.19-13.81-94.06-13.81-51.87 0-93.78 13.81-41.92 13.8-82.05 41.1 39 26.74 82.33 40.83t93.5 14.09q50.17 0 93.78-14.09Zm-54.17-358.39q15.87-15.87 15.87-39.61 0-23.74-15.87-39.89-15.87-16.15-39.61-16.15-23.74 0-39.61 16.15-15.87 16.15-15.87 39.89 0 23.74 15.87 39.61 15.87 15.87 39.61 15.87 23.74 0 39.61-15.87ZM480-578.87Zm.57 357.17Z"/></svg>}/>
                ):(
                     <MainButton title={"Login"} onClick={handleLogin} className={' border-2 border-sky-200 rounded-2xl px-4 py-2 w-30 text-center bg-[#5acae0] hover:bg-[#5acae0] hover:border-[#5acae0] font-bold text-white  cursor-pointer '} />
                )
               }
            </div>
        </div>
      
    </div>
  )
}

export default Navbar
