import {useEffect, useState} from "react";
import "./InputForm.css";
import * as React from "react";

export type InputFormProps = {
    setTheme: (string) => void;
    setPoem: (string) => void;
    setImageURL: (string) => void;
}

export function InputForm({setTheme, setPoem, setImageURL}: InputFormProps) {
    const [prompt, setPrompt] = useState("");
    const [receivedData, setReceivedData] = useState<any>(undefined);

    async function handleSubmit(event) {
        event.preventDefault();
        // send to server
        // on response, update content and update image
        // setPrompt
        // setTheme here
        const payload = {
            prompt: prompt.toString(),
            n: 1,
            size: "256x256"
        };

        const response = await fetch('http://localhost:4040/images/generate', {
            method: 'POST',
            body: JSON.stringify(payload),
        }).then(response => response.json())
            .then(data => {
                setReceivedData(data.data[0].url);
            })
            .catch((error) => {
                console.log("Error: ", error);
            });
    }

    useEffect(() => {
        console.log("Received: ", receivedData);
    }, [receivedData])

    function handleChange(event) {
        setPrompt(event.target.value);
    }

    return <>
        <div className={"header"}>
            <div className={"headerMessage"}>
                <p className={"text"}>What poem would you like to read today?</p>
            </div>
            <div className={"form"}>
                <form className={"inputForm"}>
                    <input type="text" placeholder="Type your prompt here..." onChange={handleChange}
                           className={"inputPrompt"}/>
                    <br></br>
                    <br></br>
                    <div className={"buton"}>
                        <input type="submit" value="Generate" onClick={handleSubmit} className={"generateButton"}/>
                    </div>
                </form>
            </div>
        </div>
    </>;
}