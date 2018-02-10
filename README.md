# codeforfun
spring cloud demo

> ngrok请大家不用的时候即时关闭，微信端的地址也请修改掉。为了大家的使用，降低服务器压力，文明你我他

> http://init.codeforfun.cn 是spring initializr项目的移植，在IDE创建spring项目的时候可能会有帮助

## 简介

- 1.技术体系
  - 1.1 前端
  - 1.2 后端
  - 1.3 部署
- 2.模块简介
  - 2.1 基础模块
  - 2.2 微服务

### 技术体系

#### 1.1 前端

- vue
- vuex
- vue-router
- vue-resource
- webpack
- axios
- bootstrap

#### 1.2 后端

- springcloud version: Dalston.SR4
- springboot version: 1.5.6.RELEASE
- swagger2 提供api
- oauth2 提供权限认证
- mysql 数据库 

#### 1.3 部署

- 采用docker

### 模块简介

#### 2.1基础模块

[cloud-eureka](cloud-eureka) 服务注册中心 -- 端口8761

[cloud-config](cloud-config) 配置中心 -- 端口8000

[cloud-hystrix](cloud-hystrix) 监控面板 -- 端口8300

[cloud-turbine](cloud-turbine) 监控聚合 -- 端口8400

[cloud-oauth2-server](cloud-oauth2-server) 认证中心 -- 端口8110

[cloud-gateway](cloud-gateway) 服务网关 -- 端口8888

[cloud-repo](cloud-repo) 配置文件

#### 2.2微服务

[cloud-user](cloud-user) 用户模块

[cloud-wechat](cloud-wechat) 微信模块


`cloud-nginx中的cert证书文件因为安全问题已经删除，请根据自己的需求修改配置`