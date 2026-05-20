<script setup>
/*
    Teaching note:
    This example demonstrates list rendering in Vue 3.

    Main points:
    1. Use reactive() to create a reactive array.
    2. Use v-for to render table rows.
    3. Use v-if and v-else to display different table content.
    4. Use splice() to delete an item from the array.
    5. Use a function to calculate the total amount.
*/

import { reactive } from 'vue'

/*
    Create a reactive shopping cart array.

    Each element in the array is an object.
    Each object represents one product in the shopping cart.

    name   -> product name
    price  -> product price
    number -> product quantity
*/
const carts = reactive([
  { name: 'cola', price: 3, number: 10 },
  { name: 'chips', price: 6, number: 8 }
])

/*
    Define a function to calculate the total amount.

    Total amount = price * number for each product,
    then add all subtotals together.
*/
function compute() {
  let count = 0

  /*
      Use for...in to loop through the carts array.

      index represents the index of each product in the array.
      For example:
      carts[0] is cola
      carts[1] is chips
  */
//   write here

  /*
      Return the final total amount.
  */
  return count
}

/*
    Define a function to delete a product from the shopping cart.

    index represents the position of the product in the carts array.

    carts.splice(index, 1) means:
    starting from index, delete 1 element.
*/
function removeCart(index) {
  carts.splice(index, 1)
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Use a table to display shopping cart information.
    -->
    <table>

      <!-- 
          The table header.
          It defines the names of each column.
      -->
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

      <!-- 
          v-if="carts.length > 0" means:

          If the shopping cart is not empty,
          display the product list.
      -->
      <tbody v-if="carts.length > 0">

        <!-- 
            Use v-for to render each product as one table row.

            cart  -> the current product object
            index -> the current product index

            :key="index" helps Vue identify each row.
        -->
        <tr v-for="(cart, index) in carts" :key="index">

          <!-- 
              Display product number.

              Because index starts from 0,
              we use index + 1 to display normal numbering.
          -->
          <td>{{ index + 1 }}</td>

          <!-- 
              Display product name.
          -->
          <td>{{ cart.name }}</td>

          <!-- 
              Display product price.
          -->
          <td>{{ cart.price + ' yuan' }}</td>

          <!-- 
              Display product quantity.
          -->
          <td>{{ cart.number }}</td>

          <!-- 
              Display product subtotal.

              Subtotal = price * quantity
          -->
          <td>{{ cart.price * cart.number + ' yuan' }}</td>

          <!-- 
              Delete button.

              When the button is clicked,
              removeCart(index) will be executed.

              The current product will be removed from carts.
          -->
          <td>
            <button @click="removeCart(index)">Delete</button>
          </td>
        </tr>
      </tbody>

      <!-- 
          v-else means:

          If carts.length > 0 is false,
          the shopping cart is empty.

          Then display this message.
      -->
      <tbody v-else>
        <tr>
          <!-- 
              colspan="6" means this cell spans 6 columns.

              It makes the empty message occupy the whole table row.
          -->
          <td colspan="6">The shopping cart is empty.</td>
        </tr>
      </tbody>
    </table>

    <!-- 
        Call compute() to calculate the total amount.

        Initial calculation:
        cola: 3 * 10 = 30
        chips: 6 * 8 = 48
        total: 30 + 48 = 78
    -->
    Total amount: {{ compute() }} yuan

  </div>
</template>




<!-- let count = 0;
  for(let index in carts){
    count += carts[index].price * carts[index].number;
  }
  return count; -->