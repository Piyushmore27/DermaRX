import React from 'react'
import sumoCold from '../assets/sumoCold.avif'
import MainButton from './MainButton'
function ProductCard() {
  return (
    <div>
      <div className="content w-fit border border-neutral-300 rounded-lg flex flex-col justify-center px-4 py-2 ">
        <div className="img">
            <img src={sumoCold} width={150} />
        </div>
        <div className="data w-40 font-medium">Buy Sumo Cold Tablet online | Uses, Side Effects, Price and substitutes </div>
        <div className="Price font-extrabold ">₹50.50</div>
        <div className="AddBtn">
            <MainButton title={"Add Cart"} className={'bg-[#19859b] text-white font-semibold rounded text-center cursor-pointer py-0.5'}/>
        </div>
      </div>
      
    </div>
  )
}

export default ProductCard
