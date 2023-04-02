import {useEffect, useState} from "react";
import { InputForm} from "./InputForm/InputForm.tsx";
import {PageContent} from "./PageContent/PageContent.tsx";
import "./App.css";

export async function getTheme(poem: string, setData: (value) => void, max_tokens?: number ) {
    const API_KEY = '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';

    console.log("For input: ", poem);
    const payload = {
        model: 'gpt-3.5-turbo',
        messages: [
            {role: "system", content: `You are a poem interpreter. You get poems and based on it you provide the general theme of a poem. You keep it short - a maximum of 5 words`},
            {role: "user", content: `What is the theme of this poem: Roses are red, violets are blue. I love you. `},
            {role: "assistant", content: `Flowers and love.`},
            {role: "user", content: poem}
        ],
        max_tokens: max_tokens === undefined ? 20 : max_tokens,
        temperature: 0.1
    };

    fetch("https://api.openai.com/v1/chat/completions", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${API_KEY}`,
        },
        body: JSON.stringify(payload),
    }).then(response => response.json())
        .then(data => {
            setData(data.choices[0].message.content);
            return;
        })
        .catch((error) => {
            console.log("Error: ", error);
        });
}
function App () {
    const [theme, setTheme] = useState("");
    const [poem, setPoem] = useState("");
    const [imageURL, setImageURL] = useState("");

    useEffect(() => {
        if (poem.length > 5) {
            getTheme(poem, setTheme)
                .then(r => console.log("Theme: ", r))
                .catch(e => console.log(e));
        }
    }, [poem]);

    return (
        <div className="App">
            <Background >
                <div className={"containerGeneral"}>
                <InputForm setTheme={setTheme} poem={poem} setPoem={setPoem} setImageURL={setImageURL}/>
                <PageContent theme={theme} poem={poem} imageURL={imageURL}/>
                </div>
                </Background>
        </div>
    );
}

export function Background({children}) {
    //logic to change background depending on input
    return <>{children}</>;
}


export default App;
