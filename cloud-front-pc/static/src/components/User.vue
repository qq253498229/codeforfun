<template>
  <div class="container">
    <div class="panel panel-default ">
      <div class="panel-heading">
        <h3 class="panel-title">
          用户管理
          <button class="btn btn-sm btn-primary">添加用户</button>
        </h3>
      </div>
      <div class="panel-body">
        <table class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(data,index) in dataList">
            <td v-text="index+1"></td>
            <td v-text="data.username"></td>
            <td v-text="data.password"></td>
            <td></td>
          </tr>
          </tbody>
        </table>

        <page :totalItems="dataCount" :displayPages="showPageCount"
              :pageNo="pageNo" :pageSize="pageSize"
              :pageChange="onInit"></page>

      </div>
    </div>
  </div>
</template>
<script>
  import page from '../common/Page.vue'
  import axios from '../http'

  export default {
    components: {
      page
    },
    data() {
      return {
        showPageCount: 6,
        pageNo: 1,
        pageSize: 10,
        dataCount: 0,
        dataList: []
      };
    }
    ,
    mounted() {
      this.onInit(1);
    },
    methods: {
      onInit(pageNo) {
        axios.get('api/cloud-user/' + (pageNo ? pageNo : 1) + '/' + 10).then(resp => {
          if (resp.status === 200) {
            this.dataList = resp.data.content;
            this.dataCount = resp.data.totalElements;

          }
        });
      },
    }
  }
</script>
<style>
</style>
