<template>
    <v-card>
        <v-tabs center-active>
            <v-tab to="/login">
                <v-icon>mdi-file-document</v-icon>Login, To be removed
            </v-tab>            
            <v-tab to="/" exact>
                <v-icon>mdi-home</v-icon>Home
            </v-tab>
            <v-tab to="/profile">
                <v-icon>mdi-account-circle</v-icon>Profile
            </v-tab>
        </v-tabs>
    </v-card>
</template>

<script>
export default {};
</script>

<style scoped>
</style>