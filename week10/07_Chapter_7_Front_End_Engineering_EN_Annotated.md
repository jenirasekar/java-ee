Chapter 7 Front-End Engineering


> **Teaching version note:** In this annotated version, code blocks include additional English comments for classroom explanation. Some JSON examples are shown as `jsonc` so that comments can be displayed; remove comments if you copy them into a real `.json` file.

## 1. Introduction to Front-End Engineering

### 1.1 What Is Front-End Engineering?

Front-end engineering means using **software engineering methods** to solve common problems in the front-end development process. These problems usually include **modularization**, **componentization**, **standardization**, and **automation**.

![image-20260511155946239](images\image-20260511155946239.png)

In the early stage of front-end development, a web page could be completed by writing one HTML file, one CSS file, and one JavaScript file. However, as the project becomes larger, this simple development style will cause many problems. For example, different pages may contain repeated code, CSS styles may affect each other, JavaScript files may become difficult to manage, and developers may spend a lot of time manually organizing files, importing dependencies, and packaging the project.

Therefore, front-end engineering is introduced to make front-end development more organized and efficient.

For example, suppose we are developing a student management system. The system may contain many pages, such as the login page, student list page, student information page, and course management page. These pages may all need the same header, navigation menu, buttons, forms, and table styles. Without front-end engineering, we may need to copy the same HTML, CSS, and JavaScript code many times. If we want to change the style of the navigation menu later, we have to modify many files one by one, which is inefficient and error-prone.

With front-end engineering, we can divide the page into reusable components, such as `Header`, `Menu`, `Button`, and `Table`. We can also use tools such as Node.js, npm, Vite, Vue 3, router, Pinia, and Axios to manage dependencies, build projects, switch pages, manage shared data, and communicate with the back-end server.

In short, the main purpose of front-end engineering is to **improve development efficiency**, **reduce repetitive work**, **standardize project structure**, and **make front-end projects easier to maintain and extend**.

### 1.2 Technology Stack Used in This Chapter

There are many possible technology stacks for front-end engineering. In this course, we use the following combination:

- **ECMAScript 6 (ES6)**: widely used in Vue 3 syntax.
- **Node.js**: the runtime environment for front-end projects.
- **npm**: a dependency download and package management tool.
- **Vite**: a modern front-end build tool.
- **Vue 3**: a progressive JavaScript framework for building user interfaces.
- **Vue Router**: used to switch between pages through routing.
- **Pinia**: used for state management and data sharing between components.
- **Axios**: used to send asynchronous Ajax requests and interact with the back end.
- **Element Plus**: a Vue 3 UI component library that helps us build pages quickly.

---

## 2. ECMAScript 6

### 2.1 Introduction to ES6

ECMAScript 6, usually called **ES6**, is a major update of the JavaScript language. It was released in 2015 as the sixth version of the ECMAScript standard.

ES6 introduced many new features, such as arrow functions, template strings, `let` and `const`, destructuring assignment, default parameters, classes, and modules. These features make JavaScript code more concise, more powerful, and easier to maintain.

Because Vue 3 uses a large amount of ES6 syntax, ES6 is one of the basic requirements for learning Vue 3.

ES6 improves JavaScript in the following ways:

1. **More concise syntax**: arrow functions, classes, template strings, and other features make code easier to read.
2. **More powerful functions**: new APIs, destructuring, iterators, and other features make JavaScript more flexible.
3. **Better applicability**: the module system makes it easier to organize large JavaScript applications.

### 2.2 Variables and Template Strings in ES6

ES6 adds `let` and `const` for declaring variables.

#### Differences between `let` and `var`

1. `let` cannot be declared repeatedly in the same scope.
2. `let` has block scope.
3. `let` does not support variable hoisting in the same way as `var`.
4. Global variables declared with `let` do not become properties of `window`.
5. In ES6, `let` is generally recommended instead of `var`.

```html
<!-- Teaching note: This HTML example demonstrates Differences between let and var. -->
<script>
    // Script section: write JavaScript logic here.
    // 1. let is only valid inside the current block.
    {
      let a = 1
      var b = 2
    }
    console.log(a);  // Error: a is not defined
    console.log(b);  // 2

    // 2. let cannot be declared repeatedly.
    let name = 'Tom'
    // let name = 'Jerry' // Error

    // 3. let should be declared before use.
    console.log(test) // undefined
    var test = 'test'

    // console.log(test1) // Error
    let test1 = 'test1'

    // 4. let variables do not become window properties.
    var x = 100
    console.log(window.x) // 100

    let y = 200
    console.log(window.y) // undefined

    // 5. let is recommended in loops.
    for (let i = 0; i < 10; i++) {
      console.log(i)
    }
</script>
```

