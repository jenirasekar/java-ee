import { createRouter, createWebHistory } from 'vue-router'

import Login from './pages/Login.vue'
import Regist from './pages/Regist.vue'
import ShowSchedule from './pages/ShowSchedule.vue'

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/regist',
        component: Regist
    },
    {
        path: '/showSchedule',
        component: ShowSchedule
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    const isLogin = sessionStorage.getItem('isLogin')
    if (to.path === '/showSchedule' && !isLogin) {
        next('/login')
    } else {
        next()
    }
})

export default router