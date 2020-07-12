<template>
    <v-card>
        <v-tabs center-active>    
            <v-tab to="/" exact>
                <v-icon>mdi-home</v-icon>Home
            </v-tab>
            <v-tab v-if="getAppUser.isadmin" to="/createjob">
                <v-icon>mdi-briefcase</v-icon>Create Job
            </v-tab>     
            <v-tab to="/favourites">
                <v-icon>mdi-heart</v-icon>My Favourites
            </v-tab>       
            <v-tab v-if="getAppUser.isadmin" to="/report">
                <v-icon>mdi-file-document</v-icon>Monthly Report
            </v-tab>                                 
            <v-tab to="/profile">
                <v-icon>mdi-account-circle</v-icon>Profile
            </v-tab>    
            <v-tab to="/login" @click="setUserLogout">
                <v-icon>mdi-logout</v-icon>Logout
            </v-tab>            
        </v-tabs>
    </v-card>
</template>

<script>
import { mapGetters } from 'vuex';
import { mapActions } from 'vuex';

export default {
    name: "Header",  
    methods: {
        ...mapActions('user', {
            setUserLogout: 'setUserLogout',
        })        
    },
    computed: {
        ...mapGetters('user', {
            getAppUser: 'getAppUser'
        })  
    }
};
</script>

<style scoped>
</style>