<template>
    <v-container>
        <v-form @submit.prevent="editItem">
            <font color="red">Only completed textboxes will be updated</font>
            <v-text-field v-model="editLinkname" label="Link"></v-text-field>
            <v-text-field v-model="editLinkpath" label="Link Path"></v-text-field>
            <v-text-field v-model="editIconpath" label="Icon Path"></v-text-field>
            <v-text-field v-model="editDatecreated" label="Date Created" disabled></v-text-field>
            <edit-button></edit-button>
        </v-form>
    </v-container>
</template>

<script>
import { eventBus } from '../main';
import EditButton from './EditButton.vue';

export default {
    props: ['items', 'index', 'toggleEditFunction'],
    data: function() {
        return {
            editLinkname: '',
            editLinkpath: '',
            editIconpath: '',
            editDatecreated: new Date().toISOString().split('T')[0]
        };
    },
    methods: {
        editItem: function() {
            var processedLinkpath = eventBus.processURLpath(this.editLinkpath);
            var processedIconpath = eventBus.processURLpath(this.editIconpath);

            //only completed textboxes will be updated
            if (this.editLinkname != '') {
                this.items[this.index].linkname = this.editLinkname;
            }

            if (this.editLinkpath != '') {
                this.items[this.index].linkpath = processedLinkpath;
            }

            if (this.editIconpath != '') {
                this.items[this.index].iconpath = processedIconpath;
            }

            if (this.editDatecreated != '') {
                this.items[this.index].datecreated = this.editDatecreated;
            }

            //reset form
            this.editLinkname = '';
            this.editLinkpath = '';
            this.editIconpath = '';

            eventBus.$emit('itemWasUpdated', this.items);

            this.toggleEditFunction(); //close editing box
        }
    },
    components: {
        editButton: EditButton
    }
};
</script>

<style>
</style>
