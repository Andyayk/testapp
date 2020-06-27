<template>
    <v-container>
        <h3>Create Job</h3>
        <v-form @submit.prevent>
            <v-text-field v-model="jobTitle" label="Job Title"></v-text-field>
            <v-text-field v-model="jobDescription" label="Job Description"></v-text-field>
            <v-text-field v-model="datePosted" label="Date Posted" disabled></v-text-field>
            <v-btn @click="addJob" color="success">Create</v-btn>
            <v-snackbar v-model="snackbar">
                {{ text }}
                <v-btn color="white" text @click="snackbar = false">Close</v-btn>
            </v-snackbar>
        </v-form>
    </v-container>
</template>


<script>
import axios from "axios";

const API_URL = "http://localhost:8080";

export default {
    name: "Form",
    data: function() {
        return {
            jobTitle: "",
            jobDescription: "",
            datePosted: new Date().toISOString().split("T")[0],
            snackbar: false,
            text: ""
        };
    },
    methods: {
        addJob: function() {
            if (this.jobTitle == "") {
                this.jobTitle = "Default Job Title";
            }

            if (this.jobDescription == "") {
                this.jobDescription = "Default Job Description";
            }

            axios
                .post(`${API_URL}/addjob`, {
                    jobTitle: this.jobTitle,
                    jobDescription: this.jobDescription,
                    datePosted: this.datePosted
                })
                .then(response => {
                    this.text = response.data;
                    this.snackbar = true;
                })
                .catch(error => {
                    console.log(error);
                });

            //reset form
            this.jobTitle = "";
            this.jobDescription = "";
            this.datecreated = "";
        }
    }
};
</script>

<style>
</style>
