<template>
  <div>
    <h1>文件区</h1>

    <el-row>
      <el-button @click="test">测试</el-button>
    </el-row>

  </div>
</template>

<script>

  import {test} from '@/request/api'

  export default {
    name: "file",
    methods: {

      test() {
        let num = 1
        test.requestGetPeople({num}).then(res => {
          console.log(res)
        })
        return
      }

    }
  }
</script>

<style scoped>

</style>
