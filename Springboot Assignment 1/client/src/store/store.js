import Vue from 'vue';
import Vuex from 'vuex';

import user from './modules/user';

import actions from './actions';
import getters from './getters';
import mutations from './mutations';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        jobTitle: "",
        jobDescription: "",
    },
    getters,
    mutations,
    actions,
    modules: {
        user
    }
});