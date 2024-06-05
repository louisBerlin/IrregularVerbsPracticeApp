import {Navigate, Outlet} from "react-router-dom";

type ProtectedRouteProps = {
    user:string | undefined
}
export default function ProtectedRoute(props:ProtectedRouteProps){

    const user = props.user !== undefined && props.user !== "anonymousUser"

    console.log("user : "+props.user)
    return(
        user ? <Outlet/> : <> <Navigate to={"/login"} /> </>
    )
}