<template>
  <div class="hello">
    <mt-tab-container class="page-tabbar-container" v-model="selected">
      <mt-tab-container-item id="外卖">
        <mt-cell v-for="n in 10" :title="'餐厅 ' + n"/>
      </mt-tab-container-item>
      <mt-tab-container-item id="订单">
        <mt-cell v-for="n in 5" :title="'订单 ' + n"/>
      </mt-tab-container-item>
      <mt-tab-container-item id="发现">
        <mt-cell v-for="n in 7" :title="'发现 ' + n"/>
      </mt-tab-container-item>
      <mt-tab-container-item id="我的">
        <div class="page-part">
          <mt-cell v-for="n in 12" :title="'我的 ' + n"/>
        </div>
        <router-link to="/">
          <mt-button type="danger" size="large">退出</mt-button>
        </router-link>
      </mt-tab-container-item>
    </mt-tab-container>
    <mt-tabbar v-model="selected" fixed>
      <mt-tab-item id="外卖">
        <img slot="icon">
        外卖
      </mt-tab-item>
      <mt-tab-item id="订单">
        <img slot="icon">
        订单
      </mt-tab-item>
      <mt-tab-item id="发现">
        <img slot="icon">
        发现
      </mt-tab-item>
      <mt-tab-item id="我的">
        <img slot="icon">
        我的
      </mt-tab-item>
    </mt-tabbar>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        selected: '外卖',
        active: '外卖'
      }
    },
    methods: {
      btnClick() {
        Toast({
          message: this.msg,
          position: 'bottom',
          duration: 5000
        });
      }
    }
  }
</script>
