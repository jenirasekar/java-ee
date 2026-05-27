## 

Before learning Vue Router, we first review the main content learned last week. Last week, we mainly studied the basic development workflow of Vite and Vue 3, including how to create a Vue 3 project with Vite, how to understand the project structure, and how to write basic Vue components.

In the previous lesson, we learned that Vite is a modern front-end build tool. It can quickly create and run Vue projects, providing a fast development server and convenient project configuration. Through Vite, we can start a Vue 3 project more easily and focus on component development.

We also learned several important features of Vue 3. For example, we used the `<script setup>` syntax to write component logic more simply. We practiced data binding, event handling, list rendering, conditional rendering, and form input binding. In addition, we learned how to define reactive data, how to write methods, and how to split a page into different components.

These basic Vue 3 features help us build interactive single-page applications. However, when an application becomes more complex, it usually contains multiple pages, such as a home page, a login page, a product page, and a user center page. At this time, we need a mechanism to switch between different pages without refreshing the whole browser page.

This week, we will learn Vue Router. Vue Router is the official routing library for Vue. It allows us to build multi-page navigation in a single-page application. We will learn how to configure routes, how to create page components, how to switch pages using links, and how to display matched components using `<router-view>`.

After learning the basic router mechanism, we will complete a practical task. In this practice, we will build a simple Vue 3 application with multiple pages, such as Home, About, Product List, and Product Detail pages. Through this practice, students will understand how Vue Router connects different components and how it improves the structure of a front-end project.

### 7.1 Introduction to Routing

---

## 7. Vue 3 Router Mechanism

### 7.1 Introduction to Routing

Routing means displaying different content or pages according to different URL addresses.

In a Single Page Application, routing can switch between views without refreshing the whole page. It can also help with authentication, permission control, and browser navigation.

### 7.2 Basic Router Example

Install Vue Router:

```shell
# Teaching note: Commands for 7.2 Basic Router Example.
# Install Vue Router for page navigation.
npm install vue-router@4 --save
```

Create several components: `Home.vue`, `List.vue`, `Add.vue`, and `Update.vue`.

```vue
<!-- Teaching note: Vue component example for 7.2 Basic Router Example. -->
<!-- Home.vue -->
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div><h1>Home Page</h1></div>
</template>
```

Configure routes:

```javascript
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
            path: '/',

            // components is used for named views.
            // It means different <router-view> areas can display different components.
            components: {
                // default means the component will be displayed in <router-view></router-view>
                default: Home,

                // homeView means the component will be displayed in <router-view name="homeView"></router-view>
                homeView: Home
            }
        },
        {
            // When the user visits "/list", the List component will be displayed.
            path: '/list',

            // listView means the component will be displayed in <router-view name="listView"></router-view>
            components: {
                listView: List
            }
        },
        {
            // When the user visits "/add", the Add component will be displayed.
            path: '/add',

            // addView means the component will be displayed in <router-view name="addView"></router-view>
            components: {
                addView: Add
            }
        },
        {
            // When the user visits "/update", the Update component will be displayed.
            path: '/update',

            // updateView means the component will be displayed in <router-view name="updateView"></router-view>
            components: {
                updateView: Update
            }
        }
    ]
})

// Export the router object.
// After exporting, it can be imported and used in main.js.
export default router
```

Use the router in `main.js`:

```javascript
// Teaching note: JavaScript example for 7.2 Basic Router Example.
// Import required modules or components.
import { createApp } from 'vue'
// Import required modules or components.
import App from './App.vue'
// Import required modules or components.
import router from './routers/router.js'

// Create a Vue application instance.
let app = createApp(App)
// Register a plugin in the Vue application.
app.use(router)
// Mount the Vue application to the page element.
app.mount('#app')
```

Use links and views in `App.vue`:

```vue
<!-- Teaching note: Vue component example for 7.2 Basic Router Example. -->
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <router-link to="/">Home</router-link> <br>
    <router-link to="/list">List</router-link> <br>
    <router-link to="/add">Add</router-link> <br>
    <router-link to="/update">Update</router-link> <br>

    Default view: <router-view></router-view>
    Home view: <router-view name="homeView"></router-view>
    List view: <router-view name="listView"></router-view>
    Add view: <router-view name="addView"></router-view>
    Update view: <router-view name="updateView"></router-view>
  </div>
</template>
```

