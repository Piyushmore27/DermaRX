import React from 'react'
import '../css/Navbar.css'

import logo from '../assets/dermaLogo.png';
import MainButton from './MainButton';
import { useNavigate } from 'react-router-dom';

function Navbar() {
    const navigate = useNavigate();

    const handleLogin = () =>  {
        navigate("/login");
    }
  return (
    <div className='w-full flex justify-center items-center absolute top-5 z-20'>
        <div className="nav text-sm font-medium flex justify-between w-250 border border-neutral-200 shadow-lg bg-white/80 px-4 py-4 rounded-4xl">
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
                <MainButton title={"Login"} onClick={handleLogin} className={' border-2 border-sky-200 rounded-2xl px-4 py-2 w-30 text-center bg-[#80D9EB] hover:bg-[#5acae0] hover:border-[#5acae0] font-bold text-white  cursor-pointer '} />
            </div>
        </div>
      
    </div>
  )
}

export default Navbar
