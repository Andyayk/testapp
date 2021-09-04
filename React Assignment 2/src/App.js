import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';

import Blog from './containers/Blog/Blog';
import Home from './containers/Home';
import 'primereact/resources/themes/saga-orange/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import 'primeflex/primeflex.css';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Home />
          --------------------------------------------------------------------------------------------------------------------------------
          <Blog />
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
