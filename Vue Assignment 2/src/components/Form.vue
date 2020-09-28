<template>
	<div class="container p-3 my-3 border">
		<h2>Add Favourites</h2>
		<form @submit.prevent="addItem()">
			<div class="form-group">
				<label>Link:</label>			
				<input type="text" class="form-control" v-model="linkname" placeholder="Enter Name of Link">
			</div>
			<div class="form-group">
				<label>Link Path:</label>			
				<input type="text" class="form-control" v-model="linkpath" placeholder="Enter Link Path">
			</div>
			<div class="form-group">
				<label>Icon Path:</label>			
				<input type="text" class="form-control" v-model="iconpath" placeholder="Enter Icon Path">
			</div>
			<div class="form-group">
				<label>Date Created:</label>			
				<input type="text" class="form-control" v-model="datecreated" placeholder="Enter Name of Link" disabled>
			</div>					
			<add-button></add-button>
		</form>
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import AddButton from './AddButton.vue';

	export default {
		data: function() {
			return {
				id: 2,
				linkname: '', 
				linkpath: '',
				iconpath: '',
				datecreated: new Date().toISOString().split('T')[0]	
			};
		},
		methods: {
			addItem: function(){
				var processedLinkpath = eventBus.processURLpath(this.linkpath);
				var processedIconpath = eventBus.processURLpath(this.iconpath);

				var item = {
					id: this.id,
					linkname: this.linkname, 
					linkpath: processedLinkpath, 
					iconpath: processedIconpath, 
					datecreated: this.datecreated
				};

				eventBus.$emit('itemWasCreated', item);

				this.id = ++this.id
				//reset form
				this.linkname = ''
				this.linkpath = ''
				this.iconpath = ''					
			}				
		},
		components: {
			addButton: AddButton
		}
	}
</script>

<style>

</style>
