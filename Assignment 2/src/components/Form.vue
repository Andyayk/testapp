<template>
	<div>
		<form @submit.prevent="resetAddForm()">
			<p>Name of Link: <input type="text" v-model="linkname"></p>
			<p>Link Path: <input type="text" v-model="linkpath"></p>
			<p>Icon Path: <input type="text" v-model="iconpath"></p>
			<p>Date Created: <input type="text" v-model="datecreated"></p>
			<add-item 
				:id="id"
				:linkname="linkname"
				:linkpath="linkpath"
				:iconpath="iconpath"
				:datecreated="datecreated"
			></add-item>
		</form>				
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import AddItem from './Add.vue';

	export default {
		data: function() {
			return {
				id: 2,
				linkname: '', 
				linkpath: '',
				iconpath: '',
				datecreated: ''		
			};
		},
		methods: {
			resetAddForm: function(){
				this.id = ++this.id
				this.linkname = ''
				this.linkpath = ''
				this.iconpath = ''
				this.datecreated = ''				
			}		
		},
		components: {
			addItem: AddItem
		}
	}
</script>

<style>

</style>
