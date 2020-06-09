<template>
    <div>
        <v-card-text>
            <v-combobox
                v-model="model"
                :items="items"
                :loading="isLoading"
                :search-input.sync="search"
                hide-no-data
                hide-selected
                :item-text="text"
                :item-value="value"
                :label="label"
                placeholder="Start typing to Search"
                prepend-icon="mdi-magnify"
                return-object
            ></v-combobox>
        </v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn @click="!model ? retrieveAll() : retrieveSpecific()">Submit</v-btn>
        </v-card-actions>
        <v-divider></v-divider>
        <v-expand-transition>
            <v-list two-line v-if="fields.length>0">
                <template v-for="(item, index) in fields">
                    <v-list-item :key="index+'A'">
                        <v-list-item-content>
                            <v-list-item-title v-text="index+1+')'"></v-list-item-title>
                            <v-list-item
                                v-for="(value, propertyName, itemIndex) in item"
                                :key="itemIndex+'B'"
                            >
                                <v-list-item-content>
                                    <v-list-item-title v-text="value"></v-list-item-title>
                                    <v-list-item-subtitle v-text="propertyName"></v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                        </v-list-item-content>
                    </v-list-item>
                    <v-divider v-if="index + 1 < fields.length" :key="index+'C'"></v-divider>
                </template>
            </v-list>
        </v-expand-transition>
    </div>
</template>

<script>
//import { eventBus } from "../main";

export default {
    props: ["text", "value", "label", "items", "results"],
    data: function() {
        return {
            isLoading: false,
            model: null,
            search: null
        };
    },
    methods: {
        retrieveAll: function() {
            this.$emit("retrieveAllActivated", "");
        },
        retrieveSpecific: function() {
            this.$emit("retrieveSpecificActivated", this.model);
        }
    },
    computed: {
        fields() {
            return this.results.slice(0,20); // return top 20 results
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
            this.$emit("itemWasSearched", "");

            this.isLoading = false;
        }
    }
};
</script>

<style>
</style>