### 7.3 Route Redirection

```javascript
// Teaching note: JavaScript example for 7.3 Route Redirection.
{
    path:'/showAll',
    redirect:'/list'
}
```

### 7.4 Programmatic Routing with `useRouter`

`useRouter()` returns a router object. We can use it to navigate dynamically.

```vue
<script setup>
// Teaching note: Script section for 7.4 Programmatic Routing with useRouter.

import { useRouter } from 'vue-router'
import { ref } from 'vue'

// Define a variable to store the input path.
// For example: /home, /list, /add, /update
const myPath = ref('')

// Get the router object.
const router = useRouter()

// Define a function for programmatic routing.
const goMyPage = () => {
  // If the input is empty, do not jump.
  if (myPath.value === '') {
    alert('Please enter a path, such as /list')
    return
  }

  // Jump to the path entered by the user.
  router.push({ path: myPath.value })
}
</script>

<template>
  <div>
    <h2>Vue Router Example</h2>

    <router-link to="/home">Home</router-link> |
    <router-link to="/list">List</router-link> |
    <router-link to="/add">Add</router-link> |
    <router-link to="/update">Update</router-link> |
    <router-link to="/showAll">showAll</router-link> |

    <br><br>

    <!-- The user can enter a route path here, such as /list -->
    <input type="text" v-model="myPath" placeholder="Enter path, such as /list">

    <!-- Click the button to jump to the input path -->
    <button @click="goMyPage">Go</button>

    <hr>

    <!-- The matched component will be displayed here -->
    <router-view></router-view>
  </div>
</template>
```

### 7.5 Route Parameters with `useRoute`

There are two common ways to pass parameters:

1. Path parameters: `/showDetail/1/JAVA`
2. Query parameters: `/showDetail2?id=1&language=JAVA`

Route configuration:

```javascript
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

export default router
```

Use `useRouter` to pass parameters:

```javascript
// Teaching note: JavaScript example for 7.5 Route Parameters with useRoute.
// Define a variable or arrow function.
let showDetail = (id, language) => {
  router.push({name:'showDetail', params:{id:id, language:language}})
}

// Define a variable or arrow function.
let showDetail2 = (id, language) => {
  router.push({path:'/showDetail2', query:{id:id, language:language}})
}
```

Use `useRoute` to read parameters:

```vue
ShowDetail.vue
<script setup type="module">
// Teaching note: Script section for 7.5 Route Parameters with useRoute.
import {useRoute} from 'vue-router'
let route = useRoute()
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1>ShowDetail Page</h1>
    <h3>No. {{ route.params.id }}: {{ route.params.language }} is a great language.</h3>
  </div>
</template>
```

### 7.6 Route Guards

Route guards are functions called during route switching. They can be used for login checks, permission control, data loading, and logging.

Global before guard:

```javascript
// Teaching note: JavaScript example for 7.6 Route Guards.
// Register a global route guard before page navigation.

// beforeEach is a global route guard.
// It will be executed before every route navigation.
router.beforeEach((to, from, next) => {

    // to means the route that the user wants to visit.
    // from means the route that the user is leaving.
    // For example: from /home to /list
    console.log(to.path, from.path)

    // Use conditional logic to decide whether the navigation is allowed.
    if (to.path == '/index') {

        // If the target path is /index, allow the navigation.
        next()

    } else {

        // If the target path is not /index,
        // redirect the user to /index.
        next('/index')
    }
})
```

Login protection example:

```javascript
// Teaching note: JavaScript example for 7.6 Route Guards.
// Register a global route guard before page navigation.
router.beforeEach((to, from, next) => {
// Use conditional logic to decide the next step.
    if(to.path == '/login'){
        next()
    }else{
// Declare a variable or constant.
        let username = window.localStorage.getItem('username')
// Use conditional logic to decide the next step.
        if(username != null){
            next()
        }else{
            next('/login')
        }
    }
})
```

---



------

## Review: How the Previous Non-Separated Project Worked

Before reconstructing the front-end project, let us first review how the previous schedule management system was developed.

In the earlier Java Web project, the front-end pages were placed directly under the `web` directory. For example, the project contained pages such as:

