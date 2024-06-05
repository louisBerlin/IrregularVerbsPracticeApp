import {Link} from "react-router-dom";
import axios from "axios";


export default function NavigationLogged() {

    function logout(){
        axios.get("/api/user/logout")
            .then(() => {
              //
                //  setUser("anonymousUser")
                window.location.href = "/"})
    }

   /* function logout() {
        axios.post("/api/user/logout")
            .then(() => setUser("anonymousUser"))
    }

    */

    return (

        <header className="bd-header">


            <nav className="navbar" role="navigation" aria-label="main navigation">


<div className="container">
                <div className="navbar-brand">
                    <a className="navbar-item " href="/">


                        <img src="/logo3.png" alt="logo" />

                        <p className="title is-4 is-spaced">VerbHero</p>


                    </a>
                    <div className="navbar-burger js-burger" data-target="navMenuColordark-example">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>


                <div id="navbarBasicExample" className="navbar-menu ">
                    <div className="navbar-start">


                        <Link id="RouterNavLink" className="navbar-item " to="/list">Verb list</Link>


                        <Link id="RouterNavLink" className="navbar-item " to="/exercice">Start exercice</Link>


                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">


                                <button id="RouterNavLink" className="button is-light" onClick={logout}>Log out
                                </button>


                            </div>
                        </div>
                    </div>
                </div>



</div>



            </nav>

        </header>
    )
}


