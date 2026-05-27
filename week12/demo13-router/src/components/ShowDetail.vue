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