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
import axios from "axios";

const API_URL = "http://localhost:8080/instructors";
export default {
    name: "JobList",
    data: function() {
        return {
            courses: [],
            INSTRUCTOR: "in28minutes"
        };
    },
    methods: {
        retrieveCourses() {
            axios
                .get(`${API_URL}/${this.INSTRUCTOR}/courses`)
                .then(response => {
                    this.courses = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    created() {
        this.retrieveCourses();
    }
};
</script>

<style scoped>
</style>