<template>
    <v-container>
        <h3>Job Listings</h3>
        <ListCoursesComponent />
    </v-container>
</template>

<script>
import ListCoursesComponent from "./ListCoursesComponent";
export default {
    name: "InstructorApp",
    components: {
        ListCoursesComponent
    }
};
</script>

<style scoped>
</style>