#### `const`

`const` is similar to `let`, but a variable declared by `const` cannot be reassigned.

Notice that `const` does not mean the value itself can never change. It means the memory address stored by the variable cannot be changed. For objects and arrays, internal properties or elements can still be modified.

```html
<!-- Teaching note: This HTML example demonstrates const. -->
<script>
    // Script section: write JavaScript logic here.
    const PI = 3.1415926;

    // const A; // Error: const must be initialized.

    const A = 'atguigu'
    // A = 'xx' // Error: cannot reassign a const variable.

    {
        const B = 'block value'
        console.log(B)
    }

    const TEAM = ['Andy', 'Jacky', 'Aaron'];
    TEAM.push('Leon'); // Allowed: the array address is unchanged.
    // TEAM = []       // Error: reassignment is not allowed.
</script>
```

#### Template Strings

Template strings are enhanced strings marked with backticks `` ` ``.

They support:

1. Multi-line strings.
2. Variable interpolation with `${}`.

```html
<!-- Teaching note: This HTML example demonstrates Template Strings. -->
<script>
    // Script section: write JavaScript logic here.
    let ulStr =
        '<ul>'+
        '<li>JAVA</li>'+
        '<li>HTML</li>'+
        '<li>VUE</li>'+
        '</ul>'

    let ulStr2 = `
        <ul>
            <li>JAVA</li>
            <li>HTML</li>
            <li>VUE</li>
        </ul>`

    let name = 'Zhang Xiaoming'
    let infoStr = `${name} was selected as an excellent student this year.`
    console.log(infoStr)
</script>
```

### 2.3 Destructuring Assignment in ES6

Destructuring assignment is a convenient syntax for extracting values from arrays or objects and assigning them to variables.

#### Array Destructuring

```javascript
// Teaching note: JavaScript example for Array Destructuring.
// Declare a variable or constant.
let [a, b, c] = [1, 2, 3];
console.log(a); // 1
console.log(b); // 2
console.log(c); // 3
```

A default value can be used when the array does not contain a corresponding value.

```javascript
// Teaching note: JavaScript example for Array Destructuring.
// Declare a variable or constant.
let [a, b, c, d = 4] = [1, 2, 3];
console.log(d); // 4
```

#### Object Destructuring

```javascript
// Teaching note: JavaScript example for Object Destructuring.
// Declare a variable or constant.
let {a, b} = {a: 1, b: 2};
console.log(a); // 1
console.log(b); // 2
```

The variable name must match the property name. You can also give the property a new variable name.

```javascript
// Teaching note: JavaScript example for Object Destructuring.
// Declare a variable or constant.
let {a: x, b: y} = {a: 1, b: 2};
console.log(x); // 1
console.log(y); // 2
```

#### Function Parameter Destructuring

```javascript
// Teaching note: JavaScript example for Function Parameter Destructuring.
// Define a reusable function.
function add([x, y]) {
// Return the result to the caller.
  return x + y;
}
console.log(add([1, 2])); // 3
```

### 2.4 Arrow Functions in ES6

ES6 allows us to define functions with the arrow syntax `=>`. The style is similar to Lambda expressions in Java.

#### 2.4.1 Declaration and Features

```html
<!-- Teaching note: This HTML example demonstrates 2.4.1 Declaration and Features. -->
<script>
    // Script section: write JavaScript logic here.
    let fun1 = function(){}      // Normal function declaration

    let fun2 = ()=>{}            // Arrow function declaration, lambda

    let fun3 = (x) => { 
        return x + 1 
    }                            // Arrow function with one parameter and a return value

    let fun4 = x => { 
        return x + 1 
    }                            // If there is only one parameter, the parentheses () can be omitted

    let fun5 = x => console.log(x)   
                                 // If the function body has only one line of code, the braces {} can be omitted

    let fun6 = x => x + 1        
                                 // If the function body has only one line of code, 
                                 // this line is treated as the returned result,
                                 // so both {} and return can be omitted

    let person = {
        name: 'Zhang San',
        showName: function () {
            console.log(this)      // this refers to person
            console.log(this.name)
        },
        viewName: () => {
            console.log(this)      // this refers to the outer context, usually window
            console.log(this.name)
        }
    }

    person.showName()
    person.viewName()
