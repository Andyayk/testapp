<template>
	<div>
		<form @submit.prevent="resetEditForm()">
			<font color="red">Only completed textboxes will be updated</font>
			<p>New Name of Link: <input type="text" v-model="editLinkname"></p>
			<p>New Link Path: <input type="text" v-model="editLinkpath"></p>
			<p>New Icon Path: <input type="text" v-model="editIconpath"></p>
			<p>New Date Created: <input type="text" v-model="editDatecreated" disabled></p>
			<edit-item
				:items="items"
				:editLinkname="editLinkname"
				:editLinkpath="editLinkpath"
				:editIconpath="editIconpath"
				:editDatecreated="editDatecreated"
				:index="index"
			></edit-item>
		</form>			
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import EditItem from './Edit.vue';

	export default {
		props: ['items', 'index'],
		data: function() {
			return {
				editLinkname: '',
				editLinkpath: '',
				editIconpath: '',
				editDatecreated: new Date().toISOString().split('T')[0]
			};
		},
		methods: {
			resetEditForm: function(){
				//reset form
				this.editLinkname = ''
				this.editLinkpath = ''
				this.editIconpath = ''			
			}	
		},
		components: {
			editItem: EditItem
		}
	}
</script>

<style>

</style>
