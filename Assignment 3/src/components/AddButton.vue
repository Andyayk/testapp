<template>
    <div>
        <v-btn @click="onClickFunction" color="success">Add</v-btn>
    </div>
</template>

<script>
export default {
    methods: {
        onClickFunction: function() {
            this.$emit("addButtonActivated", "");
        }
    }
};
</script>

<style>
</style>
