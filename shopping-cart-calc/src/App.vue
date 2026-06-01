<script setup>
import { ref } from 'vue'

const products = ref([
  { name: 'cola', price: 3, number: 10 },
  { name: 'chips', price: 6, number: 8 },
])

function compute() {
  let total = 0
  for (let i = 0; i < products.value.length; i++) {
    total += products.value[i].price * products.value[i].number
  }
  return total
}

function deleteProduct(index) {
  products.value.splice(index, 1)
}
</script>

<template>
  <div class="cart">
    <h2>Shopping Cart</h2>
    <table>
      <thead>
        <tr>
          <th>Product</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Subtotal</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(product, index) in products" :key="index">
          <td>{{ product.name }}</td>
          <td>{{ product.price }}</td>
          <td>{{ product.number }}</td>
          <td>{{ product.price * product.number }}</td>
          <td>
            <button @click="deleteProduct(index)">Delete</button>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="3"><strong>Total Amount</strong></td>
          <td colspan="2"><strong>{{ compute() }} yuan</strong></td>
        </tr>
      </tfoot>
    </table>
  </div>
</template>

<style scoped>
.cart {
  max-width: 600px;
  margin: 2rem auto;
  font-family: Arial, sans-serif;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th,
td {
  border: 1px solid #ddd;
  padding: 10px 14px;
  text-align: center;
}

th {
  background-color: #f0f0f0;
  color: #333;
}

button {
  background-color: #3498db;
  color: white;
  border: none;
  padding: 6px 14px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #2980b9;
}
</style>
