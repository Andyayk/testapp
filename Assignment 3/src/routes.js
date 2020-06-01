import Home from './components/Home.vue';
import Jobs from './components/Jobs.vue';
import Skills from './components/Skills.vue';

/* //Lazy Loading
const User = resolve => {
    require.ensure(['./components/user/User.vue'], () => {
        resolve(require('./components/user/User.vue'));
    }, 'user');
};
const UserStart = resolve => {
    require.ensure(['./components/user/UserStart.vue'], () => {
        resolve(require('./components/user/UserStart.vue'));
    }, 'user');
};
const UserEdit = resolve => {
    require.ensure(['./components/user/UserEdit.vue'], () => {
        resolve(require('./components/user/UserEdit.vue'));
    }, 'user');
};
const UserDetail = resolve => {
    require.ensure(['./components/user/UserDetail.vue'], () => {
        resolve(require('./components/user/UserDetail.vue'));
    }, 'user');
};
*/
export const routes = [
    {
        path: '', name: 'home', components: {
        	default: Home
    	}
    },
    {
    	path: '/jobs', name: 'jobs', components: {
    		default: Jobs
    	}
    },
    {
    	path: '/skills', name: 'skills', components: {
    		default: Skills
    	}
    },
    /*
    {
        path: '/user', components: {
        	default: User,
    	}, children: [
        	{path: '', component: UserStart},
        	{
	            path: ':id', component: UserDetail, beforeEnter: (to, from, next) => {
		            console.log('inside route setup');
		            next();
        		}
        	},
        	{path: ':id/edit', component: UserEdit, name: 'userEdit'}
    	]
    },
    */
    {path: '*', redirect: '/'}
];