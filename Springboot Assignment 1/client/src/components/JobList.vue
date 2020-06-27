<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>
            <template v-for="(job, index) in jobs">
                <v-list-item :key="job.jobId">
                    <v-list-item-content>
                        <v-list-item-title v-text="index+1+')'"></v-list-item-title>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>{{job.jobTitle}}</v-list-item-title>
                                <v-list-item-subtitle>Job Title</v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>{{job.jobDescription}}</v-list-item-title>
                                <v-list-item-subtitle>Job Description</v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>{{job.datePosted}}</v-list-item-title>
                                <v-list-item-subtitle>Date Posted</v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>

                        <v-card-actions>
                            <app-edit-form v-if="isAdmin" :job="job" :index="index" />
                            <v-btn
                                v-if="isAdmin"
                                @click="deleteJob(job.jobId, index)"
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
                <v-divider v-if="index + 1 < jobs.length" :key="index+'B'"></v-divider>
            </template>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";
import { eventBus } from "../main";
import EditForm from "./EditForm";

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
        deleteJob: function(jobId, index) {
            axios
                .post(`${API_URL}/deletejob`, {
                    jobId: jobId
                })
                .then(response => {
                    this.jobs.splice(index, 1);
                    this.text = response.data;
                    this.snackbar = true;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    components: {
        appEditForm: EditForm
    },
    created() {
        this.retrieveAllJobs();

        eventBus.$on("jobWasUpdated", payload => {
            this.jobs.splice(payload.index, 1, payload.job);
            this.text = payload.text;
            this.snackbar = true;
        });
    }
};
</script>

<style scoped>
</style>