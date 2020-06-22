import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.use(Vuetify); // use components inside vuetify

export const eventBus = new Vue({
});

Vue.config.productionTip = false

const vuetify = new Vuetify({

});

new Vue({
    router,
    vuetify,
    render: h => h(App)
}).$mount('#app')