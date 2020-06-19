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
            v-loading="loading"
            height="605"
            :data="tableData"
            :show-header=false
            style="width: 100%;"
            @row-click="getFileContentById">
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
                <el-input v-model="file.title" placeholder="请输入标题" style="height: 100%">
                </el-input>
              </div>
            </el-col>

            <el-col :span="14">
              <div class="vertical-center text-right" style="padding-right: 20px;">
                <el-button type="primary" size="small" @click="saveNote">保存</el-button>
                <!--                <el-button type="primary" size="small" @click="">测试接口</el-button>-->
                <el-button plain size="small" :icon="starIcon" @click="starFile"></el-button>
                <!--删除按钮-->
                <el-popconfirm
                  title="确定删除笔记吗？"
                  @onConfirm="deleteNote"
                >
                  <el-button plain size="small" icon="el-icon-delete" slot="reference"></el-button>
                </el-popconfirm>
                <!--查看note信息按钮-->
                <el-popover
                  placement="bottom"
                  width="400"
                  trigger="click">
                  <el-row>
                    <el-col :span="6">
                      <p style="text-align: right;">作者：</p>
                    </el-col>
                    <el-col :span="18">
                      <el-input v-model="fileInfo.author" placeholder="请输入作者" @change="updateAuthor"></el-input>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="6">
                      <p style="text-align: right;">文件夹：</p>
                    </el-col>
                    <el-col :span="18">
                      <el-input v-model="fileInfo.folderName" :disabled="true"></el-input>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="6">
                      <p style="text-align: right;">创建时间：</p>
                    </el-col>
                    <el-col :span="18">
                      <el-input v-model="fileInfo.createTime" :disabled="true"></el-input>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="6">
                      <p style="text-align: right;">修改时间：</p>
                    </el-col>
                    <el-col :span="18">
                      <el-input v-model="fileInfo.modifyTime" :disabled="true"></el-input>
                    </el-col>
                  </el-row>
                  <el-button
                    plain size="small"
                    icon="el-icon-info"
                    @click="getNoteInfoById"
                    slot="reference"></el-button>
                </el-popover>

              </div>
            </el-col>
          </el-row>
        </div>
        <!--文件内容-->
        <div class="border-line-top">
          <mavon-editor
            v-model="file.contentMd"
            ref="md"
            @change="change"
            @save="saveNote"
            :subfield="false"
            :defaultOpen="'preview'">
          </mavon-editor>
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
        starIcon: 'el-icon-star-off',
        searchInput: '',
        loading: false,
        file: {
          id: 0,
          title: 'file的title',
          contentId: '',
          contentMd: 'file的contentMd',
          contentHtml: '',
          folderId: 0,
          starFlag: false
        },
        tableData: [
          {title: 'mock文件', id: 1, contentId: 1, folderId: 0}
        ],
        fileInfo: {
          id: 0,
          author: "",
          createTime: '',
          modifyTime: '',
          folderName: ''
        }
      }
    },
    methods: {
      //刚进入页面执行的操作
      //查询列表+展示第一篇笔记
      loadPage() {
        this.loading = true
        file.getFolderList().then(res => {
          this.tableData = res.re
          this.setFirstNoteInfo()
          this.loading = false
        })
      },

      search() {
        this.loading = true
        file.getFolderList().then(res => {
          this.tableData = res.re
          this.setFirstNoteInfo()
          this.loading = false
        })
      },

      //根据文件id查询文件的内容
      getFileContentById(row, event, column) {
        let id = row.id
        file.getFileContentByFileId({id}).then(res => {
          this.file = res.re
          this.setStarIcon()
        })
      },

      change(value, render) {
        // render 为 markdown 解析后的结果[html]
        this.file.contentHtml = render;
      },

      saveNote() {
        file.saveNote(this.file).then(res => {
          console.log(res.re)
          this.setNotify(res.status, res.msg)
          this.loadPage()
        })
      },

      // 提示框通知操作结果
      setNotify(status, msg) {
        if (status === 0) {
          this.$notify({
            title: msg,
            // message: '这是一条成功的提示消息',
            type: 'success'
          })
        } else {
          this.$notify.error({
            title: msg,
            // message: '这是一条错误的提示消息'
          })
        }

      },

      getNoteInfoById() {
        let id = this.file.id
        file.getNoteInfoById({id}).then(res => {
          this.fileInfo = res.re
          console.log(res.re)
        })
      },

      //将文件的标题内容设为查询到的文件列表的第一个文件
      setFirstNoteInfo() {
        if (this.tableData.length > 0) {
          let id = this.tableData[0].id
          file.getFileContentByFileId({id}).then(res => {
            this.file = res.re
            console.log(this.file)
            this.setStarIcon()
          })
        }
      },

      starFile() {
        if (this.starIcon === "el-icon-star-on") {
          this.starIcon = "el-icon-star-off"
          this.file.starFlag = false
        } else {
          this.starIcon = "el-icon-star-on"
          this.file.starFlag = true
        }
        this.updateStarFlag()
      },

      setStarIcon() {
        if (this.file.starFlag === false) {
          this.starIcon = "el-icon-star-off"
        } else {
          this.starIcon = "el-icon-star-on"
        }
      },

      deleteNote() {
        let id = this.file.id
        file.deleteNoteById({id}).then(res => {
          console.log(res.re)
          this.loadPage()
        })
      },

      updateStarFlag() {
        file.updateStarFlag(this.file).then(res => {
          this.loadPage()
        })
      },

      updateAuthor(){
        file.updateAuthorById(this.fileInfo).then(res => {
          this.loadPage()
        })
      }


    },
    created() {
      // file.getFolderList().then(res => {
      //   this.tableData = res.re
      //   this.setFirstNoteInfo()
      // })
    },
    mounted() {
      this.loadPage()
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
