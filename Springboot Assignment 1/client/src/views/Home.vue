<template>
    <v-container>
        <h3>Job Listings</h3>
        <app-job-list />
    </v-container>
</template>

<script>
// @ is an alias to /src
import JobList from "@/components/JobList";

export default {
    name: "Home",
    components: {
        appJobList: JobList
    }
};
</script>

<style scoped>
</style>