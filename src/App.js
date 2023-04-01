import './App.css';
import {useState} from "react";
import {InputForm} from "./InputForm.tsx";
import {PageContent} from "./PageContent.tsx";
import {PageActions} from "./PageActions.tsx";

function App() {

    const [theme, setTheme] = useState("");
    const [poem, setPoem] = useState("");
    const [imageURL, setImageURL] = useState("");

    return (
        <>
            <Background >
                <InputForm setTheme={setTheme} setPoem={setPoem} setImageURL={setImageURL}/>
                <PageContent theme={theme} poem={poem} imageURL={imageURL}>
                    <PageActions />
                </PageContent>
            </Background>
        </>
    );
}

export function Background({children}) {
    //logic to change background depending on input
    return <>{children}</>;
}


export default App;