```text
web
 ├── login.html
 ├── loginUsernameError.html
 ├── loginUserPwdError.html
 ├── regist.html
 ├── registFail.html
 ├── registSuccess.html
 └── showSchedule.html
```

These pages were ordinary HTML files. The browser accessed these HTML pages directly, and when the user submitted a form, the request was sent to a Servlet. The Servlet received the request parameters, processed the business logic, and then returned another HTML page or generated HTML content as the response.

This development style is similar to the Servlet-based experiment we studied before: the page is written in HTML, the form submits data to a Servlet, and the Servlet uses `request.getParameter()` to obtain data and `PrintWriter` to generate the response page.

For example, in the previous project:

```html
<form action="/schedule/user/login" method="post">
    Username: <input type="text" name="username">
    Password: <input type="password" name="userPwd">
    <input type="submit" value="Login">
</form>
```

After the user clicked the login button, the request was submitted to the back-end Servlet. Then the Servlet decided which page should be returned, such as:

```text
login successful  -> showSchedule.html
username error    -> loginUsernameError.html
password error    -> loginUserPwdError.html
```

This means that the front end and back end were strongly connected. The HTML pages, request paths, error pages, and Servlet response logic were all mixed together in one Java Web project.

------

## Why Should We Optimize the Previous Project?

Although the previous project can run successfully, it has several obvious problems.

First, the page interaction is not flexible enough. Each operation usually needs to submit a form and refresh the whole page. For example, after login failure, the browser jumps to another error page. This works, but the user experience is not good enough.

Second, there are too many repeated HTML pages. For example, `login.html`, `loginUsernameError.html`, and `loginUserPwdError.html` may have very similar page structures. Only the error message is different, but we still need to write several separate HTML files.

Third, the front-end code and back-end code are coupled together. The HTML page depends on the Servlet path, and the Servlet also needs to decide which page to return. If the page structure changes, the back-end code may also need to be modified.

Fourth, the project is not easy to maintain when it becomes larger. In the schedule management system, we have login, registration, schedule display, schedule adding, schedule deleting, and schedule updating. If all pages are still managed by traditional HTML and Servlet forwarding, the project structure will become more and more complex.

Therefore, we need to optimize the project by using a front-end engineering approach. In this stage, we reconstruct the front-end part using Vue 3 and Vue Router. The front end will be responsible for page display and page switching, while the back end will mainly provide data interfaces.

After optimization, the project will have a clearer structure:

```text
Front-end Vue project
 ├── Login.vue
 ├── Regist.vue
 ├── ShowSchedule.vue
 ├── Header.vue
 └── router configuration

Back-end Java Web project
 ├── UserController / UserServlet
 ├── ScheduleController / ScheduleServlet
 ├── Service
 ├── DAO
 └── Database
```

In this way, the front end focuses on page design and user interaction, while the back end focuses on data processing and business logic. This is the main idea of front-end and back-end separation.

------

## 8. Case Development: Schedule Management, Stage 5

### 8.1 Reconstructing the Front-End Project

Business pages:

- Login page
- Registration page
- Schedule management page

Create the project and install dependencies:

```shell
# Teaching note: Commands for 8.1 Reconstructing the Front-End Project.
# Create a new Vite project.
npm create vite

# Enter the project directory.
cd project-directory

# Install all dependencies listed in package.json.
npm install

# Install Vue Router for page navigation.
npm install vue-router
```

Common views:

- `Header.vue`
- `Login.vue`
- `Regist.vue`
- `ShowSchedule.vue`
- `App.vue`
- `router.js`
- main.js

This component is the header of the schedule management system. It displays different buttons according to the login status. If the user has not logged in, the page shows Login and Register buttons. If the user has logged in, the page shows the username, a Logout button, and a My Schedule button. In this pure front-end version, the login status is saved in `sessionStorage`, so the page can still show the username after refreshing.

