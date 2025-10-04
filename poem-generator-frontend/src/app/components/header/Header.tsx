import {ReactElement} from "react";
import "./header.css";

export default function Header(props: { children: ReactElement[]}) {
    return (
        <header className="w-full">
            <nav className="border-gray-200 bg-gray-900 py-2.5">
                <div className="flex justify-between top-0 left-0 pl-4 pr-4">
                    {props.children}
                </div>
            </nav>
        </header>
    );
}