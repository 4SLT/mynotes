<template>
  <div style="background-color: white; height: 100%">

    <el-container style="height: 100%">

      <!--文件列表-->
      <el-aside class="border-line-left">

        <!--搜索框-->
        <div class="border-line-top search_class" style="background-color: white;height: 10%; width: 100%;">
          <div>
            <el-input
              placeholder="搜索..."
              size="medium"
              v-model="searchInput"
              class="input-with-select">
              <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
            </el-input>
          </div>
        </div>

        <!--搜索结果列表-->
        <div class="border-line-top" style="width: 100%">
          <el-table
            :data="tableData"
            :show-header=false
            style="width: 100%">
            <el-table-column
              prop="fileName">
            </el-table-column>
          </el-table>
        </div>

      </el-aside>

      <!--文件区-->
      <el-main class="border-line-left">
        <div class="border-line-top" style="background-color: white;height: 10%; width: 100%;">文件名</div>

        <div class="border-line-top">
          文件区
        </div>

      </el-main>

    </el-container>

  </div>
</template>

<script>

  import {test} from '@/request/api'

  export default {
    name: "latestFile",
    data() {
      return {
        searchInput: '',
        tableData: [
          {fileName: 'mock文件'}
        ]
      }
    },
    methods: {

      search() {
        let searchInput = this.searchInput
        test.requestSearchTest({searchInput}).then(res => {
          console.log(res.re)
          this.tableData = res.re
        })
      }

    }

  }
</script>

<style scoped>

  .el-container {
    margin: 0;
    padding: 0;
  }

  .el-aside {
    /*background-color: #E9EEF3;*/
    color: #333;
    text-align: center;
    /*line-height: 200px;*/
  }

  .el-main {
    /*background-color: #E9EEF3;*/
    color: #333;
    text-align: center;
    margin: 0;
    padding: 0;
    /*line-height: 160px;*/
  }

  .border-line-left {
    border-left: 1px solid #D3DCE6;
  }

  .border-line-top {
    border-top: 1px solid #D3DCE6;
  }

  /*用于文字居中*/
  .center {
    text-align: center;
  }

  /*用于搜索框垂直居中*/
  .search_class {
    line-height: 60px;
  }

  .el-select .el-input {
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

</style>
