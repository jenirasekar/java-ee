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