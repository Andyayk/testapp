<template>
    <v-container>
        <h3>Details</h3>
        <v-container>
            <v-list-item v-for="(value, propertyName, itemIndex) in user" v-bind:key="itemIndex">
                <v-list-item-content>
                    <v-list-item-title v-text="value"></v-list-item-title>
                    <v-list-item-subtitle v-text="propertyName"></v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
        </v-container>
    </v-container>
</template>

<script>
import axios from "axios";
import { eventBus } from "../main";

const API_URL = "http://localhost:8080/user";

export default {
    name: "UserProfile",
    data: function() {
        return {
            user: "",
        };
    },
    methods: {
        retrieveUserDetails() {
            axios
                .get(`${API_URL}/${eventBus.username}`)
                .then(response => {
                    this.user = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    created() {
        this.retrieveUserDetails();
    }
};
</script>

<style scoped>
</style>