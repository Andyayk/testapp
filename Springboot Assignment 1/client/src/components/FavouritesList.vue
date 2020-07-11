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
                            <v-btn
                                @click="unfavouriteJob(job.jobId, index)"
                                color="#64B5F6"
                                dark
                            >Unfavourite</v-btn>
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
import { mapGetters } from 'vuex';
import { eventBus } from "../main";

const API_URL = "http://localhost:8080";

export default {
    name: "FavouritesList",
    data: function() {
        return {
            jobs: [],
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
        unfavouriteJob: function(jobId, index) {
            axios
                .post(`${API_URL}/unfavouriteJob`, {
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
    computed: {
        ...mapGetters('user', {
            getAppUser: 'getAppUser'
        })  
    },
    created() {
        this.retrieveAllJobs();
    }
};
</script>

<style scoped>
</style>