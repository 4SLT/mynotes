import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import _404 from '@/pages/404'

import LatestFile from '@/components/latestFile'
import StarFile from '@/components/starFile'
import ColourFile from '@/components/colourFile'

import File from '@/components/file'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children: [
        {
          path: '/latestFile',
          name: 'latestFile',
          component: LatestFile
        }, {
          path: '/starFile',
          name: 'starFile',
          component: StarFile
        }, {
          path: '/colourFile',
          name: 'colourFile',
          component: ColourFile
        }
      ]
    },{
      path: '/latestFile',
      name: 'latestFile',
      component: LatestFile
    }, {
      path: '/starFile',
      name: 'starFile',
      component: StarFile
    }, {
      path: '/colourFile',
      name: 'colourFile',
      component: ColourFile
    }, {
      path: '/file',
      name: 'file',
      component: File
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
