var app = new Vue({
	el: '#app',
	data: {
		message: 'Hello Vue!'
	}
})

var app2 = new Vue({
	el: '#app-2',
	data: {
		message: 'You loaded this page on ' + new Date().toLocaleString()
	}
})

var app3 = new Vue({
	el: '#app-3',
	data: {
		seen: true
	}
})

var app4 = new Vue({
	el: '#app-4',
	data: {
		todos: [
		{ text: 'Learn JavaScript' },
		{ text: 'Learn Vue' },
		{ text: 'Build something awesome' }
		]
	}
})

var app5 = new Vue({
	el: '#app-5',
	data: {
		message: 'Hello Vue.js!'
	},
	methods: {
		reverseMessage: function () {
			this.message = this.message.split('').reverse().join('')
		}
	}
})

var app6 = new Vue({
	el: '#app-6',
	data: {
		message: 'Hello Vue!'
	}
})

Vue.component('todo-item', {
	// The todo-item component now accepts a
	// "prop", which is like a custom attribute.
	// This prop is called todo.
	props: ['todo'],
	template: '<li>{{ todo.text }}</li>'
})

Vue.component('greetings-item', {
	// The todo-item component now accepts a
	// "prop", which is like a custom attribute.
	// This prop is called todo.
	props: ['greetingsprop'],
	template: '<b>{{ greetingsprop }}</b>'
})

var app7 = new Vue({
	el: '#app-7',
	data: {
		groceryList: [
		{ id: 0, text: 'Vegetables' },
		{ id: 1, text: 'Cheese' },
		{ id: 2, text: 'Whatever else humans are supposed to eat' }
		],
		greetingsList: "hi"
	}
})

var vm = new Vue({
	el: '#example',
	data: {
		message: 'Hello'
	},
	computed: {
    // a computed getter
    reversedMessage: function () {
      // `this` points to the vm instance
      return this.message.split('').reverse().join('')
  }
}
})

var watchExampleVM = new Vue({
	el: '#watch-example',
	data: {
		question: '',
		answer: 'I cannot give you an answer until you ask a question!'
	},
	watch: {
    // whenever question changes, this function will run
    question: function (newQuestion, oldQuestion) {
    	this.answer = 'Waiting for you to stop typing...'
    	this.debouncedGetAnswer()
    }
},
created: function () {
    // _.debounce is a function provided by lodash to limit how
    // often a particularly expensive operation can be run.
    // In this case, we want to limit how often we access
    // yesno.wtf/api, waiting until the user has completely
    // finished typing before making the ajax request. To learn
    // more about the _.debounce function (and its cousin
    // _.throttle), visit: https://lodash.com/docs#debounce
    this.debouncedGetAnswer = _.debounce(this.getAnswer, 500)
},
methods: {
	getAnswer: function () {
		if (this.question.indexOf('?') === -1) {
			this.answer = 'Questions usually contain a question mark. ;-)'
			return
		}
		this.answer = 'Thinking...'
		var vm = this
		axios.get('https://yesno.wtf/api')
		.then(function (response) {
			vm.answer = _.capitalize(response.data.answer)
		})
		.catch(function (error) {
			vm.answer = 'Error! Could not reach the API. ' + error
		})
	}
}
})