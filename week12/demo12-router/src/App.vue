<template>
  <div>
    <h2>Vue Router Example</h2>

    <router-link to="/home">Home</router-link> |
    <router-link to="/list">List</router-link> |
    <router-link to="/add">Add</router-link> |
    <router-link to="/update">Update</router-link> |
    <router-link to="/showAll">showAll</router-link>

    <hr>

    <!-- The matched component will be displayed here -->
    <router-view></router-view>
  </div>
</template>