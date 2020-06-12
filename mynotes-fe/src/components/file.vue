<template>
  <div style="height: 100%;width: 100%;">
    <div style="height: 10%;width: 100%;">标题栏</div>
    <mavon-editor
      v-model="mdValue"
      ref="md"
      @change="change"
      style="height: 80%;width: 100%;">
    </mavon-editor>

    <button @click="submit" style="height: 10%;width: 100%;">提交</button>
  </div>
</template>

<script>

  export default {
    name: "file",
    data() {
      return {
        mdValue: '',
        mdHtml: ''
      }
    },
    methods: {
      // 所有操作都会被解析重新渲染
      change(value, render) {
        // render 为 markdown 解析后的结果[html]
        this.mdHtml = render;
      },
      // 提交
      submit() {
        console.log(this.mdValue);
        console.log(this.mdHtml);
      }
    },
    mounted() {

    }
  }
</script>

<style scoped>

</style>
