<!-- Teaching note: Vue component example for 6.8.2 Component Example. -->
<!-- Navigator.vue -->
<script setup>
import {defineEmits} from 'vue'

const emits = defineEmits(["sendMenu"])

function Send(data){
    emits("sendMenu",data)
}

</script>
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>
    <ul>
      <li @click="Send('Student Management')">Student Management</li>
      <li @click="Send('Book Management')">Book Management</li>
      <li @click="Send('Leave Management')">Leave Management</li>
      <li @click="Send('Exam Management')">Exam Management</li>
      <li @click="Send('Teacher Management')">Teacher Management</li>
    </ul>
  </div>
</template>