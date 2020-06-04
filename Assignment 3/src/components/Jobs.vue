<template>
    <div>
        <h1>The Jobs Page</h1>
        <hr>
        <p>Display data for all jobs</p>
        <button @click="retrieveAllJobs">Retrieve All</button>
		<button @click="retrieveSpecificJob">Retrieve Job</button>

        <ul class="list-group">
            <li class="list-group-item" v-for="job in jobs"><b>ID</b>: {{ job.uuid }}<br><b>Job Title</b>: {{ job.title }}<br><b>Normalized Job Title</b>: {{ job.normalized_job_title }}</li>
        </ul>
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
								console.log(data[key]);
                                resultArray.push(data[key]);
                            }
                            this.jobs = resultArray;
                        });
            },
            retrieveSpecificJob() {
                this.resource.retrieveSpecificJobData({id: this.id})
                        .then(response => {
                            return response.json();
                        })
                        .then(data => {
                            const resultArray = [];
							console.log(data);
                            resultArray.push(data);
                            this.jobs = data;
                        });
            }            
        },
        created() {
            const customActions = {
                retrieveAllJobsData: {method: 'GET'},
                retrieveSpecificJobData: {method: 'GET', url: 'jobs{/id}'}
            };
            this.resource = this.$resource('jobs{/id}', {}, customActions);
        }
    }
</script>

<style>
</style>