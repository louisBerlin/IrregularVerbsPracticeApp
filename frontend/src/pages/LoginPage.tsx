import {FormEvent, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

type LoginPageProps ={
    setUser :(user:string) => void
}
export default function LoginPage(props:LoginPageProps){

    const [username, setUsername] = useState<string>("")
    const [password, setPassword] = useState<string>("")
    const [ifBadRequest, setifBadRequest] = useState<boolean>(true)


    const navigate = useNavigate();
    function onSubmitLogin(e:FormEvent<HTMLFormElement>){
        e.preventDefault();
        axios.get("/api/user/me")//Warum? -> Durch das Get erhalten wir unseren ersten XSRF Token, damit wir POST request schicken dürfen!
            .then(() =>
                axios.post("/api/user/login", undefined, {auth: {username,  password}})
                    .then(response => props.setUser(response.data))
                    .then(() => navigate("/"))
                    .catch(() => {

                            setifBadRequest(false)
                            setUsername("")
                            setPassword("")
                        }
                    )

            )

    }
      function buttonClick(){
        setifBadRequest(true)
    }


    function loginGithub(){
        const host = window.location.host === 'localhost:5173' ? 'http://localhost:8080': window.location.origin;
        // const host = window.location.host === 'localhost:5173' ? 'https://irregularverbspracticeapp.onrender.com': window.location.origin;
        // const host = window.location.host === 'localhost:5173' ? 'localhost:8080': window.location.origin;

        window.open(host + '/oauth2/authorization/github', '_self')
    }



    return(
        <>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></link>
        <div className="columns is-centered">
            <div className="column is-5-tablet is-4-desktop is-3-widescreen">

            <div className=" container">

                <br/>

                <div className="box container">

                    <h3 className={"title"}>Login</h3>


                    <form onSubmit={onSubmitLogin}>


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


                        <button className={"button is-medium is-info"}>Login</button>
                    </form>


                </div>
                {!ifBadRequest && notification()}



                <button className={"button box container is-primary"} onClick={() => navigate("/r")}>No account ? Create
                    one here!
                </button>

                <button className={"button box container  is-danger is-medium"} onClick={loginGithub}>Login with Ghithub
                    <i className="fa fa-github" style={{fontSize:36}}></i>
                </button>


            </div>

            </div>
            </div>
        </>
    )




    function notification() {
        return (
            <div className="notification is-danger">
                <button className="delete" onClick={buttonClick}></button>
                Password or Username is wrong!
            </div>
        );
    }
}




