import axios from "axios";
import { eventBus } from "../../main";

const state = {
    appUser: null,
    userAuthentication: false,
    message: ''
};

const API_URL = "http://localhost:8080";

const getters = {
    getAppUser: state => {
        return state.appUser;
    }, 
    getUserAuthentication: state => {
        return state.userAuthentication;
    },
    getLoginMessage: state => {
        return state.message;
    },  
};

const mutations = {
    setUserLogin: (state, payload) => {
        state.appUser = payload.appUser;
        state.userAuthentication = payload.userAuthentication;
        state.message = payload.message;
        eventBus.$emit("redirectToHome", "");
    },
    setUserLogout: (state, payload) => {
        state.appUser = payload.appUser;
        state.userAuthentication = payload.userAuthentication;
        state.message = payload.message;
    },    
};

const actions = {
    setUserLogin: ({ commit }, payload) => {
        axios
            .post(`${API_URL}/loginuser`, {
                username: payload.username,
                password: payload.password
            })
            .then(response => {
                var newPayload = {};
                if (response.data != "") {
                    newPayload['appUser'] = response.data;
                    newPayload['userAuthentication'] = true;
                    newPayload['message'] = ''; //reset message
                } else {
                    newPayload['appUser'] = response.data;
                    newPayload['userAuthentication'] = false;
                    newPayload['message'] = "Wrong Username/Password";
                }
                commit('setUserLogin', newPayload);
            })
            .catch(error => {
                console.log(error);
            });
    },
    setUserLogout: ({ commit }, payload) => {
        var newPayload = {};

        newPayload['appUser'] = null;
        newPayload['userAuthentication'] = false;
        newPayload['message'] = "";

        commit('setUserLogout', newPayload);
    },    
};

export default {
    state,
    getters,
    mutations,
    actions,
    namespaced: true
}