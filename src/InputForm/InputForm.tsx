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
    const [numWords, setNumWords] = useState(50);

    async function handleSubmit(event) {
        event.preventDefault();
        //await getImageURL(prompt, setImageURL);
        //await getPoem(prompt, setPoem, numWords);
        const  poem = "That cute cat is always playing,\n" +
            "Jumping, climbing, and frolicking so gay;\n" +
            "She loves nibbling on her toys,\n" +
            "Her independent spirit lights up the way.";
        setPoem(poem)
        setImageURL("https://oaidalleapiprodscus.blob.core.windows.net/private/org-v7D9NinSpdHbGzbqEhlh5KRT/user-HZYu7OAiEzMzb6VZyqqTSkBm/img-YuekNjkF0icKOyf6MNpYJAbW.png?st=2023-04-01T22%3A49%3A21Z&se=2023-04-02T00%3A49%3A21Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-04-01T10%3A09%3A17Z&ske=2023-04-02T10%3A09%3A17Z&sks=b&skv=2021-08-06&sig=iCISLElrAp4Bka4IxpwHNtsFkMzcNoqAX1lQY%2BIOy60%3D");

        //await getTheme(prompt, setTheme);
    }
    function handlePromptChange(event) {
        setPrompt(event.target.value);
    }

    function handleNumTokensChange(event) {
        setNumWords(event.target.value);
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
                    <input type="text" placeholder="Number of words.." onChange={handleNumTokensChange}
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