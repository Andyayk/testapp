<template>
    <p>Counter is: {{ counter }}</p>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    computed: {
        ...mapGetters('counter', {
            counter: 'doubleCounter'
        })
    }
}
</script>