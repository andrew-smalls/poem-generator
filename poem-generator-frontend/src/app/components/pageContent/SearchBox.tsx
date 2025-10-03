export default function SearchBox() {
    return (
        <div className="search-box">
            <input type="search" minLength={3} autoFocus={true} placeholder="Search by theme?"></input>
        </div>
    );
}