import {useEffect, useState} from "react";
import axios from "axios";
import {LineChart} from "@mui/x-charts/LineChart";



export type Verb = {
    verbId: string,
    infinitive: string,
    table2: string,
    table3: string,
    urlAudio: string,
    levelRating: number, // 1 to 5
    levelPoints: number,  // 0 to 100
    nbOfGoodAnswers: number,
    nbOfBadAnswers: number
}

type ProgressAttributes = {
    totalPoints: number,
    timestamp: string

}



export default function ListVerb (){



    const[progress, setProgress] = useState<ProgressAttributes[]>([])



    const [data, setData] = useState<Verb[]>([])

    useEffect(()=>{
        getMe();
        getProgress();

},[])


    function date () {
        let d : Date[] = []
        for (let i = 0; i < progress.length; i++){


            d.push(new Date(progress[i].timestamp))

        }

        console.log(d)

        return d

    }



    function getMe(){
        axios.get("/api/auth/me2")
            .then(response => {
                //setUser(response.data)


                fatchData(response.data)








            })
    }

    function fatchData(username:string){

        axios.post('/api/getverbswithuserrating',username)
            .then(response=>{
                setData(response.data)
            })
    }



    function getProgress(){

        axios.get("/api/auth/me2")
            .then(response => {
                //setUser(response.data)

                axios.post("/api/progression/getAll",response.data)
                    .then(response => {
                        setProgress(response.data)




                    })




            })

    }


    function startAudio  (url : string)  {
        const audio = new Audio(url)
        audio.play()
    }





    return (
        <>


            <div className="container box">


                <p className="title is-3 is-spaced">Progression total :</p>

                {progress?.length === 0 ?
                    <progress className="progress is-warning is-large" value={0}
                              max="4000">
                    </progress>
                    :
                    <progress className="progress is-warning is-large" value={progress[progress.length - 1].totalPoints}
                              max="4000">
                    </progress>
                }

                <LineChart
                    xAxis={[{
                        //data: [1, 2, 3, 5, 8, 10]
                        data: date(),
                        scaleType: 'time',
                        valueFormatter: (date) => date.toDateString(),
                        //progress.map((p) => p.totalPoints)
                    }]}
                    series={[
                        {
                            //data: [2, 5.5, 2, 8.5, 1.5, 5],
                            data: progress.map((p) => p.totalPoints),

                        },
                    ]}
                    // width={500}
                    height={300}
                />
            </div>


            <div className="container box">

                {data?.length === 0 ? <h1>NO DATA</h1>
                    :
                    <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">


                        <thead>
                        <tr>

                            <th>verbId</th>
                            <th>infinitive</th>
                            <th>T2</th>
                            <th>T3</th>
                            <th colSpan={5}>Level</th>
                            <th>points</th>
                            <th>bf of try</th>
                            <th>Audio</th>
                        </tr>
                        </thead>

                        <tbody>

                        {data.map((p: Verb) => {
                            return (
                                <tr key={p.verbId}>
                                    <td>{p.verbId}</td>
                                    <td>{p.infinitive}</td>
                                    <td>{p.table2}</td>
                                    <td>{p.table3}</td>
                                    {showLevel(p.levelRating)}
                                    <td>{p.levelPoints}</td>
                                    <td>{p.nbOfGoodAnswers + p.nbOfBadAnswers}</td>
                                    <td>  <button onClick={() => startAudio(p.urlAudio)}>Play</button> </td>
                                </tr>
                            )


                        })}
                        </tbody>

                    </table>
                }


            </div>


            <div className="container box">



            </div>


        </>
    )
}



 function showLevel ( level : number) {

        // if level is 1 2 3 4 5
        // then return a td with the level

        // use switch case
        // case 1: return <td className={"is-danger"}>{level}</td>


        { switch(level) {
        case 1:
          return   <>
                <td className={"is-danger"}>{level}</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </>

        case 2:
            return  <>
                <td className={"is-warning"}></td>
                <td className={"is-warning"}>{level}</td>
                <td></td>
                <td></td>
                <td></td>
            </>
            case 3:
                return <>
                    <td className={"is-danger"}></td>
                    <td className={"is-danger"}></td>
                    <td className={"is-danger"}>{level}</td>
                    <td></td>
                    <td></td>
                </>
            case 4:
                return <>
                    <td className={"is-info"}></td>
                    <td className={"is-info"}></td>
                    <td className={"is-info"}></td>
                    <td className={"is-info"}>{level}</td>

                    <td></td>
                </>
            case 5:
                return <>
                    <td className={"is-success"}></td>
                    <td className={"is-success"}></td>
                    <td className={"is-success"}></td>
                    <td className={"is-success"}></td>
                    <td className={"is-success"}>{level}</td>

                </>
            default:
                return <>
                <td className={"is-danger"}></td>
                <td className={"is-danger"}>{level}</td>
                <td></td>
                <td></td>
                <td></td>
            </>  }  }



}