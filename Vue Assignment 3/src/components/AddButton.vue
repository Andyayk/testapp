<template>
    <div>
        <v-btn @click="onClickFunction" color="success">Add</v-btn>
        <v-snackbar v-model="snackbar">
            {{ text }}
            <v-btn color="white" text @click="snackbar = false">Close</v-btn>
        </v-snackbar>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            snackbar: false,
            text: "Favourites Added!"
        };
    },
    methods: {
        onClickFunction: function() {
            this.snackbar = true;
            this.$emit("addButtonActivated", "");
        }
    }
};
</script>

<style>
</style>
