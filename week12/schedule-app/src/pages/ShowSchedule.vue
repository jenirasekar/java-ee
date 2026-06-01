<script setup>
/*
  Import Pinia stores.
  defineUser is used to get the current logged-in user.
  defindSchedule is used to store the schedule list.
*/
import { defineUser } from "../store/userStore.js";
import { defindSchedule } from "../store/scheduleStore.js";

import { onMounted } from "vue";

// Get Pinia store objects
let sysUser = defineUser();
let schedule = defindSchedule();

/*
  Get the current username.

  In the previous Login page, we saved the login status into sessionStorage.
  If the page is refreshed, Pinia data may be lost,
  so we can also read the username from sessionStorage.
*/
function getCurrentUsername() {
  return sysUser.username || sessionStorage.getItem("loginUser") || "guest";
}

/*
  Generate a localStorage key for the current user.

  Different users should have different schedule lists.
  For example:
  scheduleList_tom
  scheduleList_jack
*/
function getStorageKey() {
  return "scheduleList_" + getCurrentUsername();
}

/*
  Load schedule data from localStorage.

  This function is called when the component is mounted.
*/
function loadSchedule() {
  let storageKey = getStorageKey();
  let savedList = localStorage.getItem(storageKey);

  if (savedList) {
    // If there is saved schedule data, convert JSON string to array
    schedule.itemList = JSON.parse(savedList);
  } else {
    // If there is no saved data, create some default schedule items
    schedule.itemList = [
      {
        sid: 1,
        title: "Learn Vue Router",
        completed: "0",
      },
      {
        sid: 2,
        title: "Practice schedule management",
        completed: "1",
      },
    ];

    // Save the default data into localStorage
    saveSchedule();
  }
}

/*
  Save schedule data to localStorage.

  localStorage can only store strings,
  so we need to convert the schedule list to a JSON string.
*/
function saveSchedule() {
  let storageKey = getStorageKey();
  localStorage.setItem(storageKey, JSON.stringify(schedule.itemList));
}

/*
  When the component is mounted,
  load all schedules of the current user.
*/
onMounted(() => {
  loadSchedule();
});

/*
  Add a new empty schedule item.

  In the original back-end version, this operation should send a request
  to the server and insert a new record into the database.

  In this pure front-end version, we only add the new item to Pinia
  and then save it to localStorage.
*/
function addItem() {
  let newItem = {
    sid: Date.now(),
    title: "",
    completed: "0",
  };

  schedule.itemList.push(newItem);
  saveSchedule();

  alert("Schedule added successfully.");
}

/*
  Save the modified schedule item.

  In the pure front-end version, the data has already been changed
  by v-model. So we only need to save the whole list to localStorage.
*/
function updateItem(index) {
  let item = schedule.itemList[index];

  if (!item.title.trim()) {
    alert("Schedule content cannot be empty.");
    return;
  }

  saveSchedule();
  alert("Schedule updated successfully.");
}

/*
  Remove a schedule item.

  In the original back-end version, this operation should send sid
  to the server and delete the record from the database.

  In this pure front-end version, we delete it from the array directly.
*/
function removeItem(index) {
  let result = confirm("Are you sure you want to delete this schedule?");

  if (!result) {
    return;
  }

  schedule.itemList.splice(index, 1);
  saveSchedule();

  alert("Schedule deleted successfully.");
}
</script>

<template>
  <div>
    <h3 class="ht">Your Schedule List</h3>

    <table class="tab" cellspacing="0px">
      <thead>
        <tr class="ltr">
          <th>No.</th>
          <th>Content</th>
          <th>Status</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody>
        <tr class="ltr" v-for="(item, index) in schedule.itemList" :key="item.sid">
          <td v-text="index + 1"></td>

          <td>
            <input class="ipt" type="text" v-model="item.title" placeholder="Please enter schedule content" />
          </td>

          <td>
            <input type="radio" value="1" v-model="item.completed" />
            Completed

            <input type="radio" value="0" v-model="item.completed" />
            Not completed
          </td>

          <td class="buttonContainer">
            <button class="btn1" @click="removeItem(index)">Delete</button>

            <button class="btn1" @click="updateItem(index)">Save</button>
          </td>
        </tr>
      </tbody>
      <tbody>
        <tr class="ltr buttonContainer">
          <td colspan="4">
            <button class="btn1" @click="addItem()">Add Schedule</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Table container style */
.tab {
  width: 80%;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: Arial, sans-serif;
}

/* Table cell style */
.ltr td {
  border: 1px solid powderblue;
}

/* Input box style */
.ipt {
  border: 0px;
  width: 80%;
}

/* Button style */
.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 120px;
  background-color: antiquewhite;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>
