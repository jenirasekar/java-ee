### Review of Last Week’s Lesson

Last week, we mainly learned about **npm configuration and common npm commands**.

First, we discussed **why we need npm**. In modern front-end development, a project usually depends on many third-party libraries and tools. For example, we may use `express` to build a server, `jest` to test code, and `webpack` to build the project. It would be difficult to manually download and manage all these tools. Therefore, npm helps us manage project dependencies in a standard and convenient way.

Then, we introduced the `package.json` file. This file is very important in a front-end project because it records basic project information, scripts, and dependencies.

For example:

```json
{
  "name": "my-app",
  "version": "1.0.0",
  "scripts": {
    "start": "node index.js",
    "test": "jest",
    "build": "webpack"
  },
  "dependencies": {
    "express": "^4.17.1",
    "jest": "^27.1.0",
    "webpack": "^5.39.0"
  }
}
```

In this example:

```text
"name" means the project name.
"version" means the project version.
"scripts" defines commonly used commands.
"dependencies" records the packages required by the project.
```

We also learned several common npm commands:

```bash
npm install
```

This command is used to install project dependencies.

```bash
npm run build
```

This command is used to build the project.

```bash
npm run dev
```

This command is often used to start a development server in modern front-end projects.

Through last week’s lesson, we learned that npm is not just a package installation tool. More importantly, it helps us manage modern front-end projects in a standardized way.

------

### Transition to This Week’s Lesson: Vue 3 + Vite

This week, we will continue from npm and move to a real modern front-end project.

Previously, when we learned Vue 3, we used Vue directly through a CDN:

```html
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
```

This method is very suitable for small demos. We can write HTML, JavaScript, and Vue code in one file, and quickly understand basic Vue features such as declarative rendering, reactivity, data binding, and event binding.

However, real projects are usually more complex. A real front-end project may contain many pages, many components, CSS files, images, third-party libraries, and build tools. If we still put everything in one HTML file, the code will become difficult to maintain.

Therefore, in real Vue development, we usually use **Vue 3 + Vite**.

Vite helps us create and manage Vue projects. It provides a clear project structure, supports `.vue` single-file components, starts the development server quickly, and allows us to build the final project for deployment.

So, the key question for this week is:

> How can we use npm, Vue 3, and Vite together to create a real front-end project?

This week, we will learn:

```text
1. What Vite is
2. Why Vue 3 projects usually use Vite
3. How to create a Vue 3 project with Vite
4. How to understand the project structure
5. How to run and modify a Vue 3 project
```

In short, last week we learned the basic tool: **npm**.
This week, we will use npm to create and run a real Vue 3 project with **Vite**.

## 4. Introduction to Vue 3 and Quick Experience

### 4.1 Introduction to Vue 3

Vue is a JavaScript framework for building user interfaces. It is based on standard HTML, CSS, and JavaScript. It provides a declarative and component-based programming model.

Official website: <https://vuejs.org/>

