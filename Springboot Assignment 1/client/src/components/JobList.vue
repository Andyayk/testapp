<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>
            <template v-for="(job, index) in jobs">
                <v-list-item :key="job.jobId">
                    <v-row>
                        <v-col>
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
                                    <app-edit-form
                                        v-if="getAppUser.isadmin"
                                        :job="job"
                                        :index="index"
                                    />
                                    <v-btn
                                        v-if="getAppUser.isadmin"
                                        @click="deleteJob(job.jobId, index)"
                                        color="#E53935"
                                        dark
                                    ><v-icon>mdi-delete</v-icon>Delete</v-btn>
                                    <v-snackbar v-model="snackbar">
                                        {{ text }}
                                        <v-btn color="white" text @click="snackbar = false">Close</v-btn>
                                    </v-snackbar>
                                </v-card-actions>
                            </v-list-item-content>
                        </v-col>
                        <v-col>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                    v-if="favourites.includes(job.jobId)"
                                    @click="unfavouriteJob(job.jobId)"
                                    color="#FF9800"
                                    dark
                                >
                                <v-icon>mdi-star</v-icon>
                                </v-btn>
                                <v-btn v-else @click="favouriteJob(job.jobId)" color="#64B5F6" dark>
                                    <v-icon>mdi-star-outline</v-icon>
                                </v-btn>
                            </v-card-actions>
                        </v-col>
                    </v-row>
                </v-list-item>
                <v-divider v-if="index + 1 < jobs.length" :key="index+'B'"></v-divider>
            </template>
        </v-container>
        <h3>All Users</h3>
        <v-container>
            <template v-for="(user, index) in users">
                <v-list-item :key="user.name + index">
                    <v-row>
                        <v-col>
                            <v-list-item-content>
                                <v-list-item-title>{{user.name}}</v-list-item-title>
                            </v-list-item-content>
                        </v-col>
                    </v-row>
                </v-list-item>
            </template>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";
import { mapGetters } from "vuex";
import { eventBus } from "../main";
import EditForm from "./EditForm";

const API_URL = "http://localhost:8080";

export default {
    name: "JobList",
    data: function() {
        return {
            jobs: [],
            users: [],
            snackbar: false,
            text: "",
            favourites: []
        };
    },
    methods: {
        retrieveAllUsers: function() {
            axios
                .get(`${API_URL}/users`)
                .then(response => {
                    this.users = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },        
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
        },
        retrieveFavouritesList: function(jobId) {
            axios
                .post(`${API_URL}/retrievefavouriteslist`, {
                    employeeId: this.getAppUser.employeeid
                })
                .then(response => {
                    this.favourites = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        favouriteJob: function(jobId) {
            axios
                .post(`${API_URL}/favouritejob`, {
                    employeeId: this.getAppUser.employeeid,
                    jobId: jobId
                })
                .then(response => {
                    this.favourites.push(jobId); //toggling button from favourite to unfavourite

                    this.text = response.data;
                    this.snackbar = true;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        unfavouriteJob: function(jobId) {
            axios
                .post(`${API_URL}/unfavouritejob`, {
                    employeeId: this.getAppUser.employeeid,
                    jobId: jobId
                })
                .then(response => {
                    var index = this.favourites.indexOf(jobId);
                    this.favourites.splice(index, 1); //toggling button from unfavourite to favourite

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
    components: {
        appEditForm: EditForm
    },
    created() {
        this.retrieveAllUsers();
        this.retrieveAllJobs();
        this.retrieveFavouritesList();

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