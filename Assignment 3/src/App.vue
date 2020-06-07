<template>
    <div class="container p-3 my-3">
        <h1>Employment Portal</h1>
        <hr />
        <app-header></app-header>
        <router-view></router-view>
    </div>
</template>

<script>
import Header from "./components/Header.vue";

export default {
    components: {
        appHeader: Header
    }
};
</script>
