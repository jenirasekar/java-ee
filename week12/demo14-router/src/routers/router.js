import { createRouter, createWebHashHistory } from 'vue-router'

// Import page components.
import Home from '../components/Home.vue'
import Login from '../components/Login.vue'

// Create router object.
const router = createRouter({
    // Use hash mode.
    // Example: http://localhost:5173/#/home
    history: createWebHashHistory(),

    // Define route rules.
    routes: [
        {
            // Home page
            path: "/home",
            component: Home
        },
        {
            // Default page
            // When the user visits http://localhost:5173/#/
            // the Home component will be displayed.
            path: "/",
            component: Home
        },
        {
            // Login page
            path: "/login",
            component: Login
        }
    ]
})

// Register a global route guard.
// It will be executed before every page navigation.
router.beforeEach((to, from, next) => {

    // If the target page is /login, allow access directly.
    if (to.path == '/login') {
        next()
    } else {

        // Get username from sessionStorage.
        // If username exists, it means the user has logged in.
        const username = sessionStorage.getItem("username")

        if (username != null) {
            // User has logged in, allow access.
            next()
        } else {
            // User has not logged in, redirect to login page.
            next("/login")
        }
    }
})

// Export router object.
export default router