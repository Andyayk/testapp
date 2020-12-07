import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';
import { AbilityContext } from './Can';
import ability from './ability';
import Blog from './containers/Blog/Blog';

class App extends Component {
  render () {
    return (
      // <BrowserRouter basename="/my-app">
      <AbilityContext.Provider value={ability}>
      <BrowserRouter>
        <div className="App">
          <Blog />
        </div>
      </BrowserRouter>
      </AbilityContext.Provider>
    );
  }
}

export default App;
