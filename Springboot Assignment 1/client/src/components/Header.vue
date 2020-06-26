<template>
    <v-card>
        <v-tabs center-active>    
            <v-tab to="/" exact>
                <v-icon>mdi-home</v-icon>Home
            </v-tab>
            <v-tab v-if="isAdmin" to="/createjob">
                <v-icon>mdi-briefcase</v-icon>Create Job
            </v-tab>                    
            <v-tab to="/profile">
                <v-icon>mdi-account-circle</v-icon>Profile
            </v-tab>    
            <v-tab to="/login" @click="logout">
                <v-icon>mdi-logout</v-icon>Logout
            </v-tab>            
        </v-tabs>
    </v-card>
</template>

<script>
import { eventBus } from "../main";

export default {
    name: "Header",
    data: function() {
        return {
            isAdmin: eventBus.appUser.isAdmin
        };
    },    
    methods: {
        logout: function() {
            this.$emit("userlogout", false);
        }
    }
};
</script>

<style scoped>
</style>