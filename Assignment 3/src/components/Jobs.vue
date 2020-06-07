<template>
    <div class="container p-3 my-3 border">
        <h3>Jobs</h3>
        <hr />
        <p>You may search for jobs on this page, an empty submission will return all results</p>
        <hr />
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <h5>Search for a Job</h5>
                <div class="form-group">
                    <label>Job Title:</label>
                    <input class="form-control" type="text" v-model="jobTitle" />
                </div>
                <button
                    class="btn btn-primary"
                    @click="jobTitle==='' ? retrieveAllJobs() : retrieveSpecificJob()"
                >Submit</button>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
                <h5>Results:</h5>
                <div v-if="errors">Job not found! Please try another job title.</div>
                <div class="d-flex" v-else>
                    <ul class="list-group justify-content-center">
                        <li class="list-group-item" v-for="(job,index) in jobs" :key="job.uuid">
                            {{ index+1 }})
                            <br />
                            <b>ID:</b>
                            {{ job.uuid }}
                            <br />
                            <b>Job Title:</b>
                            {{ job.normalized_job_title }}
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <v-card color="red lighten-2" dark>
            <v-card-title class="headline red lighten-3">Search for Public APIs</v-card-title>
            <v-card-text>
                Explore hundreds of free API's ready for consumption! For more information visit
                <a
                    class="grey--text text--lighten-3"
                    href="https://github.com/toddmotto/public-apis"
                    target="_blank"
                >the Github repository</a>.
            </v-card-text>
            <v-card-text>
                <v-autocomplete
                    v-model="model"
                    :items="items"
                    :loading="isLoading"
                    :search-input.sync="search"
                    color="white"
                    hide-no-data
                    hide-selected
                    item-text="Description"
                    item-value="API"
                    label="Public APIs"
                    placeholder="Start typing to Search"
                    prepend-icon="mdi-database-search"
                    return-object
                ></v-autocomplete>
            </v-card-text>
            <v-divider></v-divider>
            <v-expand-transition>
                <v-list v-if="model" class="red lighten-3">
                    <v-list-item v-for="(field, i) in fields" :key="i">
                        <v-list-item-content>
                            <v-list-item-title v-text="field.value"></v-list-item-title>
                            <v-list-item-subtitle v-text="field.key"></v-list-item-subtitle>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-expand-transition>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn :disabled="!model" color="grey darken-3" @click="model = null">
                    Clear
                    <v-icon right>mdi-close-circle</v-icon>
                </v-btn>
            </v-card-actions>
        </v-card>
    </div>
</template>

<script>
export default {
    data() {
        return {
            resource: {},
            jobTitle: "",
            jobs: [],
            errors: false,
            descriptionLimit: 60,
            entries: [],
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
                    this.jobs = resultArray;
                })
                .catch(e => {
                    this.errors = true;
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
                    this.errors = false; // no errors
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    //resultArray.push(data);
                    this.jobs = resultArray;
                })
                .catch(e => {
                    this.errors = true;
                    console.log(e);
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
                const Description =
                    entry.Description.length > this.descriptionLimit
                        ? entry.Description.slice(0, this.descriptionLimit) +
                          "..."
                        : entry.Description;

                return Object.assign({}, entry, { Description });
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
            fetch("https://api.publicapis.org/entries")
                .then(res => res.json())
                .then(res => {
                    const { count, entries } = res;
                    this.count = count;
                    this.entries = entries;
                })
                .catch(err => {
                    console.log(err);
                })
                .finally(() => (this.isLoading = false));
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
    }
};
</script>

<style>
</style>