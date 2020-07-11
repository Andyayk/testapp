<template>
    <v-container>
        <h3>Favourite Job Listings</h3>
        <app-favourites-list />
    </v-container>
</template>

<script>
// @ is an alias to /src
import FavouritesList from "@/components/FavouritesList";

export default {
    name: "Favourites",
    components: {
        appFavouritesList: FavouritesList
    }
};
</script>

<style scoped>
</style>