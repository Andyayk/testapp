<template>
	<div>
		<v-btn color="#E53935" dark @click="onclickFunction()">Delete</v-btn>
	</div>
</template>

<script>
	import { eventBus } from '../main';

	export default {
		props: ['onclickFunction']
	}
</script>

<style>
</style>
