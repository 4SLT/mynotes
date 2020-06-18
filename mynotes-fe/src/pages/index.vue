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
          <div style="background-color: white;height: 10%; width: 100%;" class="border-line-top">
            <el-button
              @click="dialogFormVisible = true"
              style="width: 100%; height: 100%;"
              icon="el-icon-plus">
              新增
            </el-button>
          </div>

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

        <!--文件区-->
        <el-main>

          <router-view :key="activeDate"></router-view>
<!--          <router-view></router-view>-->

        </el-main>


      </el-container>
    </el-container>

    <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="type" :label-width="formLabelWidth">
          <el-select v-model="form.addType" placeholder="请选择新增文件类型">
            <el-option label="新建文件夹" value="folder"></el-option>
            <el-option label="新建笔记" value="file"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="name" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="testAdd">确 定</el-button>
      </div>
    </el-dialog>

  </div>

</template>

<script>

  import {folder} from '@/request/api'
  import {file} from '@/request/api'
  import {content} from '@/request/api'

  export default {
    name: "Index",
    data() {
      return {
        dialogFormVisible: false,
        form: {
          name: '',
          addType: '',
          folderId:0
        },
        formLabelWidth: '120px',
        activeDate: 1
      }
    },
    methods: {
      testAdd() {

        if (this.form.addType === '') {
          this.dialogFormVisible = false
        } else {
          file.addNew(this.form).then(res => {
            this.activeDate = new Date().getTime()
            console.log(res.re)
          })
        }
        this.dialogFormVisible = false
      },

    }
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

  /*用于垂直居中*/
  .vertical-center {
    line-height: 60px;
  }
</style>
