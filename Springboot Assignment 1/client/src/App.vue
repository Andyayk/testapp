<template>
    <v-app>
        <v-app-bar app color="primary" dark>
            <div class="d-flex align-center">
                <v-img
                    alt="Vuetify Logo"
                    class="shrink mr-2"
                    contain
                    src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
                    transition="scale-transition"
                    width="40"
                />

                <v-img
                    alt="Vuetify Name"
                    class="shrink mt-1 hidden-sm-and-down"
                    contain
                    min-width="100"
                    src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
                    width="100"
                />
            </div>
        </v-app-bar>

        <v-content>
            <HelloWorld />
        </v-content>

        <div class="container">
            <InstructorApp />
        </div>
    </v-app>
</template>

<script>
import HelloWorld from "./components/HelloWorld";
import InstructorApp from "./components/InstructorApp.vue";

export default {
    name: "App",

    components: {
        HelloWorld,
        InstructorApp
    },

    data: function() {
        //
    }
};
</script>

<style scoped>
</style>