</script>
```

Arrow functions do not have their own `this`. The value of `this` is determined by the outer lexical scope.

```javascript
// Teaching note: JavaScript example for 2.4.1 Declaration and Features.
// Define a reusable function.
function Counter() {
    this.count = 0;
    setInterval(() => {
        this.count++;
        console.log(this.count);
    }, 1000);
}
// Declare a variable or constant.
let counter = new Counter();
```

#### 2.4.2 Practice Scenario

```html
<!DOCTYPE html>
<!-- Teaching note: This HTML example demonstrates 2.4.2 Practice Scenario. -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Arrow Function Example</title>
    <style>
        /* Style section: write CSS rules here. */
        #box{
            display: inline-block;
            width: 200px;
            height: 200px;
            background-color: red;
        }
    </style>
</head>
<body>
    <div id="box"></div>
    <script>
    // Script section: write JavaScript logic here.
       let box = document.getElementById("box");

       box.onclick = function(){
            setTimeout(() => {
                this.style.backgroundColor = 'pink';
            }, 2000);
        }
    </script>
</body>
</html>
```

#### 2.4.3 Rest and Spread

The rest parameter is used in the parameter list. It is similar to variable-length parameters in Java.

```html
<!-- Teaching note: This HTML example demonstrates 2.4.3 Rest and Spread. -->
<script>
    // Script section: write JavaScript logic here.
    // Define a normal function expression.
    // The rest parameter (...args) collects all arguments into an array.
    let fun1 = function (...args) { 
        console.log(args); // Output all received arguments as an array.
    };

    // Define an arrow function.
    // The rest parameter (...args) also collects all arguments into an array.
    let fun2 = (...args) => { 
        console.log(args); // Output all received arguments as an array.
    };

    // Call fun1 and pass three arguments.
    // Output: [1, 2, 3]
    fun1(1, 2, 3);

    // Call fun2 and pass four arguments.
    // Output: [1, 2, 3, 4]
    fun2(1, 2, 3, 4);
</script>
```

The spread syntax is used in arguments or object/array construction.

```html
<!-- Teaching note: This HTML example demonstrates 2.4.3 Rest and Spread. -->
<script>
    // Script section: write JavaScript logic here.
    // Create an array with three numbers.
    let arr = [1, 2, 3];

    // Define an arrow function with three parameters.
    let fun = (a, b, c) => {
        // Print the values of a, b, and c.
        console.log(a, b, c);
    };

    // Use the spread operator (...) to expand the array.
    // This is the same as: fun(1, 2, 3)
    fun(...arr);

    // Create another array.
    let arr2 = [4, 5, 6];

    // Use the spread operator to merge two arrays into a new array.
    // arr3 becomes [1, 2, 3, 4, 5, 6]
    let arr3 = [...arr, ...arr2];

    // Print the merged array.
    console.log(arr3);

    // Create three objects with different properties.
    let p1 = {name: 'Zhang San'};
    let p2 = {age: 10};
    let p3 = {gender: 'male'};

    // Use the spread operator to merge multiple objects into one object.
    // person becomes {name: 'Zhang San', age: 10, gender: 'male'}
    let person = {...p1, ...p2, ...p3};

    // Print the merged object.
    console.log(person);
</script>
```

### 2.5 Object Creation and Copying in ES6

#### 2.5.1 Syntactic Sugar for Object Creation

ES6 adds `class`, `extends`, `constructor`, and other keywords. This makes JavaScript syntax closer to object-oriented programming.

```javascript
// Teaching note: JavaScript example for 2.5.1 Syntactic Sugar for Object Creation.
// Define a class named Person.
// Define a class as a template for creating objects.
class Person {
    // Declare an instance field named age.
    age;

    // Define a getter method for the name property.
    // When using person.name, this getter will be called.
    get name() {
// Return the result to the caller.
        return this.n;
    }

    // Define a setter method for the name property.
    // When assigning a value to person.name, this setter will be called.
    set name(n) {
        this.n = n;
    }

    // Define an instance method.
    // This method can be called by a Person object.
    eat(food) {
        console.log(`${this.age}-year-old ${this.n} is eating ${food}`);
    }

    // Define a static method.
    // Static methods belong to the class itself, not to the object.
    static sum(a, b) {
// Return the result to the caller.
        return a + b;
    }

    // Define the constructor method.
    // It is called automatically when creating a new object.
    constructor(name, age) {
        this.n = name;
        this.age = age;
    }
}

