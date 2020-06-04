<template>
    <div>
        <h1>The Skills Page</h1>
        <hr>
        <p>Display data for all skills</p>
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
                users: [],
                resource: {},
                node: 'data'
            };
        },
        methods: {
            submit() {
//                this.$http.post('data.json', this.user)
//                        .then(response => {
//                            console.log(response);
//                        }, error => {
//                            console.log(error);
//                        });
//                this.resource.save({}, this.user);
                this.resource.saveAlt(this.user);
            },
            fetchData() {
//                this.$http.get('data.json')
//                        .then(response => {
//                            return response.json();
//                        })
//                        .then(data => {
//                            const resultArray = [];
//                            for (let key in data) {
//                                resultArray.push(data[key]);
//                            }
//                            this.users = resultArray;
//                        });
                this.resource.getData({node: this.node})
                        .then(response => {
                            return response.json();
                        })
                        .then(data => {
                            const resultArray = [];
                            for (let key in data) {
                                resultArray.push(data[key]);
                            }
                            this.users = resultArray;
                        });
            }
        },
        created() {
            const customActions = {
                saveAlt: {method: 'POST', url: 'alternative.json'},
                getData: {method: 'GET'}
            };
            this.resource = this.$resource('{node}.json', {}, customActions);
        }
    }
</script>

<style>
</style>