<template>
	<div>
		<div class="component" v-for="(item, index) in items" :key="item.id">
			<div>
				<div>
					Item {{ item.id }}:
					{{ item.linkname }}
					<img :src="item.iconpath" height="50" width="100" alt="item.linkname">
				</div>
			</div>
		</div>
	</div>
</template>

<script>
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
				}]	
			};
		}
	}

</script>

<style>

</style>
