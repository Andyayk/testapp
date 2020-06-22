<template>
    <v-app>
        <v-container>
            <h1>Employment Portal</h1>
            <br />
            <app-header />
            <br />
            <v-main>
                <router-view></router-view>
            </v-main>
        </v-container>
    </v-app>
</template>

<script>
import Header from "./components/Header";

export default {
    name: "App",

    components: {
        appHeader: Header
    }
};
</script>

<style scoped>
</style>