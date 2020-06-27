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
    </v-app>
</template>

<script>
import Header from "./components/Header";

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
    mounted() {
        if(!this.authenticated && this.$route.path !== "/login") {
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