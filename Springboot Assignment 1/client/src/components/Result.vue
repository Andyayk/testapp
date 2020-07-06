<template>
    <p>Counter is: {{ counter }}</p>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    computed: {
        counter() {
            return this.$store.getters.doubleCounter;
        }
    }
}
</script>