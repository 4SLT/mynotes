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
                {{this.file.title}}
              </div>
            </el-col>

            <el-col :span="14">
              <div class="vertical-center text-right" style="padding-right: 20px;">
                <el-button type="primary" size="small" @click="saveNote">保存</el-button>
                <el-button type="primary" size="small" @click="getFileContentById">测试接口</el-button>
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
          {{this.file.content}}
        </div>
      </el-main>

    </el-container>

  </div>
</template>

<script>

  import {folder} from '@/request/api'
  import {file} from '@/request/api'
  import {content} from '@/request/api'


  export default {
    name: "latestFile",
    data() {
      return {
        searchInput: '',
        id: 1,
        file: {
          id: 0,
          title: 'file的title',
          contentId: '',
          content: 'file的content'
        },
        tableData: [
          {title: 'mock文件', id: 1, contentId: 1}
        ]
      }
    },
    methods: {

      search() {
        file.getFolderList().then(res => {
          this.tableData = res.re
          this.setFirstNoteInfo()
        })
      },

      //根据文件id查询文件的内容
      getFileContentById() {
        let id = 1
        file.getFileContentByFileId({id}).then(res => {
          this.file = res.re
          console.log(this.file)
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

      //将文件的标题内容设为查询到的文件列表的第一个文件
      setFirstNoteInfo() {
        if (this.tableData.length > 0) {
          let id = this.tableData[0].contentId
          content.getContentById({id}).then(res => {
            this.file = this.tableData[0]
            this.file.content = res.re.content
          })
        }
      }

    },
    created() {
      file.getFolderList().then(res => {
        this.tableData = res.re
        this.setFirstNoteInfo()
      })
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
