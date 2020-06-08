<template>
    <div>
        <v-card-text>
            <v-autocomplete
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
            ></v-autocomplete>
        </v-card-text>
        <v-btn @click="retrieveAll()">Retrieve All</v-btn>
            <v-list>
                <v-list-item v-for="(item, index) in allResults" :key="index">
                    <v-list-item-content>
                        <v-list-item-title v-text="item.title"></v-list-item-title>
                        <v-list-item-subtitle v-text="item.title"></v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
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
    </div>
</template>

<script>
import { eventBus } from "../main";

export default {
    props: ["text", "value", "label", "items", "allResults"],
    data: function() {
        return {
            isLoading: false,
            model: null,
            search: null
        };
    },
    methods: {
        retrieveAll: function(){
            eventBus.$emit('retrieveAllActivated', '');
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
            eventBus.$emit('itemWasSearched', '');

            this.isLoading = false;
        }
    }
};
</script>

<style>
</style>