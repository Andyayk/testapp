<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>
            <template v-for="(favJob, index) in jobs">
                <v-list-item :key="favJob.job.jobId">
                    <v-row>
                        <v-col>
                            <v-list-item-content>
                                <v-list-item-title v-text="index+1+')'"></v-list-item-title>
                                <v-list-item>
                                    <v-list-item-content>
                                        <v-list-item-title>{{favJob.job.jobTitle}}</v-list-item-title>
                                        <v-list-item-subtitle>Job Title</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-list-item>
                                <v-list-item>
                                    <v-list-item-content>
                                        <v-list-item-title>{{favJob.job.jobDescription}}</v-list-item-title>
                                        <v-list-item-subtitle>Job Description</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-list-item>
                                <v-list-item>
                                    <v-list-item-content>
                                        <v-list-item-title>{{favJob.job.datePosted}}</v-list-item-title>
                                        <v-list-item-subtitle>Date Posted</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-list-item>
                            </v-list-item-content>
                        </v-col>
                        <v-col>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                    @click="unfavouriteJob(favJob.job.jobId, index)"
                                    color="#FF9800"
                                    dark
                                >
                                    <v-icon>mdi-star</v-icon>
                                </v-btn>
                                <v-snackbar v-model="snackbar">
                                    {{ text }}
                                    <v-btn color="white" text @click="snackbar = false">Close</v-btn>
                                </v-snackbar>
                            </v-card-actions>
                        </v-col>
                    </v-row>
                </v-list-item>
                <v-divider v-if="index + 1 < favJob.length" :key="index+'B'"></v-divider>
            </template>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";
import { mapGetters } from "vuex";
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
        retrieveAllFavouritesJobs: function() {
            axios
                .post(`${API_URL}/retrieveallfavouritesjobs`, {
                    employeeId: this.getAppUser.employeeId
                })
                .then(response => {
                    this.jobs = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        unfavouriteJob: function(jobId, index) {
            axios
                .post(`${API_URL}/unfavouritejob`, {
                    employeeId: this.getAppUser.employeeId,
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
        ...mapGetters("user", {
            getAppUser: "getAppUser"
        })
    },
    created() {
        this.retrieveAllFavouritesJobs();
    }
};
</script>

<style scoped>
</style>