import * as actionTypes from './actions';

const initialState = {
    persons: [],
    role: "",
};

const reducer = ( state = initialState, action ) => {
    switch ( action.type ) {
        case actionTypes.ADD_PERSON:
            const newPerson = {
                id: Math.random(), // not really unique but good enough here!
                name: action.personData.name,
                age: action.personData.age
            }
            return {
                ...state,
                persons: state.persons.concat( newPerson )
            }
        case actionTypes.CHANGE_ROLE:
            return {
                ...state,
                role: action.newRole
            }
    }
    return state;
};

export default reducer;