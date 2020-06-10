<template>
    <div>
        <v-btn @click="onClickFunction" color="success">Update</v-btn>
    </div>
</template>

<script>
export default {
    methods: {
        onClickFunction: function() {
            this.$emit("editButtonActivated", "");
        }
    }
};
</script>

<style>
</style>
