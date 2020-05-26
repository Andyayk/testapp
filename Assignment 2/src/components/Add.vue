<template>
	<div>
		<button @click="addItem">Submit</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['id', 'linkname', 'linkpath', 'iconpath', 'datecreated'],
		methods: {
			addItem: function(){
				var item = {
					id: this.id,
					linkname: this.linkname, 
					linkpath: this.linkpath, 
					iconpath: this.iconpath, 
					datecreated: this.datecreated
				};

				eventBus.$emit('itemWasCreated', item);
			}
		}
	}

</script>

<style>

</style>
