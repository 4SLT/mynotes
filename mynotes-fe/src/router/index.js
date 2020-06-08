import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import _404 from '@/pages/404'
import SideBar from '@/components/sideBar'
import FileList from '@/components/fileList'
import File from '@/components/file'
import TopBar from '@/components/topBar'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      components: {
        default: Index,
        'SideBar': SideBar,
        'FileList': FileList,
        'File': File
      }
    }, {
      path: '/sideBar',
      name: 'SideBar',
      component: SideBar
    }, {
      path: '/fileList',
      name: 'FileList',
      component: FileList
    }, {
      path: '/file',
      name: 'File',
      component: File
    }, {
      path: '/topBar',
      name: 'TopBar',
      component: TopBar
    },
    {
      path: '/404',
      name: '404',
      component: _404
    }, {
      path: "*",
      redirect: "/404"
    }
  ]
})
