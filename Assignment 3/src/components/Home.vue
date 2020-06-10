<template>
    <v-card>
        <v-card-title>
            <h3>Home</h3>
        </v-card-title>
        <v-card>
            <v-card-text>Welcome! You may search for jobs and skills under the respective tabs and your favourites will be shown here.</v-card-text>
            <v-divider></v-divider>
            <app-form></app-form>
            <v-divider></v-divider>
            <v-container v-if="items.length">
                <h3>Saved Favourites</h3>
                <v-card v-for="(item, index) in items" :key="index">
                    <app-item :items="items" :item="item" :index="index"></app-item>
                </v-card>
            </v-container>
        </v-card>
    </v-card>
</template>

<script>
import { eventBus } from '../main';
import Form from './Form.vue';
import Item from './Item.vue';

export default {
    data: function() {
        return {
            items: [
                {
                    linkname: 'Google',
                    linkpath: 'https://google.com/',
                    iconpath:
                        'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
                    datecreated: '2020-01-01'
                }
            ]
        };
    },
    created() {
        eventBus.$on('itemWasCreated', item => {
            this.items.push(item);
        }),
            eventBus.$on('itemWasUpdated', items => {
                this.items = items;
            });
    },
    components: {
        appForm: Form,
        appItem: Item
    }
};
</script>

<style>
</style>
