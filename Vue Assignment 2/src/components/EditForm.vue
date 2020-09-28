<template>
	<div>
		<form @submit.prevent="editItem()">
			<font color="red">Only completed textboxes will be updated</font>
			<p>New Name of Link: <input type="text" v-model="editLinkname"></p>
			<p>New Link Path: <input type="text" v-model="editLinkpath"></p>
			<p>New Icon Path: <input type="text" v-model="editIconpath"></p>
			<p>New Date Created: <input type="text" v-model="editDatecreated" disabled></p>
			<edit-button></edit-button>
		</form>			
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import EditButton from './EditButton.vue';

	export default {
		props: ['items', 'index', 'toggleEditFunction'],
		data: function() {
			return {
				editLinkname: '',
				editLinkpath: '',
				editIconpath: '',
				editDatecreated: new Date().toISOString().split('T')[0]
			};
		},
		methods: {
			editItem: function(){
				var processedLinkpath = eventBus.processURLpath(this.editLinkpath);
				var processedIconpath = eventBus.processURLpath(this.editIconpath);

				//only completed textboxes will be updated
				if(this.editLinkname != ''){
					this.items[this.index].linkname = this.editLinkname
				}
				
				if(this.editLinkpath != ''){
					this.items[this.index].linkpath = processedLinkpath
				}
				
				if(this.editIconpath != ''){
					this.items[this.index].iconpath = processedIconpath
				}

				if(this.editDatecreated != ''){
					this.items[this.index].datecreated = this.editDatecreated
				}				

				//reset form
				this.editLinkname = ''
				this.editLinkpath = ''
				this.editIconpath = ''

				eventBus.$emit('itemWasUpdated', this.items);	

				this.toggleEditFunction(); //close editing box
			}			
		},
		components: {
			editButton: EditButton
		}
	}
</script>

<style>

</style>
