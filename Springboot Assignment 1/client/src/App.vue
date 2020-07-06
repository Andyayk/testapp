<template>
    <v-app>
        <v-container>
            <h1 v-if="getUserAuthentication">Employment Portal</h1>
            <br />
            <app-header v-if="getUserAuthentication" />
            <br />
            <v-main>
                <router-view />
            </v-main>
        </v-container>   
    </v-app>
</template>

<script>
import { mapGetters } from 'vuex';

import Header from "./components/Header";

export default {
    name: "App",
    computed: {
        ...mapGetters('user', {
            getUserAuthentication: 'getUserAuthentication'
        })        
    },    
    mounted() {
        if(!this.getUserAuthentication && this.$route.path !== "/login") {
            this.$router.replace({ name: "Login" });
        }
    },
    components: {
        appHeader: Header
    }
};
</script>

<style scoped>
</style>