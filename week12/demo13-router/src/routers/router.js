// Teaching note: JavaScript example for 7.2 Basic Router Example.
// This file is used to configure Vue Router.
// File path: src/routers/router.js

import { createRouter, createWebHashHistory } from 'vue-router'

import Home from '../components/Home.vue'
import List from '../components/List.vue'
import Add from '../components/Add.vue'
import Update from '../components/Update.vue'
import ShowDetail from '../components/ShowDetail.vue'
// import ShowDetail2 from '../components/ShowDetail2.vue'

const router = createRouter({
    history: createWebHashHistory(),

    routes: [
        {
            // When the user visits /home, display Home.vue
            path: '/home',
            component: Home
        },
        {
            // When the user visits /list, display List.vue
            path: '/list',
            component: List
        },
        {
            // When the user visits /add, display Add.vue
            path: '/add',
            component: Add
        },
        {
            // When the user visits /update, display Update.vue
            path: '/update',
            component: Update
        },
        {
            // When the user visits /showAll, redirect to /list
            path: '/showAll',
            redirect: '/list'
        },
        {
            // Dynamic route.
            // Example: /showDetail/1001/JavaScript
            path: '/showDetail/:id/:language',
            name: 'showDetail',
            component: ShowDetail
        },
        // {
        //     // Query route.
        //     // Example: /showDetail2?id=1001&language=JavaScript
        //     path: '/showDetail2',
        //     component: ShowDetail2
        // }
    ]
})

// Teaching note: JavaScript example for 7.6 Route Guards.
// Register a global route guard before page navigation.
// router.beforeEach((to, from, next) => {
//     console.log(to.path, from.path)

// // Use conditional logic to decide the next step.
//     if(to.path == '/home'){
//         next()
//     }else{
//         next('/home')
//     }
// })

export default router