

export default function NavigationLogged() {

    function login(){
     //   const host = window.location.host === 'localhost:5173' ? 'http://localhost:8080': window.location.origin;
        const host = window.location.host === 'localhost:5173' ? 'https://irregularverbspracticeapp.onrender.com': window.location.origin;


        window.open(host + '/oauth2/authorization/github', '_self')
    }


    return (

        <header className="bd-header">


            <nav className="navbar is-dark" role="navigation" aria-label="main navigation">
                <div className="navbar-brand">
                    <a className="navbar-item" href="http://localhost:5173">

                        IrregularVerbsPracticeApp


                    </a>

                </div>


                <div id="navbarBasicExample" className="navbar-menu">
                    <div className="navbar-start">


                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">


                                <button id="RouterNavLink" className="button is-light" onClick={login}>Log in</button>

                            </div>
                        </div>
                    </div>
                </div>
            </nav>


            <div className="container box">
                <h1 className="title">Welcome to the Irregular Verbs Practice App</h1>
                <h2 className="subtitle">Please log in to start practicing</h2>
                <button className="button is-primary" onClick={login}>Log in</button>
            </div>

        </header>
    )
}


