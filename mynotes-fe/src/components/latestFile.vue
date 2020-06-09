<template>
  <div style="background-color: brown; height: 100%">

    <el-container style="height: 100%">

      <!--文件列表-->
      <el-aside class="border-line">
        <div style="background-color: white;height: 10%; width: 100%;">搜索</div>

      </el-aside>

      <!--文件区-->
      <el-main class="border-line">
        <div style="background-color: white;height: 10%; width: 100%;">文件名</div>

      </el-main>

    </el-container>

  </div>
</template>

<script>
  export default {
    name: "latestFile"
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

  .border-line {
    border-left: 1px solid #D3DCE6;
    border-top: 1px solid #D3DCE6;
  }

</style>
