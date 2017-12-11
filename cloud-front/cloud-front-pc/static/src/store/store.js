/**
 * https://github.com/superman66/vue-axios-github
 * Created by superman on 17/2/16.
 */
import Vue from 'vue'
import Vuex from 'vuex'
import * as types from './types'

Vue.use(Vuex);
const store = new Vuex.Store({
  state: {
    user: {},
    token: {
      access_token: '',
      token_type: '',
      refresh_token: '',
      expires_in: 0,
      scope: ''
    },
    title: ''
  },
  mutations: {
    [types.LOGIN]: (state, data) => {
      localStorage.token = JSON.stringify(data);
      state.token = data;
    },
    [types.LOGOUT]: (state) => {
      localStorage.removeItem('token');
      state.token = null
    },
    [types.TITLE]: (state, data) => {
      state.title = data;
    }
  }
})

export default store

// 页面刷新时，重新赋值token
if (window.localStorage.getItem('token')) {
  store.commit(types.LOGIN, JSON.parse(window.localStorage.getItem('token')))
}