```vue
Header.vue
<script setup>
/*
  Import Pinia stores.

  defineUser is used to store the current logged-in user.
  defindSchedule is used to store the schedule list.
*/
import { defineUser } from '../store/userStore.js'
import { defindSchedule } from '../store/scheduleStore.js'

import { useRouter } from 'vue-router'
import { onMounted } from 'vue'

// Get Pinia store objects
let sysUser = defineUser()
let schedule = defindSchedule()

// Get the router object for page navigation
let router = useRouter()

/*
  When the component is mounted, try to restore the login status.

  In a pure front-end project, Pinia data may be lost after refreshing the page.
  So we read the username from sessionStorage and put it back into Pinia.
*/
onMounted(() => {
  let loginUser = sessionStorage.getItem('loginUser')

  if (loginUser) {
    sysUser.username = loginUser
    sysUser.uid = 1
  }
})

/*
  Logout function.

  In the pure front-end version, logout means:
  1. Clear user information in Pinia.
  2. Clear schedule information in Pinia.
  3. Remove login status from sessionStorage.
  4. Jump back to the login page.
*/
function logout() {
  // Clear all Pinia user data
  sysUser.$reset()

  // Clear all Pinia schedule data
  schedule.$reset()

  // Clear login status saved in sessionStorage
  sessionStorage.removeItem('loginUser')

  // Jump to the login page
  router.push('/login')
}
</script>

<template>
  <div>
    <h1 class="ht">Welcome to Schedule Management System</h1>

    <div>
      <!--
        If the username is empty, it means the user has not logged in.
        Show Login and Register buttons.
      -->
      <div class="optionDiv" v-if="sysUser.username === ''">
        <router-link to="/login">
          <button class="b1s" type="button">Login</button>
        </router-link>

        <router-link to="/regist">
          <button class="b1s" type="button">Register</button>
        </router-link>
      </div>

      <!--
        If the username is not empty, it means the user has logged in.
        Show welcome message, logout button, and schedule button.
      -->
      <div class="optionDiv" v-else>
        Welcome {{ sysUser.username }}

        <button class="b1b" type="button" @click="logout()">
          Logout
        </button>

        <router-link to="/showSchedule">
          <button class="b1b" type="button">
            My Schedule
          </button>
        </router-link>
      </div>

      <br />
    </div>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Small button style */
.b1s {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 80px;
  background-color: antiquewhite;
}

/* Big button style */
.b1b {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 120px;
  background-color: antiquewhite;
}

/* Option area style */
.optionDiv {
  width: 450px;
  float: right;
}
</style>
```



This page is a pure front-end registration page. It does not connect to a database or send requests to the back end. It only checks the username format, password format, and whether the two passwords are the same. If all inputs are valid, the data is temporarily saved in `localStorage`, and the page jumps to the login page. Later, when the back-end API is ready, we can replace the `localStorage` part with an Axios request.

