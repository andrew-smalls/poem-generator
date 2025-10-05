import {ReactElement} from "react";

export default function PageContent(props: { children: ReactElement[]}) {
    return <div id="pageContent" className="flex flex-col w-full items-center gap-3">
        {props.children}
    </div>
}