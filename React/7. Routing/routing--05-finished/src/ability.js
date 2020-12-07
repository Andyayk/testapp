import { AbilityBuilder, Ability } from '@casl/ability'

export default function defineAbilityFor(user) {
    const { can, cannot, rules } = new AbilityBuilder();
  
    if (user.role == 'admin') {
        can('manage', 'Admin');
    } else {
        can('manage', 'Normal');
    }

    return new Ability(rules);
}