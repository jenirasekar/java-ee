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