import React, {Component, useState} from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  state = {
    persons: [
      {name: 'Max', age: 28},
      {name: 'Manu', age: 29}
    ],
    otherStateThatWontBeAffected: 'some other value'
  }

  switchNameHandler = (newName) => {
    this.setState({
      persons: [
        {name: 'Andy', age: 28},
        {name: newName, age: 30}
      ]
    })
  }

  nameChangedHandler = (event) => {
    this.setState({
      persons: [
        {name: 'Andy', age: 28},
        {name: event.target.value, age: 30}
      ]
    })    
  }

  render() {
    return (
      <div className="App">
        <h1>HI</h1>
        <button onClick={this.switchNameHandler}>Switch Name</button>
        <Person 
          name={this.state.persons[0].name} 
          age={this.state.persons[0].age}
          click={this.switchNameHandler.bind(this, "ABC")}>My hobbies: Racing
        </Person>
        <Person 
          name={this.state.persons[1].name} 
          age={this.state.persons[1].age}
          changed={this.nameChangedHandler}>My hobbies: Racing
        </Person>
      </div>
    );
  }
}

export default App;
/*
const App = props => {
  const [personsState, setPersonsState] = useState({
    persons: [
      {name: 'Max', age: 28},
      {name: 'Manu', age: 29}
    ]
  });

  const [otherState, setOtherState] = useState({otherStateThatWontBeAffected: 'some other value'});

  const switchNameHandler = () => {
    setPersonsState({
      persons: [
        {name: 'Andy', age: 28},
        {name: 'Manu', age: 30}
      ]
    })
  }

  return (
    <div className="App">
      <h1>HI</h1>
      <button onClick={switchNameHandler}>Switch Name</button>
      <Person name={personsState.persons[0].name} age={personsState.persons[0].age}>My hobbies: Racing</Person>
      <Person name={personsState.persons[1].name} age={personsState.persons[1].age}>My hobbies: Racing</Person>
    </div>
  );
}

export default App;
*/
