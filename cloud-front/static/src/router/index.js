import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Student from '@/components/Student'
import Teacher from '@/components/Teacher'
import Course from '@/components/Course'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/student',
      name: 'Student',
      component: Student
    },
    {
      path: '/teacher',
      name: 'Teacher',
      component: Teacher
    },
    {
      path: '/course',
      name: 'Course',
      component: Course
    }
  ]
})
