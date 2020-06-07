<template>
    <div class="container p-3 my-3 border">
        <h3>Skills</h3>
        <hr />
        <p>You may search for skills on this page, an empty submission will return all results</p>
        <hr />
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <h5>Search for a Skill</h5>
                <div class="form-group">
                    <label>Skill Title:</label>
                    <input class="form-control" type="text" v-model="skillTitle" />
                </div>
                <button
                    class="btn btn-primary"
                    @click="skillTitle==='' ? retrieveAllSkills() : retrieveSpecificSkill()"
                >Submit</button>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
                <h5>Results:</h5>
                <div v-if="errors">Skill Not Found! Please Try Another Skill Title.</div>
                <div class="d-flex" v-else>
                    <ul class="list-group justify-content-center">
                        <li
                            class="list-group-item"
                            v-for="(skill,index) in skills"
                            :key="skill.uuid"
                        >
                            {{ index+1 }})
                            <br />
                            <b>ID:</b>
                            {{ skill.uuid }}
                            <br />
                            <b>Skill Title:</b>
                            {{ skill.normalized_skill_name }}
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            resource: {},
            skillTitle: "",
            skills: [],
            errors: false
        };
    },
    methods: {
        retrieveAllSkills() {
            this.resource
                .retrieveAllSkillsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    this.errors = false; // no errors
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    this.skills = resultArray;
                })
                .catch(e => {
                    this.errors = true;
                    console.log(e);
                });
        },
        retrieveSpecificSkill() {
            this.resource
                .retrieveSpecificSkillData({
                    contains: this.skillTitle
                })
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    this.errors = false; // no errors
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    //resultArray.push(data);
                    this.skills = resultArray;
                })
                .catch(e => {
                    this.errors = true;
                    console.log(e);
                });
        }
    },
    created() {
        const customActions = {
            retrieveAllSkillsData: {
                method: "GET"
            },
            retrieveSpecificSkillData: {
                method: "GET",
                url: "skills/autocomplete{/skillTitle}"
            }
        };
        this.resource = this.$resource("skills", {}, customActions);
    }
};
</script>

<style>
</style>
