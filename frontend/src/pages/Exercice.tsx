import {useEffect, useState} from "react";
import axios from "axios";








export type VerbList = {
    userId : string,
    verbId: string,
    infinitive: string,
    table2: string,
    table3: string,
    level : number,
    nbOfBadAnswers: number,
    nbOfGoodAnswers: number
}









export default function Exercice () {




    const [barProgress, setBarProgress] = useState(0);


         const [dataVerbList, setDataVerbList] = useState<VerbList[]>([])
         const [dataVerbListReturn, setDataVerbListReturn] = useState<VerbList[]>([])


    const [nbExercice, setNbExercice] = useState<number>(0)
         const [inputValue1, setInputValue1] = useState('');
         const [inputValue2, setInputValue2] = useState('');
         const [inputValue3, setInputValue3] = useState('');


    const [inputClassName2, setinputClassName2] = useState('input is-medium');
    const [inputClassName3, setinputClassName3] = useState('input is-medium');



    function randomIntFromInterval(min:number, max:number) { // min and max included
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    const getData = async ( ) => {
        const dataFromAxios =  await axios.get('/api/get10verbsforexercice')
            .then(response => {
                setDataVerbList(response.data);
                console.log(response.data)

            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });

    }


    useEffect(() => {
        function handleKeyDown(e: KeyboardEvent)     {
            if (e.key === 'Enter') {
                console.log(e.keyCode);
                if(inputValue2 !== '' || inputValue3 !== '') {
                    console.log(inputValue2);
                    console.log(inputValue3);

                    eventButton()
                }
            }
        }



        document.addEventListener('keydown', handleKeyDown);

        // Don't forget to clean up
        return function cleanup() {
            document.removeEventListener('keydown', handleKeyDown);
        }
    }, []);


    useEffect(()=>{
        getData()

    },[])


    useEffect(() => {
        if(dataVerbList) {
            initQuestion()
        }
    }, [dataVerbList])








 /*   function fatchDataVerb(){

         axios.get('/api/get10verbswithuserrating')
            .then(response=>{
                setDataVerbList(response.data)
                console.log(response.data)
                setLoading(false); //set loading state

            })
    }

        const fetchDataVerb = () => {
        axios.get('/api/get10verbswithuserrating')
            .then(response => {
                setDataVerbList(response.data);
                console.log(response.data)

            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

  */



    function initQuestion(){

        const nb = randomIntFromInterval(0, dataVerbList.length - 1)
        setinputClassName2("input is-medium ")
        setinputClassName3("input is-medium ")
        setNbExercice(nb)
        setInputValue1(dataVerbList[nb]?.infinitive)
        setInputValue2("")
        setInputValue3("")
    }

    const delay = (ms: number | undefined) => new Promise(res => setTimeout(res, ms));


    async function eventButton() {


        if (inputValue1 === dataVerbList[nbExercice]?.infinitive && inputValue2 === dataVerbList[nbExercice].table2 && inputValue3 === dataVerbList[nbExercice].table3) {
            //alert("bravo")
            setinputClassName2("input is-medium is-success is-focused")
            setinputClassName3("input is-medium is-success is-focused")

            await delay(1500);

            if (dataVerbList[nbExercice].level < 5)
                dataVerbList[nbExercice].level = dataVerbList[nbExercice].level + 1

            dataVerbList[nbExercice].nbOfGoodAnswers = dataVerbList[nbExercice].nbOfGoodAnswers + 1

            setBarProgress(barProgress + 1)

            if (dataVerbList[nbExercice].level === 5) {
                dataVerbListReturn.push(dataVerbList[nbExercice])
                setDataVerbListReturn(dataVerbListReturn)
                dataVerbList.splice(nbExercice, 1)
                setDataVerbList(dataVerbList)
            }
            if (dataVerbList.length === 0) {
                axios.post(
                    // 1. Parameter = die URL
                    '/api/setanswers',
                    // 2. Parameter = der Request-Body
                    dataVerbListReturn
                )


            } else {
                initQuestion()
            }
        } else {
            alert("try again : good answer is : " + dataVerbList[nbExercice].infinitive + " " + dataVerbList[nbExercice].table2 + " " + dataVerbList[nbExercice].table3)
            if (dataVerbList[nbExercice].level > 1) {
                dataVerbList[nbExercice].level = dataVerbList[nbExercice].level - 1
                setBarProgress(barProgress + 1)

            }
            dataVerbList[nbExercice].nbOfBadAnswers = dataVerbList[nbExercice].nbOfBadAnswers + 1
            initQuestion()
        }
    }






    return (
        <>


            <div className="container box">

                <progress className="progress is-warning" value={barProgress} max="50">
                    75%
                </progress>

            </div>


            <div className="columns container">
                <div className="column">

                    <div className="box container">


                        <p className="title is-1 is-spaced">Exercice</p>


                        <div className="field">
                            <label className="label">infinitive</label>
                            <div className="control">
                                <input className="input is-medium" value={inputValue1}
                                       onChange={event => setInputValue1(event.target.value)} type="text"
                                       placeholder="Text input"
                                       readOnly/>
                            </div>
                        </div>
                        <div className="field">
                            <label className="label">table2</label>
                            <div className="control">
                                <input className={inputClassName2} value={inputValue2}
                                       onChange={event => setInputValue2(event.target.value)} type="text"
                                       placeholder="Text input"/>
                            </div>
                        </div>
                        <div className="field">
                            <label className="label">table3</label>
                            <div className="control">
                                <input className={inputClassName3} value={inputValue3}
                                       onChange={event => setInputValue3(event.target.value)} type="text"
                                       placeholder="Text input"/>
                            </div>
                        </div>
                        <button className={"button"} onClick={eventButton}>Next</button>


                    </div>

                </div>
                <div className="column">


                    <div className="container box">

                        <progress className="progress is-warning" value={barProgress} max="50">
                            75%
                        </progress>

                    </div>

                </div>

            </div>


            <div className="box container">

                {dataVerbList?.length === 0 ? <h1>NO DATA</h1>
                    :
                    <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                        <thead>
                        <tr>

                            <th>verbId</th>
                            <th>infinitive</th>
                            <th>level</th>
                            <th>nbOfGoodAnswers</th>
                            <th>nbOfBadAnswers</th>
                        </tr>
                        </thead>
                        <tbody>

                        {dataVerbList.map((p: VerbList) => {
                            return (
                                <tr key={p.verbId}>
                                    <td>{p.verbId}</td>
                                    <td>{p.infinitive}</td>

                                    <td>{p.level}</td>
                                    <td>{p.nbOfGoodAnswers}</td>
                                    <td>{p.nbOfBadAnswers}</td>


                                </tr>
                            )


                        })}
                        </tbody>

                    </table>
                }

            </div>


            <div className="box container">

                {dataVerbListReturn?.length === 0 ? <h1>NO DATA</h1>
                    :
                    <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                        <thead>
                        <tr>

                            <th>verbId</th>
                            <th>infinitive</th>
                            <th>level</th>
                            <th>nbOfGoodAnswers</th>
                            <th>nbOfBadAnswers</th>
                        </tr>
                        </thead>
                        <tbody>

                        {dataVerbListReturn.map((p: VerbList) => {
                            return (
                                <tr key={p.verbId}>
                                    <td>{p.verbId}</td>
                                    <td>{p.infinitive}</td>

                                    <td>{p.level}</td>
                                    <td>{p.nbOfGoodAnswers}</td>
                                    <td>{p.nbOfBadAnswers}</td>


                                </tr>
                            )


                        })}
                        </tbody>

                    </table>
                }
            </div>


            <div className="container box">

                <img src="https://www.dict.cc/img/vt/box5.png"/>


            </div>
        </>
    )
}