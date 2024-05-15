import {Link} from "react-router-dom";
import axios from "axios";


export default function NavigationLogged() {

    function logout(){
        axios.get("/api/auth/logout")
            .then(() => window.location.href = "http://localhost:5173")
    }


    return (

        <header className="bd-header">


            <nav className="navbar is-dark" role="navigation" aria-label="main navigation">
                <div className="navbar-brand">
                    <a className="navbar-item " href="http://localhost:5173">


                        <h3 className="navbar-item title is-3">IrregularVerbsPracticeApp</h3>


                    </a>
                    <div className="navbar-burger js-burger" data-target="navMenuColordark-example">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>


                <div id="navbarBasicExample" className="navbar-menu">
                    <div className="navbar-start">
                        <Link id="RouterNavLink" className="navbar-item is-active " to="/">Home</Link>


                        <Link id="RouterNavLink" className="navbar-item " to="/list">List</Link>


                        <Link id="RouterNavLink" className="navbar-item " to="/exercice">exercice</Link>


                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">


                                <button id="RouterNavLink" className="button is-light" onClick={logout}>Log out</button>


                            </div>
                        </div>
                    </div>
                </div>
            </nav>

        </header>
    )
}


