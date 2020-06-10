<template>
	<div class="card-body">
		<div class="row">
			<div class="col-sm-6">
				<div class="container">
					<h5>Item {{ item.id }}:</h5>
					{{ item.linkname }}
					<img :src="item.iconpath" height="50" width="100" alt="item.linkname">
					<br>
					<a :href="item.linkpath" target="_blank"> {{ item.linkpath }} </a>
					<br>
					Date Created: {{ item.datecreated }}					
				</div>
			</div>
			<div class="col-sm-6">
				<div class="container">
					<div class="row justify-content-end">
						<delete-button :onclickFunction="deleteItem"></delete-button>
						<br>
						<v-btn color="primary" @click="toggleEdit">Edit</v-btn>
					</div>
					<div align="right">			
						<div v-if="editenable">
							<app-edit-form
							:items="items"
							:index="index"
							:toggleEditFunction="toggleEdit"
							></app-edit-form>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import DeleteButton from './DeleteButton.vue';
	import EditForm from './EditForm.vue';	

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
			},
			deleteItem: function(){
				this.items.splice(this.index, 1)

				eventBus.$emit('itemWasUpdated', this.items);				
			}			
		},		
		components: {
			deleteButton: DeleteButton,
			appEditForm: EditForm
		}

	}

</script>

<style>

</style>