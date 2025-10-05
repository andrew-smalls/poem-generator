import {PoemType} from "@/app/types";

export default function Poem({userId, theme, content, creationDate}: PoemType) {
    return (
        <li className="border p-3 rounded-md bg-white shadow-sm">
            <h3 className="font-semibold text-lg">{theme}</h3>
            <p className="text-gray-700">{content}</p>
            {userId && <span className="text-sm text-gray-500">– {userId}</span>}
        </li>
    );
}