// Create a Person object.
// Declare a variable or constant.
let person = new Person("Zhang San", 10);

// Access the name property.
// This will call the getter method.
console.log(person.name);

// Modify the name property.
// This will call the setter method.
person.name = "Xiao Ming";

// Call the eat method.
person.eat("hot pot");

// Call the static method using the class name.
// Output: 3
console.log(Person.sum(1, 2));

// Define a Student class that extends the Person class.
// Student inherits the properties and methods from Person.
// Define a class as a template for creating objects.
class Student extends Person {
    constructor(name, age) {
        // Call the constructor of the parent class.
        super(name, age);
    }
}

// Create a Student object.
// Declare a variable or constant.
let stu = new Student("Student Li", 18);

// Call the inherited eat method.
stu.eat("noodles");
```

#### 2.5.2 Shallow Copy and Deep Copy

A shallow copy only copies the reference.

```html
<!-- Teaching note: This HTML example demonstrates 2.5.2 Shallow Copy and Deep Copy. -->
<script>
    // Script section: write JavaScript logic here.
    // Create an array that stores programming languages.
    let arr = ['java', 'c', 'python'];

    // Create an object named person.
    // The language property stores the arr array.
    let person = {
        name: 'Zhang San',
        language: arr
    };

    // Assign person to person2.
    // This does not create a new object.
    // person and person2 point to the same object in memory.
    let person2 = person;

    // Modify the name property through person2.
    person2.name = "Xiao Hei";

    // Because person and person2 refer to the same object,
    // the name property of person is also changed.
    // Output: Xiao Hei
    console.log(person.name);
</script>
```

A deep copy creates a new object.

```html
<!-- Teaching note: This HTML example demonstrates 2.5.2 Shallow Copy and Deep Copy. -->
<script>
    // Script section: write JavaScript logic here.
    // Create an array that stores programming languages.
    let arr = ['java', 'c', 'python'];

    // Create an object named person.
    // The language property stores the arr array.
    let person = {
        name: 'Zhang San',
        language: arr
    };

    // Create a deep copy of the person object.
    // JSON.stringify(person) converts the object into a JSON string.
    // JSON.parse(...) converts the JSON string back into a new object.
    // Therefore, person2 is a new object, not the same object as person.
    let person2 = JSON.parse(JSON.stringify(person));

    // Modify the name property of person2.
    person2.name = "Xiao Hei";

    // Print the name property of the original person object.
    // Output: Zhang San
    console.log(person.name);

    // Print the name property of the copied person2 object.
    // Output: Xiao Hei
    console.log(person2.name);
</script>
```

### 2.6 ES6 Modularization

#### 2.6.1 Introduction to Modularization

Modularization is a way to organize and manage front-end code. It divides code into small modules, making the code easier to maintain, extend, and reuse.

Main advantages:

1. **Better maintainability**: code is divided into clear units.
2. **Better reusability**: repeated logic can be packaged into reusable modules.
3. **Better extensibility**: loosely coupled modules are easier to replace or extend.

Common module specifications include CommonJS, AMD, and ES6 modules. ES6 modules use `import` and `export`.

#### 2.6.2 Named Export

```javascript
// Teaching note: JavaScript example for 2.6.2 Named Export.
// module.js
// Export a named constant so other files can import it.
export const PI = 3.14

export function sum(a, b) {
// Return the result to the caller.
  return a + b;
}

export class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  sayHello() {
    console.log(`Hello, my name is ${this.name}, I'm ${this.age} years old.`);
  }
}
```

```javascript
// Teaching note: JavaScript example for 2.6.2 Named Export.
// app.js
// Import required modules or components.
import * as m1 from './module.js'

console.log(m1.PI)
console.log(m1.sum(10, 20))

// Declare a variable or constant.
let person = new m1.Person('Zhang San', 10)
person.sayHello()
```

```html
<!-- Teaching note: This HTML example demonstrates 2.6.2 Named Export. -->
<!-- index.html -->
<script src="./app.js" type="module"></script>
```

#### 2.6.3 Unified Export

```javascript
// Teaching note: JavaScript example for 2.6.3 Unified Export.
// Declare a variable or constant.
const PI = 3.14

// Define a reusable function.
function sum(a, b) {
// Return the result to the caller.
  return a + b;
}

// Define a class as a template for creating objects.
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  sayHello() {
    console.log(`Hello, my name is ${this.name}, I'm ${this.age} years old.`);
  }
}

