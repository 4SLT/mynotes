<template>

  <div style="height: 100%">

    <el-container>
      <el-header>
        <div>
          <topBar></topBar>
        </div>
      </el-header>

      <el-container>

        <el-aside class="aside">
          <side-bar></side-bar>
        </el-aside>

        <el-aside class="next-aside">
          <fileList></fileList>
        </el-aside>

        <el-main>
          <file></file>
        </el-main>

      </el-container>
    </el-container>

  </div>

</template>

<script>

  import file from '@/components/file'
  import fileList from '@/components/fileList'
  import sideBar from '@/components/sideBar'
  import topBar from '@/components/topBar'


  export default {
    name: "Index",
    components: {
      file,
      fileList,
      sideBar,
      topBar
    }
  }
</script>

<style scoped>

  .el-container {
    margin: 0;
    padding: 0;
    height: 100%;
  }

  .el-header, .el-footer {
    background-color: #409EFF;
    color: #333;
    text-align: center;
    /*line-height: 60px;*/
  }

  .aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .next-aside {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
</style>
