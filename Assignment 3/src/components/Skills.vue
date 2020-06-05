<template>
<div class="container p-3 my-3 border">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <h1>The Skills Page</h1>
            <hr>
            <p>Display data for all skills</p>
            <button class="btn btn-primary" @click="retrieveAllSkills">Retrieve All</button>
            <br><br>
            <div class="form-group">
                <label>Skill ID:</label>
                <input class="form-control" type="text" v-model="id">
            </div>
            <button class="btn btn-primary" @click="retrieveSpecificSkill">Retrieve Skill</button>
            <br><br>
            <ul class="list-group">
                <li class="list-group-item" v-for="skill in skills"><b>ID</b>: {{ skill.uuid }}<br><b>Normalized Skill Title</b>: {{ skill.normalized_skill_name }}</li>
            </ul>
        </div>
    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            user: {
                username: '',
                email: ''
            },
            resource: {},
            id: '02eb7ff7569c9beedda699580d679557',
            skills: []
        };
    },
    methods: {
        retrieveAllSkills() {
            this.resource.retrieveAllSkillsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    this.skills = resultArray;
                });
        },
        retrieveSpecificSkill() {
            this.resource.retrieveSpecificSkillData({
                    id: this.id
                })
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    resultArray.push(data);
                    this.skills = resultArray;
                });
        }
    },
    created() {
        const customActions = {
            retrieveAllSkillsData: {
                method: 'GET'
            },
            retrieveSpecificSkillData: {
                method: 'GET',
                url: 'skills{/id}'
            }       
        };
        this.resource = this.$resource('skills', {}, customActions);
    }
}
</script>

<style>
</style>