// Export several members together.
export {
    PI,
    sum,
    Person
}
```

```javascript
// Teaching note: JavaScript example for 2.6.3 Unified Export.
// Import required modules or components.
import {PI, Person, sum, PI as pi, Person as People, sum as add} from './module.js'

console.log(PI)
console.log(pi)
console.log(sum(10, 20))
console.log(add(10, 20))

// Declare a variable or constant.
let person1 = new Person('Zhang San', 10)
person1.sayHello()
```

#### 2.6.4 Default Export

```javascript
// Teaching note: JavaScript example for 2.6.4 Default Export.
// Export a named constant so other files can import it.
export const PI = 3.14

// Define a reusable function.
function sum(a, b) {
// Return the result to the caller.
  return a + b;
}

// Define a class as a template for creating objects.
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  sayHello() {
    console.log(`Hello, my name is ${this.name}, I'm ${this.age} years old.`);
  }
}

// Export the default value of this module.
export default sum
// Export several members together.
export { Person }
```

```javascript
// Teaching note: JavaScript example for 2.6.4 Default Export.
// Import required modules or components.
import * as m1 from './module.js'
// Import required modules or components.
import {default as add} from './module.js'
// Import required modules or components.
import add2 from './module.js'
// Import required modules or components.
import {PI, Person} from './module.js'

console.log(m1.default(10, 20))
console.log(add(10, 20))
console.log(add2(10, 20))

// Declare a variable or constant.
let person = new Person('Zhang San', 10)
person.sayHello()
console.log(PI)
```

---

## 3. Setting Up the Front-End Engineering Environment

### 3.1 Introduction and Installation of Node.js

#### 3.1.1 What Is Node.js?

Node.js is a JavaScript runtime environment based on the Chrome V8 engine. It allows JavaScript to run on the server side.

With Node.js, we can develop server-side applications, web APIs, back-end services, and command-line tools.

Main features:

- Single-threaded, but event-driven and based on asynchronous I/O, so it can handle high concurrency.
- Lightweight and fast because of the V8 engine.
- Modular, with built-in modules and a large third-party module ecosystem.
- Cross-platform, running on Windows, Linux, and macOS.

#### 3.1.2 How to Install Node.js

1. Open the official website and download the LTS version: <https://nodejs.org/en>
2. Install it with the default options.
3. Check the installation:

```shell
# Teaching note: Commands for 3.1.2 How to Install Node.js.
# Check the installed Node.js version.
node -v
# Check the installed npm version.
npm -v
```

Create an `app.js` file and run it with Node.js.

```javascript
// Teaching note: JavaScript example for 3.1.2 How to Install Node.js.
// Define a reusable function.
function sum(a, b){
// Return the result to the caller.
    return a + b;
}
// Define a reusable function.
function main(){
    console.log(sum(10, 20))
}
main()
```

```shell
# Teaching note: Commands for 3.1.2 How to Install Node.js.
# Run a JavaScript file with Node.js.
node app.js
```

### 3.2 npm Configuration and Usage

#### Why Do We Use npm?

`npm` stands for **Node Package Manager**. It is the official package management tool for Node.js.

In front-end development, many useful libraries and tools are needed, such as:

- React
- Vue
- Axios
- Webpack
- Vite
- Bootstrap

Instead of downloading these libraries manually one by one, developers use npm to automatically install and manage them.

#### Main Reasons for Using npm

##### 1. Install Libraries Easily

Without npm:

- Developers must search websites manually
- Download files manually
- Copy files into the project

With npm:

```bash
npm install axios
```

The library will be downloaded and configured automatically.

------

##### 2. Manage Project Dependencies

Modern front-end projects often use many external packages.

npm records all required packages in a file called:

```text
package.json
```

This makes the project easier to share and maintain.

For example:

```json
{
  "dependencies": {
    "axios": "^1.0.0",
    "vue": "^3.0.0"
  }
}
```

Other developers only need to run:

```bash
npm install
```

and all dependencies will be installed automatically.

------

##### 3. Improve Development Efficiency

npm can also install development tools, such as:

- Code bundlers
- Development servers
- Automatic refresh tools
- CSS preprocessors

Example:

```bash
npm install vite
```

This helps developers build projects faster and more efficiently.

------

##### 4. Version Management

Different projects may require different library versions.

npm can manage package versions automatically and avoid conflicts.

Example:

```bash
npm install react@18
```

This installs a specific version of React.

------

##### 5. Modern Front-End Development Depends on npm

Most modern front-end frameworks and tools are based on npm, including:

- React
- Vue.js
- Angular
- Vite
- Webpack

Therefore, learning npm is an important part of front-end engineering.

------

### Simple Summary

npm is used to:

- Install libraries quickly
- Manage project dependencies
- Improve development efficiency
- Manage package versions
- Support modern front-end development workflows

Without npm, front-end development would become much slower and harder to maintain.

#### 3.2.2 npm Installation and Configuration

npm is installed automatically when Node.js is installed.

Configure a mirror source:

```shell
# Teaching note: Commands for 3.2.2 npm Installation and Configuration.
# Set npm to use a faster mirror registry.
npm config set registry https://registry.npmmirror.com
```

Check the current registry:

```shell
# Teaching note: Commands for 3.2.2 npm Installation and Configuration.
# View the current npm registry address.
npm config get registry
```

Restore the official source:

```shell
# Teaching note: Commands for 3.2.2 npm Installation and Configuration.
# Restore npm to the official registry.
npm config set registry https://registry.npmjs.org/
```

Configure the global dependency installation path on Windows:

```shell
# Teaching note: Commands for 3.2.2 npm Installation and Configuration.
# Set the global npm package installation directory.
npm config set prefix "D:\GlobalNodeModules"
# Check the global npm package installation directory.
npm config get prefix
```

Upgrade npm:

```shell
# Teaching note: Commands for 3.2.2 npm Installation and Configuration.
# Upgrade npm globally to the specified version.
npm install -g npm@9.6.6
```

#### 3.2.3 Common npm Commands

Initialize a project:

```shell
# Teaching note: Commands for 3.2.3 Common npm Commands.
# Initialize a project and answer questions step by step.
npm init
# Initialize a project quickly with default settings.
npm init -y
```

Install dependencies:

```shell
# Teaching note: Commands for 3.2.3 Common npm Commands.
# Install a dependency into the current project.
npm install jquery
# Install a specific version of a dependency.
npm install package-name@version
# Install a dependency globally.
npm install -g package-name
# Install all dependencies listed in package.json.
npm install
```

Update, uninstall, and list dependencies:

```shell
# Teaching note: Commands for 3.2.3 Common npm Commands.
# Update an installed dependency.
npm update package-name
# Remove an installed dependency.
npm uninstall package-name
# List local project dependencies.
npm ls
# List globally installed npm packages.
npm list -g
```

Run scripts defined in `package.json`:

```shell
# Teaching note: Commands for 3.2.3 Common npm Commands.
# Start the development server.
npm run dev
# Build the project for production.
npm run build
# Preview the production build locally.
npm run preview
```

Example `package.json`:

```jsonc
// Teaching note: JSON-style configuration example for 3.2.3 Common npm Commands.
// Real JSON files do not support comments; remove these comment lines before copying into package.json.
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

