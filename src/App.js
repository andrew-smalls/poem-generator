import {useState} from "react";
import {InputForm} from "./InputForm/InputForm.tsx";
import {PageContent} from "./PageContent/PageContent.tsx";
import {PageActions} from "./PageActions.tsx";
import "./App.css";

function App () {

    const [theme, setTheme] = useState("");
    const [poem, setPoem] = useState("");
    const [imageURL, setImageURL] = useState("");

    return (
        <>
            <div className="App">
            <Background >
                <InputForm setTheme={setTheme} setPoem={setPoem} setImageURL={setImageURL}/>
                <PageContent theme={theme} poem={poem} imageURL={imageURL}>
                    <PageActions />
                </PageContent>
            </Background>
                </div>
        </>
    );
}

export function Background({children}) {
    //logic to change background depending on input
    return <>{children}</>;
}


export default App;
