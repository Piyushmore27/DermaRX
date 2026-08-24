import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import logo from '../assets/dermaLogo.png'
import loginPage from '../assets/loginPageImg.png'
function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const formData = new FormData();

    const navigate = useNavigate();

    const handleRegister = () => {
        navigate("/register");
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const user = {
            username: username,
            password: password
        };
        formData.append("input", username);
        formData.append("password", password);
        console.log(formData);

        try {
            const response = await fetch(
                "http://localhost:8080/backend/api/Login",
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
        
            }else{
                navigate("/login");
            }

            console.log(response.data);
        } catch (error) {
            console.log(error);
        }


    };
    return (
        <div>
            <div className='flex flex-row w-full h-screen bg-[#80D9EB] relative' >
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
                    <div className=" absolute z-40 top-22 left-20">
                        <img src={loginPage} className='w-150 '/>
                    </div>
                </section>
                <section className='right w-[80%] h-screen bg-white rounded-l-4xl'>
                    <div className="flex flex-col justify-center items-center  h-screen gap-4 ">
                        <div className="">

                            <h3 className='font-bold text-3xl py-2'>Welcome Back👋</h3>

                            <form className='border border-neutral-200 w-150 h-120 flex flex-col px-10 py-10 gap-4  rounded-2xl shadow'>
                                <div className="content flex flex-col gap-4">
                                    <p>Username : </p>
                                    <input placeholder="email@your.com" onChange={(e) => setUsername(e.target.value)} className="px-3 py-2 rounded-lg  border border-neutral-300 outline-none " />
                                    <p>Password : </p>
                                    <input placeholder="password" onChange={(e) => setPassword(e.target.value)} className="px-3 py-2 rounded-lg  border border-neutral-300 outline-none  " />
                                    <button onClick={handleSubmit} className='px-3 py-2 bg-[#80D9EB] rounded-lg text-white font-medium hover:cursor-pointer mt-4 shadow-2xl hover:bg-[#6dbccc] hover:shadow-none hover:transform hover:translate-y-0.5 transition-all duration-100'>Login</button>
                                    <button

                                        className='px-3 py-2  rounded text-neutral-500 border border-neutral-300 font-medium hover:cursor-pointer  hover:bg-neutral-100 flex justify-center gap-4 items-center transition-all duration-100 '>
                                        <svg width="24" height="24" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path opacity="0.987" fill-rule="evenodd" clip-rule="evenodd" d="M7.21022 1.06075C7.93522 0.97975 8.36422 0.97975 9.14322 1.06075C10.5222 1.26485 11.8004 1.90224 12.7932 2.88075C12.1223 3.51489 11.4603 4.15828 10.8072 4.81075C9.55655 3.75075 8.16055 3.50608 6.61922 4.07675C5.48855 4.59675 4.70122 5.43942 4.25722 6.60475C3.53166 6.06458 2.81555 5.51183 2.10922 4.94675C2.06013 4.92091 2.00407 4.91145 1.94922 4.91975C3.07122 2.75642 4.82455 1.46975 7.20922 1.05975" fill="#F44336" />
                                            <path opacity="0.997" fill-rule="evenodd" clip-rule="evenodd" d="M1.94625 4.92018C2.00292 4.91151 2.05659 4.92051 2.10725 4.94718C2.81358 5.51226 3.52969 6.06501 4.25525 6.60518C4.14108 7.05924 4.0691 7.52288 4.04025 7.99018C4.06492 8.44218 4.13659 8.88585 4.25525 9.32118L2.00025 11.1162C1.01825 9.06418 1.00025 6.99885 1.94625 4.92018Z" fill="#FFC107" />
                                            <path opacity="0.999" fill-rule="evenodd" clip-rule="evenodd" d="M12.6841 13.2897C11.982 12.6705 11.2469 12.0897 10.4821 11.5497C11.2488 11.0084 11.7141 10.2657 11.8781 9.32174H8.12109V6.71274C10.2878 6.69474 12.4534 6.71308 14.6181 6.76774C15.0288 8.99774 14.5544 11.0084 13.1951 12.7997C13.0335 12.9716 12.8622 13.1351 12.6841 13.2897Z" fill="#448AFF" />
                                            <path opacity="0.993" fill-rule="evenodd" clip-rule="evenodd" d="M4.255 9.32129C5.075 11.3593 6.57833 12.3106 8.765 12.1753C9.37883 12.1042 9.96735 11.8898 10.483 11.5493C11.2483 12.0906 11.9823 12.6706 12.685 13.2893C11.5716 14.2897 10.1521 14.8834 8.658 14.9733C8.31854 15.0004 7.97746 15.0004 7.638 14.9733C5.09267 14.6733 3.21333 13.3873 2 11.1153L4.255 9.32129Z" fill="#43A047" />
                                        </svg>

                                        Sign in with Google</button>

                                    <p className='text-center font-light'>Don't have account? <span className='font-medium underline hover:text-[#6dbccc] hover:cursor-pointer' onClick={handleRegister}>Sign up</span></p>
                                </div>


                            </form>
                        </div>
                    </div>
                </section>
            </div>

        </div>
    )
}

export default Login
