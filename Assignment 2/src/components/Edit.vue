<template>
	<div>
		<button @click="editItem">Submit</button>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['items', 'editLinkname', 'editLinkpath', 'editIconpath', 'editDatecreated', 'index'],
		methods: {
			editItem: function(){
				if(this.editLinkname != ""){
					this.items[this.index].linkname = this.editLinkname
				}
				
				if(this.editLinkpath != ""){
					this.items[this.index].linkpath = this.editLinkpath
				}
				
				if(this.editIconpath != ""){
					this.items[this.index].iconpath = this.editIconpath
				}

				if(this.editDatecreated != ""){
					this.items[this.index].datecreated = this.editDatecreated
				}			

				eventBus.$emit('itemWasUpdated', this.items);					
			}
		}
	}

</script>

<style>

</style>
