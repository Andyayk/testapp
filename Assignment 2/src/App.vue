<template>
	<div>
		<app-form></app-form>
		<app-items></app-items>
	</div>
</template>

<script>
	import Form from "./components/Form.vue";
	import Items from "./components/Items.vue";	
	
	export default {
		components: {
			appForm: Form,
			appItems: Items
		}
	}	
</script>

<style>
    div.component {
        border: 1px solid black;
        padding: 30px;
    }
</style>
