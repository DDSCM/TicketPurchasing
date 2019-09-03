<template>
  <div>
    <el-container class="container">
      <el-main>
        <el-tabs type="border-card">
          <el-tab-pane label="票房排行">
            <div>
              <div v-for="(f,index) in filmAllNumDESC" v-if="index<10" style="margin-top: 3%;">

                <div class="index">
                  <span>{{index+1}}</span>
                </div>

                  <div class="post">
                    <img :src="f.post" height="230px" style="width: 180px;">
                  </div>
                  <div class="main">
                    <span class="name">{{f.fName}}</span>
                    <br><br>
                    <span class="actor">主演：{{f.fAct}}</span>
                    <br><br>
                    <span class="time">上映时间：{{f.fTime==='other'? '2014年之前':f.fTime}}</span>
                  </div>
                  <div class="ticket">
                    <span class="other">票房：</span><span class="num">{{f.num}}</span><span class="other"> 万</span>
                  </div>

              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="评分排行">
            <div>
              <div v-for="(f,index) in filmAllRankDESC" v-if="index<10" style="margin-top: 3%;">

                <div class="index">
                  <span>{{index+1}}</span>
                </div>

                <div class="post">
                  <img :src="f.post" height="230px" style="width: 180px;">
                </div>
                <div class="main">
                  <span class="name">{{f.fName}}</span>
                  <br><br>
                  <span class="actor">主演：{{f.fAct}}</span>
                  <br><br>
                  <span class="time">上映时间：{{f.fTime==='other'? '2014年之前':f.fTime}}</span>
                </div>
                <div class="ticket">
                  <span class="other">评分：</span><span class="num">{{f.fRank}}</span><span class="other"> 分</span>
                </div>

              </div>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'rank',
    data(){
      return{
        filmAllNumDESC:[],
        filmAllRankDESC:[],
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Film/FindByFStateAllDESC").then(response=>{
        this.filmAllNumDESC=response.data;
      })
      this.$ajax.get("http://localhost:8080/Film/findByFStateRankAllDESC").then(response=>{
        this.filmAllRankDESC=response.data;
      })
    }
  }
</script>

<style scoped>
  .container{
    margin-left: 15%;
    margin-right: 15%;
    margin-top: 2%;
    /*border: 1px solid #d3d3d3;*/
  }
  .index{
    float: left;
    font-size: 300%;
    font-family: 张海山草泥马体;
    margin-left: 3%;
    color: red;
    width: 5%;
    height: 230px;
    /*border: 2px solid #eee;*/
  }
  .post{
    float: left;
    margin-left: 3%;
    height: 230px;
    /*border: 2px solid #eee;*/
  }
  .main{
    float: left;
    margin-left: 5%;
    margin-top: 5%;
    margin-right: 10%;
    width: 30%;
    /*border: 2px solid #eee;*/
  }
  .name{
    font-size:170% ;
  }
  .actor{
    font-size: 100%;
  }
  .time{
    color: darkgrey;
  }
  .ticket{
    float: left;
    /*border: 2px solid #eee;*/
    color: red;
    font-size: 180%;
    height: 230px;
    width: 25%;
    margin-top: 5%;
    font-weight: bold;

  }
  .other{

  }
  .num{
    font-family: 八大山人 V2007;
    font-size: 150%;
  }
</style>