Two core features of Vue:

  ### 1. Declarative Rendering（声明式渲染）

  **Declarative rendering** means that we only need to describe **what the page should look like**, instead of manually telling the browser **how to update each DOM element**.

  Vue extends standard HTML with template syntax. We can directly write JavaScript state inside HTML templates, and Vue will render the correct HTML output based on the current state. Vue 官方文档也将其定义为：可以基于 JavaScript state，用模板语法声明式地描述 HTML 输出。([Vue.js](https://vuejs.org/guide/introduction))

  For example:

  ```html
  <div id="app">
    <h2>{{ message }}</h2>
  </div>
  
  <script>
  const { createApp } = Vue
  
  createApp({
    data() {
      return {
        message: 'Hello Vue!'
      }
    }
  }).mount('#app')
  </script>
  ```

  In this example, we do not need to write:

  ```javascript
  document.querySelector('h2').innerHTML = 'Hello Vue!'
  ```

  Instead, we only write:

  ```html
  <h2>{{ message }}</h2>
  ```

  Vue will automatically render the value of `message` into the page.

  So, declarative rendering makes the code easier to read, because the HTML clearly shows the relationship between the page content and the data.

------

  ### 2. Reactivity（响应式）

  **Reactivity** means that when the JavaScript data changes, Vue will automatically update the related content on the page.

  We do not need to manually operate the DOM. Vue tracks state changes and efficiently updates the DOM when changes happen. ([Vue.js](https://vuejs.org/guide/introduction))

  For example:

  ```html
  <div id="app">
    <p>Count is: {{ count }}</p>
    <button @click="count++">Click Me</button>
  </div>
  
  <script>
  const { createApp } = Vue
  
  createApp({
    data() {
      return {
        count: 0
      }
    }
  }).mount('#app')
  </script>
  ```

  When the user clicks the button, `count` will increase by 1.

  Because `count` is reactive data, Vue will automatically update:

  ```html
  <p>Count is: {{ count }}</p>
  ```

  For example:

  ```text
  Count is: 0
  ```

  After clicking once:

  ```text
  Count is: 1
  ```

  After clicking again:

  ```text
  Count is: 2
  ```

  We do not need to write DOM update code by ourselves. Vue automatically keeps the data and page display synchronized.

  **Declarative rendering** focuses on how we describe the page based on data, while **reactivity** focuses on automatically updating the page when the data changes.

### 4.2 Quick Vue 3 Experience Without Engineering Tools

```html
<!DOCTYPE html>
<!-- 
    This example demonstrates how to quickly use Vue 3 
    without engineering tools such as Vite or Vue CLI.
-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vue 3 Quick Demo</title>
</head>
<body>

    <!-- 
        Import Vue 3 from CDN.
        This allows us to use Vue directly in an HTML file.
    -->
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>

    <!-- 
        This is the root element of the Vue application.
        Vue will control everything inside this div.
    -->
    <div id="app">

       <!-- 
            v-bind:style binds the style attribute to the variable colorStyle.
            {{ headline }} uses interpolation to display the value of headline.
       -->
       <h1 v-bind:style="colorStyle">{{ headline }}</h1>

       <!-- 
            v-text is used to set the text content of this paragraph.
            It will display the value of article.
       -->
       <p v-text="article"></p>

       <!-- 
            v-bind:type binds the input type to the variable inputType.
            Here, inputType is 'text', so this input is a text box.
       -->
       <input v-bind:type="inputType" value="helloVue3"> 
       <br>

       <!-- 
            @click is the shorthand for v-on:click.
            When the button is clicked, the sayHello function will be executed.
       -->
       <button @click="sayHello()">hello</button>
    </div>

    <script>
        // Create a Vue application.
        const app = Vue.createApp({

            // setup() is the entry function of the Composition API in Vue 3.
            // Variables and functions defined here can be used in the template
            // only if they are returned.
            setup() {

                // Define the type of the input element.
                let inputType = 'text';

                // Define the text displayed in the h1 element.
                let headline = 'hello vue3';

                // Define the text displayed in the paragraph.
                let article = 'vue is awesome';

                // Define the style object for the h1 element.
                // The text color will be red.
                let colorStyle = {
                    'color': 'red'
                };

                // Define a function.
                // This function will be called when the button is clicked.
                let sayHello = () => {
                    alert("hello Vue");
                };

                // Return variables and functions to the template.
                // Only returned data can be used in the HTML template.
                return {
                   inputType,
                   headline,
                   article,
                   colorStyle,
                   sayHello
                };
            }
        });

        // Mount the Vue application to the element whose id is app.
        // After mounting, Vue will control the content inside <div id="app">.
        app.mount("#app");
    </script>

</body>
</html>
```

---

## 5. Building Vue 3 Projects with Vite -- 自己构建一个项目vue+js

Previously, we used Vue 3 directly in an HTML file:

```html
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
```

This method is simple and suitable for quickly experiencing Vue 3. However, it is not suitable for developing real projects.

When a project becomes larger, we usually use **Vite** to create and manage Vue 3 projects.

### 5.1 Introduction to Vite

Vite is a modern front-end build tool. It makes development faster by using native ES modules in the browser and providing a very fast development server.

The main benefits of Vite include:

1. Quickly creating a project with a scaffold.
2. Providing a standardized project structure.
3. Supporting reusable code templates and component libraries.
4. Supporting automatic build and deployment workflows.

Official guide: <https://vitejs.dev/guide/>

### 5.2 Creating a Vue 3 Engineering Project with Vite

#### 5.2.1 Create, Start, and Stop a Vite + Vue 3 Project

Create a project:

```shell
# Teaching note: Commands for 5.2.1 Create, Start, and Stop a Vite + Vue 3 Project.
# Create a new Vite project.
npm create vite@latest
```

Choose **Vue + JavaScript**.

Install dependencies:

```shell
# Teaching note: Commands for 5.2.1 Create, Start, and Stop a Vite + Vue 3 Project.
# Enter the project directory.
cd ./vue3-demo1
# Install all dependencies listed in package.json.
npm install
```

Start the project:

```shell
# Teaching note: Commands for 5.2.1 Create, Start, and Stop a Vite + Vue 3 Project.
# Start the development server.
npm run dev
```

Stop the project:

```shell
# Teaching note: Commands for 5.2.1 Create, Start, and Stop a Vite + Vue 3 Project.
# Stop the running development server in the terminal.
Ctrl + C
```

#### 5.2.2 Project Directory Structure

Common Vite project structure:

- `public/`: public resources. They are copied directly to the build output.
- `src/`: source code of the project.
  - `assets/`: static resources such as images, fonts, and style files.
  - `components/`: reusable components.
  - `layouts/`: layout components such as header, footer, and navigation menu.
  - `pages/`: page-level components, usually connected with routes.
  - `plugins/`: Vite or Vue plugin-related files.
  - `router/`: route configuration files.
  - `store/`: state management files.
  - `utils/`: common utility functions.
- `vite.config.js`: Vite configuration file.
- `package.json`: project information, dependencies, and scripts.
- `src/main.js`: the entry file of the Vue application.

Example scripts in `package.json`:

```jsonc
// Teaching note: JSON-style configuration example for 5.2.2 Project Directory Structure.
// Real JSON files do not support comments; remove these comment lines before copying into package.json.
{
  "scripts": {
    "dev": "vite",
    "build": "vite build",
    "preview": "vite preview"
  }
}
```

Set a custom port in `vite.config.js`:

```javascript
// Teaching note: JavaScript example for 5.2.2 Project Directory Structure.
// Export the default value of this module.
export default defineConfig({
  plugins: [vue()],
  server:{
    port:3000
  }
})
```

### Single-File Component vs. Multi-File Component

A `.vue` file is called a **Single-File Component**, or **SFC**.

It means that the **HTML structure**, **JavaScript logic**, and **CSS style** of one component are written in the same `.vue` file.

------

## 1. Single-File Component

For example, we create a component called `HelloWorld.vue`.

```text
HelloWorld.vue
<template>
  <h1>{{ message }}</h1>
  <button @click="changeMessage">Click Me</button>
</template>

<script setup>
import { ref } from 'vue'

const message = ref('Hello Vue')

const changeMessage = () => {
  message.value = 'Hello Vue Component'
}
</script>

<style scoped>
h1 {
  color: red;
}
</style>
```

The structure is like this:

```text
┌──────────────────────────────┐
│        HelloWorld.vue         │
├──────────────────────────────┤
│ <template>                    │
│ HTML structure                │
├──────────────────────────────┤
│ <script setup>                │
│ JavaScript logic              │
├──────────────────────────────┤
│ <style scoped>                │
│ CSS style                     │
└──────────────────────────────┘
```

So, in a Single-File Component, one `.vue` file contains everything related to one component.

------

## 2. Multi-File Component

A multi-file component means that the structure, logic, and style are separated into different files.

For example:

```text
HelloWorld
├── HelloWorld.html
├── HelloWorld.js
└── HelloWorld.css
```

The structure is like this:

```text
┌──────────────────────┐
│  HelloWorld.html      │
│  HTML structure       │
└──────────────────────┘

┌──────────────────────┐
│  HelloWorld.js        │
│  JavaScript logic     │
└──────────────────────┘

┌──────────────────────┐
│  HelloWorld.css       │
│  CSS style            │
└──────────────────────┘
```

This method separates different types of code into different files.

------

## 3. Comparison Diagram

```text
Single-File Component
------------------------------------------------
One component = One .vue file

┌──────────────────────────────────────┐
│ Button.vue                            │
│                                      │
│  <template> HTML </template>          │
│  <script> JavaScript </script>        │
│  <style> CSS </style>                 │
└──────────────────────────────────────┘


Multi-File Component
------------------------------------------------
One component = Multiple files

┌────────────────────┐
│ Button.html         │
│ HTML structure      │
└────────────────────┘

┌────────────────────┐
│ Button.js           │
│ JavaScript logic    │
└────────────────────┘

┌────────────────────┐
│ Button.css          │
│ CSS style           │
└────────────────────┘
```

------

## 4. Why Do We Use Components?

![](images\image-20260518153034479.png)

In real projects, a webpage is usually made of many parts.

For example:

```text
┌──────────────────────────────────────┐
│ Header                               │
├──────────────────────────────────────┤
│ Navigation Bar                       │
├──────────────────────────────────────┤
│ Product List                         │
│  ├── Product Card                    │
│  ├── Product Card                    │
│  └── Product Card                    │
├──────────────────────────────────────┤
│ Footer                               │
└──────────────────────────────────────┘
```

Each part can be written as a component:

```text
App.vue
├── Header.vue
├── NavBar.vue
├── ProductList.vue
│   └── ProductCard.vue
└── Footer.vue
```

------

## 5. Benefits of Components

### 1. Code Reuse

If we create a `ProductCard.vue` component, we can use it many times.

```vue
<ProductCard />
<ProductCard />
<ProductCard />
```

We do not need to write the same HTML and CSS again and again.

------

### 2. Easier Maintenance

If there is a problem in the product card, we only need to modify:

```text
ProductCard.vue
```

After modification, all places using this component will be updated.

------

### 3. Clearer Project Structure

Without components, a page may become very long and difficult to read.

With components, we can divide a big page into small parts.

```text
Big page
↓
Small components
↓
Easier to understand and manage
```

------

### 4. Better Teamwork

In a real development team, different people can work on different components.

For example:

```text
Student A -> Header.vue
Student B -> ProductCard.vue
Student C -> Footer.vue
```

This makes cooperation easier.

------

## 6. Simple Summary

A **Single-File Component** puts the HTML, JavaScript, and CSS of one component into one `.vue` file.

A **multi-file component** separates HTML, JavaScript, and CSS into different files.

In Vue projects, we usually use **Single-File Components** because they are clear, organized, reusable, and easy to maintain.

A simple sentence for students:

> Components allow us to divide a large webpage into small, independent, and reusable parts.

#### 5.2.3 Vue Single-File Components

A `.vue` file is called a **Single-File Component**, or SFC.

A Vue component usually contains three parts:

```vue
<script>
// Teaching note: Script section for 5.2.3 Vue Single-File Components.
    // JavaScript logic
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
    <!-- HTML structure -->
</template>

<style scoped>
/* Style section: define styles that apply to this component. */
    /* CSS styles */
</style>
```

In a Vue engineering project:

- `index.html` is the application entry page.
- `main.js` creates the Vue application and mounts it to the DOM.
- `App.vue` is the root component.
- Other components are usually imported into `App.vue` or displayed through routes.

#### 5.2.4 Reactivity and the `setup` Function

Vue 3 data is not reactive by default. To make data reactive, we use `ref()` or `reactive()`.

```vue
<script type="module">
/*
    Teaching note:
    This example demonstrates reactivity in Vue 3
    and how to use the setup() function.
*/

// Import ref from Vue.
// ref is used to create reactive data.
import { ref } from 'vue'

export default {
    /*
        setup() is an important function in Vue 3 Composition API.

        Code written inside setup() is used to define:
        1. reactive data
        2. functions
        3. variables that can be used in the template
    */
    setup() {

        /*
            Create a reactive variable named counter.

            ref(1) means:
            - the initial value of counter is 1
            - counter is reactive

            When counter changes, the page will update automatically.
        */
        let counter = ref(1)

        /*
            Define the increase function.

            Because counter is created by ref(),
            we need to use counter.value to access or modify its value
            in the JavaScript section.
        */
        function increase() {
            counter.value++
        }

        /*
            Define the decrease function.

            This function decreases the value of counter by 1.
        */
        function decrease() {
            counter.value--
        }

        /*
            Return data and functions.

            Only the variables and functions returned here
            can be used in the template section.
        */
        return {
            counter,
            increase,
            decrease
        }
    }
}
</script>

<template>
    <!-- 
        Template section:
        This part defines the page structure displayed in the browser.
    -->

    <div>
        <!-- 
            @click is the shorthand form of v-on:click.

            When the user clicks this button,
            the decrease() function will be executed.
        -->
        <button @click="decrease()">-</button>

        <!-- 
            Display the value of counter.

            In the template, Vue automatically unwraps ref data,
            so we can write counter directly instead of counter.value.
        -->
        {{ counter }}

        <!-- 
            When the user clicks this button,
            the increase() function will be executed.
        -->
        <button @click="increase()">+</button>
    </div>
</template>
```

Using `<script setup>` can simplify the code:

```vue
<script setup type="module">
// Teaching note: Script section for 5.2.4 Reactivity and the setup Function.
import {ref} from 'vue'

let counter = ref(1)

function increase(){
    counter.value++
}

function decrease(){
    counter.value--
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
    <div>
      <button @click="decrease()">-</button>
      {{ counter }}
      <button @click="increase()">+</button>
    </div>
</template>
```

#### 5.2.5 Ways to Import Styles

1. Import globally in `main.js`:

```javascript
// Teaching note: JavaScript example for 5.2.5 Ways to Import Styles.
// Import required modules or components.
import './style/reset.css'
```

2. Import in the script part of a Vue file:

```javascript
// Teaching note: JavaScript example for 5.2.5 Ways to Import Styles.
// Import required modules or components.
import './style/reset.css'
```

3. Import in the style part of a Vue file:

```css
/* Teaching note: CSS style example for 5.2.5 Ways to Import Styles. */
@import './style/reset.css';
```

---

## 6. Vue 3 View Rendering Techniques

### 6.1 Template Syntax

Vue uses an HTML-based template syntax. It allows us to declaratively bind data to the DOM.

#### 6.1.1 Interpolation and Text Rendering

Interpolation uses the Mustache syntax `{{ }}`.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates interpolation and text rendering in Vue 3.

    Interpolation means using {{ }} to display JavaScript data
    or JavaScript expression results in the HTML template.
*/

/*
    Define a normal string variable.

    This variable can be displayed in the template by using:
    {{ msg }}
*/
let msg = "hello vue3"

/*
    Define a function.

    In the template, we can call this function by using:
    {{ getMsg() }}
*/
let getMsg = () => 'hello vue3 message'

/*
    Define a number variable.

    Later, we will use this variable in a conditional expression.
*/
let age = 19

/*
    Define a string variable.

    Later, we will use JavaScript string methods
    to process this value in the template.
*/
let bee = 'bee honey'

/*
    Define an array of shopping cart items.

    Each item is an object.
    Each object contains:
    - name: product name
    - price: product price
    - number: product quantity
*/
const carts = [
  { name: 'cola', price: 3, number: 10 },
  { name: 'chips', price: 6, number: 8 }
]

/*
    Define a function to calculate the total amount.

    Total amount = price * number for each product,
    then add all results together.
*/
function compute() {
    let count = 0;

    /*
        Use a loop to traverse the carts array.

        index represents the index of each item in the array.
    */
    for (let index in carts) {
        count += carts[index].price * carts[index].number;
    }

    /*
        Return the final total amount.
    */
    return count;
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Basic interpolation:
        Display the value of the msg variable.
    -->
    <h1>{{ msg }}</h1>

    <!-- 
        Display a variable directly.
    -->
    Message value: {{ msg }} <br>

    <!-- 
        Call a function inside interpolation.
        The return value of getMsg() will be displayed.
    -->
    Function result: {{ getMsg() }} <br>

    <!-- 
        Use a conditional expression inside interpolation.

        If age >= 18 is true, display 'true'.
        Otherwise, display 'false'.
    -->
    Adult: {{ age >= 18 ? 'true' : 'false' }} <br>

    <!-- 
        Use JavaScript string methods inside interpolation.

        bee.split(' ')       -> split the string into an array
        reverse()            -> reverse the array
        join('-')            -> join the array into a string with '-'
        
        Original value: bee honey
        Result: honey-bee
    -->
    Reverse: {{ bee.split(' ').reverse().join('-') }} <br>

    <!-- 
        Call the compute() function to calculate the total amount.

        cola: 3 * 10 = 30
        chips: 6 * 8 = 48
        total: 30 + 48 = 78
    -->
    Total amount: {{ compute() }} <br />

  </div>
</template>
```

Vue also provides `v-text` and `v-html`.

- `v-text` renders plain text.
- `v-html` renders HTML strings.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates text rendering in Vue 3.

    Main points:
    1. v-text renders content as plain text.
    2. v-html renders content as real HTML.
*/

/*
    Define a normal string variable.
*/
let msg = 'hello vue3'

/*
    Define a string that looks like an HTML tag.

    Although this string contains <font>,
    it is still just a normal string in JavaScript.
*/
let redMsg = "<font color='red'>msg</font>"

/*
    Define an HTML string by using template literals.

    ${msg} means inserting the value of the msg variable into the string.

    Final value:
    <font color='green'>hello vue3</font>
*/
let greenMsg = `<font color='green'>${msg}</font>`
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-text renders plain text.

        It will display:
        hello vue3
    -->
    <span v-text="msg"></span>
    <br>

    <!-- 
        v-text treats redMsg as normal text.

        It will display the HTML tag itself:
        <font color='red'>msg</font>

        The text will NOT become red.
    -->
    <span v-text="redMsg"></span>
    <br>

    <!-- 
        v-html renders redMsg as real HTML.

        It will display:
        msg

        The displayed text will become red.
    -->
    <span v-html="redMsg"></span>
    <br>

    <!-- 
        v-html renders greenMsg as real HTML.

        It will display:
        hello vue3

        The displayed text will become green.
    -->
    <span v-html="greenMsg"></span>
    <br>

  </div>
</template>
```

#### 6.1.2 Attribute Rendering

To bind an attribute of an element, use `v-bind`. It can be shortened to `:`.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates attribute rendering in Vue 3.

    Attribute rendering means binding JavaScript data
    to HTML attributes, such as href, src, title, and value.

    In Vue, we can use:
    v-bind:attributeName

    Or its shorthand form:
    :attributeName
*/

/*
    Define an object named data.

    This object contains three properties:
    - name: website name
    - url: website address
    - logo: image address
*/
const data = {
    name: 'Atguigu',
    url: 'http://www.atguigu.com',
    logo: 'http://www.atguigu.com/images/index_new/logo.png'
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        :href is the shorthand form of v-bind:href.

        It binds the href attribute of the <a> tag
        to data.url.

        So the final result is similar to:
        <a href="http://www.atguigu.com">

        target="_self" means opening the link in the current page.
    -->
    <a :href="data.url" target="_self">

      <!-- 
          :src binds the src attribute of the image
          to data.logo.

          :title binds the title attribute of the image
          to data.name.

          When the mouse moves over the image,
          the browser may show the title text.
      -->
      <img :src="data.logo" :title="data.name">

      <br>

      <!-- 
          :value binds the value attribute of the button
          to a JavaScript expression.

          `Visit ${data.name}` is a template string.

          Since data.name is 'Atguigu',
          the button text will be:
          Visit Atguigu
      -->
      <input type="button" :value="`Visit ${data.name}`">

    </a>
  </div>
</template>
```

#### 6.1.3 Event Binding

Use `v-on` to listen to DOM events. It can be shortened to `@`.

Common event modifiers:

- `.once`: trigger only once.
- `.prevent`: prevent the default behavior.
- `.stop`: stop event bubbling.
- `.capture`: use capture mode.
- `.self`: trigger only when the event target is the element itself.

```vue
<script setup type="module">
// Teaching note: Script section for 6.1.3 Event Binding.
import {ref} from 'vue'

let count = ref(0)

let addCount = () => {
    count.value++
}

let incrCount = (event) => {
    count.value++
    event.preventDefault();
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1>count: {{ count }}</h1>
    <button v-on:click="addCount()">addCount</button> <br>
    <button @click="count++">incrCount</button> <br>
    <button @click.once="count++">addOnce</button> <br>
    <a href="http://www.atguigu.com" target="_blank" @click.prevent="count++">prevent</a> <br>
    <a href="http://www.atguigu.com" target="_blank" @click="incrCount($event)">prevent by function</a> <br>
  </div>
</template>
```

### 6.2 Reactivity Basics

Reactivity means that when the data model changes, the DOM is updated automatically.

#### 6.2.1 A Non-Reactive Example

```vue
<script setup type="module">
// Teaching note: Script section for 6.2.1 A Non-Reactive Example.
let counter = 0;
function show(){
    alert(counter);
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <button @click="counter--">-</button>
    {{ counter }}
    <button @click="counter++">+</button>
    <hr>
    <button @click="show()">Show counter</button>
  </div>
</template>
```

The value changes in JavaScript, but the page does not update because `counter` is not reactive.

#### 6.2.2 `ref`

`ref` is mainly used for basic data types.

```vue
<script setup type="module">
// Teaching note: Script section for 6.2.2 ref.
import {ref} from 'vue'

let counter = ref(0);

function show(){
    alert(counter.value);
}

let decr = () => {
  counter.value--;
}

let incr = () => {
  counter.value++;
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <button @click="decr()">-</button>
    {{ counter }}
    <button @click="incr()">+</button>
    <hr>
    <button @click="show()">Show counter</button>
  </div>
</template>
```

In JavaScript, use `.value` to access or change a `ref` value. In templates, Vue automatically unwraps it.

#### 6.2.3 `reactive`

`reactive()` is mainly used for objects and arrays.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates reactive in Vue 3.

    Main points:
    1. reactive is used to create a reactive object.
    2. When a property inside the reactive object changes,
       the page will update automatically.
    3. reactive is usually used for objects or arrays.
*/

/*
    Import reactive from Vue.

    reactive is used to create a reactive object.
*/
import { reactive } from 'vue'

/*
    Create a reactive object named data.

    The object has one property:
    counter: 0

    Because data is reactive, when data.counter changes,
    the template will update automatically.
*/
let data = reactive({
  counter: 0
})

/*
    Define a function named show.

    This function displays the current value of data.counter
    in an alert box.
*/
function show() {
    alert(data.counter)
}

/*
    Define a function named decr.

    This function decreases data.counter by 1.
*/
let decr = () => {
  data.counter--
}

/*
    Define a function named incr.

    This function increases data.counter by 1.
*/
let incr = () => {
  data.counter++
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        When this button is clicked,
        the decr() function will be executed.

        data.counter will decrease by 1.
    -->
    <button @click="decr()">-</button>

    <!-- 
        Display the value of data.counter.

        Because data is reactive,
        the displayed value will update automatically
        when data.counter changes.
    -->
    {{ data.counter }}

    <!-- 
        When this button is clicked,
        the incr() function will be executed.

        data.counter will increase by 1.
    -->
    <button @click="incr()">+</button>

    <hr>

    <!-- 
        When this button is clicked,
        the show() function will be executed.

        It will show the current counter value in an alert box.
    -->
    <button @click="show()">Show counter</button>

  </div>
</template>
```

#### 6.2.4 `toRef` and `toRefs`

`toRef` creates a `ref` based on a property of a reactive object.

`toRefs` converts multiple properties of a reactive object into refs.

```vue
<script setup type="module">
// Teaching note: Script section for 6.2.4 toRef and toRefs.
import {reactive, toRef, toRefs} from 'vue'

let data = reactive({
  counter: 0,
  name: 'test'
})

let ct = toRef(data, 'counter');
let {counter, name} = toRefs(data)

function show(){
    alert(data.counter);
    alert(counter.value);
    alert(name.value);
}

let decr = () => {
  data.counter--;
}

let incr = () => {
  counter.value++;
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <button @click="decr()">-</button>
    {{ data.counter }} & {{ ct }}
    <button @click="incr()">+</button>
    <hr>
    <button @click="show()">Show counter</button>
  </div>
</template>
```

### 6.3 Conditional and List Rendering

#### 6.3.1 Conditional Rendering

`v-if` renders an element only when the expression is true.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates conditional rendering in Vue 3.

    Main points:
    1. v-if is used to render an element only when the condition is true.
    2. v-else is used to render another element when the v-if condition is false.
    3. ref is used to create reactive data.
*/

/*
    Import ref from Vue.

    ref is used to create a reactive variable.
    When the value changes, the page will update automatically.
*/
import { ref } from 'vue'

/*
    Define a reactive variable named awesome.

    Initial value: true

    Because awesome is true at the beginning,
    the element with v-if="awesome" will be displayed first.
*/
let awesome = ref(true)
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-if="awesome" means:
        If awesome is true, this h1 element will be rendered.

        Initial result:
        Vue is awesome!
    -->
    <h1 v-if="awesome">Vue is awesome!</h1>

    <!-- 
        v-else must be used immediately after v-if.

        If awesome is false, this h1 element will be rendered instead.
    -->
    <h1 v-else>Oh no 😢</h1>

    <!-- 
        @click is used to bind a click event.

        awesome = !awesome means reversing the current value.

        If awesome is true, it becomes false.
        If awesome is false, it becomes true.

        In the template, ref variables are automatically unwrapped,
        so we can write awesome directly instead of awesome.value.
    -->
    <button @click="awesome = !awesome">Toggle</button>

  </div>
</template>
```

`v-show` always renders the element, but switches the CSS `display` property.

```vue
<script setup type="module">
// Teaching note: Script section for 6.3.1 Conditional Rendering.
import {ref} from 'vue'
let awesome = ref(true)
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1 v-show="awesome">Vue is awesome!</h1>
    <h1 v-if="awesome">Vue is awesome!</h1>
    <h1 v-else>Oh no 😢</h1>
    <button @click="awesome = !awesome">Toggle</button>
  </div>
</template>
```

Comparison:

- `v-if` has higher switching cost but lower initial rendering cost.
- `v-show` has higher initial rendering cost but lower switching cost.
- Use `v-show` for frequent switching.
- Use `v-if` when the condition rarely changes.

#### 6.3.2 List Rendering

Use `v-for` to render a list.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates list rendering in Vue 3.

    Main points:
    1. v-for is used to render a list.
    2. We can traverse an array and display each item.
    3. We can get both item and index in v-for.
    4. :key is used to help Vue identify each list item.
*/

/*
    Import ref and reactive from Vue.

    ref is usually used for simple values.
    reactive is usually used for objects or arrays.
*/
import { ref, reactive } from 'vue'

/*
    Define a reactive variable named parentMessage.

    Initial value: 'Product'

    In the template, Vue automatically unwraps ref variables,
    so we can write parentMessage directly instead of parentMessage.value.
*/
let parentMessage = ref('Product')

/*
    Define a reactive array named items.

    Each item is an object.

    Each object contains:
    - id: a unique identifier
    - message: product name
*/
let items = reactive([
  { id: 'item1', message: 'chips' },
  { id: 'item2', message: 'cola' }
])
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        First list:
        Use v-for to display each item in the items array.
    -->
    <ul>

      <!-- 
          v-for="item in items" means:
          traverse the items array one by one.

          In each loop:
          item represents the current object.

          :key="item.id" gives each list item a unique key.
          This helps Vue update the list more efficiently.
      -->
      <li v-for="item in items" :key="item.id">
        <!-- 
            Display the message property of the current item.

            First item: chips
            Second item: cola
        -->
        {{ item.message }}
      </li>
    </ul>

    <!-- 
        Second list:
        Use v-for to get both item and index.
    -->
    <ul>

      <!-- 
          v-for="(item, index) in items" means:
          traverse the items array.

          item  -> the current object
          index -> the position of the current item in the array

          The index starts from 0.
      -->
      <li v-for="(item, index) in items" :key="index">

        <!-- 
            Display parentMessage, index, and item.message together.

            Example output:
            Product - 0 - chips
            Product - 1 - cola
        -->
        {{ parentMessage }} - {{ index }} - {{ item.message }}
      </li>
    </ul>

  </div>
</template>
```

Shopping cart example:

```vue
<script setup type="module">
// Teaching note: Script section for 6.3.2 List Rendering.
import { reactive } from 'vue'

const carts = reactive([
  {name:'cola', price:3, number:10},
  {name:'chips', price:6, number:8}
])

function compute(){
  write here
}

function removeCart(index){
  carts.splice(index, 1);
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <table>
      <thead>
        <tr>
          <th>No.</th>
          <th>Product</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Subtotal</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody v-if="carts.length > 0">
        <tr v-for="(cart, index) in carts" :key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ cart.name }}</td>
          <td>{{ cart.price + ' yuan' }}</td>
          <td>{{ cart.number }}</td>
          <td>{{ cart.price * cart.number + ' yuan' }}</td>
          <td><button @click="removeCart(index)">Delete</button></td>
        </tr>
      </tbody>
      <tbody v-else>
        <tr>
          <td colspan="6">The shopping cart is empty.</td>
        </tr>
      </tbody>
    </table>
    Total amount: {{ compute() }} yuan
  </div>
</template>
```

### 6.4 Two-Way Binding

One-way binding means that changes in reactive data update the DOM, but user input in the DOM does not update the data automatically.

Two-way binding means that both sides update each other. In Vue, `v-model` is used for two-way binding on form elements.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates two-way binding in Vue 3.

    Main points:
    1. v-model is used for two-way binding.
    2. When the input value changes, the JavaScript data changes automatically.
    3. When the JavaScript data changes, the page value also updates automatically.
    4. v-model can be used with input, checkbox, textarea, and select.
*/

import { reactive, ref } from 'vue'

/*
    Define a reactive array for hobbies.

    Because multiple checkboxes may be selected,
    we use an array to store the selected values.

    Example:
    If the user selects Eat and Play,
    hbs.value will become:
    ['eat', 'play']
*/
let hbs = ref([])

/*
    Define a reactive object to store user information.

    username  -> account name
    password  -> password
    introduce -> self-introduction
    pro       -> selected province
*/
let user = reactive({
  username: null,
  password: null,
  introduce: null,
  pro: null
})

/*
    Define the login function.

    This function is executed when the Login button is clicked.
*/
function login() {
  /*
      Show the selected hobbies.

      Because hbs is created by ref(),
      we need to use hbs.value in JavaScript.
  */
  alert(hbs.value)

  /*
      Convert the user object into a JSON string
      and show it in an alert box.
  */
  alert(JSON.stringify(user))
}

/*
    Define the reset function.

    This function clears all form data.
*/
function clearx() {
  /*
      Clear the values in the user object.

      Because user is created by reactive(),
      we can directly modify its properties.
  */
  user.username = ''
  user.password = ''
  user.introduce = ''
  user.pro = ''

  /*
      Clear the hobbies array.

      splice(0, hbs.value.length) means:
      starting from index 0,
      delete all elements in the array.
  */
  hbs.value.splice(0, hbs.value.length)
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-model="user.username" creates two-way binding.

        When the user types in this input box,
        user.username will update automatically.
    -->
    Account:
    <input type="text" v-model="user.username">
    <br>

    <!-- 
        v-model="user.password" binds the input value
        to user.password.

        In real projects, type="password" is usually better
        because it hides the password text.
    -->
    Password:
    <input type="text" v-model="user.password">
    <br>

    <!-- 
        Checkbox two-way binding.

        Because hbs is an array,
        selected checkbox values will be added into hbs.

        If a checkbox is unchecked,
        its value will be removed from hbs.
    -->
    Hobbies:

    Eat
    <input type="checkbox" v-model="hbs" value="eat">

    Drink
    <input type="checkbox" v-model="hbs" value="drink">

    Play
    <input type="checkbox" v-model="hbs" value="play">

    <br>

    <!-- 
        textarea can also use v-model.

        The text entered by the user will be stored in user.introduce.
    -->
    Introduction:
    <textarea v-model="user.introduce"></textarea>

    <br>

    <!-- 
        select can also use v-model.

        The selected option value will be stored in user.pro.
    -->
    Province:
    <select v-model="user.pro">

      <!-- 
          If this option is selected,
          user.pro will become '1'.
      -->
      <option value="1">Heilongjiang</option>

      <!-- 
          If this option is selected,
          user.pro will become '2'.
      -->
      <option value="2">Jilin</option>

      <!-- 
          If this option is selected,
          user.pro will become '3'.
      -->
      <option value="3">Liaoning</option>

      <!-- 
          If this option is selected,
          user.pro will become '4'.
      -->
      <option value="4">Beijing</option>
    </select>

    <br>

    <!-- 
        When this button is clicked,
        the login() function will be executed.
    -->
    <button @click="login()">Login</button>

    <!-- 
        When this button is clicked,
        the clearx() function will be executed.

        It will reset all form data.
    -->
    <button @click="clearx()">Reset</button>

    <hr>

    <!-- 
        Display the selected hobbies.

        In the template, Vue automatically unwraps ref variables,
        so we can write hbs directly instead of hbs.value.
    -->
    Hobbies: {{ hbs }}

    <hr>

    <!-- 
        Display the user object.

        When the form input changes,
        this displayed object will also update automatically.
    -->
    User information: {{ user }}

  </div>
</template>
```

### 6.5 Computed Properties---不讲了

Templates should not contain too much complex logic. Computed properties help us describe derived values based on reactive state.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates computed properties in Vue 3.

    Main points:
    1. computed() is used to define a computed property.
    2. A computed property is based on reactive data.
    3. Computed properties are cached.
    4. A normal function will run every time it is called.
*/

import { reactive, computed } from 'vue'

/*
    Define a reactive object named author.

    This object contains:
    - name: author's name
    - books: a list of books written by the author

    Because author is created by reactive(),
    changes to author.name or author.books can be tracked by Vue.
*/
const author = reactive({
  name: 'John Doe',
  books: [
    'Vue 2 - Advanced Guide',
    'Vue 3 - Basic Guide',
    'Vue 4 - The Mystery'
  ]
})

/*
    Define a computed property named publishedBooksMessage.

    computed() receives a function.
    The return value of this function becomes the value of the computed property.

    This computed property depends on:
    author.books.length

    If author.books does not change,
    Vue will reuse the cached result.
*/
const publishedBooksMessage = computed(() => {
  /*
      This console.log is used to observe how many times
      the computed property is actually executed.
  */
  console.log('publishedBooksMessage')

  /*
      If the author has at least one book, return 'Yes'.
      Otherwise, return 'No'.
  */
  return author.books.length > 0 ? 'Yes' : 'No'
})

/*
    Define a normal function named hasBooks.

    This function does almost the same thing as the computed property above.

    However, a normal function is not cached.
    Every time hasBooks() is called in the template,
    this function will run again.
*/
let hasBooks = () => {
  /*
      This console.log is used to observe how many times
      the normal function is executed.
  */
  console.log('hasBooks')

  /*
      If the author has at least one book, return 'Yes'.
      Otherwise, return 'No'.
  */
  return author.books.length > 0 ? 'Yes' : 'No'
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Display a question using author.name.
    -->
    <p>{{ author.name }} has published books?</p>

    <!-- 
        Call the normal function hasBooks().

        Because this is a normal function,
        it will execute every time it is called.

        Here hasBooks() is used twice,
        so the console will print:
        hasBooks
        hasBooks
    -->
    <span>{{ hasBooks() }}</span>
    <span>{{ hasBooks() }}</span>

    <!-- 
        Display the same question again.
    -->
    <p>{{ author.name }} has published books?</p>

    <!-- 
        Use the computed property publishedBooksMessage.

        Notice:
        In the template, we write publishedBooksMessage directly.
        We do not write publishedBooksMessage.value.

        Also, we do not call it like a function.
        So do not write:
        publishedBooksMessage()

        Because it is a computed property, Vue will cache the result.
        Even if it is used twice here, it usually only calculates once
        if author.books does not change.
    -->
    <span>{{ publishedBooksMessage }}</span>
    <span>{{ publishedBooksMessage }}</span>

  </div>
</template>
```

A computed property is cached based on its reactive dependencies. A method is executed each time it is called.

### 6.6 Watchers

Watchers are used to perform side effects when data changes, such as updating another state, sending requests, or operating on the DOM.

```vue
<script setup>--不讲
/*
    Teaching note:
    This example demonstrates watchers in Vue 3.

    Main points:
    1. watch() is used to observe data changes.
    2. When the watched data changes, the callback function will run.
    3. watch() can watch ref data directly.
    4. To watch a property inside a reactive object, we usually use a function.
    5. deep: true is used for deeply watching an object.
*/

import { ref, reactive, watch } from 'vue'

/*
    Define a ref variable.

    firstname is a simple reactive value.
    Because it is created by ref(),
    we need to use firstname.value in JavaScript.
*/
let firstname = ref('')

/*
    Define a reactive object.

    lastname is an object.
    It has one property: name.
*/
let lastname = reactive({
  name: ''
})

/*
    Define a ref variable to store the full name.

    fullname will be updated when firstname or lastname.name changes.
*/
let fullname = ref('')

/*
    Watch firstname.

    Because firstname is created by ref(),
    we can watch it directly.

    newValue -> the new value after change
    oldValue -> the previous value before change
*/
watch(firstname, (newValue, oldValue) => {
  /*
      Print the value change in the browser console.
  */
  console.log(`${oldValue} changed to ${newValue}`)

  /*
      Update fullname.

      firstname.value is used because firstname is a ref variable.
      lastname.name is used because lastname is a reactive object.
  */
  fullname.value = firstname.value + lastname.name
})

/*
    Watch lastname.name.

    Since lastname is a reactive object,
    we use a function to return lastname.name.

    This means:
    only watch the name property inside lastname.
*/
watch(() => lastname.name, (newValue, oldValue) => {
  /*
      Print the value change in the browser console.
  */
  console.log(`${oldValue} changed to ${newValue}`)

  /*
      Update fullname when lastname.name changes.
  */
  fullname.value = firstname.value + lastname.name
})

/*
    Watch the whole lastname object.

    deep: true means deeply watching the object.
    If any property inside lastname changes, this watcher can be triggered.

    immediate: false means this watcher will not run immediately
    when the page is loaded. It only runs after the data changes.

    Note:
    In this example, this watcher and the watcher above both watch lastname.name.
    So when lastname.name changes, fullname may be updated more than once.
    This is mainly for demonstrating different watch usages.
*/
watch(() => lastname, (newValue, oldValue) => {
  fullname.value = firstname.value + lastname.name
}, {
  deep: true,
  immediate: false
})
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Display fullname.

        fullname is a ref variable.
        In the template, Vue automatically unwraps ref variables,
        so we can write fullname directly instead of fullname.value.
    -->
    Full name: {{ fullname }}
    <br>

    <!-- 
        v-model creates two-way binding.

        When the user types in this input box,
        firstname will change automatically.

        Then the watcher of firstname will be triggered.
    -->
    First name:
    <input type="text" v-model="firstname">
    <br>

    <!-- 
        This input is bound to lastname.name.

        When the user types in this input box,
        lastname.name will change automatically.

        Then the watcher of lastname.name will be triggered.
    -->
    Last name:
    <input type="text" v-model="lastname.name">
    <br>

  </div>
</template>
```

`watchEffect` automatically tracks all reactive data used inside it.

```vue
<script setup>
/*
    Teaching note:
    This example demonstrates watchEffect in Vue 3.

    Main points:
    1. watchEffect() is used to automatically track reactive dependencies.
    2. It runs immediately when the page is loaded.
    3. When the reactive data used inside watchEffect changes,
       watchEffect will run again automatically.
*/

import { ref, reactive, watchEffect } from 'vue'

/*
    Define a ref variable named firstname.

    firstname is used to store the first name entered by the user.
*/
let firstname = ref('')

/*
    Define a reactive object named lastname.

    lastname.name is used to store the last name entered by the user.
*/
let lastname = reactive({
  name: ''
})

/*
    Define a ref variable named fullname.

    fullname is used to store the complete name.
*/
let fullname = ref('')

/*
    watchEffect() will run immediately.

    Vue will automatically track the reactive data used inside it.

    In this function, we use:
    - firstname.value
    - lastname.name

    So when firstname or lastname.name changes,
    this function will run again automatically.
*/
watchEffect(() => {

  /*
      Combine firstname and lastname.name,
      then assign the result to fullname.value.

      Because fullname is created by ref(),
      we need to use fullname.value in JavaScript.
  */
  fullname.value = `${firstname.value}${lastname.name}`
})
</script>
<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Display fullname.

        fullname is a ref variable.
        In the template, Vue automatically unwraps ref variables,
        so we can write fullname directly instead of fullname.value.
    -->
    Full name: {{ fullname }}
    <br>

    <!-- 
        v-model creates two-way binding.

        When the user types in this input box,
        firstname will change automatically.

        Then the watcher of firstname will be triggered.
    -->
    First name:
    <input type="text" v-model="firstname">
    <br>

    <!-- 
        This input is bound to lastname.name.

        When the user types in this input box,
        lastname.name will change automatically.

        Then the watcher of lastname.name will be triggered.
    -->
    Last name:
    <input type="text" v-model="lastname.name">
    <br>

  </div>
</template>
```

Difference:

- `watch` tracks explicitly declared data sources.
- `watchEffect` automatically tracks dependencies used during execution.

### 6.7 Vue Lifecycle--不讲

#### 6.7.1 Introduction

Every Vue component instance goes through a series of initialization steps, such as setting up data observation, compiling templates, mounting to the DOM, and updating the DOM when data changes.

Common lifecycle hooks:

- `onMounted()`: called after the component is mounted.
- `onUpdated()`: called after the DOM is updated due to reactive state changes.
- `onUnmounted()`: called after the component is unmounted.
- `onBeforeMount()`: called before mounting.
- `onBeforeUpdate()`: called before updating.
- `onBeforeUnmount()`: called before unmounting.

#### 6.7.2 Lifecycle Example

```vue
<script setup>
// Teaching note: Script section for 6.7.2 Lifecycle Example.
import {ref, onUpdated, onMounted, onBeforeUpdate} from 'vue'

let message = ref('hello')

onMounted(() => {
  console.log('-----------onMounted---------')
  let span1 = document.getElementById('span1')
  console.log(span1.innerText)
})

onBeforeUpdate(() => {
  console.log('-----------onBeforeUpdate---------')
  console.log(message.value)
  let span1 = document.getElementById('span1')
  console.log(span1.innerText)
})

onUpdated(() => {
  console.log('-----------onUpdated---------')
  let span1 = document.getElementById('span1')
  console.log(span1.innerText)
})
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <span id="span1" v-text="message"></span> <br>
    <input type="text" v-model="message">
  </div>
</template>
```

### 6.8 Vue Components

#### 6.8.1 Component Basics

A component is a reusable unit that contains local HTML, CSS, and JavaScript logic.

Componentization means packaging HTML, CSS, and JavaScript together in Vue.

Modularization usually refers to packaging JavaScript code using ES6 modules.

#### 6.8.2 Component Example

Create three child components: `Header.vue`, `Navigator.vue`, and `Content.vue`.

```vue
<!-- Teaching note: Vue component example for 6.8.2 Component Example. -->
<!-- Header.vue -->
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    Welcome: xx <a href="#">Logout</a>
  </div>
</template>
```

```vue
<!-- Teaching note: Vue component example for 6.8.2 Component Example. -->
<!-- Navigator.vue -->
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <ul>
      <li>Student Management</li>
      <li>Book Management</li>
      <li>Leave Management</li>
      <li>Exam Management</li>
      <li>Teacher Management</li>
    </ul>
  </div>
</template>
```

```vue
<!-- Teaching note: Vue component example for 6.8.2 Component Example. -->
<!-- Content.vue -->
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>Main content area.</div>
</template>
```

```vue
<!-- App.vue -->

<script setup>
/*
    Teaching note:
    This example demonstrates how to use components in Vue 3.

    Main points:
    1. App.vue is the parent component.
    2. Header.vue, Navigator.vue, and Content.vue are child components.
    3. We import child components first.
    4. Then we use them as custom tags in the template.
*/

/*
    Import the Header component.

    './components/Header.vue' means:
    find Header.vue in the components folder.
*/
import Header from './components/Header.vue'

/*
    Import the Navigator component.
*/
import Navigator from './components/Navigator.vue'

/*
    Import the Content component.
*/
import Content from './components/Content.vue'
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.

      In this example, App.vue divides the page into three parts:
      1. Header
      2. Navigator
      3. Content
  -->
  <div>

    <!-- 
        Use the Header component.

        class="header" means applying the CSS style
        defined in the style section below.
    -->
    <Header class="header"></Header>

    <!-- 
        Use the Navigator component.

        This component is used as the left navigation area.
    -->
    <Navigator class="navigator"></Navigator>

    <!-- 
        Use the Content component.

        This component is used as the main content area.
    -->
    <Content class="content"></Content>

  </div>
</template>

<style scoped>
/*
    Style section:
    This part defines styles for the current component.

    scoped means:
    these styles only apply to this component,
    and will not affect other components globally.
*/

/*
    Style for the Header component.

    height: 80px;
    sets the height of the header area.

    border: 1px solid red;
    adds a red border so that students can clearly see the area.
*/
.header {
  height: 80px;
  border: 1px solid red;
}

/*
    Style for the Navigator component.

    width: 15%;
    means the navigator takes 15% of the page width.

    height: 800px;
    sets the height of the navigation area.

    display: inline-block;
    allows the element to be displayed like an inline block.

    float: left;
    places the navigator on the left side.

    border: 1px blue solid;
    adds a blue border.
*/
.navigator {
  width: 15%;
  height: 800px;
  display: inline-block;
  border: 1px blue solid;
  float: left;
}

/*
    Style for the Content component.

    width: 83%;
    means the content area takes most of the page width.

    height: 800px;
    sets the height of the content area.

    float: right;
    places the content area on the right side.

    border: 1px goldenrod solid;
    adds a golden border.
*/
.content {
  width: 83%;
  height: 800px;
  display: inline-block;
  border: 1px goldenrod solid;
  float: right;
}
</style>
```

#### 6.8.3 Passing Data Between Components

##### Parent to Child

Use `props`.

```vue
<!-- App.vue -->
<script setup>
// Teaching note: Script section for Parent to Child.
import Son from './components/Son.vue'
import {ref} from 'vue'

let message = ref('parent data!')
let title = ref(42)

function changeMessage(){
  message.value = 'modified data!'
  title.value++
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h2>{{ message }}</h2>
    <Son :message="message" :title="title"></Son>
    <button @click="changeMessage">Update</button>
  </div>
</template>
```

```vue
<!-- Son.vue -->
<script setup type="module">
// Teaching note: Script section for Parent to Child.
defineProps({
  message: String,
  title: Number
})
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <div>{{ message }}</div>
    <div>{{ title }}</div>
  </div>
</template>
```

##### Child to Parent

Use `defineEmits`.

```vue
<!-- Son.vue -->
<script setup>
// Teaching note: Script section for Child to Parent.
import {ref} from 'vue'

let emits = defineEmits(['add', 'sub']);
let data = ref(1);

function sendMsgToParent(){
  emits('add', 'add data!' + data.value)
  emits('sub', 'sub data!' + data.value)
  data.value++;
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <button @click="sendMsgToParent">Send message to parent</button>
  </div>
</template>
```

##### Sibling Communication

Sibling components can communicate through their common parent: child A sends data to the parent, and the parent passes the data to child B.

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
// src/routers/router.js
// Import required modules or components.
import {createRouter, createWebHashHistory} from 'vue-router'

// Import required modules or components.
import Home from '../components/Home.vue'
// Import required modules or components.
import List from '../components/List.vue'
// Import required modules or components.
import Add from '../components/Add.vue'
// Import required modules or components.
import Update from '../components/Update.vue'

// Create the router object and define all route rules.
const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path:'/',
            components:{
                default:Home,
                homeView:Home
            }
        },
        {
            path:'/list',
            components:{ listView : List }
        },
        {
            path:'/add',
            components:{ addView:Add }
        },
        {
            path:'/update',
            components:{ updateView:Update }
        }
    ]
})

// Export the default value of this module.
export default router;
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
<script setup type="module">
// Teaching note: Script section for 7.4 Programmatic Routing with useRouter.
import {useRouter} from 'vue-router'

let router = useRouter()

let showList = () => {
  router.push({path:'/list'})
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <button @click="showList()">showList</button>
</template>
```

### 7.5 Route Parameters with `useRoute`

There are two common ways to pass parameters:

1. Path parameters: `/showDetail/1/JAVA`
2. Query parameters: `/showDetail2?id=1&language=JAVA`

Route configuration:

```javascript
// Teaching note: JavaScript example for 7.5 Route Parameters with useRoute.
{
    path:'/showDetail/:id/:language',
    name:'showDetail',
    components:{ showDetailView:ShowDetail }
},
{
    path:'/showDetail2',
    components:{ showDetailView2:ShowDetail2 }
}
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
router.beforeEach((to, from, next) => {
    console.log(to.path, from.path)

// Use conditional logic to decide the next step.
    if(to.path == '/index'){
        next()
    }else{
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

Example route configuration:

```javascript
// Teaching note: JavaScript example for 8.1 Reconstructing the Front-End Project.
// Import required modules or components.
import {createRouter, createWebHashHistory} from 'vue-router'

// Import required modules or components.
import Login from '../components/Login.vue'
// Import required modules or components.
import Regist from '../components/Regist.vue'
// Import required modules or components.
import ShowSchedule from '../components/ShowSchedule.vue'

// Create the router object and define all route rules.
let router = createRouter({
    history:createWebHashHistory(),
    routes:[
        { path:'/', component:Login },
        { path:'/login', component:Login },
        { path:'/showSchedule', component:ShowSchedule },
        { path:'/regist', component:Regist }
    ]
})

// Export the default value of this module.
export default router
```

Configure `main.js`:

```javascript
// Teaching note: JavaScript example for 8.1 Reconstructing the Front-End Project.
// Import required modules or components.
import { createApp } from 'vue'
// Import required modules or components.
import App from './App.vue'
// Import required modules or components.
import router from './router/router.js'

// Create a Vue application instance.
let app = createApp(App)
// Register a plugin in the Vue application.
app.use(router)
// Mount the Vue application to the page element.
app.mount('#app')
```

---

## 9. Vue 3 Data Interaction with Axios

### 9.0 Preliminary Knowledge: Promise

#### 9.0.1 Normal Functions and Callback Functions

A normal function is called immediately and the next line runs after it finishes.

```html
<!-- Teaching note: This HTML example demonstrates 9.0.1 Normal Functions and Callback Functions. -->
<script>
    // Script section: write JavaScript logic here.
    let fun1 = () => {
        console.log('fun1 invoked')
    }
    fun1()
    console.log('other code processed')
</script>
```

A callback function is executed in the future. The following code will not wait for it.

```html
<!-- Teaching note: This HTML example demonstrates 9.0.1 Normal Functions and Callback Functions. -->
<script>
    // Script section: write JavaScript logic here.
    setTimeout(function (){
        console.log('setTimeout invoked')
    }, 2000)
    console.log('other code processed')
</script>
```

#### 9.0.2 Promise Introduction

A Promise is a solution for asynchronous programming.

A Promise has three states:

- `Pending`: running.
- `Resolved` / `Fulfilled`: completed successfully.
- `Rejected`: failed.

Once a Promise state changes, it will not change again.

#### 9.0.3 Basic Promise Usage

```html
<!-- Teaching note: This HTML example demonstrates 9.0.3 Basic Promise Usage. -->
<script>
    // Script section: write JavaScript logic here.
    let promise = new Promise(function(resolve, reject){
        console.log('promise is running...')
        // resolve('promise success')
        reject('promise fail')
    })

    console.log('other code 1111 invoked')

    promise.then(
        function(value){ console.log(`resolved: ${value}`) },
        function(error){ console.log(`rejected: ${error}`) }
    )

    console.log('other code 2222 invoked')
</script>
```

#### 9.0.4 `catch()`

```html
<!-- Teaching note: This HTML example demonstrates 9.0.4 catch(). -->
<script>
    // Script section: write JavaScript logic here.
    let promise = new Promise(function(resolve, reject){
        throw new Error('error message')
    })

    promise.then(
        function(resolveValue){ console.log(`resolved: ${resolveValue}`) }
    ).catch(
        function(error){ console.log(error) }
    )
</script>
```

#### 9.0.5 `async` and `await`

`async` marks a function as asynchronous. The return value of an async function is a Promise.

```html
<!-- Teaching note: This HTML example demonstrates 9.0.5 async and await. -->
<script>
    // Script section: write JavaScript logic here.
async function fun1(){
    return 10
}

let promise = fun1()

promise.then(function(value){
    console.log('success:' + value)
})
</script>
```

`await` waits for the Promise on the right to finish and returns its successful result.

```html
<!-- Teaching note: This HTML example demonstrates 9.0.5 async and await. -->
<script>
    // Script section: write JavaScript logic here.
async function fun1(){
    return 10
}

async function fun2(){
    try{
        let res = await fun1()
        console.log('await got:' + res)
    }catch(e){
        console.log('catch got:' + e)
    }
}

fun2()
</script>
```

### 9.1 Axios Introduction

AJAX means **Asynchronous JavaScript and XML**. It allows the browser to exchange data with the server and update part of a page without reloading the whole page.

Axios is a Promise-based HTTP request library for browsers and Node.js.

Axios features:

- Create XMLHttpRequests in the browser.
- Create HTTP requests in Node.js.
- Support the Promise API.
- Intercept requests and responses.
- Transform request and response data.
- Cancel requests.
- Automatically convert JSON data.

Official website: <https://axios-http.com/>

### 9.2 Basic Axios Example

Install Axios:

```shell
# Teaching note: Commands for 9.2 Basic Axios Example.
# Install Axios for sending HTTP requests.
npm install axios
```

Example:

```vue
<script setup type="module">
// Teaching note: Script section for 9.2 Basic Axios Example.
import axios from 'axios'
import { onMounted, reactive } from 'vue'

let jsonData = reactive({code:1, content:'I work hard not for you, but because of you.'})

let getLoveMessage = () => {
  axios({
    method:'post',
    url:'https://api.uomg.com/api/rand.qinghua?format=json',
    data:{ username:'123456' }
  }).then(function (response){
    console.log(response)
    Object.assign(jsonData, response.data)
  }).catch(function (error){
    console.log(error)
  })
}

onMounted(() => {
  getLoveMessage()
})
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1>Today's message: {{ jsonData.content }}</h1>
    <button @click="getLoveMessage">Get today's message</button>
  </div>
</template>
```

A typical Axios response contains:

```jsonc
// Teaching note: JSON-style configuration example for 9.2 Basic Axios Example.
// Real JSON files do not support comments; remove these comment lines before copying into package.json.
{
  "data": {},
  "status": 200,
  "statusText": "OK",
  "headers": {},
  "config": {},
  "request": {}
}
```

### 9.3 Axios `get` and `post`

Syntax:

```javascript
// Teaching note: JavaScript example for 9.3 Axios get and post.
axios.get(url[, config])
axios.post(url[, data[, config]])
```

GET example:

```javascript
// Teaching note: JavaScript example for 9.3 Axios get and post.
// Define a variable or arrow function.
let getLoveWords = async () => {
// Return the result to the caller.
  return await axios.get(
    'https://api.uomg.com/api/rand.qinghua',
    {
      params:{
        format:'json',
        username:'zhangsan',
        password:'123456'
      },
      headers:{
        'Accept':'application/json, text/plain, text/html,*/*'
      }
    }
  )
}
```

POST example:

```javascript
// Teaching note: JavaScript example for 9.3 Axios get and post.
// Define a variable or arrow function.
let getLoveWords = async () => {
// Return the result to the caller.
  return await axios.post(
    'https://api.uomg.com/api/rand.qinghua',
    {
      username:'zhangsan',
      password:'123456'
    },
    {
      params:{ format:'json' },
      headers:{
        'Accept':'application/json, text/plain, text/html,*/*',
        'X-Requested-With':'XMLHttpRequest'
      }
    }
  )
}
```

### 9.4 Axios Interceptors

Interceptors allow us to perform extra work before a request is sent or before a response is processed.

```javascript
// Teaching note: JavaScript example for 9.4 Axios Interceptors.
axios.interceptors.request.use(
// Define a reusable function.
  function (config) {
// Return the result to the caller.
    return config;
  },
// Define a reusable function.
  function (error) {
// Return the result to the caller.
    return Promise.reject(error);
  }
);

axios.interceptors.response.use(
// Define a reusable function.
  function (response) {
// Return the result to the caller.
    return response;
  },
// Define a reusable function.
  function (error) {
// Return the result to the caller.
    return Promise.reject(error);
  }
);
```

Encapsulate Axios in `src/axios.js`:

```javascript
// Teaching note: JavaScript example for 9.4 Axios Interceptors.
// Import required modules or components.
import axios from 'axios'

// Create an Axios instance with shared request settings.
const instance = axios.create({
    baseURL:'https://api.uomg.com',
    timeout:10000
})

instance.interceptors.request.use(
    config => {
        console.log('before request')
        config.headers.Accept = 'application/json, text/plain, text/html,*/*'
// Return the result to the caller.
        return config
    },
    error => {
        console.log('request error')
// Return the result to the caller.
        return Promise.reject(error)
    }
)

instance.interceptors.response.use(
    response => {
        console.log('after success response')
// Return the result to the caller.
        return response
    },
    error => {
        console.log('after fail response')
// Return the result to the caller.
        return Promise.reject(error)
    }
)

// Export the default value of this module.
export default instance
```

---

## 10. Case Development: Schedule Management, Stage 6

### 10.1 Front-End Code Processing

#### 10.1.1 Create `src/utils/request.js`

```javascript
// Teaching note: JavaScript example for 10.1.1 Create src/utils/request.js.
// Import required modules or components.
import axios from 'axios'

// Create an Axios instance with shared request settings.
const instance = axios.create({
    baseURL:'http://localhost:8080/'
})

instance.interceptors.request.use(
    config => {
// Return the result to the caller.
        return config
    },
    error => {
// Return the result to the caller.
        return Promise.reject(error)
    }
)

instance.interceptors.response.use(
    response => {
// Return the result to the caller.
        return response
    },
    error => {
// Return the result to the caller.
        return Promise.reject(error)
    }
)

// Export the default value of this module.
export default instance
```

#### 10.1.2 Complete Registration Page

Main logic:

1. Use regular expressions to check the username and password.
2. Send a request to check whether the username is already used.
3. Send a registration request if all checks pass.
4. Jump to the login page after successful registration.

```javascript
// Teaching note: JavaScript example for 10.1.2 Complete Registration Page.
// Define an asynchronous function because it needs to wait for a request result.
async function checkUsername(){
// Declare a variable or constant.
    let usernameReg = /^[a-zA-Z0-9]{5,10}$/
// Use conditional logic to decide the next step.
    if(!usernameReg.test(registUser.username)){
        usernameMsg.value = 'Invalid format'
// Return the result to the caller.
        return false
    }

// Declare a variable or constant.
    let {data} = await request.post(`user/checkUsernameUsed?username=${registUser.username}`)
// Use conditional logic to decide the next step.
    if(data.code != 200){
        usernameMsg.value = 'Username already used'
// Return the result to the caller.
        return false
    }

    usernameMsg.value = 'Available'
// Return the result to the caller.
    return true
}

// Define an asynchronous function because it needs to wait for a request result.
async function regist(){
// Declare a variable or constant.
    let flag1 = await checkUsername()
// Declare a variable or constant.
    let flag2 = await checkUserPwd()
// Declare a variable or constant.
    let flag3 = await checkReUserPwd()

// Use conditional logic to decide the next step.
    if(flag1 && flag2 && flag3){
// Declare a variable or constant.
        let {data} = await request.post('user/regist', registUser)
// Use conditional logic to decide the next step.
        if(data.code == 200){
            alert('Registration successful. Please log in.')
            router.push('/login')
        }else{
            alert('The username has already been registered.')
        }
    }else{
        alert('Validation failed. Please check the data again.')
    }
}
```

#### 10.1.3 Complete Login Page

Main logic:

1. Validate username and password.
2. Send login data to the server.
3. Jump to the schedule page if login succeeds.
4. Show different messages according to the business code.

```javascript
// Teaching note: JavaScript example for 10.1.3 Complete Login Page.
// Define an asynchronous function because it needs to wait for a request result.
async function login(){
// Declare a variable or constant.
    let flag1 = checkUsername()
// Declare a variable or constant.
    let flag2 = checkUserPwd()
// Use conditional logic to decide the next step.
    if(!(flag1 && flag2)){
        return
    }

// Declare a variable or constant.
    let {data} = await request.post('user/login', loginUser)
// Use conditional logic to decide the next step.
    if(data.code == 200){
        alert('Login successful')
        router.push('/showSchedule')
    }else if(data.code == 503){
        alert('Wrong password')
    }else if(data.code == 501){
        alert('Wrong username')
    }else{
        alert('Unknown error')
    }
}
```

### 10.2 Back-End Code Processing

#### 10.2.1 Add a CORS Filter

##### What Is CORS?

The same-origin policy is a basic browser security mechanism. Two pages are considered same-origin only if they have the same protocol, host, and port.

In front-end/back-end separation, the front-end server and back-end server often have different ports or domains. This causes cross-origin requests.

##### CORS Filter Example

```java
// Teaching note: Java example for CORS Filter Example.
// Declare the Java package of this class.
package com.atguigu.schedule.filter;

// Import a class or interface used in this file.
import com.atguigu.schedule.common.Result;
// Import a class or interface used in this file.
import com.atguigu.schedule.util.WebUtil;
// Import a class or interface used in this file.
import jakarta.servlet.*;
// Import a class or interface used in this file.
import jakarta.servlet.annotation.WebFilter;
// Import a class or interface used in this file.
import jakarta.servlet.http.HttpServletRequest;
// Import a class or interface used in this file.
import jakarta.servlet.http.HttpServletResponse;

// Import a class or interface used in this file.
import java.io.IOException;

// Map this filter to matching request URLs.
@WebFilter("/*")
// Define a public Java class.
public class CrosFilter implements Filter {
// Override a method from the parent class or interface.
    @Override
// Define a method that handles a specific request or operation.
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");

// Check a condition and choose the corresponding branch.
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
// Send the result back to the browser as JSON.
            WebUtil.writeJson(response, Result.ok(null));
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
```

In future frameworks, CORS can often be handled by `@CrossOrigin`.

#### 10.2.2 Refactor `UserController`

Main functions:

- Check whether a username is used.
- Register a user.
- Log in a user.

```java
// Teaching note: Java example for 10.2.2 Refactor UserController.
// Map this Servlet controller to matching request URLs.
@WebServlet("/user/*")
// Define a public Java class.
public class UserController extends BaseController{
    private SysUserService userService = new SysUserServiceImpl();

// Define a method that handles a specific request or operation.
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SysUser registUser = userService.findByUsername(username);

// Prepare a unified result object for the front end.
        Result result;
// Check a condition and choose the corresponding branch.
        if(null == registUser){
            result = Result.ok(null);
        }else{
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
// Send the result back to the browser as JSON.
        WebUtil.writeJson(resp, result);
    }

// Define a method that handles a specific request or operation.
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser registUser = WebUtil.readJson(req, SysUser.class);
        int rows = userService.regist(registUser);

// Prepare a unified result object for the front end.
        Result result;
// Check a condition and choose the corresponding branch.
        if(rows > 0){
           result = Result.ok(null);
        }else{
           result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
// Send the result back to the browser as JSON.
        WebUtil.writeJson(resp, result);
    }

// Define a method that handles a specific request or operation.
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser inputUser = WebUtil.readJson(req, SysUser.class);
        SysUser loginUser = userService.findByUsername(inputUser.getUsername());

// Prepare a unified result object for the front end.
        Result result;
// Check a condition and choose the corresponding branch.
        if(null == loginUser){
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }else if(!loginUser.getUserPwd().equals(MD5Util.encrypt(inputUser.getUserPwd()))){
            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }else{
            result = Result.ok(null);
        }
// Send the result back to the browser as JSON.
        WebUtil.writeJson(resp, result);
    }
}
```

#### 10.2.3 Remove the Login Verification Filter

At this stage, we do not use cookies or sessions to store user login status. In later development, token-based login will be used. Therefore, the previous login verification filter can be removed.

---

## 11. Vue 3 State Management with Pinia

### 11.1 Introduction to Pinia

When multiple components need to share the same state, we can use:

1. Component parameter passing.
2. Route parameter passing.
3. State management with Pinia.

Pinia is a state management library maintained by the Vue core team. It supports Vue 2 and Vue 3.

Official website: <https://pinia.vuejs.org/>

### 11.2 Basic Pinia Usage

Install Pinia:

```shell
# Teaching note: Commands for 11.2 Basic Pinia Usage.
# Install Pinia for state management.
npm install pinia
```

Define a store in `src/store/store.js`:

```javascript
// Teaching note: JavaScript example for 11.2 Basic Pinia Usage.
// Import required modules or components.
import {defineStore} from 'pinia'

// Export a named constant so other files can import it.
export const definedPerson = defineStore({
    id: 'personPinia',
    state: () => {
// Return the result to the caller.
        return {
            username:'Zhang San',
            age:0,
            hobbies:['singing','dancing']
        }
    },
    getters:{
        getHobbiesCount(){
// Return the result to the caller.
            return this.hobbies.length
        },
        getAge(){
// Return the result to the caller.
            return this.age
        }
    },
    actions:{
        doubleAge(){
            this.age = this.age * 2
        }
    }
})
```

Configure Pinia in `main.js`:

```javascript
// Teaching note: JavaScript example for 11.2 Basic Pinia Usage.
// Import required modules or components.
import { createApp } from 'vue'
// Import required modules or components.
import App from './App.vue'
// Import required modules or components.
import { createPinia } from 'pinia'

// Declare a variable or constant.
let pinia = createPinia()
// Create a Vue application instance.
let app = createApp(App)

// Register a plugin in the Vue application.
app.use(pinia)
// Mount the Vue application to the page element.
app.mount('#app')
```

Operate store data in a component:

```vue
<script setup type="module">
// Teaching note: Script section for 11.2 Basic Pinia Usage.
import { definedPerson } from '../store/store'

let person = definedPerson()
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    Name: <input type="text" v-model="person.username"> <br>
    Age: <input type="text" v-model="person.age"> <br>

    <button @click="person.doubleAge()">Double age</button> <br>
    <button @click="person.$reset()">Reset</button> <br>
    <button @click="person.$patch({username:'Ultraman', age:100, hobbies:['sunbathing','fighting monsters']})">
      Become Ultraman
    </button>
    <br>
    Person data: {{ person }}
  </div>
</template>
```

Display store data in another component:

```vue
<script setup type="module">
// Teaching note: Script section for 11.2 Basic Pinia Usage.
import { definedPerson } from '../store/store'
let person = definedPerson()
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    Name: {{ person.username }} <br>
    Age: {{ person.age }} <br>
    Age by getter: {{ person.getAge }} <br>
    Number of hobbies: {{ person.getHobbiesCount }} <br>
    <ul>
      <li v-for="(hobby, index) in person.hobbies" :key="index">{{ hobby }}</li>
    </ul>
  </div>
</template>
```

### 11.3 More Pinia Details

State is the core data source of a store.

Getters are equivalent to computed values of the store state.

Actions are equivalent to methods. They are suitable for business logic and can be asynchronous.

```javascript
// Teaching note: JavaScript example for 11.3 More Pinia Details.
// Export a named constant so other files can import it.
export const useCounterStore = defineStore('main', {
  state: () => ({
    count: 0,
  }),
  getters: {
    doubleCount: (state) => state.count * 2,
  },
  actions: {
    increment() {
      this.count++
    },
    randomizeCounter() {
      this.count = Math.round(100 * Math.random())
    },
  },
})
```

---

## 12. Case Development: Schedule Management, Stage 7

### 12.1 Use Pinia to Store Front-End Data

Install Pinia:

```shell
# Teaching note: Commands for 12.1 Use Pinia to Store Front-End Data.
# Install Pinia for state management.
npm install pinia
```

Create `src/pinia.js`:

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Import required modules or components.
import {createPinia} from 'pinia'
// Declare a variable or constant.
let pinia = createPinia()
// Export the default value of this module.
export default pinia
```

Use Pinia in `main.js`:

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Import required modules or components.
import { createApp } from 'vue'
// Import required modules or components.
import App from './App.vue'
// Import required modules or components.
import router from './router/router.js'
// Import required modules or components.
import pinia from './pinia.js'

// Create a Vue application instance.
let app = createApp(App)
// Register a plugin in the Vue application.
app.use(router)
// Register a plugin in the Vue application.
app.use(pinia)
// Mount the Vue application to the page element.
app.mount('#app')
```

Create `src/store/userStore.js`:

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Import required modules or components.
import {defineStore} from 'pinia'

// Export a named constant so other files can import it.
export const defineUser = defineStore('loginUser', {
    state: () => {
// Return the result to the caller.
        return {
            uid:0,
            username:''
        }
    }
})
```

Create `src/store/scheduleStore.js`:

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Import required modules or components.
import {defineStore} from 'pinia'

// Export a named constant so other files can import it.
export const defineSchedule = defineStore('scheduleList', {
    state: () => {
// Return the result to the caller.
        return {
            itemList: []
        }
    },
    actions:{
    }
})
```

In `Header.vue`, display different content according to the Pinia user state.

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Import required modules or components.
import {defineUser} from '../store/userStore.js'
// Import required modules or components.
import {defineSchedule} from '../store/scheduleStore.js'
// Import required modules or components.
import {useRouter} from 'vue-router'

// Declare a variable or constant.
let sysUser = defineUser()
// Declare a variable or constant.
let schedule = defineSchedule()
// Declare a variable or constant.
let router = useRouter()

// Define a reusable function.
function logout(){
  sysUser.$reset()
  schedule.$reset()
  router.push('/login')
}
```

In `Login.vue`, store the returned user ID and username after successful login.

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Use conditional logic to decide the next step.
if(data.code == 200){
    alert('Login successful')
    sysUser.uid = data.data.loginUser.uid
    sysUser.username = data.data.loginUser.username
    router.push('/showSchedule')
}
```

Use a route guard to prevent unauthenticated users from entering the schedule page.

```javascript
// Teaching note: JavaScript example for 12.1 Use Pinia to Store Front-End Data.
// Register a global route guard before page navigation.
router.beforeEach((to, from, next) => {
// Use conditional logic to decide the next step.
    if(to.path == '/showSchedule'){
// Use conditional logic to decide the next step.
        if(sysUser.username == ''){
            alert('You are not logged in. Please log in first.')
            next('/login')
        }else{
            next()
        }
    }else{
        next()
    }
})
```

### 12.2 Display All Schedule Data

Send a request to the server after the page is mounted.

```vue
<script setup>
// Teaching note: Script section for 12.2 Display All Schedule Data.
import request from '../utils/request.js'
import {defineSchedule} from '../store/scheduleStore.js'
import {defineUser} from '../store/userStore.js'
import { onMounted } from 'vue'

let schedule = defineSchedule();
let sysUser = defineUser()

onMounted(async function (){
    showSchedule()
})

async function showSchedule(){
    let {data} = await request.get('/schedule/findAllSchedule', {params:{uid:sysUser.uid}})
    schedule.itemList = data.data.itemList
}
</script>
```

Back-end controller:

```java
// Teaching note: Java example for 12.2 Display All Schedule Data.
// Map this Servlet controller to matching request URLs.
@WebServlet("/schedule/*")
// Define a public Java class.
public class SysScheduleController extends BaseController{
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();

// Define a method that handles a specific request or operation.
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);

        Map<String,Object> data = new HashMap<>();
        data.put("itemList", itemList);
// Send the result back to the browser as JSON.
        WebUtil.writeJson(resp, Result.ok(data));
    }
}
```

DAO implementation:

```java
// Teaching note: Java example for 12.2 Display All Schedule Data.
// Override a method from the parent class or interface.
@Override
public List<SysSchedule> findItemListByUid(int uid) {
// Write the SQL statement to operate on the database.
    String sql = "select sid, uid, title, completed from sys_schedule where uid = ?";
// Execute the SQL statement through the common DAO method.
    return baseQuery(SysSchedule.class, sql, uid);
}
```

### 12.3 Add and Save Schedule Data

Front-end logic:

```javascript
// Teaching note: JavaScript example for 12.3 Add and Save Schedule Data.
// Define an asynchronous function because it needs to wait for a request result.
async function addItem(){
// Declare a variable or constant.
    let {data} = await request.get('/schedule/addDefaultSchedule', {params:{uid:sysUser.uid}})
// Use conditional logic to decide the next step.
    if(data.code == 200){
        showSchedule()
    }else{
        alert('Add failed')
    }
}

// Define an asynchronous function because it needs to wait for a request result.
async function updateItem(index){
// Declare a variable or constant.
    let {data} = await request.post('/schedule/updateSchedule', schedule.itemList[index])
// Use conditional logic to decide the next step.
    if(data.code == 200){
        showSchedule()
    }else{
        alert('Update failed')
    }
}
```

Back-end controller:

```java
// Teaching note: Java example for 12.3 Add and Save Schedule Data.
// Define a method that handles a specific request or operation.
protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int uid = Integer.parseInt(req.getParameter("uid"));
    scheduleService.addDefault(uid);
// Send the result back to the browser as JSON.
    WebUtil.writeJson(resp, Result.ok(null));
}

// Define a method that handles a specific request or operation.
protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
    scheduleService.updateSchedule(sysSchedule);
// Send the result back to the browser as JSON.
    WebUtil.writeJson(resp, Result.ok(null));
}
```

DAO implementation:

```java
// Teaching note: Java example for 12.3 Add and Save Schedule Data.
// Override a method from the parent class or interface.
@Override
public Integer addDefault(int uid) {
// Write the SQL statement to operate on the database.
    String sql = "insert into sys_schedule value(default, ?, 'Please enter a schedule', 0)";
// Execute the SQL statement through the common DAO method.
    return baseUpdate(sql, uid);
}

// Override a method from the parent class or interface.
@Override
public Integer updateSchedule(SysSchedule sysSchedule) {
// Write the SQL statement to operate on the database.
    String sql = "update sys_schedule set title = ?, completed = ? where sid = ?";
// Execute the SQL statement through the common DAO method.
    return baseUpdate(sql, sysSchedule.getTitle(), sysSchedule.getCompleted(), sysSchedule.getSid());
}
```

### 12.5 Delete Schedule Data

Front-end logic:

```javascript
// Teaching note: JavaScript example for 12.5 Delete Schedule Data.
// Define an asynchronous function because it needs to wait for a request result.
async function removeItem(index){
// Use conditional logic to decide the next step.
    if(confirm('Are you sure you want to delete this item?')){
// Declare a variable or constant.
        let sid = schedule.itemList[index].sid
// Declare a variable or constant.
        let {data} = await request.get('/schedule/removeSchedule', {params:{sid:sid}})
// Use conditional logic to decide the next step.
        if(data.code == 200){
            showSchedule()
        }else{
            alert('Delete failed')
        }
    }
}
```

Back-end controller:

```java
// Teaching note: Java example for 12.5 Delete Schedule Data.
// Define a method that handles a specific request or operation.
protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int sid = Integer.parseInt(req.getParameter("sid"));
    scheduleService.removeSchedule(sid);
// Send the result back to the browser as JSON.
    WebUtil.writeJson(resp, Result.ok(null));
}
```

DAO implementation:

```java
// Teaching note: Java example for 12.5 Delete Schedule Data.
// Override a method from the parent class or interface.
@Override
public Integer removeBySid(int sid) {
// Write the SQL statement to operate on the database.
    String sql = "delete from sys_schedule where sid = ?";
// Execute the SQL statement through the common DAO method.
    return baseUpdate(sql, sid);
}
```

---

## 13. Element Plus Component Library

### 13.1 Introduction to Element Plus

Element Plus is an open-source UI component library based on Vue 3. It is the upgraded version of Element UI and provides many ready-to-use components.

It helps developers quickly build high-quality web applications.

Features:

- Rich UI components.
- Easy-to-use APIs.
- Flexible theme customization.
- On-demand loading support.
- Clear documentation and example code.

Official website: <https://element-plus.org/>

Because Vue 3 no longer supports IE11, Element Plus also does not support Internet Explorer.

### 13.2 Basic Element Plus Example

Create a Vite project and install common dependencies:

```shell
# Teaching note: Commands for 13.2 Basic Element Plus Example.
# Create a new Vite project.
npm create vite
# Install all dependencies listed in package.json.
npm install
# Install Vue Router for page navigation.
npm install vue-router@4 --save
# Install Pinia for state management.
npm install pinia
# Install Axios for sending HTTP requests.
npm install axios
```

Install Element Plus:

```shell
# Teaching note: Commands for 13.2 Basic Element Plus Example.
# Install Element Plus UI component library.
npm install element-plus
```

Import Element Plus globally in `main.js`:

```javascript
// Teaching note: JavaScript example for 13.2 Basic Element Plus Example.
// Import required modules or components.
import { createApp } from 'vue'
// Import required modules or components.
import ElementPlus from 'element-plus'
// Import required modules or components.
import 'element-plus/dist/index.css'

// Import required modules or components.
import App from './App.vue'

// Create a Vue application instance.
const app = createApp(App)
// Register a plugin in the Vue application.
app.use(ElementPlus)
// Mount the Vue application to the page element.
app.mount('#app')
```

Basic example:

```vue
<script setup>
// Teaching note: Script section for 13.2 Basic Element Plus Example.
import { ref } from 'vue'
const value = ref(true)
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <el-button>Button</el-button>
    <br>
    <el-switch
      v-model="value"
      size="large"
      active-text="Open"
      inactive-text="Close"
    />
    <br />
    <el-switch v-model="value" active-text="Open" inactive-text="Close" />
    <br />
    <el-switch
      v-model="value"
      size="small"
      active-text="Open"
      inactive-text="Close"
    />
  </div>
</template>
```

Start the project:

```shell
# Teaching note: Commands for 13.2 Basic Element Plus Example.
# Start the development server.
npm run dev
```

### 13.3 Common Element Plus Components

Commonly used components include:

- Button
- Form
- Input
- Table
- Dialog
- Tabs
- DatePicker
- TimePicker
- Cascader
- Slider
- ColorPicker

Reference: <https://element-plus.org/en-US/component/button.html>

---

## Teaching Notes

This chapter introduces the basic workflow of modern front-end engineering:

1. Learn ES6 syntax.
2. Set up Node.js and npm.
3. Create a Vue 3 project with Vite.
4. Understand Vue components, rendering, reactivity, routing, and state management.
5. Use Axios to communicate with the Java Web back end.
6. Use Pinia to store shared front-end state.
7. Use Element Plus to build pages quickly.

By completing the schedule management case, students can understand how a Vue 3 front end interacts with a Servlet-based Java Web back end.
