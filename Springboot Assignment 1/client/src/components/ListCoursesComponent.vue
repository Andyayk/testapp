<template>
    <v-container>
        <h3>All Courses</h3>
        <v-container>
            <v-simple-table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="course in courses" v-bind:key="course.id">
                        <td>{{course.id}}</td>
                        <td>{{course.description}}</td>
                    </tr>
                </tbody>
            </v-simple-table>
        </v-container>
    </v-container>
</template>

<script>
import CourseDataService from "../service/CourseDataService";
export default {
    name: "CoursesList",
    data: function() {
        return {
            courses: [],
            message: null,
            INSTRUCTOR: "in28minutes"
        };
    },
    methods: {
        refreshCourses() {
            CourseDataService.retrieveAllCourses(this.INSTRUCTOR) //HARDCODED
                .then(response => {
                    this.courses = response.data;
                });
        }
    },
    created() {
        this.refreshCourses();
    }
};
</script>

<style scoped>
</style>