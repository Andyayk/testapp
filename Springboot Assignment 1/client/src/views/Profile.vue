<template>
    <v-container>
        <h3>User Profile</h3>
        <app-user-profile />
    </v-container>
</template>

<script>
// @ is an alias to /src
import UserProfile from "@/components/UserProfile"

export default {
    name: "Profile",
    components: {
        appUserProfile: UserProfile
    }
};
</script>

<style scoped>
</style>