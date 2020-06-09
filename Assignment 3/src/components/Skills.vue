<template>
    <v-card>
        <v-card-title>
            <h3>Skills</h3>
        </v-card-title>
        <v-card>
            <v-card-text>You may search for skills on this page, only top 20 results will be shown, an empty submission will return all results.</v-card-text>
            <app-search
                :text="text"
                :value="value"
                :label="label"
                :items="items"
                :results="results"
                @itemWasSearched="retrieveAutocompleteSuggestions"
                @retrieveAllActivated="retrieveAllSkills"
                @retrieveSpecificActivated="processRetrieveSpecificSkill"
            ></app-search>
        </v-card>
    </v-card>
</template>

<script>
//import { eventBus } from "../main";
import Search from "./Search.vue";

export default {
    data() {
        return {
            resource: {},
            skillName: "",
            entries: [],
            results: [],
            descriptionLimit: 60,
            text: "normalized_skill_name",
            value: "uuid",
            label: "Skill Name"
        };
    },
    methods: {
        retrieveAutocompleteSuggestions() {
            this.resource
                .retrieveAllSkillsData()
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
        retrieveAllSkills() {
            this.resource
                .retrieveAllSkillsData()
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
        retrieveSpecificSkill() {
            this.resource
                .retrieveSpecificSkillData({
                    contains: this.skillName
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
        },
        processRetrieveSpecificSkill(model) {
            if (typeof model == "string") {
                // either return a user input string or object from autocomplete
                this.skillName = model;
            } else {
                this.skillName = model.normalized_skill_name;
            }
			this.retrieveSpecificSkill();
        }
    },
    computed: {
        items() {
            return this.entries.map(entry => {
                const normalized_skill_name =
                    entry.normalized_skill_name.length > this.descriptionLimit
                        ? entry.normalized_skill_name.slice(
                              0,
                              this.descriptionLimit
                          ) + "..."
                        : entry.normalized_skill_name; // shortern the length

                return Object.assign({}, entry, { normalized_skill_name }); // replace
            });
        }
    },
    created() {
        const customActions = {
            retrieveAllSkillsData: {
                method: "GET"
            },
            retrieveSpecificSkillData: {
                method: "GET",
                url: "skills/autocomplete{/skillName}"
            }
        };
        this.resource = this.$resource("skills", {}, customActions);
    },
    components: {
        appSearch: Search
    }
};
</script>

<style>
</style>
