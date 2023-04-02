import {useEffect, useState} from "react";
import {InputForm} from "./InputForm/InputForm.tsx";
import {PageContent} from "./PageContent/PageContent.tsx";
import "./App.css";

function App () {

    const [theme, setTheme] = useState("");
    const [poem, setPoem] = useState("");
    const [imageURL, setImageURL] = useState("");

    useEffect(() => {
        console.log("URL: ", imageURL);
        console.log("poem: ", poem);
        console.log("theme: ", theme);
    }, [imageURL, poem, theme]);

    return (
        <div className="App">
            <Background >
                <div className={"containerGeneral"}>
                <InputForm setTheme={setTheme} setPoem={setPoem} setImageURL={setImageURL}/>
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
