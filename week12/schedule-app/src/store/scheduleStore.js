import { defineStore } from 'pinia'

export const defindSchedule = defineStore('scheduleList', {
  state: () => ({
    itemList: []
  }),
  getters: {},
  actions: {
    setList(list) {
      this.itemList = list
    },
    clearList() {
      this.itemList = []
    }
  }
})