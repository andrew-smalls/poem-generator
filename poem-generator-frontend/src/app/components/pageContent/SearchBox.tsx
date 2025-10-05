"use client";

import { useState } from "react";

export default function SearchBox({onSearch}: {onSearch: (term: string, searchCategory: string) => void}) {
    const [term, setTerm] = useState("");
    const [searchCategory, setSearchCategory] = useState("");

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        onSearch(term, searchCategory);
    };

    return (
        <form onSubmit={handleSubmit} className="flex flex-col md:flex-row gap-3" id="searchForm">
            <div className="search-box flex mt-4 left-0 rounded-lg">
                <input
                    type="search"
                    minLength={3}
                    placeholder="Search by theme?"
                    name="searchBox"
                    className="w-80 md:w-80 px-3 h-10 border-2 focus:outline-none"
                    value={term}
                    onChange={(e) => setTerm(e.target.value)}
                />
                <select
                    id="searchType"
                    name="searchType"
                    className="w-20 h-10 border-2 tracking-wider"
                    onChange={(e) => setSearchCategory(e.target.value)}
                >
                    <option value="">All</option>
                    <option value="wordsUsed">Words Used</option>
                    <option value="theme">Theme</option>
                    <option value="author">Author</option>
                </select>
                <button
                    type="submit"
                    className="bg-gray-900 text-white px-4 rounded-md hover:bg-gray-700"
                >
                    Search
                </button>
            </div>
        </form>
    );
}