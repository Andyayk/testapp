<template>
	<div>
		<button @click="addItem">Submit</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['id', 'linkname', 'linkpath', 'iconpath', 'datecreated', 'editenable'],
		methods: {
			addItem: function(){
				eventBus.items.push({
					id: this.id,
					linkname: this.linkname, 
					linkpath: this.linkpath, 
					iconpath: this.iconpath, 
					datecreated: this.datecreated,
					editenable: this.editenable
				})
			}
		}
	}

</script>

<style>

</style>
