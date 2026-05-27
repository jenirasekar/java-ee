import { defineStore } from 'pinia'

export const defineUser = defineStore('user', {
  state: () => ({
    username: '',
    uid: null
  }),
  actions: {
    setUser(name) {
      this.username = name
    },
    clearUser() {
      this.username = ''
      this.uid = null
    }
  }
})