<template>
    <v-app>
        <v-container>
            <h1 v-if="authenticated">Employment Portal</h1>
            <br />
            <app-header v-if="authenticated" @userlogout="setAuthenticated"/>
            <br />
            <v-main>
                <router-view @authenticated="setAuthenticated"/>
            </v-main>
        </v-container>
        <v-container>
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                    <h1>Vuex</h1>
                    <app-result></app-result>
                    <app-another-result></app-another-result>
                    <hr>
                    <app-counter></app-counter>
                    <app-another-counter></app-another-counter>
                    <hr>
                    <input type="text" v-model="value">
                    <p>{{ value }}</p>
                </div>
            </div>
        </v-container>        
    </v-app>
</template>

<script>
import Header from "./components/Header";

import Counter from './components/Counter.vue';
import AnotherCounter from './components/AnotherCounter.vue';
import Result from './components/Result.vue';
import AnotherResult from './components/AnotherResult.vue';

export default {
    name: "App",
    data: function() {
        return {
            authenticated: false,
        }
    },
    methods: {
        setAuthenticated: function(status) {
            this.authenticated = status;
        }
    },
    computed: {
        value: {
            get() {
                return this.$store.getters.value;
            },
            set(value) {
                this.$store.dispatch('updateValue', value);
            }
        }
    },    
    mounted() {
        if(!this.authenticated && this.$route.path !== "/login") {
            this.$router.replace({ name: "Login" });
        }
    },
    components: {
        appHeader: Header,
        appCounter: Counter,
        appAnotherCounter: AnotherCounter,
        appResult: Result,
        appAnotherResult: AnotherResult 
    }
};
</script>

<style scoped>
</style>