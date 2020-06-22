<template>
    <v-template>
        <v-card>
            <app-instructor-app />
        </v-card>
    </v-template>
</template>

<script>
// @ is an alias to /src
import InstructorApp from "@/components/InstructorApp.vue";

export default {
    name: "Home",
    components: {
        appInstructorApp: InstructorApp
    }
};
</script>

<style scoped>
</style>