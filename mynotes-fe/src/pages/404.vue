<template>

  <div class="app-404">

    <el-row>
      <h1>Emmmm、迷路了</h1>
      <el-button @click="back">返回首页</el-button>
    </el-row>

  </div>

</template>

<script>
  export default {
    name: "404",
    methods: {
      back() {
        this.$router.push({path: '/'})
      }
    }
  }
</script>

<style scoped>

  .app-404 {
    background-color: dodgerblue;
    color: #fff;
  }


</style>
