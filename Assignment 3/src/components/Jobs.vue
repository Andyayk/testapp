<template>
<div class="container p-3 my-3 border">
    <h3>The Jobs Page</h3>
    <hr>
    <p>You may search for jobs on this page, an empty submission will return all results</p>
    <hr>
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
            <h5>Search for a job</h5>
            <div class="form-group">
                <label>Job ID:</label>
                <input class="form-control" type="text" v-model="id">
            </div>
            <button class="btn btn-primary" @click="id==='' ? retrieveAllJobs() : retrieveSpecificJob()">Submit</button>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6">
			<h5>Results:</h5>
			<div v-if="errors">
				Job Not Found! Please Try Another Job ID.
			</div>
            <div class="d-flex" v-else>
                <ul class="list-group justify-content-center">
                    <li class="list-group-item" v-for="job in jobs"><b>ID</b>: {{ job.uuid }}<br><b>Job Title</b>: {{ job.title }}<br><b>Normalized Job Title</b>: {{ job.normalized_job_title }}</li>
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
            user: {
                username: '',
                email: ''
            },
            resource: {},
            id: '',
            jobs: [],
			errors: false
        };
    },
    methods: {
        retrieveAllJobs() {
            this.resource.retrieveAllJobsData()
                .then(response => {
                    return response.json();
                })
                .then(data => {
					this.errors = false;
                    const resultArray = [];
                    for (let key in data) {
                        resultArray.push(data[key]);
                    }
                    this.jobs = resultArray;
                })
				.catch(e => { 
					this.errors = true;
					console.log(e);
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
					this.errors = false;
                    const resultArray = [];
                    resultArray.push(data);
                    this.jobs = resultArray;
                })
				.catch(e => {
					this.errors = true;
					console.log(e);
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
        this.resource = this.$resource('jobs', {}, customActions);
    }
}
</script>

<style>
</style>
