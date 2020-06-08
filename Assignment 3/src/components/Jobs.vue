<template>
    <v-card>
        <v-card-title>
            <h3>Jobs</h3>
        </v-card-title>
        <v-card>
            <v-card-text>You may search for jobs on this page</v-card-text>
            <app-search :text="text" :value="value" :label="label" :items="items" :allResults="entries"></app-search>
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
            entries: [],
            descriptionLimit: 60,
            text: "title",
            value: "uuid",
            label: "Job Title"
        };
    },
    methods: {
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
                    this.entries = resultArray;
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
                    entry.title.length > this.descriptionLimit
                        ? entry.title.slice(0, this.descriptionLimit) + "..."
                        : entry.title; // shortern the length

                return Object.assign({}, entry, { title }); // replace
            });
        }
    },
    created() {
        const customActions = {
            retrieveAllJobsData: {
                method: "GET"
            }
        };
        this.resource = this.$resource("jobs", {}, customActions);

        eventBus.$on("itemWasSearched", () => {
            this.retrieveAllJobs();
        });

        eventBus.$on("retrieveAllActivated", () => {
            this.retrieveAllJobs();
        });        
    },
    components: {
        appSearch: Search
    }
};
</script>

<style>
</style>