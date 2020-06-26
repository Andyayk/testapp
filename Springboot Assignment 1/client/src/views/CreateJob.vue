<template>
    <v-container>
        <h3>Create Job</h3>
        <app-form />
    </v-container>
</template>

<script>
// @ is an alias to /src
import Form from "@/components/Form.vue";

export default {
    name: "CreateJob",
    components: {
        appForm: Form
    }
};
</script>

<style scoped>
</style>