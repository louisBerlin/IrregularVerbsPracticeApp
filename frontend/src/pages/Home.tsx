import {useEffect, useState} from "react";
import axios from "axios";

type UserAttributes = {
    login: string,
    id: string,
    avatar_url: string,
    url: string,
    name: string,
    location: string,




}


export default function Home () {




    const[userAt, setUserAt] = useState<UserAttributes>({} as UserAttributes)






    useEffect(() =>
            getMe()
        , [userAt])


    function getMe(){
        axios.get("/api/auth/me3")
            .then(response => {
                setUserAt(response.data)

            })
    }



    return (
        <>


            <div className="container box">

                <div className="columns">
                    <div className="column">
                        <img src={userAt.avatar_url} alt="avatar"/>

                    </div>
                    <div className="column">
                        <p> ID : {userAt.id}  </p>
                        <p> Login : {userAt.login}  </p>
                        <p> Name : {userAt.name}  </p>
                        <p> Location : {userAt.location}  </p>
                    </div>

                </div>


            </div>




        </>
    )
}