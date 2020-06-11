<template>

  <div style="height: 100%; width: 100%">

    <el-container style="height: 100%">
      <!--头部导航-->
      <el-header style="height: 10%">

        <div class="top-bar">

          <el-row>
            <el-col :span="4">
              <div class="logo center">
                <h1>4SLT</h1>
              </div>
            </el-col>

            <el-col :span="20">
              <div></div>
            </el-col>

          </el-row>

        </div>


      </el-header>

      <el-container style="height: 90%">
        <!--侧边栏-->
        <el-aside class="aside">
          <div style="background-color: white;height: 10%; width: 100%;" class="border-line-top">新建</div>

          <el-menu class="border-line-top">

            <el-menu-item index="1">
              <i class="el-icon-files"></i>
              <router-link to="/latestFile">最新文档</router-link>
            </el-menu-item>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-folder"></i>
                <span>我的文件夹</span>
              </template>
            </el-submenu>

            <el-menu-item index="3">
              <i class="el-icon-star-off"></i>
              <router-link to="/starFile">加星文件</router-link>
            </el-menu-item>

            <el-menu-item index="4">
              <i class="el-icon-menu"></i>
              <router-link to="/colourFile">颜色文件</router-link>
            </el-menu-item>

          </el-menu>

        </el-aside>

<!--        &lt;!&ndash;文件列表&ndash;&gt;-->
<!--        <el-aside class="next-aside">-->
<!--          <div style="background-color: white;height: 10%; width: 100%;">搜索</div>-->

<!--          <router-view></router-view>-->

<!--        </el-aside>-->

        <!--文件区-->
        <el-main>
<!--          <div style="background-color: white;height: 10%; width: 100%;">文件名</div>-->
<!--          <file></file>-->
          <router-view></router-view>

        </el-main>


      </el-container>
    </el-container>


  </div>

</template>

<script>


  export default {
    name: "Index"
  }
</script>

<style scoped>

  .el-container {
    margin: 0;
    padding: 0;
  }

  .el-header {
    background-color: #409EFF;
    color: #333;
    text-align: center;
    margin: 0;
    padding: 0;
  }

  .top-bar {
    margin: 0;
    padding: 0;
    height: 100%;
    background-color: #409EFF;
  }

  .logo {
    margin: 0;
    padding: 0;
    color: white;
    font-style: italic;
    font-size: 1em;
  }

  .center {
    text-align: center;
  }

  .el-row {
    height: 100%;
  }

  .el-col {
    height: 100%;
  }

  .aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    /*line-height: 200px;*/
  }

  .next-aside {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    /*line-height: 200px;*/
  }

  .el-main {
    background-color: #E9EEF3;
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

</style>
