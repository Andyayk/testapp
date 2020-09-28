<template>
    <div>
        <v-btn @click="onClickFunction" color="#E53935" dark>Delete</v-btn>
    </div>
</template>

<script>
export default {
    methods: {
        onClickFunction: function() {
            this.$emit("deleteButtonActivated", "");
        }
    }
};
</script>

<style>
</style>
