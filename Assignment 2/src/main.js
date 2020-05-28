import Vue from 'vue'
import App from './App.vue'

export const eventBus = new Vue({
	methods: {
		processURLpath: function(urlPath){
			var newPath = window.decodeURIComponent(urlPath);					
			if(urlPath != ''){
			    newPath = newPath.trim().replace(/\s+/g, ''); //remove whitespaces before/after/in-between

			    if(/^(:\/\/)/.test(newPath)){ //if start with ://
			        newPath = `http${newPath}`;
			    }

			    if(!/^https?:\/\//i.test(newPath)){ //if does not start with http:// or https:// 
			        newPath = `http://${newPath}`;
				}
			}
    			return newPath 				
		}
	}
});

new Vue({
	el: '#app',
	render: h => h(App)
})
