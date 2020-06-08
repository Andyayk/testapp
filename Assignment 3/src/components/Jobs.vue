<template>
    <v-card>
        <v-card-title>
            <h3>Jobs</h3>
        </v-card-title>
        <v-card>
            <v-card-text>You may search for jobs on this page</v-card-text>
            <app-search
                :text="text"
                :value="value"
                :label="label"
                :items="items"
                :results="results"
            ></app-search>
        </v-card>
    </v-card>
</template>

<script>
import { eventBus } from "../main";
import Search from "./Search.vue";

export default {
    data() {
        return {
            resource: {},
            jobTitle: '',
            entries: [],
            results: [],
            descriptionLimit: 60,
            text: 'normalized_job_title',
            value: 'uuid',
            label: 'Job Title'
        };
    },
    methods: {
        retrieveAutocompleteSuggestions() {
            this.resource
                .retrieveAllJobsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    resultArray.pop(); // remove last entry
                    this.entries = resultArray;
                })
                .catch(e => {
                    console.log(e);
                });
        },        
        retrieveAllJobs() {
            this.resource
                .retrieveAllJobsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    resultArray.pop(); // remove last entry
                    this.results = resultArray;
                })
                .catch(e => {
                    console.log(e);
                });
        },
        retrieveSpecificJob() {
            this.resource
                .retrieveSpecificJobData({
                    contains: this.jobTitle
                })
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    //resultArray.push(data);
                    this.results = resultArray;
                })
                .catch(e => {
                    console.log(e);
                });
        }
    },
    computed: {
        items() {
            return this.entries.map(entry => {
                const title =
                    entry.normalized_job_title.length > this.descriptionLimit
                        ? entry.normalized_job_title.slice(0, this.descriptionLimit) + "..."
                        : entry.normalized_job_title; // shortern the length

                return Object.assign({}, entry, { title }); // replace
            });
        }
    },
    created() {
        const customActions = {
            retrieveAllJobsData: {
                method: "GET"
            },
            retrieveSpecificJobData: {
                method: "GET",
                url: "jobs/autocomplete{/jobTitle}"
            }
        };
        this.resource = this.$resource("jobs", {}, customActions);

        eventBus.$on("itemWasSearched", () => {
            this.retrieveAutocompleteSuggestions();
        });

        eventBus.$on("retrieveAllActivated", () => {
            this.retrieveAllJobs();
        });
        
        eventBus.$on("retrieveSpecificActivated", (model) => {
            this.jobTitle = model.normalized_job_title;
            this.retrieveSpecificJob();
        });        
    },
    components: {
        appSearch: Search
    }
};
</script>

<style>
</style>