<template>
    <v-card>
        <v-card-title>
            <h3>Home</h3>
        </v-card-title>
        <v-card>
            <v-card-text>Welcome! This is the home page. You may search for jobs and skills under the respective tabs</v-card-text>
            <app-form></app-form>
            <br />
            <div class="container p-3 my-3 border" v-if="items.length">
                <h2>Saved Favourites</h2>
                <div class="card" v-for="(item, index) in items" :key="item.id">
                    <app-item :items="items" :item="item" :index="index"></app-item>
                </div>
            </div>
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
                    id: 1,
                    linkname: 'Google',
                    linkpath: 'https://google.com/',
                    iconpath: 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
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
