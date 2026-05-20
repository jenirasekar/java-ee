<!-- Teaching note: Vue component example for 6.8.2 Component Example. -->
<!-- Content.vue -->
<script setup>
import {defineProps} from "vue"

defineProps({
    message:String
})


</script>
<template>
  <!-- Template section: define the page structure displayed in the browser. -->
  <div>{{message}}</div>
</template>