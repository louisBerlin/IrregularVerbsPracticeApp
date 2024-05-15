
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



type UserAttributes = {
    login: string,
    id: number,
    node_id: string,
    avatar_url: string,
    gravatar_id: string,
    url: string,
    html_url: string,
    followers_url: string,
    following_url: string,
    gists_url: string,
    starred_url: string,
    subscriptions_url: string,
    organizations_url: string,
    repos_url: string,
    events_url: string,
    received_events_url: string,
    type: string,
    site_admin: boolean,
    name: string,
    company: string,
    blog: string,
    location: string,
    email: string,
    hireable: string,
    bio: string,
    twitter_username: string,
    public_repos: number,
    public_gists: number,
    followers: number,
    following: number,
    created_at: string,
    updated_at: string

}





function App() {

    const[userAt, setUserAt] = useState<UserAttributes>({} as UserAttributes)

    const[user, setUser] = useState<string>("anonymousUser")
    function login(){
        const host = window.location.host === 'localhost:5173' ? 'http://localhost:8080': window.location.origin;

        window.open(host + '/oauth2/authorization/github', '_self')
    }

    useEffect(() =>
            getMe()
        , [user])

    function logout(){
        axios.get("/api/auth/logout")
            .then(() => getMe())
    }
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


