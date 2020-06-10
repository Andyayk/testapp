<template>
    <v-card>
        <v-card-title>
            <h3>Home</h3>
        </v-card-title>
        <v-card>
            <v-card-text>Welcome! You may search for jobs and skills under the respective tabs and your favourites will be shown here.</v-card-text>
            <br />
            <v-container v-if="items.length">
                <h2>Saved Favourites</h2>
                <v-card v-for="(item, index) in items" :key="item.id">
                    <app-item :items="items" :item="item" :index="index"></app-item>
                </v-card>
            </v-container>
        </v-card>
    </v-card>
</template>

<script>
import { eventBus } from "../main";
import Item from "./Item.vue";

export default {
    data: function() {
        return {
            items: [
                {
                    id: 1,
                    linkname: "Google",
                    linkpath: "https://google.com/",
                    iconpath:
                        "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png",
                    datecreated: "2020-01-01"
                }
            ]
        };
    },
    created() {
        eventBus.$on("itemWasCreated", item => {
            this.items.push(item);
        }),
            eventBus.$on("itemWasUpdated", items => {
                this.items = items;
            });
    },
    components: {
        appItem: Item
    }
};
</script>

<style>
</style>
