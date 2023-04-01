import * as React from "react";

export type PageContentProps = {
    children: React.ReactChildren;
    poem: string;
    theme: string;
    imageURL: string;
}

export function PageContent({children, poem, theme, imageURL} : PageContentProps) {
    return <>
        <div className={"headerMessage"}>What poem would you like to read today?</div>
        <div>{poem}</div>
        <div>{imageURL}</div>
        <div>{theme}</div>
        {children}
    </>;
}