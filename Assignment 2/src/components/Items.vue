<template>
	<div v-if="items.length">
		<div class="component" v-for="(item, index) in items" :key="item.id">
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
					<button @click="toggleEdit(index)">Edit</button>
					<div v-if="item.editenable">
						<form @submit.prevent="resetEdit()">
							<font color="red">Only completed textboxes will be updated</font>
							<p>New Name of Link: <input type="text" v-model="editLinkname"></p>
							<p>New Link Path: <input type="text" v-model="editLinkpath"></p>
							<p>New Icon Path: <input type="text" v-model="editIconpath"></p>
							<p>New Date Created: <input type="text" v-model="editDatecreated"></p>
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
	import DeleteItem from "./Delete.vue";
	import EditItem from "./Edit.vue";

	export default {
		props: ['id', 'linkname', 'linkpath', 'iconpath', 'datecreated', 'editenable'],
		data: function (){
			return {
				items: [{
					id: 1,
					linkname: 'Google', 
					linkpath: 'https://google.com/',
					iconpath: 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
					datecreated: '11/12/2020',
					editenable: false
				}],
				editLinkname: "",
				editLinkpath: "",
				editIconpath: "",
				editDatecreated: ""				
			};
		},		
		methods: {
			toggleEdit: function(index){
				this.items[index].editenable = !this.items[index].editenable
			},
			resetEdit: function(){
				this.editLinkname = ''
				this.editLinkpath = ''
				this.editIconpath = ''
				this.editDatecreated = ''				
			}		
		},
		created() {
			eventBus.$on('itemWasCreated', (item) => {
				this.items.push(item)
			}),
			eventBus.$on('itemWasUpdated', (items) => {
				this.items = items
			})		
		}, 
		components: {
			deleteItem: DeleteItem,
			editItem: EditItem
		}

	}

</script>

<style>

</style>
