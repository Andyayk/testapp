<template>
	<div>
		<button @click="deleteItem">Delete</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['items', 'index'],
		methods: {
			deleteItem: function(){
				this.items.splice(this.index, 1)

				eventBus.$emit('itemWasUpdated', this.items);				
			}
		}
	}

</script>

<style>

</style>
