<template>
    <v-card>
        <v-card-title>
            <h3>Jobs</h3>
        </v-card-title>
        <v-card>
            <v-card-text>You may search for jobs on this page</v-card-text>
            <v-card-text>
                <v-autocomplete
                    v-model="model"
                    :items="items"
                    :loading="isLoading"
                    :search-input.sync="search"
                    hide-no-data
                    hide-selected
                    item-text="title"
                    item-value="uuid"
                    label="Job Title"
                    placeholder="Start typing to Search"
                    prepend-icon="mdi-magnify"
                    return-object
                ></v-autocomplete>
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn :disabled="!model" @click="model = null">
                    Clear
                    <v-icon right>mdi-close-circle</v-icon>
                </v-btn>
            </v-card-actions>
            <v-divider></v-divider>
            <v-expand-transition>
                <v-list v-if="model">
                    <v-list-item v-for="(field, index) in fields" :key="index">
                        <v-list-item-content>
                            <v-list-item-title v-text="field.value"></v-list-item-title>
                            <v-list-item-subtitle v-text="field.key"></v-list-item-subtitle>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-expand-transition>
        </v-card>
    </v-card>
</template>

<script>
export default {
    data() {
        return {
            resource: {},
            entries: [],
            errors: false,
            descriptionLimit: 60,
            isLoading: false,
            model: null,
            search: null
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
                    this.errors = false; // no errors
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    resultArray.pop(); // remove last entry
                    this.entries = resultArray;
                })
                .catch(e => {
                    this.errors = true;
                    console.log(e);
                })
                .finally(() => {
                    this.isLoading = false;
                });
        }
    },
    computed: {
        fields() {
            if (!this.model) return [];

            return Object.keys(this.model).map(key => {
                return {
                    key,
                    value: this.model[key] || "n/a"
                };
            });
        },
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
    watch: {
        search(val) {
            // Items have already been loaded
            if (this.items.length > 0) return;

            // Items have already been requested
            if (this.isLoading) return;

            this.isLoading = true;

            // Lazily load input items
            this.retrieveAllJobs();
        }
    },
    created() {
        const customActions = {
            retrieveAllJobsData: {
                method: "GET"
            }
        };
        this.resource = this.$resource("jobs", {}, customActions);
    }
};
</script>

<style>
</style>