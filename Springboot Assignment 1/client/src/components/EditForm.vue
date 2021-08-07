<template>
    <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
            <v-btn color="#9E9D24" dark v-bind="attrs" v-on="on"><v-icon>mdi-pencil-outline</v-icon>Edit</v-btn>
        </template>
        <v-card>
            <v-card-title>
                <span class="headline">
                   {{ job.jobTitle }}
                </span>
            </v-card-title>
            <v-card-text>
                <v-form @submit.prevent>
                    <v-text-field 
                    v-model="jobTitle" 
                    label="Title" 
                    :rules="[() => !!jobTitle || 'This field is required']"
                    required>
                    </v-text-field>
                    <v-text-field v-model="jobDescription" label="Description" required></v-text-field>
                    <v-text-field v-model="datePosted" label="Date Posted" disabled></v-text-field>
                </v-form>
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
                <v-btn color="blue darken-1" text @click="editJob">Save</v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
import axios from "axios";
import { eventBus } from "../main";

const API_URL = "http://localhost:8080";

export default {
    name: "EditForm",
    props: ["job", "index"],
    data: function() {
        return {
            dialog: false,
            jobTitle: this.job.jobTitle,
            jobDescription: this.job.jobDescription,
            datePosted: new Date().toISOString().split("T")[0]
        };
    },
    methods: {
        editJob: function() {
            axios
                .post(`${API_URL}/editjob`, {
                    jobId: this.job.jobId,
                    jobTitle: this.jobTitle,
                    jobDescription: this.jobDescription,
                    datePosted: this.datePosted
                })
                .then(response => {
                    var updatedJob = this.job;

                    if (this.jobTitle != "") {
                        updatedJob.jobTitle = this.jobTitle;
                    }
                    if (this.jobDescription != "") {
                        updatedJob.jobDescription = this.jobDescription;
                    }
                    if (this.datePosted != "") {
                        updatedJob.datePosted = this.datePosted;
                    }

                    var payload = {
                        job: updatedJob,
                        index: this.index,
                        text: response.data
                    };

                    eventBus.$emit("jobWasUpdated", payload);
                    this.dialog = false;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
};
</script>

<style>
</style>
