import {useEffect, useState} from "react";
import axios from "axios";



export type Verb = {
    id: string,
    infinitive: string,
    table2: string,
    table3: string
}

export default function ListVerb (){





    const [data, setData] = useState<Verb[]>([])

    useEffect(()=>{
        fatchData()
    },[])

    function fatchData(){

        axios.get('/api/getverbs')
            .then(response=>{
                setData(response.data)
            })
    }





    return (
        <>


            <div className="container box">

            <progress className="progress is-warning is-large" value="75" max="100">
                75%
            </progress>

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
                            <th>Level</th>
                            <th>bf of try</th>
                        </tr>
                        </thead>

                        <tbody>

                        {data.map((p: Verb) => {
                            return (
                                <tr key={p.id}>
                                    <td>{p.id}</td>
                                    <td>{p.infinitive}</td>
                                    <td>{p.table2}</td>
                                    <td>{p.table3}</td>
                                    <td>1</td>
                                    <td>1</td>

                                </tr>
                            )


                        })}
                        </tbody>

                    </table>
                }


            </div>

        </>
    )
}