---

## 4. Introduction to Vue 3 and Quick Experience

### 4.1 Introduction to Vue 3

Vue is a JavaScript framework for building user interfaces. It is based on standard HTML, CSS, and JavaScript. It provides a declarative and component-based programming model.

Official website: <https://vuejs.org/>

Two core features of Vue:

- **Declarative rendering**: Vue extends HTML with template syntax, allowing us to describe the relationship between HTML output and JavaScript state.
- **Reactivity**: Vue automatically tracks JavaScript state changes and updates the DOM accordingly.

Vue was created by Evan You.

### 4.2 Quick Vue 3 Experience Without Engineering Tools

```html
<!DOCTYPE html>
<!-- Teaching note: This HTML example demonstrates 4.2 Quick Vue 3 Experience Without Engineering Tools. -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vue 3 Quick Demo</title>
</head>
<body>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>

    <div id="app">
       <h1 v-bind:style="colorStyle">{{headline}}</h1>
       <p v-text="article"></p>
       <input v-bind:type="inputType" value="helloVue3"> <br>
       <button @click="sayHello()">hello</button>
    </div>

    <script>
    // Script section: write JavaScript logic here.
        const app = Vue.createApp({
            setup(){
                let inputType = 'text'
                let headline = 'hello vue3'
                let article = 'vue is awesome'
                let colorStyle = {'color': 'red'}

                let sayHello = () => {
                    alert("hello Vue")
                }

                return {
                   inputType,
                   headline,
                   article,
                   colorStyle,
                   sayHello
                }
            }
        });
        app.mount("#app");
    </script>
</body>
</html>
```

