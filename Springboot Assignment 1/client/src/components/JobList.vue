<template>
    <v-container>
        <h3>All Jobs</h3>
        <v-container>   
            <template v-for="(job, index) in jobs">        
            <v-list-item :key="index+'A'">
                <v-list-item-content>
                    <v-list-item-title v-text="index+1+')'"></v-list-item-title>
                    <v-list-item v-for="(value, propertyName, itemIndex) in job" v-bind:key="itemIndex+'B'">
                        <v-list-item-content>
                            <v-list-item-title v-text="value"></v-list-item-title>
                            <v-list-item-subtitle v-text="propertyName"></v-list-item-subtitle>
                        </v-list-item-content>    
                    </v-list-item>
                    <v-card-actions>
                        <v-btn>Edit</v-btn>
                        <v-btn>Delete</v-btn>
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