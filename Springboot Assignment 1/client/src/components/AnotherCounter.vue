<template>
    <div>
        <button class="btn btn-primary" @click="asyncI({by: 50, duration: 500})">Increment</button>
        <button class="btn btn-primary" @click="asyncD({by: 50, duration: 500})">Decrement</button>
    </div>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    methods: {
        ...mapActions('counter', {
            asyncI: 'asyncIncrement',
            asyncD: 'asyncDecrement'
        })
    }
}
</script>