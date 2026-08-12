import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import MainButton from '../components/MainButton';
import RoleBtn from '../components/RoleBtn';
import { Eye, EyeOff } from "lucide-react";

function Register() {

    const [name,setName] = useState("");
    const [password,setPassword] = useState("");
    const [confirmPassword,setConfimPassword] = useState("");
    const [role,setRole] = useState("");
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);
    
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate("/login");
    }

    const handleUser = () => {
        setRole("User")
    }

    const handleAdmin = () => {
        setRole("Admin");
    }

    const handlePharmacist =() => {
        setRole("Pharmacist");
    }

    const handleRegister = async (e) =>{
        e.preventDefault();

    // Basic validation
        if (!name || !password || !confirmPassword) {
            alert("Please fill all fields");
            return;
        }

    // Password validation
        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }

        const formData = new FormData();

        formData.append("username",name);
        formData.append("password",password);
        formData.append("role",role);

        console.log(formData);

        const response = await fetch(
            "http://localhost:8080/backend/api/Register",
        {
            method: "POST",
            // headers: {
            //     "Content-Type": "application/x-www-form-urlencoded"
            // },
            body: formData
        }
        );
        const data = await response.json();

        if (data.success) {
            navigate("/home");
        }
    }


  return (
    <div className='flex flex-row w-full h-screen overflow-hidden'>
        <section className='left w-[50%]  bg-green-200 '>
                        
                           <div className="h-screen bg-cover bg-center flex items-center justify-center"
                    ></div>
                           
                       
                    </section>
        <section className='right w-[50%]  bg-white'>
                <div className="content  px-10 py-10 flex flex-col justify-center items-center gap-4 ">
                    
                    <div className='text-center text-4xl font-extrabold w-120'><h3>Begin Your Journey with DermaRx Today</h3></div>
                    <div className="form flex flex-col gap-5 py-6 w-full items-center ">

    {/* Username */}
    <div className="flex flex-col gap-1">
        <label className="text-sm font-medium text-gray-700">
            Username 
        </label>
        <input
            type="text"
            placeholder="Enter your username or email"
            className="
                w-80
                h-11
                px-4
                border
                border-gray-300
                rounded-lg
                outline-none
                transition-all
                duration-200
                focus:border-green-500
                focus:ring-2
                focus:ring-green-200
            "
            onChange={(e) => setName(e.target.value)}
        />
    </div>

    {/* Password */}
    <div className="flex flex-col gap-1">
        <label className="text-sm font-medium text-gray-700">
            Password
        </label>
        <div className="relative">
    <input
        type={showPassword ? "text" : "password"}
        placeholder="Enter your password"
        className="
            w-80
            h-11
            px-4
            pr-12
            border
            border-gray-300
            rounded-lg
            outline-none
            focus:border-green-500
            focus:ring-2
            focus:ring-green-200
        "
        onChange={(e) => setPassword(e.target.value)}
    />

    <button
        type="button"
        onClick={() => setShowPassword(!showPassword)}
        className="absolute right-3 top-1/2 -translate-y-1/2 text-gray-500"
    >
        {showPassword ? <Eye size={20} /> : <EyeOff size={20} />}
    </button>
</div>
    </div>
    {/* Confirm Password */}
    <div className="flex flex-col gap-1">
        <label className="text-sm font-medium text-gray-700">
            Confirm Password
        </label>
        
        <div className="relative">
    <input
        type={showConfirmPassword ? "text" : "password"}
        placeholder="Enter password again"
        className="
            w-80
            h-11
            px-4
            pr-12
            border
            border-gray-300
            rounded-lg
            outline-none
        "
        onChange={(e) => setConfimPassword(e.target.value)}
    />

    <button
        type="button"
        onClick={() => setShowConfirmPassword(!showConfirmPassword)}
        className="absolute right-3 top-1/2 -translate-y-1/2 text-gray-500"
    >
        {showConfirmPassword ? <Eye size={20} /> : <EyeOff size={20} />}
    </button>
</div>
    </div>
    <div className=" h-5">
        {confirmPassword && password !== confirmPassword && (
  <p className="text-red-500 text-xs">
    Passwords do not match
  </p>
)}
    </div>
    

    {/* select role */}
    <div className="flex flex-col gap-1">
        <div className=" flex gap-6 text-sm ">
            <div className='flex flex-col items-center'>
                <RoleBtn svg={<svg xmlns="http://www.w3.org/2000/svg" height="26px" viewBox="0 -960 960 960" width="26px" fill="#fff"><path d="M234-276q51-39 114-61.5T480-360q69 0 132 22.5T726-276q35-41 54.5-93T800-480q0-133-93.5-226.5T480-800q-133 0-226.5 93.5T160-480q0 59 19.5 111t54.5 93Zm146.5-204.5Q340-521 340-580t40.5-99.5Q421-720 480-720t99.5 40.5Q620-639 620-580t-40.5 99.5Q539-440 480-440t-99.5-40.5ZM480-80q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm100-95.5q47-15.5 86-44.5-39-29-86-44.5T480-280q-53 0-100 15.5T294-220q39 29 86 44.5T480-160q53 0 100-15.5ZM523-537q17-17 17-43t-17-43q-17-17-43-17t-43 17q-17 17-17 43t17 43q17 17 43 17t43-17Zm-43-43Zm0 360Z"/></svg>}
                    onClick={handleUser}
                />
                <span>User</span>
            </div>
            <div className='flex flex-col items-center'>
                <RoleBtn svg={<svg xmlns="http://www.w3.org/2000/svg" height="26px" viewBox="0 -960 960 960" width="26px" fill="#fff"><path d="M722.5-297.5Q740-315 740-340t-17.5-42.5Q705-400 680-400t-42.5 17.5Q620-365 620-340t17.5 42.5Q655-280 680-280t42.5-17.5ZM680-160q31 0 57-14.5t42-38.5q-22-13-47-20t-52-7q-27 0-52 7t-47 20q16 24 42 38.5t57 14.5ZM480-80q-139-35-229.5-159.5T160-516v-244l320-120 320 120v227q-19-8-39-14.5t-41-9.5v-147l-240-90-240 90v188q0 47 12.5 94t35 89.5Q310-290 342-254t71 60q11 32 29 61t41 52q-1 0-1.5.5t-1.5.5Zm200 0q-83 0-141.5-58.5T480-280q0-83 58.5-141.5T680-480q83 0 141.5 58.5T880-280q0 83-58.5 141.5T680-80ZM480-494Z"/></svg>}
                    onClick={handleAdmin}
                />
                <p>Admin</p>
            </div>
            <div className='flex flex-col items-center'>
                <RoleBtn svg={<svg xmlns="http://www.w3.org/2000/svg" height="26px" viewBox="0 -960 960 960" width="26px" fill="#fff"><path d="M160-80q-33 0-56.5-23.5T80-160v-480q0-33 23.5-56.5T160-720h160v-80q0-33 23.5-56.5T400-880h160q33 0 56.5 23.5T640-800v80h160q33 0 56.5 23.5T880-640v480q0 33-23.5 56.5T800-80H160Zm0-80h640v-480H160v480Zm240-560h160v-80H400v80ZM160-160v-480 480Zm280-200v120h80v-120h120v-80H520v-120h-80v120H320v80h120Z"/></svg>}
                onClick={handlePharmacist}
                />
                <p>Pharmacist</p>
            </div>
        </div>
    </div>
   

    {/* Remember Me + Forgot Password */}
    <div className="flex justify-between items-center w-80 text-sm">
        <label className="flex items-center gap-2">
            <input type="checkbox" />
            Remember me
        </label>

        
    </div>

    {/* Login Button */}
    <button
        onClick={handleRegister}
        className="
            w-80
            h-11
            bg-green-600
            text-white
            rounded-lg
            font-medium
            transition
            hover:bg-green-700
            cursor-pointer
        "
    >
        Register
    </button>
    <p className='text-sm underline cursor-pointer hover:text-blue-400' onClick={handleLogin}>Alreday have Account</p>
</div>
                </div>
            </section>
      
    </div>
  )
}

export default Register
