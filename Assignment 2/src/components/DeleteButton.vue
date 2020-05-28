<template>
	<div>
		<button class="btn btn-danger" @click="onclickFunction()">Delete</button>
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
