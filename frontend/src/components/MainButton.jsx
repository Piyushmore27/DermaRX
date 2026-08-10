import React from 'react'

function MainButton({title,onClick}) {
  return (
    <div className=" border border-green-400 px-4 py-1  rounded-2xl text-neutral-700 cursor-pointer text-center hover:bg-green-300"
        onClick={onClick}
    >
      <div className="text">
        {title}
      </div>
      
    </div>
  )
}

export default MainButton
