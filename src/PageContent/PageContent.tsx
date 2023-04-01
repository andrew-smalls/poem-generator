import * as React from "react";
import "./PageContent.css";

export type PageContentProps = {
    children: React.ReactChildren;
    poem: string;
    theme: string;
    imageURL: string;
}

export function PageContent({children, poem, theme, imageURL} : PageContentProps) {
    return <>

        <div className={"poemContainer"}>
            <div className={"poemContent"}>
                {poem}
            </div>
        </div>
        <div className={"imageContainer"}>
            <div className={"imageContent"}>
                {imageURL}
            </div>
        </div>
        <div className={"themeContainer"}>
            <div className={"themeContent"}>
                {theme}
            </div>
        </div>
        {children}
    </>;
}