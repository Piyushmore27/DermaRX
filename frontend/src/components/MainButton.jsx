import React from 'react'

function MainButton({title,onClick,className,svg}) {
  return (
    <div className={className}
        onClick={onClick}
    >
      <div className="text">
        {title}
      </div>
      {svg}
      
    </div>
  )
}

export default MainButton