```vue
`Regist.vue`
<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'

// Get the router object for page navigation
const router = useRouter()

// Create a reactive object to store registration form data
let registUser = reactive({
  username: '',
  userPwd: ''
})

// Message variables used to show validation results
let usernameMsg = ref('')
let userPwdMsg = ref('')
let reUserPwdMsg = ref('')

// Store the repeated password
let reUserPwd = ref('')

// Check whether the username is valid
function checkUsername() {
  // Username rule:
  // 5 to 10 characters, only letters and numbers are allowed
  let usernameReg = /^[a-zA-Z0-9]{5,10}$/

  if (!usernameReg.test(registUser.username)) {
    usernameMsg.value = 'Invalid format'
    return false
  }

  // In this pure front-end version, there is no database.
  // So we do not check whether the username already exists.
  usernameMsg.value = 'Available'
  return true
}

// Check whether the password is valid
function checkUserPwd() {
  // Password rule:
  // Exactly 6 digits
  let userPwdReg = /^[0-9]{6}$/

  if (!userPwdReg.test(registUser.userPwd)) {
    userPwdMsg.value = 'Invalid format'
    return false
  }

  userPwdMsg.value = 'OK'
  return true
}

// Check whether the repeated password is valid
function checkReUserPwd() {
  let userPwdReg = /^[0-9]{6}$/

  if (!userPwdReg.test(reUserPwd.value)) {
    reUserPwdMsg.value = 'Invalid format'
    return false
  }

  // Check whether the two passwords are the same
  if (registUser.userPwd !== reUserPwd.value) {
    reUserPwdMsg.value = 'Passwords do not match'
    return false
  }

  reUserPwdMsg.value = 'OK'
  return true
}

// Registration function
function regist() {
  // Validate all form fields before registration
  let flag1 = checkUsername()
  let flag2 = checkUserPwd()
  let flag3 = checkReUserPwd()

  if (flag1 && flag2 && flag3) {
    // Pure front-end demonstration:
    // Save the username and password temporarily in localStorage.
    // This is only for classroom demonstration.
    localStorage.setItem('username', registUser.username)
    localStorage.setItem('userPwd', registUser.userPwd)

    alert('Registration successful. Please log in.')

    // Jump to the login page
    router.push('/login')
  } else {
    alert('Validation failed. Please check your input again.')
  }
}

// Clear all form data and messages
function clearForm() {
  registUser.username = ''
  registUser.userPwd = ''
  reUserPwd.value = ''

  usernameMsg.value = ''
  userPwdMsg.value = ''
  reUserPwdMsg.value = ''
}
</script>

<template>
  <div>
    <h3 class="ht">Register</h3>

    <table class="tab" cellspacing="0px">
      <tr class="ltr">
        <td>Please enter username</td>
        <td>
          <input
            class="ipt"
            id="usernameInput"
            type="text"
            name="username"
            v-model="registUser.username"
            @blur="checkUsername()"
          />

          <span id="usernameMsg" class="msg" v-text="usernameMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td>Please enter password</td>
        <td>
          <input
            class="ipt"
            id="userPwdInput"
            type="password"
            name="userPwd"
            v-model="registUser.userPwd"
            @blur="checkUserPwd()"
          />

          <span id="userPwdMsg" class="msg" v-text="userPwdMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td>Confirm password</td>
        <td>
          <input
            class="ipt"
            id="reUserPwdInput"
            type="password"
            v-model="reUserPwd"
            @blur="checkReUserPwd()"
          />

          <span id="reUserPwdMsg" class="msg" v-text="reUserPwdMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td colspan="2" class="buttonContainer">
          <input class="btn1" type="button" @click="regist()" value="Register" />
          <input class="btn1" type="button" @click="clearForm()" value="Reset" />

          <router-link to="/login">
            <button class="btn1" type="button">Login</button>
          </router-link>
        </td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Table container style */
.tab {
  width: 500px;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: Arial, sans-serif;
}

/* Table cell border style */
.ltr td {
  border: 1px solid powderblue;
}

/* Input box style */
.ipt {
  border: 0px;
  width: 50%;
}

/* Button style */
.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 80px;
  background-color: antiquewhite;
}

/* Validation message style */
.msg {
  color: goldenrod;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>
```



This page is a pure front-end login page. It does not send a request to the back end and does not connect to a database. The page first checks the username and password formats. Then it reads the registered user information from `localStorage` and compares it with the input values. If the username and password are correct, the login information is saved in Pinia and `sessionStorage`, and the page jumps to the schedule management page. Later, when the back-end API is ready, we can replace the `localStorage` comparison with an Axios request.

