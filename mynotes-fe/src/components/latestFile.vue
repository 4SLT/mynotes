<template>
  <div style="background-color: white; height: 100%">

    <el-container style="height: 100%">

      <!--文件列表-->
      <el-aside class="border-line-left" style="overflow-y: hidden">

        <!--搜索框-->
        <div class="border-line-top vertical-center" style="background-color: white;height: 10%; width: 100%;">
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
        <div class="border-line-top" style="width: 100%;">
          <el-table
            height="605"
            :data="tableData"
            :show-header=false
            style="width: 100%;">
            <el-table-column
              prop="title">
            </el-table-column>
          </el-table>
        </div>

      </el-aside>

      <!--文件标题+按钮-->
      <el-main class="border-line-left">
        <div class="border-line-top" style="background-color: white;height: 10%; width: 100%;">
          <el-row>
            <el-col :span="10">
              <div class="vertical-center text-left" style="padding-left: 20px;">
                {{noteTitle}}
              </div>
            </el-col>

            <el-col :span="14">
              <div class="vertical-center text-right" style="padding-right: 20px;">
                <!--                <el-color-picker-->
                <!--                  v-model="color"-->
                <!--                  size="mini"-->
                <!--                  show-alpha="false"-->
                <!--                  :predefine="predefineColors"-->
                <!--                >-->
                <!--                </el-color-picker>-->
                <el-button type="primary" size="small" @click="saveNote">保存</el-button>
                <el-button plain size="small" icon="el-icon-star-on"></el-button>
                <el-button plain size="small" icon="el-icon-delete"></el-button>
                <!--                <el-button plain size="small" icon="el-icon-more"></el-button>-->
                <el-button plain size="small" icon="el-icon-info" @click="getNoteInfoById"></el-button>
              </div>
            </el-col>
          </el-row>
        </div>
        <!--文件内容-->
        <div class="border-line-top">
          文件区
        </div>
      </el-main>

    </el-container>

  </div>
</template>

<script>

  import {test} from '@/request/api'
  import {folder} from '@/request/api'
  import {file} from '@/request/api'


  export default {
    name: "latestFile",
    data() {
      return {
        searchInput: '',
        id: 1,
        // color: '#409EFF',
        // predefineColors: [
        //   '#ff4500',
        //   '#ff8c00',
        //   '#ffd700',
        //   '#90ee90',
        //   '#00ced1',
        //   '#1e90ff'
        // ],
        noteTitle: '标题标题标题标题标题标题标题标题',
        tableData: [
          {title: 'mock文件'}
        ]
      }
    },
    methods: {

      search() {
        let searchInput = this.searchInput
        file.getFolderList().then(res => {
          console.log(res.re)
          this.tableData = res.re
          this.setNoteTitle()
        })
      },

      saveNote() {
        alert("保存笔记")
      },

      getNoteInfoById() {
        let id = this.id
        file.getNoteInfoById({id}).then(res => {
          console.log(res.re)
        })
      },

      // 文件标题设为查到的文件列表的第一个文件标题
      setNoteTitle() {
        if (this.tableData.length > 0) {
          this.noteTitle = this.tableData[0].title
        }
      },

      // searchTest() {
      //   let searchInput = this.searchInput
      //   test.requestSearchTest({searchInput}).then(res => {
      //     console.log(res.re)
      //     this.tableData = res.re
      //   })
      // }

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
  .text-center {
    text-align: center;
  }

  .text-left {
    text-align: left;
  }

  .text-right {
    text-align: right;
  }

  /*用于垂直居中*/
  .vertical-center {
    line-height: 60px;
  }

  .el-select .el-input {
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

</style>
