<template>
    <v-container>
        <h3>Details</h3>
        <v-container>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{user.name}}</v-list-item-title>
                    <v-list-item-subtitle>Name</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{user.email}}</v-list-item-title>
                    <v-list-item-subtitle>Email</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{user.employeeid}}</v-list-item-title>
                    <v-list-item-subtitle>Employee Id</v-list-item-subtitle>
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
            user: eventBus.appUser
        };
    }
};
</script>

<style scoped>
</style>