<template>
<div class="container p-3 my-3 border">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <h1>The Jobs Page</h1>
            <hr>
            <p>Display data for all jobs</p>
            <button class="btn btn-primary" @click="retrieveAllJobs">Retrieve All</button>
            <br><br>
            <div class="form-group">
                <label>Job ID:</label>
                <input class="form-control" type="text" v-model="id">
            </div>
            <button class="btn btn-primary" @click="retrieveSpecificJob">Retrieve Job</button>
            <br><br>
            <ul class="list-group">
                <li class="list-group-item" v-for="job in jobs"><b>ID</b>: {{ job.uuid }}<br><b>Job Title</b>: {{ job.title }}<br><b>Normalized Job Title</b>: {{ job.normalized_job_title }}</li>
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
            jobs: [],
            resource: {},
            id: '26bc4486dfd0f60b3bb0d8d64e001800'
        };
    },
    methods: {
        retrieveAllJobs() {
            this.resource.retrieveAllJobsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    this.jobs = resultArray;
                });
        },
        retrieveSpecificJob() {
            this.resource.retrieveSpecificJobData({
                    id: this.id
                })
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    const resultArray = [];
                    resultArray.push(data);
                    this.jobs = resultArray;
                });
        }
    },
    created() {
        const customActions = {
            retrieveAllJobsData: {
                method: 'GET'
            },
            retrieveSpecificJobData: {
                method: 'GET',
                url: 'jobs{/id}'
            }
        };
        this.resource = this.$resource('jobs{/id}', {}, customActions);
    }
}
</script>

<style>
</style>
