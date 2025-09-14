import {useState} from "react";
import "./InputForm.css";
import * as React from "react";

export async function getPoem(prompt: string, setData: (value) => void, max_tokens?: number ) {
    const API_KEY = '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';

    const payload = {
        prompt: `Generate a poem inspired by the following prompt: "${prompt}"`,
        model: 'text-davinci-003',
        max_tokens: max_tokens === undefined ? 50 : max_tokens,
        n: 1
    };

    fetch("https://api.openai.com/v1/completions", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${API_KEY}`,
        },
        body: JSON.stringify(payload),
    }).then(response => response.json())
        .then(data => {
            console.log("Data for poem generation: ", data);
            setData(data.choices[0].text);
            return;
        })
        .catch((error) => {
            console.log("Error: ", error);
        });
}
export async function getImageURL(prompt: string, setData: (value) => void) {

    const payload = {
        prompt: prompt.toString(),
        n: 1,
        size: "256x256"
    };

    fetch('http://localhost:4040/images/generate', {
        method: 'POST',
        body: JSON.stringify(payload),
    }).then(response => response.json())
        .then(data => {
            console.log("Data for image url generation: ", data);
            setData(data.data[0].url);
            return;
        })
        .catch((error) => {
            console.log("Error: ", error);
        });
}

export type InputFormProps = {
    setPoem: (string) => void;
    setImageURL: (string) => void;
}

export function InputForm({setPoem, setImageURL}: InputFormProps) {
    const [prompt, setPrompt] = useState("");
    const [numWords, setNumWords] = useState(50);

    async function handleSubmit(event) {
        event.preventDefault();
        console.log("Prompt: ", prompt);
        await getImageURL(prompt, setImageURL);
        await getPoem(prompt, setPoem, numWords);
    }


    function handlePromptChange(event) {
        setPrompt(event.target.value);
    }

    function handleNumTokensChange(event) {
        setNumWords(event.target.valueAsNumber);
    }

    return <>
        <div className={"header"}>
            <div className={"headerMessage"}>
                <p className={"text"}>What poem would you like to read today?</p>
            </div>
            <div className={"form"}>
                <form className={"inputForm"}>
                    <div className={"inputs"}>
                    <input type="text" placeholder="Type your prompt here..." onChange={handlePromptChange}
                           className={"inputPrompt"}/>
                    <input type="number" placeholder="Number of words.." onChange={handleNumTokensChange}
                           className={"inputNumber"} />
                    </div>
                    <br></br>
                    <div className={"buton"}>
                        <input type="submit" value="Generate" onClick={handleSubmit} className={"generateButton"}/>
                    </div>
                </form>
            </div>
        </div>
    </>;
}