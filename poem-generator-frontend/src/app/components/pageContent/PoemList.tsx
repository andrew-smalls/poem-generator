'use client'

import Poem from "@/app/components/pageContent/Poem";
import {usePoems} from "@/app/hooks/usePoems";

export default function PoemList({searchTerm, searchCategory} : {searchTerm: string, searchCategory: string}) {

    const { poems, loading, error } = usePoems(searchTerm, searchCategory);

    if (loading) return <p>Loading poems...</p>;
    if (error) return <p className="text-red-600">Error: {error}</p>;
    if (poems.length === 0) return <p>No poems found.</p>;

    return (
        <div className="flex flex-col gap-3">
            <ul className="space-y-2">
                {poems.map((poem) => (
                    <Poem key={poem.id} {...poem} />
                ))}
            </ul>
        </div>
    );
}