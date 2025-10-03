import {ReactElement} from "react";

export default function PageContent(props: { children: ReactElement[]}) {
    return <div className="flex flex-col w-full items-center ">
        {props.children}
    </div>
}