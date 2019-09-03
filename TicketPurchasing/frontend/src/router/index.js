import Vue from 'vue'
import Router from 'vue-router'

import head from '@/components/user/head'
import register from '@/components/user/register'
import userInformation from '@/components/user/userInformation'
import main from '@/components/user/Main'
import film from '@/components/user/film'
import cinema from '@/components/user/cinema'
import rank from '@/components/user/rank'
import filmCinema from '@/components/user/filmCinema'
import selectSeat from '@/components/user/selectSeat'
import CinemaPage from '@/components/user/CinemaPage'
import headA from '@/components/administrator/headA'
import filmA from '@/components/administrator/filmA'
import userA from '@/components/administrator/userA'
import orderA from '@/components/administrator/orderA'
import addFilm from '@/components/administrator/addFilm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'head',
      component: head,
      children:[
        {
          path:'',
          name:'main',
          component:main
        },
        {
          path:'/CinemaPage/:cId',
          name:'CinemaPage',
          component:CinemaPage,
        },
        {
          path:'/film',
          name:'film',
          component:film
        },
        {
          path:'/cinema',
          name:'cinema',
          component:cinema
        },
        {
          path:'/rank',
          name:'rank',
          component:rank
        },
       {
          path:'/register',
          name:'register',
          component: register
        },
        {
          path:'/userInformation',
          name:'userInformation',
          component:userInformation
        },
        {
          path:'/filmCinema/:fId',
          name:'filmCinema',
          component:filmCinema
        }
        ,{
          path:'/selectSeat/:cId/:fId/:hhId/:sfId/:showTime/:showHour',
          name:'selectSeat',
          component:selectSeat
        }
      ]
    },
    {
      path:'/Manager',
      name:'headA',
      component:headA,
      children:[
        {
          path:'/filmA',
          name:'filmA',
          component:filmA,
        },
        {
          path:'/userA',
          name:'userA',
          component:userA,
        },
        {
          path:'/orderA',
          name:'orderA',
          component:orderA,
        },
        {
          path:'/addFilm/:post',
          name:'addFilm',
          component:addFilm
        }
      ]
    }
 /*   {
      path: '/register',
      name: 'register',
      component: register,
    }*/
  ]
})
