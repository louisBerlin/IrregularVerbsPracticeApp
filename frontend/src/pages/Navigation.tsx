import {useNavigate} from "react-router-dom";



export default function NavigationLogged() {





    const navigate = useNavigate();


    return (

        <header className="bd-header">


            <nav className="navbar" role="navigation" aria-label="main navigation">
                <div className="container">

                    <div className="navbar-brand">
                        <a className="navbar-item" href="/">

                            <img src="/logo3.png" alt="logo"/>
                            <p className="title is-4 is-spaced">VerbHero</p>


                        </a>

                    </div>


                    <div id="navbarBasicExample" className="navbar-menu">
                        <div className="navbar-start">


                        </div>

                        <div className="navbar-end">
                            <div className="navbar-item">
                                <div className="buttons">


                                    <button id="RouterNavLink" className="button is-light"
                                            onClick={() => navigate("/login")}>Log in
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


