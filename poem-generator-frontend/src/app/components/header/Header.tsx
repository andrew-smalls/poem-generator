import {ReactElement} from "react";

export default function Header(props: { children: ReactElement[]}) {
    return (
        <header className="flex justify-between fixed top-0 left-0 w-full">
            {props.children}
        </header>
    );
}