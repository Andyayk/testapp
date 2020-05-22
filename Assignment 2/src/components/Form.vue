<template>
	<div>
		<form @submit.prevent="increaseCount()">
			<p>Name of Link: <input type="text" v-model="linkname"></p>
			<p>Link Path: <input type="text" v-model="linkpath"></p>
			<p>Icon Path: <input type="text" v-model="iconpath"></p>
			<p>Date Created: <input type="text" v-model="datecreated"></p>
			<add-item 
				:id = "id"
				:linkname="linkname"
				:linkpath="linkpath"
				:iconpath="iconpath"
				:datecreated="datecreated"
				:editenable="editenable"
			></add-item>
		</form>
		<br><br>

		<div class="component" v-for="(item, index) in items" :key="item.id">
			<div>
				<div>
					Item {{ item.id }}:
					{{ item.linkname }}
					<img :src="item.iconpath" height="50" width="100" alt="item.linkname">
				</div>
				<div align="right">
					<delete-item
						:index="index"
					></delete-item>			
					<button @click="toggleEdit(index)">Edit</button>
					<div v-if="item.editenable">
						<form @submit.prevent="resetEdit()">
							<font color="red">Only completed textboxes will be updated</font>
							<p>New Name of Link: <input type="text" v-model="editLinkname"></p>
							<p>New Link Path: <input type="text" v-model="editLinkpath"></p>
							<p>New Icon Path: <input type="text" v-model="editIconpath"></p>
							<p>New Date Created: <input type="text" v-model="editDatecreated"></p>
							<edit-item
								:editLinkname="editLinkname"
								:editLinkpath="editLinkpath"
								:editIconpath="editIconpath"
								:editDatecreated="editDatecreated"
								:index="index"
							></edit-item>
						</form>
					</div>
				</div>
				<a :href="item.linkpath" target="_blank"> {{ item.linkpath }} </a>
				<br>
				Date Created: {{ item.datecreated }}
			</div>
		</div>						
	</div>
</template>

<script>
	import { eventBus } from '../main';
	import AddItem from "./Add.vue";
	import DeleteItem from "./Delete.vue";
	import EditItem from "./Edit.vue";

	export default {
		data: function() {
			return {
				id: 2,
				linkname: '', 
				linkpath: '',
				iconpath: '',
				datecreated: '',
				editenable: '',
				items: eventBus.items,
				editLinkname: "",
				editLinkpath: "",
				editIconpath: "",
				editDatecreated: ""					
			};
		},
		methods: {
			increaseCount: function(){
				this.id = ++this.id
				this.linkname = ''
				this.linkpath = ''
				this.iconpath = ''
				this.datecreated = ''				
			},
			toggleEdit: function(index){
				eventBus.items[index].editenable = !eventBus.items[index].editenable
			},
			resetEdit: function(){
				this.editLinkname = ''
				this.editLinkpath = ''
				this.editIconpath = ''
				this.editDatecreated = ''				
			}		
		},
		components: {
			addItem: AddItem,
			deleteItem: DeleteItem,
			editItem: EditItem
		}
	}
</script>

<style>

</style>
