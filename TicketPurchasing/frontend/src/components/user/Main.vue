<template>
<div>
  <el-container class="container">
    <el-aside style="border: 1px solid #eee;">
      <el-main>

        <div class="header">
          今日票房
        </div>

        <div style="margin-top: 5%">
          <div v-for="(vi,index) in filmNumDESC" v-if="index <10">

            <span class="aside_left">
              {{index+1}}
            </span>

            <span>
            <a :href="'http://localhost:8081/#/filmCinema/'+vi.fId" class="aside_href">{{vi.fName}}</a>
            </span>

            <span class="aside_right">
              {{vi.num}}万
            </span>
            <hr>

          </div>
        </div>

        <div style="margin-top: 6%">
          <router-link :to="{name:'rank'}" style="float: right;color: red;text-decoration: none">查看详情 ></router-link>
        </div>

      </el-main>
    </el-aside>

    <el-container style="border: 1px solid #eee;">
      <el-main class="main_main">

        <div class="main_header">
          正在热映
          <router-link :to="{name:'film'}">查看全部 ></router-link>
        </div>

          <div v-for="(vi, index) in film1" v-if="index<8">

            <el-card :body-style="{ padding: '0px'}" class="card_head" >
              <span>
                <div style="position: relative">
                  <img :src="vi.post" style="height: 230px;width:160px">
                  <div style="position: absolute; bottom: 5px;color: white;background-color: rgba(0,0,0,0.67);width: 160px;height: 30px">
                    <span>{{vi.fName}}</span>
                  </div>

                </div>
              </span>

              <div>
                <el-button class="card_bottom" @click="purchase(vi)">购票</el-button>
              </div>
            </el-card>

          </div>

      </el-main>
    </el-container>
  </el-container>

  <el-container class="container">
    <el-aside style="border: 1px solid #eee;">
      <el-main>

        <div class="header2">
          评价最高
        </div>

        <div style="margin-top: 5%">
          <div v-for="(vi,index) in filmRankDESC" v-if="index <10">

            <span class="aside_left">
              {{index+1}}
            </span>

            <a :href="'http://localhost:8081/#/filmCinema/'+vi.fId" class="aside_href2">{{vi.fName}}</a>

            <span class="aside_right2">
              {{vi.fRank}}
            </span>
            <hr>

          </div>
        </div>

        <div style="margin-top: 6%">
          <router-link :to="{name:'rank'}" style="float: right;color: #ffb605;text-decoration: none">查看详情 ></router-link>
        </div>
      </el-main>
    </el-aside>

    <el-container style="border: 1px solid #eee;">
      <el-main class="main_main">

        <div class="main_header2">
          即将上映
          <router-link :to="{name:'film'}">查看全部 ></router-link>
        </div>

        <div :span="8" v-for="(vi, index) in film2" v-if="index<8">

          <el-card :body-style="{ padding: '0px'}" class="card_head" >
              <span>
                <div style="position: relative">
                  <img :src="vi.post" style="height: 230px;width:160px">
                  <div style="position: absolute; bottom: 5px;color: white;background-color: rgba(0,0,0,0.67);width: 160px;height: 30px">
                    <span>{{vi.fName}}</span>
                  </div>

                </div>
              </span>

            <div>
              <el-button class="card_bottom" @click="purchase(vi)">购票</el-button>
            </div>
          </el-card>

          <!--<div v-if="index===3">
            <br>
          </div>-->

        </div>

      </el-main>
    </el-container>
  </el-container>
</div>
</template>

<script>
  export default {
    name: 'Main',
    data(){
      return{
        film1:[],
        film2:[],
        filmNumDESC:[],
        filmRankDESC:[],
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Film/FindByFState/fState=1").then(response=>{
        console.log(response.data);
        this.film1=response.data;
      })
      this.$ajax.get("http://localhost:8080/Film/FindByFState/fState=2").then(response=>{
        console.log(response.data);
        this.film2=response.data;
      })
      this.$ajax.get("http://localhost:8080/Film/FindByFStateDESC").then(response=>{
        this.filmNumDESC=response.data;
      })
      this.$ajax.get("http://localhost:8080/Film/findByFStateRankDESC").then(response=>{
        this.filmRankDESC=response.data;
      })
    },
    methods:{
      purchase(film){
        this.$router.push('/filmCinema/'+film.fId);
      }
    }
  }
</script>

<style scoped>
  .container{
    margin-left: 15%;
    margin-right: 15%;
    margin-top: 2%;
  }
  .card_head{
    width: 160px;
    float: left;
    margin-left: 3%;
    margin-top: 2%;
  }
  .card_bottom{
   /* padding: 14px;*/
    width: 100%;
  }
  .card_bottom:hover{
    background-color:red;
    color:white;
  }
  .card_bottom2{
    /* padding: 14px;*/
    width: 100%;
  }
  .card_bottom2:hover{
    background-color:#ffb605;
    color:white;
  }
  .header{
    color: red;
    font-size: 150%;
    text-align: center;
  }
  .header2{
    color: #ffb605;
    font-size: 150%;
    text-align: center;
  }
  .aside_left{
    font-family: 张海山草泥马体;
    font-size: 150%;
    color: darkgrey;
  }
  .aside_right{
    float: right;
    /*margin-right: 0px;*/
    margin-top: 4px;
    color: red;
  }
  .aside_right2{
    float: right;
    margin-top: 4.5px;
    color: #ffb605;
  }
  .aside_href{
    color: black;
    text-decoration: none;
  }
  .aside_href:hover{
    color: red;
  }
  .aside_href2{
    color: black;
    text-decoration: none;
  }
  .aside_href2:hover{
    color: #ffb605;
  }
  .main_header{
    color: red;
    font-size: 150%;
    margin-left: 3%;
  }
  .main_header a{
    font-size: 60%;
    text-decoration: none;
    color: red;
    /*float: right;*/
    /*float: bottom;*/
    margin-left: 70%;
  }
  .main_header a:visited{
    color: red;
  }
  .main_header2{
    color: #ffb605;
    font-size: 150%;
    margin-left: 3%;
  }
  .main_header2 a{
    font-size: 60%;
    text-decoration: none;
    color: #ffb605;
    /*float: right;*/
    /*float: bottom;*/
    margin-left: 70%;
  }
  .main_header2 a:visited{
    color: #ffb605;
  }
  .main_main{
    margin-left: 3%;
  }


</style>
