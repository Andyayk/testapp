<template>
    <div>
        <v-btn @click="increment(100)">Increment</v-btn>
        <v-btn @click="decrement(50)">Decrement</v-btn>
    </div>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    methods: {
        ...mapActions('counter', {
            increment: 'increment',
            decrement: 'decrement'
        })
    }
}
</script>