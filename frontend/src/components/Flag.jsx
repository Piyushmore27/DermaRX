import React from 'react'

function Flag({title,svg,className}) {
  return (
    <div className={` rounded-2xl ${className}`}>
      <div className="flex  items-center">
        <div className="title">{title}</div>
        <div className="title">{svg}</div>
      </div>
    </div>
  )
}

export default Flag
