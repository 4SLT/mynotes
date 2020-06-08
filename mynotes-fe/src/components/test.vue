<template>
  <div>

    <el-row>
      <el-button @click="test">测试</el-button>
    </el-row>

  </div>
</template>

<script>

  import {test} from '@/request/api'

  export default {
    name: "test",
    methods: {

      test() {
        var num = 1
        test.requestGetPeople({num}).then(res => {
          console.log(res.re)
        })
      }

    }
  }
</script>

<style scoped>

</style>
