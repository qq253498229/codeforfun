import Vue from 'vue'
import Router from 'vue-router'
import Hello from '../components/Hello.vue'
import Home from '../components/Home.vue'
import User from '../components/User.vue'
import Teacher from '../components/Teacher.vue'
import Course from '../components/Course.vue'
import Login from '../common/login/Login.vue'
import store from '../store/store'

Vue.use(Router)


const router = new Router({
  routes: [
    {
      path: '',
      component: Home,
      children: [
        {
          path: '',
          component: Hello
        },
        {
          path: '/user',
          component: User,
          meta: {requiresAuth: true}
        },
        {
          path: '/teacher',
          component: Teacher
        },
        {
          path: '/course',
          component: Course
        }
      ]
    },
    {
      path: '/login',
      component: Login
    }
  ]
})

export default router


router.beforeEach((to, from, next) => {
  if (to.matched.some(r => r.meta.requiresAuth)) {
    if (store.state.token) {
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  }
  else {
    next();
  }
})

