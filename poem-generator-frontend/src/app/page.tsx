import PageContent from "./components/pageContent/PageContent";
import SearchBox from "@/app/components/pageContent/SearchBox";
import PoemList from "@/app/components/pageContent/PoemList";

export default function Home() {
    return (
        <>
            <PageContent>
                <SearchBox/>
                <PoemList/>
            </PageContent>
        </>
    );
}






