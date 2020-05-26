<template>
	<div>
		<div>
			Item {{ item.id }}:
			{{ item.linkname }}
			<img :src="item.iconpath" height="50" width="100" alt="item.linkname">
		</div>
		<div align="right">
			<delete-item
				:items="items"
				:index="index"
			></delete-item>			
			<button @click="toggleEdit">Edit</button>
			<div v-if="editenable">
				<app-edit-form
					:items="items"
					:index="index"					
				></app-edit-form>
			</div>
		</div>
		<a :href="item.linkpath" target="_blank"> {{ item.linkpath }} </a>
		<br>
		Date Created: {{ item.datecreated }}
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import DeleteItem from "./Delete.vue";
	import EditItem from "./Edit.vue";
	import EditForm from "./EditForm.vue";	

	export default {
		props: ['items', 'item', 'index'],
		data: function (){
			return {
				editenable: false			
			};
		},		
		methods: {
			toggleEdit: function(){
				this.editenable = !this.editenable
			}	
		},
		components: {
			deleteItem: DeleteItem,
			editItem: EditItem,
			appEditForm: EditForm
		}

	}

</script>

<style>

</style>
