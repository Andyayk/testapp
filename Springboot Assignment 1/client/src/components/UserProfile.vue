<template>
    <v-container>
        <h3>Details</h3>
        <v-container>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{getAppUser.name}}</v-list-item-title>
                    <v-list-item-subtitle>Name</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{getAppUser.email}}</v-list-item-title>
                    <v-list-item-subtitle>Email</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
            <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>{{getAppUser.employeeId}}</v-list-item-title>
                    <v-list-item-subtitle>Employee Id</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
        </v-container>
    </v-container>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
    name: "UserProfile",
    computed: {
        ...mapGetters('user', {
            getAppUser: 'getAppUser'
        })  
    }
};
</script>

<style scoped>
</style>