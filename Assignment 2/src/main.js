import Vue from 'vue'
import App from './App.vue'
import Form from './components/Form.vue'

export const eventBus = new Vue({
	data: {
		items:[
		{
			id: 1,
			linkname: 'Google', 
			linkpath: 'https://google.com/',
			iconpath: 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
			datecreated: '11/12/2020',
			editenable: false}
		]	
	}
});

new Vue({
	el: '#app',
	render: h => h(App)
})
