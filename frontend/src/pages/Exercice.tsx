import React, {useEffect, useState} from "react";
import axios from "axios";





// Sentence (String verbId,String baseForm, String pastSimple, String pastParticiple)
export type Sentence = {
    verbId: string,
    baseForm: string,
    pastSimple: string,
    pastParticiple: string
}


export type VerbList = {
    userId : string,
    verbId: string,
    infinitive: string,
    urlAudio: string,
    table2: string,
    table3: string,
    level : number,
    sentence: Sentence,
    nbOfBadAnswers: number,
    nbOfGoodAnswers: number
}










export default function Exercice () {



    const [exercicTerminated, setExercicTerminated] = useState(false);

    const [barProgress, setBarProgress] = useState(0);


         const [dataVerbList, setDataVerbList] = useState<VerbList[]>([])
         const [dataVerbListReturn, setDataVerbListReturn] = useState<VerbList[]>([])


    const [nbExercice, setNbExercice] = useState<number>(0)
         const [inputValue1, setInputValue1] = useState('');
         const [inputValue2, setInputValue2] = useState('');
         const [inputValue3, setInputValue3] = useState('');


    const [inputClassName2, setinputClassName2] = useState('input is-medium');
    const [inputClassName3, setinputClassName3] = useState('input is-medium');

    const [input1Sentense, setinput1Sentense] = useState('1 @ 2');
    const [input2Sentense, setinput2Sentense] = useState('1 @ 2');
    const [input3Sentense, setinput3Sentense] = useState('1 @ 2');

    //const[user, setUser] = useState<string>("anonymousUser")


    useEffect(() =>
            getMe()
        , [])


    function getMe(){
        axios.get("/api/auth/me2")
            .then(response => {
                //setUser(response.data)


                getData(response.data)



            })
    }

    function randomIntFromInterval(min:number, max:number) { // min and max included
        return Math.floor(Math.random() * (max - min + 1) + min);
    }



    const getData = async (userName: string ) => {
        await axios.post('/api/get5verbsforexercice', userName)
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


    /*
    useEffect(()=>{
        getData()

    },[])

     */


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


        setinput1Sentense(dataVerbList[nb]?.sentence.baseForm)
        setinput2Sentense(dataVerbList[nb]?.sentence.pastSimple)

        setinput3Sentense(dataVerbList[nb]?.sentence.pastParticiple)
        inputRef.current?.focus();

    }

    const delay = (ms: number | undefined) => new Promise(res => setTimeout(res, ms));


    async function eventButton() {


        const audio = new Audio(dataVerbList[nbExercice].urlAudio)
        audio.play()

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
                ).then( response => {
                    console.log(response.data)
                    setExercicTerminated(true)
                }


                )


            } else {
                initQuestion()
            }
        } else {
            alert("try again : good answer is : " + dataVerbList[nbExercice].infinitive + " " + dataVerbList[nbExercice].table2 + " " + dataVerbList[nbExercice].table3)
            if (dataVerbList[nbExercice].level > 1) {
                dataVerbList[nbExercice].level = dataVerbList[nbExercice].level - 1
                setBarProgress(barProgress - 1)

            }
            dataVerbList[nbExercice].nbOfBadAnswers = dataVerbList[nbExercice].nbOfBadAnswers + 1
            initQuestion()
        }
    }


    const inputRef = React.useRef<HTMLInputElement>(null);




    return (

        exercicTerminated ? <div className="container box">The exercise is terminated, check your points !!!</div> :

            <>


                <div className=" box container ">

                    <p className="title is-1 is-spaced">Exercice</p>

                    <br/>



                    <progress className="progress is-warning" value={barProgress} max="8">
                        75%
                    </progress>


                    <div className="columns container  ">
                        <div className="column">

                            <div className="block container  ">


                                <div className="field">
                                    <label className="label">Infinitive</label>
                                    <div className="control">
                                        <div className="field has-addons">
                                            <p className="control">
                                                <a className="button is-static is-medium">

                                                    {input1Sentense == undefined ? <h1>-</h1>
                                                        : input1Sentense.split('@')[0]}

                                                </a>
                                            </p>

                                            <div className="control">
                                                <input className="input is-medium" value={inputValue1}
                                                       onChange={event => setInputValue1(event.target.value)}
                                                       type="text"
                                                       placeholder="Text input"
                                                       readOnly/>
                                            </div>
                                            <p className="control">
                                                <a className="button is-static is-medium">
                                                    {input1Sentense == undefined ? <h1>-</h1>
                                                        : input1Sentense.split('@')[1]}
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div className="field">
                                    <label className="label">Past simple</label>
                                    <div className="control">
                                        <div className="field has-addons">
                                            <p className="control">
                                                <a className="button is-static is-medium">

                                                    {input2Sentense == undefined ? <h1>-</h1>
                                                        : input2Sentense.split('@')[0]}

                                                </a>
                                            </p>

                                            <div className="control">
                                                <input ref={inputRef} className={inputClassName2} value={inputValue2}
                                                       onChange={event => setInputValue2(event.target.value)}
                                                       type="text"
                                                       placeholder="Text input"/>
                                            </div>
                                            <p className="control">
                                                <a className="button is-static is-medium">
                                                    {input2Sentense == undefined ? <h1>-</h1>
                                                        : input2Sentense.split('@')[1]}
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div className="field">
                                    <label className="label">Participle</label>
                                    <div className="control">


                                        <div className="field has-addons">
                                            <p className="control">
                                                <a className="button is-static is-medium">

                                                    {input3Sentense == undefined ? <h1>-</h1>
                                                        : input3Sentense.split('@')[0]}

                                                </a>
                                            </p>

                                            <div className="control">
                                                <input style={{width: "150px"}} className={inputClassName3}
                                                       value={inputValue3}
                                                       onChange={event => setInputValue3(event.target.value)}
                                                       type="text"
                                                       placeholder="Text input"/></div>
                                            <p className="control">
                                                <a className="button is-static is-medium">
                                                    {input3Sentense == undefined ? <h1>-</h1>
                                                        : input3Sentense.split('@')[1]}
                                                </a>
                                            </p>
                                        </div>


                                    </div>
                                </div>
                                <br/>
                                <button className={"button is-medium"} onClick={eventButton}>Next</button>


                            </div>

                        </div>
                        <div className="column">


                            <div className="box container has-background-primary-95">

                                {dataVerbList?.length === 0 ? <h1>NO DATA</h1>
                                    :
                                    <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                                        <thead>
                                        <tr>

                                            <th>verbId</th>
                                            <th>infinitive</th>
                                            <th colSpan={5}>Level</th>
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

                                                    {showLevel(p.level)}
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

                                {dataVerbListReturn?.length === 0 ?  <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                                    <thead>
                                    <tr>

                                        <th>verbId</th>
                                        <th>infinitive</th>
                                        <th colSpan={5}>Level</th>
                                        <th>nbOfGoodAnswers</th>
                                        <th>nbOfBadAnswers</th>
                                    </tr>
                                    </thead>
                                    </table>

                                    :
                                    <table className="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                                        <thead>
                                        <tr>

                                            <th>verbId</th>
                                            <th>infinitive</th>
                                            <th colSpan={5}>Level</th>
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

                                                    {showLevel(p.level)}
                                                    <td>{p.nbOfGoodAnswers}</td>
                                                    <td>{p.nbOfBadAnswers}</td>


                                                </tr>
                                            )


                                        })}
                                        </tbody>

                                    </table>
                                }
                            </div>

                        </div>
                    </div>

                </div>

            </>

    )
}


function showLevel(level: number) {

    // if level is 1 2 3 4 5
    // then return a td with the level

    // use switch case
    // case 1: return <td className={"is-danger"}>{level}</td>


    {
        switch (level) {
            case 1:
                return <>
                    <td className={"is-danger"}></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </>

        case 2:
            return  <>
                <td className={"is-warning"}></td>
                <td className={"is-warning"}></td>
                <td></td>
                <td></td>
                <td></td>
            </>
        case 3:
            return <>
                <td className={"is-danger"}></td>
                <td className={"is-danger"}></td>
                <td className={"is-danger"}></td>
                <td></td>
                <td></td>
            </>
        case 4:
            return <>
                <td className={"is-info"}></td>
                <td className={"is-info"}></td>
                <td className={"is-info"}></td>
                <td className={"is-info"}></td>

                <td></td>
            </>
        case 5:
            return <>
                <td className={"is-success"}></td>
                <td className={"is-success"}></td>
                <td className={"is-success"}></td>
                <td className={"is-success"}></td>
                <td className={"is-success"}></td>

            </>
        default:
            return <>
                <td className={"is-danger"}></td>
                <td className={"is-danger"}></td>
                <td></td>
                <td></td>
                <td></td>
            </>  }  }



}