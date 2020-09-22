import React, {Component, useState} from 'react';
import './App.css';
import Person from './Person/Person'

class App extends Component {
  state = {
    persons: [
      {id: '125d6', name: 'Max', age: 28},
      {id: '12s5d', name: 'Manu', age: 29}
    ],
    otherStateThatWontBeAffected: 'some other value',
    showPersons: false
  }

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id;
    });

    const person = {
      ...this.state.persons[personIndex]
    };

    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({persons: persons})    
  }

  deletePersonHandler = (personIndex) => {
    const persons = [...this.state.persons];
    persons.splice(personIndex, 1);
    this.setState({persons: persons});
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({showPersons: !doesShow});
  }

  render() {
    let persons = null;

    if (this.state.showPersons) {
      persons = (
        <div>
          {this.state.persons.map((person, index) => {
            return <Person
            click={() => this.deletePersonHandler(index)}
            name={person.name} 
            age={person.age} 
            key={person.id}
            changed={(event) => this.nameChangedHandler(event, person.id)}/>
          })}
        </div>        
      )
    }

    return (
      <div className="App">
        <h1>HI</h1>
        <button onClick={this.togglePersonsHandler}>Toggle Persons</button>
        { persons }
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
