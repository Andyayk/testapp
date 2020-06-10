<template>
    <v-container>
        <v-card-text>
            <v-row>
                <v-col cols="7">
                    <v-container>
                        <h3>Item {{ item.id }}</h3>
						<br />
                        <img
                            :src="item.iconpath"
                            alt="item.linkname"
                        />		
						<br />				
                        Name: {{ item.linkname }}
                        <br />
                        Link: <a :href="item.linkpath" target="_blank">{{ item.linkpath }}</a>
                        <br />
                        Date Created: {{ item.datecreated }}
                    </v-container>
                </v-col>
                <v-col cols="5" class="text-right">
                    <v-container>
                        <v-card-actions>
							 <v-spacer></v-spacer>
                            <delete-button :onclickFunction="deleteItem"></delete-button>
                            <v-btn color="primary" @click="toggleEdit">Edit</v-btn>
                        </v-card-actions>
                        <app-edit-form
                            v-if="editenable"
                            :items="items"
                            :index="index"
                            :toggleEditFunction="toggleEdit"
                        ></app-edit-form>
                    </v-container>
                </v-col>
            </v-row>
        </v-card-text>
    </v-container>
</template>

<script>
import { eventBus } from "../main";
import DeleteButton from "./DeleteButton.vue";
import EditForm from "./EditForm.vue";

export default {
    props: ["items", "item", "index"],
    data: function() {
        return {
            editenable: false
        };
    },
    methods: {
        toggleEdit: function() {
            this.editenable = !this.editenable;
        },
        deleteItem: function() {
            this.items.splice(this.index, 1);

            eventBus.$emit("itemWasUpdated", this.items);
        }
    },
    components: {
        deleteButton: DeleteButton,
        appEditForm: EditForm
    }
};
</script>

<style>
</style>