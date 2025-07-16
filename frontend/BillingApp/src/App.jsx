
import { Route, Routes } from 'react-router-dom'
import './App.css'
import MenuBar from './components/MenuBar/MenuBar'
import Dashboard from './pages/DashBoard/Dashboard'
import ManageCategory from './pages/ManageCategory/ManageCategory'
import ManageUsers from './pages/ManageUsers/ManageUsers'
import ManageItems from './pages/ManageItems/ManageItems'
import Explore from './pages/Explore/Explore'
import { Toaster } from 'react-hot-toast'



const App =()=> {
  

  return (
    <>
     
     <MenuBar/>
     <Toaster/>
     <Routes>
      <Route path='/dashboard' element={<Dashboard/>} />
      <Route path='/' element={<Dashboard/>} />
      <Route path='/category' element={<ManageCategory/>} />
      <Route path='/users' element={<ManageUsers/>} />
      <Route path='/items' element={<ManageItems/>} />
      <Route path='/explore' element={<Explore/>} />

     </Routes>
    
    </>
  )
}

export default App
