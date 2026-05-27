// Teaching note: JavaScript example for 7.2 Basic Router Example.
// This file is used to configure Vue Router.
// File path: src/routers/router.js

// Import createRouter and createWebHashHistory from vue-router.
// createRouter is used to create a router object.
// createWebHashHistory is used to create hash mode routing, such as http://localhost:5173/#/list
import { createRouter, createWebHashHistory } from 'vue-router'

// Import page components.
// These components will be displayed when the route path matches.

// Home page component
import Home from '../components/Home.vue'

// List page component
import List from '../components/List.vue'

// Add page component
import Add from '../components/Add.vue'

// Update page component
import Update from '../components/Update.vue'

// Create the router object.
// A router object manages the relationship between URL paths and Vue components.
const router = createRouter({

    // Define the routing history mode.
    // createWebHashHistory() means the URL will use hash mode.
    // Example: http://localhost:5173/#/list
    history: createWebHashHistory(),

    // Define all route rules.
    // Each route rule usually contains a path and the component to display.
    routes: [
        {
            // When the user visits "/", the Home component will be displayed.
            path: '/home',

            // components is used for named views.
            // It means different <router-view> areas can display different components.
            component: Home
        },
        {
            // When the user visits "/list", the List component will be displayed.
            path: '/list',

            // listView means the component will be displayed in <router-view name="listView"></router-view>
            component: List
        },
        {
            // When the user visits "/add", the Add component will be displayed.
            path: '/add',

            // addView means the component will be displayed in <router-view name="addView"></router-view>
            component: Add
        },
        {
            // When the user visits "/update", the Update component will be displayed.
            path: '/update',

            // updateView means the component will be displayed in <router-view name="updateView"></router-view>
            component: Update
        },
        {
                    // When the user visits "/update", the Update component will be displayed.
                    path: '/showAll',
        
                    // updateView means the component will be displayed in <router-view name="updateView"></router-view>
                    redirect: '/list'
        
                    
                }
    ]
})

// Export the router object.
// After exporting, it can be imported and used in main.js.
export default router