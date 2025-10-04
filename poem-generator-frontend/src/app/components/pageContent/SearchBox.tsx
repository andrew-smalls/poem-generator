export default function SearchBox() {
    return (
        <form className="flex flex-col md:flex-row gap-3" id="searchForm">
            <div className="search-box flex mt-4 left-0 rounded-lg">
                <input type="search" minLength={3} placeholder="Search by theme?"
                       name="searchBox" className="w-80 md:w-80 px-3 h-10 border-2 focus:outline-none"/>
                <select id="searchType" name="searchType" className="w-20 h-10 border-2 tracking-wider">
                    <option value="">All</option>
                    <option value="wordsUsed">Words Used</option>
                    <option value="title">Title</option>
                    <option value="author">Author</option>
                </select>
            </div>
        </form>
    );
}