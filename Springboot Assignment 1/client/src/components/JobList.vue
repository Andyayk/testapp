<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>
            <template v-for="(job, index) in jobs">
                <v-list-item :key="job.jobId">
                    <v-list-item-content>
                        <v-list-item-title v-text="index+1+')'"></v-list-item-title>
                        <v-list-item
                            v-for="(value, propertyName, itemIndex) in job"
                            v-bind:key="itemIndex+'B'"
                        >
                            <v-list-item-content>
                                <v-list-item-title v-text="value"></v-list-item-title>
                                <v-list-item-subtitle v-text="propertyName"></v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-card-actions>
                            <v-btn v-if="isAdmin" color="success">Edit</v-btn>
                            <v-btn
                                v-if="isAdmin"
                                @click="deleteJob(job.jobId)"
                                color="#E53935"
                                dark
                            >Delete</v-btn>
                            <v-snackbar v-model="snackbar">
                                {{ text }}
                                <v-btn color="white" text @click="snackbar = false">Close</v-btn>
                            </v-snackbar>
                        </v-card-actions>
                    </v-list-item-content>
                </v-list-item>
                <v-divider v-if="index + 1 < jobs.length" :key="index+'C'"></v-divider>
            </template>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";
import { eventBus } from "../main";

const API_URL = "http://localhost:8080";

export default {
    name: "JobList",
    data: function() {
        return {
            jobs: [],
            isAdmin: eventBus.appUser.isAdmin,
            snackbar: false,
            text: ""
        };
    },
    methods: {
        retrieveAllJobs: function() {
            axios
                .get(`${API_URL}/jobs`)
                .then(response => {
                    this.jobs = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        deleteJob: function(jobId) {
            axios
                .post(`${API_URL}/deletejob`, {
                    jobId: jobId
                })
                .then(response => {
                    this.jobs = response.data;
                    this.text = "Job Deleted!";
                    this.snackbar = true;
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