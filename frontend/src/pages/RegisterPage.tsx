import {FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";


export default function RegisterPage(){

    const [username, setUsername] = useState<string>("")
    const [password, setPassword] = useState<string>("")

    const navigate = useNavigate();
    function onSubmitRegister(e:FormEvent<HTMLFormElement>){
        e.preventDefault();
        axios.get("/api/user/me") //Warum? -> Durch das Get erhalten wir unseren ersten XSRF Token, damit wir POST request schicken dürfen!
            .then(() =>
                axios.post("/api/user/register",  {username,  password})
                    .then(() => navigate("/login")))

    }

    return(
        <>


            <br/>


            <div className="box container">

                <h3 className={"title"}>Register</h3>
                <form onSubmit={onSubmitRegister}>


                    <div className="field">

                        <input className="input is-medium" value={username} placeholder={"Please enter Username"}
                               type={"text"}
                               onChange={e => setUsername(e.target.value)}/>

                    </div>
                    <div className="field">

                        <input className="input is-medium" value={password} placeholder={"Please enter Password"}
                               type={"password"}
                               onChange={e => setPassword(e.target.value)}/>
                    </div>
                    <button className={"button"}>Register</button>
                </form>
            </div>
        </>
    )
}