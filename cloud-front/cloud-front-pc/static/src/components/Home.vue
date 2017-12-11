<template>
  <div>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <router-link to="/" class="navbar-brand">学生管理系统</router-link>
          <!--<a class="navbar-brand" href="#">学生管理系统</a>-->
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li :class="{active:$route.path=='/user'}">
              <router-link to="/user">用户管理</router-link>
            </li>
            <li :class="{active:$route.path=='/teacher'}">
              <router-link to="/teacher">教师管理</router-link>
            </li>
            <li :class="{active:$route.path=='/course'}">
              <router-link to="/course">课程管理</router-link>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Dropdown <span
                class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div>
    </nav>
    <router-view></router-view>
  </div>
</template>
<script>

</script>
<style>
  body {
    background-color: #eee;
    padding-top: 70px;
  }
</style>
