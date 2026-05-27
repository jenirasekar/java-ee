import { createApp } from 'vue'
import './assets/style.css'
import App from './App.vue'
import router from './router.js'
import pinia from './pinia.js'

const app = createApp(App)
app.use(router)
app.use(pinia)
app.mount('#app')