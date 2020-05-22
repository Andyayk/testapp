<template>
	<div>
		<button @click="editItem">Submit</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['editLinkname', 'editLinkpath', 'editIconpath', 'editDatecreated', 'index'],
		methods: {
			editItem: function(){
				if(this.editLinkname != ""){
					eventBus.items[this.index].linkname = this.editLinkname
				}
				
				if(this.editLinkpath != ""){
					eventBus.items[this.index].linkpath = this.editLinkpath
				}
				
				if(this.editIconpath != ""){
					eventBus.items[this.index].iconpath = this.editIconpath
				}

				if(this.editDatecreated != ""){
					eventBus.items[this.index].datecreated = this.editDatecreated
				}			
			}
		}
	}

</script>

<style>

</style>
