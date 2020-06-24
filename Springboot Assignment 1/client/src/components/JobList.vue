<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>
            <v-simple-table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date Posted</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(job, index) in jobs" v-bind:key="index">
                        <td>{{job.jobTitle}}</td>
                        <td>{{job.jobDescription}}</td>
                        <td>{{job.datePosted}}</td>                       
                    </tr>
                </tbody>
            </v-simple-table>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";

const API_URL = "http://localhost:8080";

export default {
    name: "JobList",
    data: function() {
        return {
            jobs: [],
        };
    },
    methods: {
        retrieveAllJobs() {
            axios
                .get(`${API_URL}/jobs`)
                .then(response => {
                    this.jobs = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    created() {
        this.retrieveAllJobs();
    }
};
</script>

<style scoped>
</style>