```vue
Login.vue
<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'

// Import the Pinia user store
// It is used to save the current logged-in user information on the front end
import { defineUser } from '../store/userStore.js'

// Get the router object for page navigation
const router = useRouter()

// Get the user store object
let sysUser = defineUser()

// Create a reactive object to store login form data
let loginUser = reactive({
  username: '',
  userPwd: ''
})

// Message variables used to show validation results
let usernameMsg = ref('')
let userPwdMsg = ref('')

// Check whether the username is valid
function checkUsername() {
  // Username rule:
  // 5 to 10 characters, only letters and numbers are allowed
  let usernameReg = /^[a-zA-Z0-9]{5,10}$/

  if (!usernameReg.test(loginUser.username)) {
    usernameMsg.value = 'Invalid format'
    return false
  }

  usernameMsg.value = 'OK'
  return true
}

// Check whether the password is valid
function checkUserPwd() {
  // Password rule:
  // Exactly 6 digits
  let userPwdReg = /^[0-9]{6}$/

  if (!userPwdReg.test(loginUser.userPwd)) {
    userPwdMsg.value = 'Invalid format'
    return false
  }

  userPwdMsg.value = 'OK'
  return true
}

// Login function
function login() {
  // Validate all form fields before login
  let flag1 = checkUsername()
  let flag2 = checkUserPwd()

  if (!(flag1 && flag2)) {
    alert('Validation failed. Please check your input again.')
    return
  }

  // Pure front-end demonstration:
  // Read the registered username and password from localStorage.
  // These values are saved by the registration page.
  let savedUsername = localStorage.getItem('username')
  let savedUserPwd = localStorage.getItem('userPwd')

  // If there is no user information in localStorage,
  // it means the user has not registered yet.
  if (!savedUsername || !savedUserPwd) {
    alert('No registered user found. Please register first.')
    return
  }

  // Check whether the username is correct
  if (loginUser.username !== savedUsername) {
    alert('Username is incorrect.')
    return
  }

  // Check whether the password is correct
  if (loginUser.userPwd !== savedUserPwd) {
    alert('Password is incorrect.')
    return
  }

  // Login successful
  alert('Login successful.')

  // Save the logged-in user information into Pinia
  // In this pure front-end version, uid is only a simulated value.
  sysUser.uid = 1
  sysUser.username = loginUser.username

  // Save login status in sessionStorage
  // This can be used to check whether the user has logged in.
  sessionStorage.setItem('loginUser', loginUser.username)

  // Jump to the schedule management page
  router.push('/showSchedule')
}

// Clear all form data and messages
function clearForm() {
  loginUser.username = ''
  loginUser.userPwd = ''

  usernameMsg.value = ''
  userPwdMsg.value = ''
}
</script>

<template>
  <div>
    <h3 class="ht">Login</h3>

    <table class="tab" cellspacing="0px">
      <tr class="ltr">
        <td>Please enter username</td>
        <td>
          <input
            class="ipt"
            type="text"
            v-model="loginUser.username"
            @blur="checkUsername()"
          />

          <span id="usernameMsg" v-text="usernameMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td>Please enter password</td>
        <td>
          <input
            class="ipt"
            type="password"
            v-model="loginUser.userPwd"
            @blur="checkUserPwd()"
          />

          <span id="userPwdMsg" v-text="userPwdMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td colspan="2" class="buttonContainer">
          <input class="btn1" type="button" @click="login()" value="Login" />
          <input class="btn1" type="button" @click="clearForm()" value="Reset" />

          <router-link to="/regist">
            <button class="btn1" type="button">Register</button>
          </router-link>
        </td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Table container style */
.tab {
  width: 500px;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: Arial, sans-serif;
}

/* Table cell border style */
.ltr td {
  border: 1px solid powderblue;
}

/* Input box style */
.ipt {
  border: 0px;
  width: 50%;
}

/* Button style */
.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 80px;
  background-color: antiquewhite;
}

/* Validation message style */
#usernameMsg,
#userPwdMsg {
  color: goldenrod;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>
```



This page is a pure front-end schedule management page. It does not send requests to the back end and does not connect to a database. When the page is loaded, it reads schedule data from `localStorage`. Users can add, modify, and delete schedules. After each operation, the updated schedule list is saved back to `localStorage`. Later, when the back-end API and database are ready, we can replace the `localStorage` operations with Axios requests.

