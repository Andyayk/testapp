import React, {Component} from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  state = {
    persons: [
      {name: 'Max', age: 28},
      {name: 'Manu', age: 29}
    ]
  }

  render() {
    return (
      <div className="App">
        <h1>HI</h1>
        <button>Switch Name</button>
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}>My hobbies: Racing</Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}>My hobbies: Racing</Person>
      </div>
    );
  }
}

export default App;
