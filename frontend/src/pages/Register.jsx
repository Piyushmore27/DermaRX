import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import MainButton from '../components/MainButton';
import RoleBtn from '../components/RoleBtn';
import { Eye, EyeOff } from "lucide-react";
import registerPage from '../assets/registerPAgeImg2.png'
import { useAuth } from '../context/AuthContext';
import api from '../api/axios';

function Register() {
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfimPassword] = useState("");
    const [role, setRole] = useState("");
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);
    const [error, setError] = useState("");
    const [showError, setShowError] = useState(false);

    const { login } = useAuth();


    const navigate = useNavigate();

    const handleLogin = () => {
        navigate("/login");
    }

    const handleRegister = async (e) => {
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


        const registerData = {
            username: name,
            password: password,
            
        };

        console.log(registerData);
        

        try {

            const response = await api.post("/api/Register", registerData);


            const data = response.data;

            console.log("Data", data);

            if (data.success) {
                login(data.object);
                navigate("/");
            } else {
                setError(data.message);
                setShowError(true);

                setTimeout(() => {
                    setShowError(false);
                }, 5000);
            }

        } catch (error) {
            console.error("Registration error:", error);

            setError(
                error.response?.data?.message ||
                "Registration failed. Please try again."
            );

            setShowError(true);

            setTimeout(() => {
                setShowError(false);
            }, 5000);
        }
    };
    return (
        <div className='flex flex-row w-full h-screen bg-[#80D9EB] relative'>
            <section className='left w-[40%] h-screen '>
                <div className="content flex h-150 flex-col justify-between px-10 py-20">
                    <div className="upper mt-5 flex flex-col font-medium">
                        <span>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Earum dolorum commodi repellendus hic a voluptates necessitatibu</span>

                    </div>
                    <div className="down w-xl text-xl">

                    </div>
                    <div className=" absolute top-10 bg-white rounded-4xl p-2">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#19859b"><path d="M521-298q-45.71 46-110.86 46Q345-252 299-297.8q-46-45.81-46-110.5 0-64.7 46-110.7l143-143q45.97-46 111.49-46Q619-708 665-662.2q46 45.81 46 110.5 0 64.7-46 110.7L521-298Zm-140-83q12 12 28.5 12.5T438-380l33-34-57-57-33 34q-12 11.87-12 27.94Q369-393 381-381Zm201-198q-12-12-28.5-13T525-580l-34 35 57 57 34-35q11-12 11.5-28T582-579ZM212-86q-51.98 0-88.99-37.01T86-212v-536q0-51.97 37.01-88.99Q160.02-874 212-874h135q20-38 55.5-59t77.5-21q42 0 77.5 21t55.5 59h135q51.97 0 88.99 37.01Q874-799.97 874-748v536q0 51.98-37.01 88.99Q799.97-86 748-86H212Zm0-126h536v-536H212v536Zm295-581q11-11 11-27t-11-27q-11-11-27-11t-27 11q-11 11-11 27t11 27q11 11 27 11t27-11ZM212-212v-536 536Z" /></svg>
                    </div>
                </div>
                <div className=" absolute z-40 top-40 left-90">
                    <img src={registerPage} className='w-100 ' />
                </div>
            </section>
            <div className="right w-[60%] bg-white rounded-l-4xl flex flex-col justify-center items-center ">
                <div className="content flex flex-col gap-2 p-4 relative ">
                    {showError && (
                        <div
                            className={`
                                     bg-red-100 border border-red-400 text-red-700
                                        px-2 py-1 rounded w-full mb-4 text-center
                                        absolute z-40 top-5
                                        transition-all duration-500 ease-out
                                        ${showError
                                    ? "translate-y-0 opacity-100"
                                    : "translate-y-10 opacity-0"
                                }
                            `}
                        >
                            {error}
                        </div>
                    )}
                    <div className="heading">
                        <h3 className='font-bold text-2xl px-4'>Create Account</h3>
                    </div>
                    <div className="form w-140 h-120  rounded-2xl">
                        <div className="px-4 flex justify-between">
                            <button

                                className='px-3 py-2  rounded text-neutral-500  font-medium hover:cursor-pointer  hover:bg-neutral-100 flex justify-center gap-4 items-center transition-all duration-100 '>
                                <svg width="24" height="24" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path opacity="0.987" fill-rule="evenodd" clip-rule="evenodd" d="M7.21022 1.06075C7.93522 0.97975 8.36422 0.97975 9.14322 1.06075C10.5222 1.26485 11.8004 1.90224 12.7932 2.88075C12.1223 3.51489 11.4603 4.15828 10.8072 4.81075C9.55655 3.75075 8.16055 3.50608 6.61922 4.07675C5.48855 4.59675 4.70122 5.43942 4.25722 6.60475C3.53166 6.06458 2.81555 5.51183 2.10922 4.94675C2.06013 4.92091 2.00407 4.91145 1.94922 4.91975C3.07122 2.75642 4.82455 1.46975 7.20922 1.05975" fill="#F44336" />
                                    <path opacity="0.997" fill-rule="evenodd" clip-rule="evenodd" d="M1.94625 4.92018C2.00292 4.91151 2.05659 4.92051 2.10725 4.94718C2.81358 5.51226 3.52969 6.06501 4.25525 6.60518C4.14108 7.05924 4.0691 7.52288 4.04025 7.99018C4.06492 8.44218 4.13659 8.88585 4.25525 9.32118L2.00025 11.1162C1.01825 9.06418 1.00025 6.99885 1.94625 4.92018Z" fill="#FFC107" />
                                    <path opacity="0.999" fill-rule="evenodd" clip-rule="evenodd" d="M12.6841 13.2897C11.982 12.6705 11.2469 12.0897 10.4821 11.5497C11.2488 11.0084 11.7141 10.2657 11.8781 9.32174H8.12109V6.71274C10.2878 6.69474 12.4534 6.71308 14.6181 6.76774C15.0288 8.99774 14.5544 11.0084 13.1951 12.7997C13.0335 12.9716 12.8622 13.1351 12.6841 13.2897Z" fill="#448AFF" />
                                    <path opacity="0.993" fill-rule="evenodd" clip-rule="evenodd" d="M4.255 9.32129C5.075 11.3593 6.57833 12.3106 8.765 12.1753C9.37883 12.1042 9.96735 11.8898 10.483 11.5493C11.2483 12.0906 11.9823 12.6706 12.685 13.2893C11.5716 14.2897 10.1521 14.8834 8.658 14.9733C8.31854 15.0004 7.97746 15.0004 7.638 14.9733C5.09267 14.6733 3.21333 13.3873 2 11.1153L4.255 9.32129Z" fill="#43A047" />
                                </svg>

                                Sign in with Google</button>
                            <button

                                className='px-3 py-2  rounded text-neutral-500  font-medium hover:cursor-pointer  hover:bg-neutral-100 flex justify-center gap-4 items-center transition-all duration-100 '>
                                <svg width="20" height="20" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <g clip-path="url(#clip0_30_6)">
                                        <path d="M6.68125 15.9187C2.88125 15.2406 0 11.9594 0 8C0 3.6 3.6 0 8 0C12.4 0 16 3.6 16 8C16 11.9594 13.1188 15.2406 9.31875 15.9187L8.87813 15.5594H7.11875L6.68125 15.9187Z" fill="#0866FF" />
                                        <path d="M11.1186 10.2408L11.4779 8.0002H9.35918V6.44082C9.35918 5.8002 9.5998 5.32207 10.5592 5.32207H11.5998V3.28145C11.0404 3.2002 10.3998 3.12207 9.84043 3.12207C7.9998 3.12207 6.72168 4.24082 6.72168 6.24082V8.0002H4.72168V10.2408H6.72168V15.8814C7.1623 15.9627 7.60293 16.0002 8.04043 16.0002C8.48105 16.0002 8.92168 15.9596 9.35918 15.8814V10.2408H11.1186Z" fill="white" />
                                    </g>
                                    <defs>
                                        <clipPath id="clip0_30_6">
                                            <rect width="16" height="16" fill="white" />
                                        </clipPath>
                                    </defs>
                                </svg>


                                Continue with Facebook</button>
                        </div>
                        <div className="content p-4 flex flex-col justify-center items-center gap-4 ">

                            <div className="  p-4">
                                <div className="form flex flex-col justify-center items-center gap-4 py-6 w-full px-4 ">

                                    {/* Username */}
                                    <div className="flex flex-col gap-2">
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
                focus:border-sky-500
                focus:ring-2
                focus:ring-sky-200
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
            focus:border-sky-500
            focus:ring-2
            focus:ring-sky-200
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
                                        className="px-3 py-2 w-full bg-[#80D9EB] rounded-lg text-white font-medium hover:cursor-pointer mt-4 shadow-2xl hover:bg-[#6dbccc] hover:shadow-none hover:transform hover:translate-y-0.5 transition-all duration-100"
                                    >
                                        Register
                                    </button>
                                    <p className='text-sm underline-none cursor-pointer hover:text-sky-400 ' onClick={handleLogin}>Alreday have Account</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Register
