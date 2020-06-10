<template>
    <v-app>
        <v-container>
            <h1>Employment Portal</h1>
            <br />
            <app-header></app-header>
            <br />
            <router-view></router-view>
        </v-container>
    </v-app>
</template>

<script>
import Header from './components/Header.vue';

export default {
    components: {
        appHeader: Header
    }
};
</script>

<style>
</style>
