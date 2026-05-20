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