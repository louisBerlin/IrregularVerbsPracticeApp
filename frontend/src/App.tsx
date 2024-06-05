
import './App.css'



import 'bulma/css/bulma.min.css';
import ListVerb from "./pages/ListVerb.tsx";
import NavigationLogged from "./pages/NavigationLogged.tsx";
import Navigation from "./pages/Navigation.tsx";
import Footer from "./pages/Footer.tsx";
import { Route, Routes} from "react-router-dom";
import Home from "./pages/Home.tsx";
import LoginPage from "./pages/LoginPage.tsx";
import Exercice from "./pages/Exercice.tsx";
import ProtectedRoutes from "./pages/ProtectedRoutes.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import Test from "./pages/Test.tsx";
import RegisterPage from "./pages/RegisterPage.tsx";







function App() {


    const[user, setUser] = useState<string>("anonymousUser")
 

    useEffect(() =>
            getMe()
        , [])


    function getMe(){
        axios.get("/api/auth/me2")
            .then(response => {
                setUser(response.data)
              //  alert(response.data)
              //  alert(userAt)
            })
    }







  return (
      <>

      {user === "anonymousUser" ?
          <Navigation/> : <><NavigationLogged/>

              <br/>

              <div className="box container notification is-warning is-light">Welcome to {user}.</div>

          </>
      }


          <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/login" element={<LoginPage  setUser={setUser}/>}/>
              <Route path="/test" element={<Test/>}/>
              <Route path="/r" element={<RegisterPage/>}/>



              <Route element={<ProtectedRoutes user={user} />}>
                  <Route path="/exercice" element={<Exercice/>}/>
                  <Route path="/list" element={<ListVerb/>}/>
              </Route>

          </Routes>



          <Footer/>

      </>
  )
}

export default App


