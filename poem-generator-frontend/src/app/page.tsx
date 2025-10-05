"use client";

import SearchBox from "@/app/components/pageContent/SearchBox";
import PoemList from "@/app/components/pageContent/PoemList";
import {useState} from "react";

export default function Home() {

    const [searchTerm, setSearchTerm] = useState("");
    const [searchCategory, setSearchCategory] = useState("");

    const handleSearch = (term: string, category: string) => {
        setSearchTerm(term);
        setSearchCategory(category);
    };

    return (
            <div id="pageContent" className="flex flex-col w-full items-center gap-3">
                <SearchBox onSearch={handleSearch}/>
                <PoemList searchTerm={searchTerm} searchCategory={searchCategory} />
            </div>
    );
}






