import Home from './components/Home.vue';

//Lazy Loading
const Jobs = resolve => {
    require.ensure(['./components/Jobs.vue'], () => {
        resolve(require('./components/Jobs.vue'));
    });
};
const Skills = resolve => {
    require.ensure(['./components/Skills.vue'], () => {
        resolve(require('./components/Skills.vue'));
    });
};

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
    {path: '*', redirect: '/'} //redirect to home page
];