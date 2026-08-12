import React, { useLayoutEffect, useRef, useState } from 'react'
import Navbar from '../components/Navbar'
import img from '../assets/homeImage1.png'
import Flag from '../components/Flag'
import MainButton from '../components/MainButton'
import '../css/Home.css'
import gsap from 'gsap'
import { ScrollTrigger } from 'gsap/ScrollTrigger'

import dermaLogo from '../assets/dermaLogo.png'
import ProductCard from '../components/ProductCard'

gsap.registerPlugin(ScrollTrigger)

function Home() {
  const [searchItem, setSearchItem] = useState("")

  const trackRef = useRef(null)
  const inputRef = useRef(null)

  const marqueeItems = [
    'Trusted Medicine For Your Family',
    'Trusted Medicine For Your Family',
    'Trusted Medicine For Your Family',
    'Trusted Medicine For Your Family',
    'Trusted Medicine For Your Family',
  ]

  useLayoutEffect(() => {
    const track = trackRef.current
    if (!track) return

    const totalWidth = track.scrollWidth / 2

    const ctx = gsap.context(() => {
      gsap.fromTo(
        track,
        { x: 0 },
        {
          x: -totalWidth,
          duration: 18,
          ease: 'none',
          repeat: -1,
          onRepeat: () => gsap.set(track, { x: 0 }),
        }
      )
    }, track)

    return () => ctx.revert()
  }, [])

  return (
    <div className="">
      <div className="homeBG absolute right-0 -z-10">
        <img src={img} className="h-screen" />
      </div>

      <div className="left w-full h-screen bg-gradient-to-r from-[#80D9EB] via-[#d8f8ff5d] to-transparent" />

      <div className="content absolute z-20 top-50 left-30 w-150 flex flex-col gap-4">
        <Flag
          title={'Trusted Medicine For Your Family'}
          className={'bg-[#22eabb9e] px-4 py-0.5 text-[#091b179e] font-bold text-center w-fit'}
        />

        <section className=''>
          <h2 className='text-6xl font-extrabold '>Your Health</h2>
          <h2 className='text-6xl font-extrabold text-[#19859b]'>Our Priority</h2>
        </section>

        <section className=''>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo omnis
            conseserunt facere ratione amet aliquid.
          </p>
        </section>

        <MainButton
          title={"Explore"}
          className={'bg-sky-400 w-fit px-4 py-2 rounded-2xl font-medium text-white flex justify-between items-center gap-1.5 shadow-2xl cursor-pointer hover:shadow-none duration-100 hover:transform hover:translate-y-1 '}
          svg={
            <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#FFFFFF">
              <path d="m560-240-56-58 142-142H160v-80h486L504-662l56-58 240 240-240 240Z" />
            </svg>
          }
        />
      </div>

      <section className="absolute bottom-10 w-full overflow-hidden">
        <div ref={trackRef} className="flex w-max gap-6">
          {[...marqueeItems, ...marqueeItems].map((item, index) => (
            <Flag
              key={`${item}-${index}`}
              title={item}
              className={'bg-[#19859ba8] px-4 py-2 text-white font-medium text-center w-fit'}
            />
          ))}
        </div>
      </section>

      <div className="products h-screen bg-gradient-to-r from-[#80D9EB] via-[#d8f8ff5d] to-[#80D9EB] flex justify-center">
        <div className="section products w-350 bg-white rounded-xl mt-0.5">
          <div className="flex justify-between items-center w-full h-fit px-4 py-4">
            <img src={dermaLogo} className='w-60 h-10' />
            <div
              onClick={() => inputRef.current.focus()}
              className="border border-neutral-400 focus-within:border-[#80D9EB] rounded-xl w-3xl h-15 flex items-center px-4"
            >
              <input
                ref={inputRef}
                type="text"
                value={searchItem}
                onChange={(e) => setSearchItem(e.target.value)}
                placeholder="Search"
                className="outline-none w-full h-full bg-transparent"
              />

              <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#046a54">
                <path d="M784-120 532-372q-30 24-69 38t-83 14q-109 0-184.5-75.5T120-580q0-109 75.5-184.5T380-840q109 0 184.5 75.5T640-580q0 44-14 83t-38 69l252 252-56 56ZM380-400q75 0 127.5-52.5T560-580q0-75-52.5-127.5T380-760q-75 0-127.5 52.5T200-580q0 75 52.5 127.5T380-400Z" />
              </svg>
            </div>
          </div>

          <div className="products px-4 grid grid-cols-6 gap-2">
            <ProductCard />
            <ProductCard />
            <ProductCard />
            <ProductCard />
            <ProductCard />
            <ProductCard />
            <ProductCard />
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home
