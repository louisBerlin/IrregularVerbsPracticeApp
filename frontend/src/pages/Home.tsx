import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";



type UserAttributes = {
    login: string,
    id: string,
    avatar_url: string,
    url: string,
    name: string,
    location: string,
}

//  private long totalPoints;
//     private LocalDateTime timestamp;







export default function Home () {



    const navigate = useNavigate();



    const[userAt, setUserAt] = useState<UserAttributes>({login: "", id: "", avatar_url: "", url: "", name: "", location: ""})


    const[user, setUser] = useState<string>("anonymousUser")


    useEffect(() =>{
            getMe()
            getMe2()
            }
        , [])


    function getMe2(){
        axios.get("/api/auth/me2")
            .then(response => {
                setUser(response.data)
                //  alert(response.data)
                //  alert(userAt)
            })
    }




    useEffect(() =>
            getMe()
        , [])


    function getMe(){
        axios.get("/api/auth/me3")
            .then(response => {
                if(response.data === ""){
                    setUserAt({login: "", id: "", avatar_url: "", url: "", name: "", location: ""})
                    return
                }else {
                    setUserAt(response.data)


                }


            })
    }






    return (
        <>


            {userAt.login !== "" ?

                <div className="container box">

                    <div className="columns">
                        <div className="column">
                            <img src={userAt.avatar_url} alt="avatar"/>

                        </div>
                        <div className="column">
                            <p> ID : {userAt.id}  </p>
                            <p> Login : {userAt.login}  </p>
                            <p> Name : {userAt.name}  </p>
                            <p> Url : {userAt.url}  </p>
                            <p> Location : {userAt.location}  </p>
                        </div>

                    </div>


                </div> : <></>}

                {user === "anonymousUser" ?

                <>
              <br/>
                <div className="container box">
                    <h1 className="title">Welcome to the Irregular Verbs Practice App {userAt.id}</h1>
                    <h2 className="subtitle">Please log in to start practicing</h2>
                    <button className="button is-primary" onClick={() => navigate("/login")}>Log in</button>
                </div>
                </>

                     : <></>

            }



    </>)
}