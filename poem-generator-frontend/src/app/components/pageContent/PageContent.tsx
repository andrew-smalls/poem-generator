import {ReactElement} from "react";

export default function PageContent(props: { children: ReactElement[]}) {
    return <div className="flex flex-col w-full items-center fixed top-10 left-0">
        {props.children}
    </div>
}