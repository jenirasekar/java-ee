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
import {ref} from 'vue'

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

let menu = ref("")
function receiver(data){
  menu.value = data

}

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
    {{menu}}

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
    <Navigator @sendMenu="receiver" class="navigator"></Navigator>

    <!-- 
        Use the Content component.

        This component is used as the main content area.
    -->
    <Content class="content" :message="menu"></Content>

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