<template>
    <v-container>
        <h3>Add Favourites</h3>
        <v-form @submit.prevent>
            <v-text-field v-model="linkname" label="Link"></v-text-field>
            <v-text-field v-model="linkpath" label="Link Path"></v-text-field>
            <v-text-field v-model="iconpath" label="Icon Path"></v-text-field>
            <v-text-field v-model="datecreated" label="Date Created" disabled></v-text-field>
            <add-button
                @addButtonActivated="addItem"
            ></add-button>
        </v-form>
    </v-container>
</template>

<script>
import { eventBus } from '../main';
import AddButton from './AddButton.vue';

export default {
    data: function() {
        return {
            linkname: '',
            linkpath: '',
            iconpath: '',
            datecreated: new Date().toISOString().split('T')[0]
        };
    },
    methods: {
        addItem: function() {
            var processedLinkpath = eventBus.processURLpath(this.linkpath);
            var processedIconpath = eventBus.processURLpath(this.iconpath);

            var item = {
                linkname: this.linkname,
                linkpath: processedLinkpath,
                iconpath: processedIconpath,
                datecreated: this.datecreated
            };

            eventBus.$emit('itemWasCreated', item);
  
            //reset form
            this.linkname = '';
            this.linkpath = '';
            this.iconpath = '';
        }
    },
    components: {
        addButton: AddButton
    }
};
</script>

<style>
</style>
