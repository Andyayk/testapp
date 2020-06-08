import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

import { store } from './store/store';
import { routes } from './routes';

Vue.use(VueRouter); // to use router
Vue.use(VueResource); // to send http request
Vue.use(Vuetify); // use components inside vuetify

export const eventBus = new Vue({});

Vue.http.options.root = 'http://api.dataatwork.org/v1/'; // set root http

const router = new VueRouter({
	routes,
	mode: 'history' // remove # in url
});

const vuetify = new Vuetify({

});

new Vue({
	el: '#app',
	router,
	store,
	vuetify,
	render: h => h(App)
})
