<template>
  <div class="inline-block">
    <nav aria-label="Page navigation">
      <ul class="pagination">
        <li :class="{disabled : pageNo==1}">
          <a href="javascript:void(0);" aria-label="Previous" v-if="pageNo==1">
            <span>&laquo;</span>
          </a>
          <a href="javascript:void(0);" aria-label="Previous" @click="goto(pageNo-1)" v-if="pageNo>1">
            <span>&laquo;</span>
          </a>
        </li>
        <li v-for="page in totalPagesList" :class="{active : pageNo==page}">
          <a href="javascript:void(0);" v-text="page" @click="goto(page)"></a>
        </li>
        <li :class="{disabled: pageNo==totalPages}">
          <a href="javascript:void(0);" aria-label="Next" v-if="pageNo==totalPages">
            <span>&raquo;</span>
          </a>
          <a href="javascript:void(0);" aria-label="Next" @click="goto(pageNo+1)" v-if="pageNo<totalPages">
            <span>&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>
<script>
  export default {
    props: {
      //是否隐藏每页条数下拉框，默认隐藏
      hiddenPageChange: {
        type: Boolean,
        default: true
      },
      //每页条数
      pageSize: {
        type: Number,
        default: 10
      },
      //总条数
      totalItems: {
        type: Number,
        default: 0
      },
      //显示几页
      displayPages: {
        type: Number,
        default: 6
      },
      //分页变化返回事件
      pageChange: {
        type: Function
      }
    },
    data() {
      return {
        totalPages: false,//总页数
        //分页数组
        totalPagesList: [],
        //页码(从1开始)
        pageNo: 1
      }
    },
    watch: {
      'pageSize'(newVal, oldVal) {
        this.changePageList();
      },
      'totalItems'(newVal, oldVal) {
        this.changePageList();
      }
    },
    methods: {
      pageSizeChange(event) {
        this.changePageList();
      },
      /**
       * 跳转到第N页
       * @param pageNumber
       */
      goto(pageNumber) {
        if (this.pageNo === pageNumber) return;
        this.pageNo = pageNumber;
        this.changePageList();
        this.pageChange(this.pageNo);
      },
      /**
       * 调整分页状态
       */
      changePageList() {
        //向上取整,有小数就整数部分加1
        this.totalPages = Math.ceil(this.totalItems / this.pageSize);
        //当总页数小于或等于导航页码数时
        if (this.totalPages <= this.displayPages) {
          this.totalPagesList = [];
          for (let i = 1; i < this.totalPages + 1; i++) {
            this.totalPagesList.push(i);
          }
        } else { //当总页数大于导航页码数时
          this.totalPagesList = [];
          let startNum = this.pageNo - this.displayPages / 2;
          let endNum = this.pageNo + this.displayPages / 2;
          if (startNum < 1) {
            startNum = 1;
            //(最前navPageCount页
            for (let i = 0; i < this.displayPages; i++) {
              this.totalPagesList.push(startNum++);
            }
          } else if (endNum > this.totalPages) {
            endNum = this.totalPages;
            //最后navPageCount页
            for (let i = this.displayPages - 1; i >= 0; i--) {
              this.totalPagesList.unshift(endNum--);
            }
          } else {
            //所有中间页
            for (let i = 0; i < this.displayPages; i++) {
              this.totalPagesList.push(startNum++);
            }
          }
        }
      }
    },
    mounted() {
      this.changePageList();
    }
  }
</script>
<style>
  .inline-block {
    display: inline-block;
  }

  .inline-block > nav > ul.pagination {
    margin: 0;
  }
</style>
