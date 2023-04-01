import logo from './logo.svg';
import './App.css';

function App() {
  return (
      <>
        <ChangingBackground>
          <PageContent>
          <InputForm/>
          {basicReactApp()}
          </PageContent>
        </ChangingBackground>
      </>
  );
}

function ChangingBackground({children}) {
  //logic to change background depending on input
  return <>{children}</>;
}

function PageContent({children}) {
  return <>{children}</>;
}
function InputForm() {
  return <form>
    <label>
      Name:
      <input type="text" name="name" />
    </label>
    <input type="submit" value="Submit" />
  </form>
}

function basicReactApp() {
  return <div className="App">
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo"/>
      <p>
        Edit <code>src/App.js</code> and save to reload.
      </p>
      <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
      >
        Learn Reactsdfdas
      </a>
    </header>
  </div>;
}


export default App;
