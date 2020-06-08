<template>
    <v-card>
        <v-card-title>
            <h3>Skills</h3>
        </v-card-title>
        <v-card>
            <v-card-text>You may search for skills on this page</v-card-text>
            <app-search :text="text" :value="value" :label="label" :items="items"></app-search>
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
            text: "name",
            value: "uuid",
            label: "Skill Name"
        };
    },
    methods: {
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
                const name =
                    entry.name.length > this.descriptionLimit
                        ? entry.name.slice(0, this.descriptionLimit) + "..."
                        : entry.name; // shortern the length

                return Object.assign({}, entry, { name }); // replace
            });
        }
    },
    created() {
        const customActions = {
            retrieveAllSkillsData: {
                method: "GET"
            }
        };
        this.resource = this.$resource("skills", {}, customActions);

        eventBus.$on("itemWasSearched", () => {
            this.retrieveAllSkills();
        });
    },
    components: {
        appSearch: Search
    }
};
</script>

<style>
</style>
