
import './App.css'



import 'bulma/css/bulma.min.css';
import ListVerb from "./pages/ListVerb.tsx";
import NavigationLogged from "./pages/NavigationLogged.tsx";
import Navigation from "./pages/Navigation.tsx";
import Footer from "./pages/Footer.tsx";
import {Navigate, Outlet, Route, Routes} from "react-router-dom";
import Home from "./pages/Home.tsx";
import Login from "./pages/Login.tsx";
import Exercice from "./pages/Exercice.tsx";
import {useEffect, useState} from "react";
import axios from "axios";







function App() {


    const[user, setUser] = useState<string>("anonymousUser")
 

    useEffect(() =>
            getMe()
        , [user])


    function getMe(){
        axios.get("/api/auth/me2")
            .then(response => {
                setUser(response.data)
              //  alert(response.data)

              //  alert(userAt)
            })
    }


      function ProtectedRoutes(props: { user: string }) {

        if (props.user === undefined) {
            return <div>Loading...</div>
        }

        return (
            user !== "anonymousUser" ? <Outlet /> : <Navigate to = "/" />
        )
    }


  return (
      <>

      {user === "anonymousUser" ?
          <Navigation/> : <><NavigationLogged/>

              <div className="box container">Welcome to {user}.</div>

          </>
      }


          <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/login" element={<Login/>}/>

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


