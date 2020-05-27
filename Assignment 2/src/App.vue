<template>
	<div>
		<app-form></app-form>
		<br><br>
		<div v-if="items.length">
			<div class="component" v-for="(item, index) in items" :key="item.id">		
			<app-item
				:items="items"
				:item="item"
				:index='index'
			></app-item>
			</div>	
		</div>			
	</div>
</template>

<script>
	import { eventBus } from './main';	
	import Form from './components/Form.vue';
	import Item from './components/Item.vue';	
	
	export default {
		data: function (){
			return {
				items: [{
					id: 1,
					linkname: 'Google', 
					linkpath: 'https://google.com/',
					iconpath: 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
					datecreated: '2020-01-01'
				}]		
			};
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
			appForm: Form,
			appItem: Item
		}
	}	
</script>

<style>
    div.component {
        border: 1px solid black;
        padding: 30px;
    }
</style>
