<template>
    <v-container>
        <h3>Monthly Report</h3>
        <app-generate-report />
    </v-container>
</template>

<script>
// @ is an alias to /src
import GenerateReport from "@/components/GenerateReport"

export default {
    name: "Report",
    components: {
        appGenerateReport: GenerateReport
    }
};
</script>

<style scoped>
</style>