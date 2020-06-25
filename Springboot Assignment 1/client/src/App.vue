<template>
    <v-app>
        <v-container>
            <h1>Employment Portal</h1>
            <br />
            <app-header v-if="authenticated"/>
            <br />
            <v-main>
                <router-view @authenticated="setAuthenticated" />
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
            mockAccount: {
                username: "nraboy",
                password: "password"
            }
        }
    },
    mounted() {
        if(!this.authenticated) {
            this.$router.replace({ name: "Login" });
        }
    },
    methods: {
        setAuthenticated(status) {
            this.authenticated = status;
        },
        logout() {
            this.authenticated = false;
        }
    },
    components: {
        appHeader: Header
    }
};
</script>

<style scoped>
</style>