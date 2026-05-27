import { createRouter, createWebHashHistory } from 'vue-router'

// Import page components
import Login from '../components/Login.vue'
import Regist from '../components/Regist.vue'
import ShowSchedule from '../components/ShowSchedule.vue'

// Import Pinia instance and user store
import pinia from '../pinia.js'
import { defineUser } from '../store/userStore.js'

// Get the user store object outside the component
let sysUser = defineUser(pinia)

// Create router object
const router = createRouter({
  // Use hash mode.
  // The URL will look like this: http://localhost:5173/#/login
  history: createWebHashHistory(),

  // Configure route mapping
  routes: [
    {
      // When accessing the root path, redirect to the schedule page
      path: '/',
      redirect: '/showSchedule'
    },
    {
      // Schedule management page
      path: '/showSchedule',
      component: ShowSchedule
    },
    {
      // Login page
      path: '/login',
      component: Login
    },
    {
      // Registration page
      path: '/regist',
      component: Regist
    }
  ]
})

/*
  Global navigation guard.

  It is used to control whether the user can access some pages.

  In this project:
  - Login page can be accessed directly.
  - Registration page can be accessed directly.
  - Schedule page can only be accessed after login.
*/
router.beforeEach((to, from, next) => {
  // If the user wants to visit the schedule management page
  if (to.path === '/showSchedule') {
    /*
      Check login status.

      In the pure front-end version:
      1. Pinia stores the username while the page is running.
      2. sessionStorage stores the username after login.
      3. If the page is refreshed, Pinia may be lost,
         but sessionStorage can still keep the login status.
    */
    

    if (false) {
      // If the username exists in sessionStorage but Pinia is empty,
      // restore the username to Pinia.
      

      // Allow access
      next()
    } else {
      // If the user has not logged in, redirect to the login page
      alert('Please log in first.')
      next('/login')
    }
  } else {
    // Other pages can be accessed directly
    next()
  }
})

export default router