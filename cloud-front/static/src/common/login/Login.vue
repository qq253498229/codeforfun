<template>
  <div class="signin">
    <div class="signin-head text-center">
      <h1><b>用户登录</b></h1>
    </div>
    <form class="form-signin" role="form">
      <input type="text" class="form-control" placeholder="用户名" required autofocus v-model="user.username"/>
      <input type="password" class="form-control" placeholder="密码" required v-model="user.password"/>
      <button type="button" class="btn btn-lg btn-warning btn-block" @click="login">登录</button>
    </form>
  </div>
</template>
<script>
  import * as types from "../../store/types"
  import token from '../../store/store'
  import axios from 'axios'

  export default {
    data() {
      return {
        user: {
          username: 'admin',
          password: 'admin',
          grant_type: 'password'
        }
      }
    },
    mounted() {
      this.$store.commit(types.TITLE, 'Login');
    },
    methods: {
      login() {
        let formData = new FormData();
        formData.append('username', this.user.username);
        formData.append('password', this.user.password);
        formData.append('grant_type', 'password');
        this.$http.post(
          'oauth/token',
          // 请求体重发送数据给服务端
          formData, {
            'headers': {
              'Content-Type': 'x-www-form-urlencoded',
              'Authorization': 'Basic ' + btoa('client:secret')
            }
          }).then(function (res) {
          // 成功回调
          console.log(res)
          if (res.ok === true || res.status === 200) {
            this.$store.commit(types.LOGIN, res.body)
            this.$router.push(this.$route.query.redirect || '/')
          }
        }, function (err) {
          // 失败回调
          console.log(err)
        });
        console.log(this.user);
      }
    }
  }
</script>
<style>
  @import "css/login.css";

  .signin-head {
    height: 150px;
    width: inherit;
  }
</style>
