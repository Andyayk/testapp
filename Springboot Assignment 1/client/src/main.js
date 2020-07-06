import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
import { store } from './store/store';

Vue.use(Vuetify); // use components inside vuetify

export const eventBus = new Vue({
    data: {

    }
});

Vue.config.productionTip = false

const vuetify = new Vuetify({

});

new Vue({
    router,
    vuetify,
    store,
    render: h => h(App)
}).$mount('#app')
