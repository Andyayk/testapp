import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';
import { AbilityContext } from './Can';
import defineAbilityFor from './ability';
import Blog from './containers/Blog/Blog';

import { connect } from 'react-redux';

class App extends Component {
  render () {
    return (
      // <BrowserRouter basename="/my-app">
      <AbilityContext.Provider value={defineAbilityFor({role: this.props.role})}>
      <BrowserRouter>
        <div className="App">
          <Blog />
        </div>
      </BrowserRouter>
      </AbilityContext.Provider>
    );
  }
}

const mapStateToProps = state => {
  return {
      role: state.role
  };
};


export default connect(mapStateToProps)(App);
