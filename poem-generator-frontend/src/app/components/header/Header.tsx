import {ReactElement} from "react";

export default function Header(props: { children: ReactElement[]}) {
    return (
        <header className="flex justify-between">
            {props.children}
        </header>
    );
}