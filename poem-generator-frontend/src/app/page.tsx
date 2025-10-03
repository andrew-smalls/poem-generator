import Footer from "@/app/components/footer/Footer";
import PageContent from "./components/pageContent/PageContent";
import Header from "./components/header/Header";
import CreatePoem from "@/app/components/header/CreatePoem";
import CountryPicker from "@/app/components/header/CountryPicker";
import Profile from "@/app/components/header/Profile";
import SearchBox from "@/app/components/pageContent/SearchBox";
import PoemList from "@/app/components/pageContent/PoemList";

export default function Home() {
    return (
        <>
            <Header>
                <CreatePoem/>
                <CountryPicker/>
                <Profile/>
            </Header>
            <PageContent>
                <SearchBox/>
                <PoemList/>
            </PageContent>
            <Footer/>
        </>
    );
}






