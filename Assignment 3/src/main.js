import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

import { store } from './store/store';
import { routes } from './routes';

Vue.use(VueRouter); // to use router
Vue.use(VueResource); // to send http request

Vue.http.options.root = 'http://api.dataatwork.org/v1/'; // set root http

const router = new VueRouter({
	routes,
	mode: 'history' // remove # in url
});

new Vue({
	el: '#app',
	router,
	store,
	render: h => h(App)
})