```vue
`ShowSchedule.vue`
<script setup>
/*
  Import Pinia stores.
  defineUser is used to get the current logged-in user.
  defindSchedule is used to store the schedule list.
*/
import { defineUser } from '../store/userStore.js'
import { defindSchedule } from '../store/scheduleStore.js'

import { onMounted } from 'vue'

// Get Pinia store objects
let sysUser = defineUser()
let schedule = defindSchedule()

/*
  Get the current username.

  In the previous Login page, we saved the login status into sessionStorage.
  If the page is refreshed, Pinia data may be lost,
  so we can also read the username from sessionStorage.
*/
function getCurrentUsername() {
  return sysUser.username || sessionStorage.getItem('loginUser') || 'guest'
}

/*
  Generate a localStorage key for the current user.

  Different users should have different schedule lists.
  For example:
  scheduleList_tom
  scheduleList_jack
*/
function getStorageKey() {
  return 'scheduleList_' + getCurrentUsername()
}

/*
  Load schedule data from localStorage.

  This function is called when the component is mounted.
*/
function loadSchedule() {
  let storageKey = getStorageKey()
  let savedList = localStorage.getItem(storageKey)

  if (savedList) {
    // If there is saved schedule data, convert JSON string to array
    schedule.itemList = JSON.parse(savedList)
  } else {
    // If there is no saved data, create some default schedule items
    schedule.itemList = [
      {
        sid: 1,
        title: 'Learn Vue Router',
        completed: '0'
      },
      {
        sid: 2,
        title: 'Practice schedule management',
        completed: '1'
      }
    ]

    // Save the default data into localStorage
    saveSchedule()
  }
}

/*
  Save schedule data to localStorage.

  localStorage can only store strings,
  so we need to convert the schedule list to a JSON string.
*/
function saveSchedule() {
  let storageKey = getStorageKey()
  localStorage.setItem(storageKey, JSON.stringify(schedule.itemList))
}

/*
  When the component is mounted,
  load all schedules of the current user.
*/
onMounted(() => {
  loadSchedule()
})

/*
  Add a new empty schedule item.

  In the original back-end version, this operation should send a request
  to the server and insert a new record into the database.

  In this pure front-end version, we only add the new item to Pinia
  and then save it to localStorage.
*/
function addItem() {
  let newItem = {
    sid: Date.now(),
    title: '',
    completed: '0'
  }

  schedule.itemList.push(newItem)
  saveSchedule()

  alert('Schedule added successfully.')
}

/*
  Save the modified schedule item.

  In the pure front-end version, the data has already been changed
  by v-model. So we only need to save the whole list to localStorage.
*/
function updateItem(index) {
  let item = schedule.itemList[index]

  if (!item.title.trim()) {
    alert('Schedule content cannot be empty.')
    return
  }

  saveSchedule()
  alert('Schedule updated successfully.')
}

/*
  Remove a schedule item.

  In the original back-end version, this operation should send sid
  to the server and delete the record from the database.

  In this pure front-end version, we delete it from the array directly.
*/
function removeItem(index) {
  let result = confirm('Are you sure you want to delete this schedule?')

  if (!result) {
    return
  }

  schedule.itemList.splice(index, 1)
  saveSchedule()

  alert('Schedule deleted successfully.')
}
</script>

<template>
  <div>
    <h3 class="ht">Your Schedule List</h3>

    <table class="tab" cellspacing="0px">
      <tr class="ltr">
        <th>No.</th>
        <th>Content</th>
        <th>Status</th>
        <th>Operation</th>
      </tr>

      <tr
        class="ltr"
        v-for="(item, index) in schedule.itemList"
        :key="item.sid"
      >
        <td v-text="index + 1"></td>

        <td>
          <input
            class="ipt"
            type="text"
            v-model="item.title"
            placeholder="Please enter schedule content"
          />
        </td>

        <td>
          <input
            type="radio"
            value="1"
            v-model="item.completed"
          />
          Completed

          <input
            type="radio"
            value="0"
            v-model="item.completed"
          />
          Not completed
        </td>

        <td class="buttonContainer">
          <button class="btn1" @click="removeItem(index)">
            Delete
          </button>

          <button class="btn1" @click="updateItem(index)">
            Save
          </button>
        </td>
      </tr>

      <tr class="ltr buttonContainer">
        <td colspan="4">
          <button class="btn1" @click="addItem()">
            Add Schedule
          </button>
        </td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Table container style */
.tab {
  width: 80%;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: Arial, sans-serif;
}

/* Table cell style */
.ltr td {
  border: 1px solid powderblue;
}

/* Input box style */
.ipt {
  border: 0px;
  width: 80%;
}

/* Button style */
.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 120px;
  background-color: antiquewhite;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>


```

```vue
APP.vue
<script setup>
  import Header from './components/Header.vue'
</script>

<template>
  <div>
    <Header></Header>
    <hr>
    <router-view></router-view>
  </div>
 
</template>

<style scoped>
</style>

```



This file configures page routing for the front-end project. We use Vue Router to map different paths to different components, such as `/login`, `/regist`, and `/showSchedule`. The global navigation guard is used to protect the schedule management page. If the user has not logged in, the router will redirect the user to the login page. In this pure front-end version, the login status is stored in `sessionStorage`, so the user can still access the schedule page after refreshing the browser.

```js
router.js
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
    let loginUser = sessionStorage.getItem('loginUser')

    if (sysUser.username !== '' || loginUser) {
      // If the username exists in sessionStorage but Pinia is empty,
      // restore the username to Pinia.
      if (sysUser.username === '' && loginUser) {
        sysUser.username = loginUser
        sysUser.uid = 1
      }

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
```

