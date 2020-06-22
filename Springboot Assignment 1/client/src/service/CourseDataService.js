import axios from "axios";

const INSTRUCTOR = "in28minutes";
const COURSE_API_URL = "http://localhost:8080";
const INSTRUCTOR_API_URL = `${COURSE_API_URL}/instructors/${INSTRUCTOR}`;

class CourseDataService {
    retrieveAllCourses() {
        return axios.get(`${INSTRUCTOR_API_URL}/courses`);
    }
}

export default new CourseDataService();