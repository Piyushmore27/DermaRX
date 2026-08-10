import React from 'react'

function RoleBtn({props ,svg,onClick}) {
  return (
    <div className="px-6 py-4 bg-green-300 cursor-pointer rounded-2xl hover:bg-green-400 focus:bg-green-400
    focus:outline-none" onClick={onClick} tabIndex={0}>
      {svg}
    </div>
  )
}

export default RoleBtn
