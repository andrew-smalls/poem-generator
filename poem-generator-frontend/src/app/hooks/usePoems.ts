'use client'

import {useEffect, useState} from "react";
import {PoemType} from "@/app/types";

export function usePoems(searchTerm: string, searchCategory: string) {

    const [poems, setPoems] = useState<PoemType[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        async function fetchPoems() {
            setLoading(true);
            setError(null);

            try {
                const params = new URLSearchParams();
                if (searchTerm) params.append("search", searchTerm);
                if (searchCategory) params.append("category", searchCategory);

                const url = `http://localhost:8080/mistral/poems?${params.toString()}`;
                const response = await fetch(url);

                if (!response.ok) {
                    throw new Error(`Error ${response.status}: ${response.statusText}`);
                }

                const data = await response.json();
                setPoems(data);
            } catch (err) {
                setError('Failed to fetch poems');
                console.log(err);
            } finally {
                setLoading(false);
            }

        }

        fetchPoems();
    }, [searchTerm, searchCategory]);

    return { poems, loading, error};
}