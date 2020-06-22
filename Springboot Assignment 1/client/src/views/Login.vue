<template>
    <v-container>
        <v-row class="text-center">
            <v-col cols="12">
                <v-img :src="require('../assets/logo.svg')" class="my-3" contain height="200" />
            </v-col>

            <v-col class="mb-4">
                <h1 class="display-2 font-weight-bold mb-3">Employment Portal</h1>
            </v-col>
        </v-row>
        <font color="red">{{ this.message }}</font>
        <v-container>
            <v-form @submit.prevent>
                <v-text-field v-model="username" label="Username"></v-text-field>
                <v-text-field
                    v-model="password"
                    :append-icon="showpassword ? 'mdi-eye' : 'mdi-eye-off'"
                    :rules="[rules.required, rules.min]"
                    :type="showpassword ? 'text' : 'password'"
                    label="Password"
                    hint="At least 4 characters"
                    @click:append="showpassword = !showpassword"
                ></v-text-field>
                <v-btn @click="loginUser">Login</v-btn>
            </v-form>
        </v-container>
    </v-container>
</template>

<script>
export default {
    name: "Login",
    data: function() {
        return {
            username: "",
            password: "",
            message: "",
            showpassword: false,
            rules: {
                required: value => !!value || "Required.",
                min: v => v.length >= 4 || "Min 4 characters"
            }
        };
    },
    methods: {
        loginUser: function() {
            if (this.username == "user" && this.password == 1234) {
                console.log("a");
                this.message = "";
            } else if (this.username == "admin" && this.password == 1234) {
                console.log("b");
                this.message = "";
            } else {
                this.message = "Wrong Username/Password";
            }
        }
    }
};
</script>

<style scoped>
</style>