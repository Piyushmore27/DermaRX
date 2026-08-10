import React from 'react'
import Navbar from '../components/Navbar'
import img from '../assets/homePage.png';


function Home() {
  return (
    <div className='relative w-full h-screen flex'>
      <section className='left  w-[50%] h-screen bg-green-200'>

      </section>
      <section className='right w-[50%]  bg-[#00b4d84d]'></section>
      <div className="content absolute z-10 w-350 h-150 bg-white/80 top-1/2 border border-neutral-100  rounded-2xl left-1/2
        -translate-x-1/2 -translate-y-1/2 shadow flex justify-between">
          <section className='left'>
            <div className="content flex h-150 flex-col justify-between px-10 py-20">
                        <div className="upper flex flex-col ">
                            
                            <span className='text-8xl font-bold'>Derma<i className='text-green-500'>Rx</i></span>
                            <span className='text-md'><i>Fastest Medical Service</i></span>
                        </div>
                        <div className="down w-xl text-xl">
                            
                        </div>
                    </div>
          </section>
          <section className='right'>
            <img src={img} width={430} className='mt-1'/>
          </section>


        </div>
        
    </div>
  )
}

export default Home
