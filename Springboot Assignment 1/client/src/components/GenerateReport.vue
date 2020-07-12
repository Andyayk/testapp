<template>
    <v-container>
        <v-card>
            <v-card-title>
                Popular Jobs
                <v-spacer></v-spacer>
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Search"
                    single-line
                    hide-details
                ></v-text-field>
            </v-card-title>
            <v-data-table :headers="headers" :items="jobs" :search="search"></v-data-table>
        </v-card>
        <br />
        <v-card-actions>
            <v-btn @click="csvExport()"><v-icon>mdi-download</v-icon>Download to CSV</v-btn>
            <v-btn @click="excelExport()"><v-icon>mdi-download</v-icon>Download to Excel</v-btn>
            <v-snackbar v-model="snackbar">
                {{ text }}
                <v-btn color="white" text @click="snackbar = false">Close</v-btn>
            </v-snackbar>
        </v-card-actions>
    </v-container>
</template>

<script>
import axios from "axios";
import XLSX from 'xlsx';
import { eventBus } from "../main";

const API_URL = "http://localhost:8080";

export default {
    name: "UserProfile",
    data: function() {
        return {
            jobs: [],
            snackbar: false,
            text: "",
            search: "",
            headers: [
                {
                    text: "Job ID",
                    align: "start",
                    sortable: false,
                    value: "jobId"
                },
                { text: "Job Title", value: "jobTitle" },
                { text: "Job Description", value: "jobDescription" },
                { text: "Date Posted", value: "datePosted" },
                { text: "Favourite Count", value: "favouriteCount" },
                { text: "Date Retrieved", value: "dateRetrieved" }
            ]
        };
    },
    methods: {
        retrieveAllPopularJobs: function() {
            axios
                .get(`${API_URL}/popularjobs`)
                .then(response => {
                    this.jobs = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        csvExport: function() {
            const items = this.jobs;
            const replacer = (key, value) => (value === null ? "" : value); // specify how you want to handle null values here
            const header = Object.keys(items[0]);

            var csvContent = "data:text/csv;charset=utf-8,";

            let csv = items.map(row =>
                header
                    .map(fieldName => JSON.stringify(row[fieldName], replacer))
                    .join(",")
            );
            csv.unshift(header.join(","));
            csv = csv.join("\r\n");

            csvContent += csv;

            var encodedUri = encodeURI(csvContent);

            var link = document.createElement("a");
            link.setAttribute("href", csvContent);
            link.setAttribute("download", "popular_jobs.csv");
            document.body.appendChild(link);

            link.click();

            document.body.removeChild(link);

            this.text = "CSV File Downloaded!";
            this.snackbar = true;
        },
        excelExport: function() {
            const data = XLSX.utils.json_to_sheet(this.jobs)
            const wb = XLSX.utils.book_new()
            XLSX.utils.book_append_sheet(wb, data, 'data')
            XLSX.writeFile(wb,'popular_jobs.xlsx')

            this.text = "Excel File Downloaded!";
            this.snackbar = true;
        }
    },
    created() {
        this.retrieveAllPopularJobs();
    }
};
</script>

<style scoped>
</style>