---

## 5. Building Vue 3 Projects with Vite

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
// Teaching note: Script section for 5.2.4 Reactivity and the setup Function.
import {ref} from 'vue'
export default{
    setup(){
        let counter = ref(1)

        function increase(){
            counter.value++
        }

        function decrease(){
            counter.value--
        }

        return {
            counter,
            increase,
            decrease
        }
    }
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

#### 5.2.6 JavaScript or TypeScript?

TypeScript is a superset of JavaScript. It makes JavaScript syntax closer to Java and is widely used in real projects.

In this course, we start with JavaScript for the following reasons:

1. It reduces the learning difficulty.
2. Java students can learn TypeScript relatively easily later.
3. TypeScript is useful, but not required for basic Vue engineering.
4. After learning the complete front-end engineering workflow, students can learn TypeScript separately.

---

## 6. Vue 3 View Rendering Techniques

### 6.1 Template Syntax

Vue uses an HTML-based template syntax. It allows us to declaratively bind data to the DOM.

#### 6.1.1 Interpolation and Text Rendering

Interpolation uses the Mustache syntax `{{ }}`.

```vue
<script setup type="module">
// Teaching note: Script section for 6.1.1 Interpolation and Text Rendering.
let msg = "hello vue3"
let getMsg = () => 'hello vue3 message'
let age = 19
let bee = 'bee honey'

const carts = [
  {name:'cola', price:3, number:10},
  {name:'chips', price:6, number:8}
]

function compute(){
    let count = 0;
    for(let index in carts){
        count += carts[index].price * carts[index].number;
    }
    return count;
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1>{{ msg }}</h1>
    Message value: {{ msg }} <br>
    Function result: {{ getMsg() }} <br>
    Adult: {{ age >= 18 ? 'true' : 'false' }} <br>
    Reverse: {{ bee.split(' ').reverse().join('-') }} <br>
    Total amount: {{ compute() }} <br/>
  </div>
</template>
```

Vue also provides `v-text` and `v-html`.

- `v-text` renders plain text.
- `v-html` renders HTML strings.

```vue
<script setup type="module">
// Teaching note: Script section for 6.1.1 Interpolation and Text Rendering.
let msg = 'hello vue3'
let redMsg = '<font color=\'red\'>msg</font>'
let greenMsg = `<font color='green'>${msg}</font>`
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <span v-text="msg"></span> <br>
    <span v-text="redMsg"></span> <br>
    <span v-html="redMsg"></span> <br>
    <span v-html="greenMsg"></span> <br>
  </div>
</template>
```

#### 6.1.2 Attribute Rendering

To bind an attribute of an element, use `v-bind`. It can be shortened to `:`.

```vue
<script setup type="module">
// Teaching note: Script section for 6.1.2 Attribute Rendering.
const data = {
    name:'Atguigu',
    url:'http://www.atguigu.com',
    logo:'http://www.atguigu.com/images/index_new/logo.png'
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <a :href="data.url" target="_self">
      <img :src="data.logo" :title="data.name">
      <br>
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
<script setup type="module">
// Teaching note: Script section for 6.2.3 reactive.
import {reactive} from 'vue'

let data = reactive({
  counter: 0
})

function show(){
    alert(data.counter);
}

let decr = () => {
  data.counter--;
}

let incr = () => {
  data.counter++;
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <button @click="decr()">-</button>
    {{ data.counter }}
    <button @click="incr()">+</button>
    <hr>
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
<script setup type="module">
// Teaching note: Script section for 6.3.1 Conditional Rendering.
import {ref} from 'vue'
let awesome = ref(true)
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <h1 v-if="awesome">Vue is awesome!</h1>
    <h1 v-else>Oh no 😢</h1>
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
<script setup type="module">
// Teaching note: Script section for 6.3.2 List Rendering.
import {ref, reactive} from 'vue'

let parentMessage = ref('Product')
let items = reactive([
  { id:'item1', message:'chips' },
  { id:'item2', message:'cola' }
])
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.message }}
      </li>
    </ul>

    <ul>
      <li v-for="(item, index) in items" :key="index">
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
  let count = 0;
  for(let index in carts){
    count += carts[index].price * carts[index].number;
  }
  return count;
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
<script setup type="module">
// Teaching note: Script section for 6.4 Two-Way Binding.
import { reactive, ref } from 'vue'

let hbs = ref([])
let user = reactive({
  username: null,
  password: null,
  introduce: null,
  pro: null
})

function login(){
  alert(hbs.value);
  alert(JSON.stringify(user));
}

function clearx(){
  user.username = ''
  user.password = ''
  user.introduce = ''
  user.pro = ''
  hbs.value.splice(0, hbs.value.length)
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    Account: <input type="text" v-model="user.username"> <br>
    Password: <input type="text" v-model="user.password"> <br>
    Hobbies:
    Eat <input type="checkbox" v-model="hbs" value="eat">
    Drink <input type="checkbox" v-model="hbs" value="drink">
    Play <input type="checkbox" v-model="hbs" value="play">
    <br>
    Introduction:<textarea v-model="user.introduce"></textarea>
    <br>
    Province:
    <select v-model="user.pro">
      <option value="1">Heilongjiang</option>
      <option value="2">Jilin</option>
      <option value="3">Liaoning</option>
      <option value="4">Beijing</option>
    </select>
    <br>
    <button @click="login()">Login</button>
    <button @click="clearx()">Reset</button>
    <hr>
    Hobbies: {{ hbs }}
    <hr>
    User information: {{ user }}
  </div>
</template>
```

### 6.5 Computed Properties

Templates should not contain too much complex logic. Computed properties help us describe derived values based on reactive state.

```vue
<script setup type="module">
// Teaching note: Script section for 6.5 Computed Properties.
import { reactive, computed } from 'vue'

const author = reactive({
  name: 'John Doe',
  books: [
    'Vue 2 - Advanced Guide',
    'Vue 3 - Basic Guide',
    'Vue 4 - The Mystery'
  ]
})

const publishedBooksMessage = computed(() => {
  console.log('publishedBooksMessage')
  return author.books.length > 0 ? 'Yes' : 'No'
})

let hasBooks = () => {
  console.log('hasBooks')
  return author.books.length > 0 ? 'Yes' : 'No'
}
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <p>{{ author.name }} has published books?</p>
    <span>{{ hasBooks() }}</span>
    <span>{{ hasBooks() }}</span>

    <p>{{ author.name }} has published books?</p>
    <span>{{ publishedBooksMessage }}</span>
    <span>{{ publishedBooksMessage }}</span>
  </div>
</template>
```

A computed property is cached based on its reactive dependencies. A method is executed each time it is called.

### 6.6 Watchers

Watchers are used to perform side effects when data changes, such as updating another state, sending requests, or operating on the DOM.

```vue
<script setup type="module">
// Teaching note: Script section for 6.6 Watchers.
import { ref, reactive, watch } from 'vue'

let firstname = ref('')
let lastname = reactive({name:''})
let fullname = ref('')

watch(firstname, (newValue, oldValue) => {
  console.log(`${oldValue} changed to ${newValue}`)
  fullname.value = firstname.value + lastname.name
})

watch(() => lastname.name, (newValue, oldValue) => {
  console.log(`${oldValue} changed to ${newValue}`)
  fullname.value = firstname.value + lastname.name
})

watch(() => lastname, (newValue, oldValue) => {
  fullname.value = firstname.value + lastname.name
}, {deep:true, immediate:false})
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    Full name: {{ fullname }} <br>
    First name: <input type="text" v-model="firstname"> <br>
    Last name: <input type="text" v-model="lastname.name"> <br>
  </div>
</template>
```

`watchEffect` automatically tracks all reactive data used inside it.

```vue
<script setup type="module">
// Teaching note: Script section for 6.6 Watchers.
import { ref, reactive, watchEffect } from 'vue'

let firstname = ref('')
let lastname = reactive({name:''})
let fullname = ref('')

watchEffect(() => {
  fullname.value = `${firstname.value}${lastname.name}`
})
</script>
```

Difference:

- `watch` tracks explicitly declared data sources.
- `watchEffect` automatically tracks dependencies used during execution.

### 6.7 Vue Lifecycle

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
// Teaching note: Script section for 6.8.2 Component Example.
import Header from './components/Header.vue'
import Navigator from './components/Navigator.vue'
import Content from './components/Content.vue'
</script>

<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <Header class="header"></Header>
    <Navigator class="navigator"></Navigator>
    <Content class="content"></Content>
  </div>
</template>

<style scoped>
/* Style section: define styles that apply to this component. */
.header{
  height: 80px;
  border: 1px solid red;
}
.navigator{
  width: 15%;
  height: 800px;
  display: inline-block;
  border: 1px blue solid;
  float: left;
}
.content{
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
