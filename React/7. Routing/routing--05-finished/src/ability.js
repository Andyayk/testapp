import { AbilityBuilder, Ability, defineAbility } from '@casl/ability'
import store from "./store"

const { can, cannot, build } = new AbilityBuilder(Ability);

can('read', 'Post');
can('update', 'Post');
can('read', 'Comment');
can('update', 'Comment');

export default build();
/*
const { can, cannot, build } = new AbilityBuilder(Ability);

//subscribing to changes in the store
let currentUser;
store.subscribe(() => {

    const prevUser = currentUser;
    console.log(prevUser);
    currentUser = store.getState();
    console.log(currentUser);
    if (currentUser.role == "admin") {
        can('read', 'Post');
        can('update', 'Post');
        can('read', 'Comment');
        can('update', 'Comment');
    }

});

function updateAbility(ability, user) {
    const { can, rules } = new AbilityBuilder();
  
    if (user.role === 'admin') {
        can('read', 'Post');
        can('update', 'Post');
    } else {
        can('read', 'Comment');
        can('update', 'Comment');
    }
  
    ability.update(rules);
  }
can('read', 'Post');
can('update', 'Post');
can('read', 'Comment');
can('update', 'Comment');

export default build();
*/