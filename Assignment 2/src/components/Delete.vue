<template>
	<div>
		<button @click="deleteItem">Delete</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['index'],
		methods: {
			deleteItem: function(){
				eventBus.items.splice(this.index, 1)
			}
		}
	}

</script>

<style>

</style>
