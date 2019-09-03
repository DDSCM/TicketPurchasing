<template>
  <div>

    <el-container class="Headcontainer">

      <el-aside style="margin-left: 15%;margin-top: 50px">
        <img :src="film.post" height="330px" style="width: 230px;border: 5px solid white;">
      </el-aside>
      <el-main style="margin-top: 50px;color: white">

        <el-header><!--style="font-size: 35px;font-weight: bold"-->
          <h1>{{film.fName}}</h1>
        </el-header>

        <el-container>

          <el-aside>
            <span>类型：{{film.fType}}</span>
            <br><br>
            <span>{{film.fCountry}} / {{film.fLast}}分钟 / {{date}}上映</span>
            <br><br>
            <el-button @click="function(){ currentPane='c1';window.location.href='#tab';}">查看详情</el-button>
            <el-button @click="function(){ currentPane='c2';window.location.href='#tab';}">查看评价</el-button>
            <br>
            <el-button type="primary" @click="function(){ currentPane='c3';window.location.href='#tab';}" style="width: 210px;margin-top: 8px">购票</el-button>

          </el-aside>

          <el-main>
            <span>票房统计：</span><br>
            <span style="font-weight: bold;font-size: 30px;color: #ffb500">{{film.num}}</span>万<br><br>
            <span>评分：</span><br>
            <span style="font-weight: bold;font-size: 30px;color: #ffb500">{{film.fRank}}</span>分

          </el-main>
        </el-container>

      </el-main>
    </el-container>

    <el-container class="container">
      <el-main>
        <el-tabs v-model="currentPane" id="tab">
          <el-tab-pane label="影片介绍" name="c1">
            <div>
              <h3 class="head">剧情简介</h3>
              {{film.fDes}}
              <h3 class="head">主要演员</h3>
              {{film.fAct}}
            </div>
          </el-tab-pane>
          <el-tab-pane label="购票" name="c3">
            <div>
              <h3 class="head">影院列表</h3>

              <div v-for="(c,index) in Cinema" class="cinemaMain">
                <div style="float: left">
                  {{c.cName}}<br><span style="font-size: 85%;color: red">{{c.cAddress}}</span>
                </div>
                <div style="margin-left: 90%">
                  <el-button type="primary" @click="jumpCinema(c)">点击订票</el-button>
                </div>
                <hr class="hr">
              </div>

            </div>
          </el-tab-pane>
          <el-tab-pane label="评论" name="c2">
            <el-table :data="view" height="300px">
              <el-table-column prop="user.uName" label="用户名"></el-table-column>
              <el-table-column prop="vScore" label="星数">

                <template slot-scope="scope">
                  <el-rate v-model="scope.row.vScore" disabled show-score text-color="#ff9900" score-template="{value}"></el-rate>
                </template>

              </el-table-column>
              <el-table-column prop="vContext" label="评价"></el-table-column>
            </el-table>
            <div style="margin-top: 10px">
              <h3 class="head">我的评价</h3>

              <div v-if="isPurchase">
                <el-row>
                  <el-col :span="3"><span>请选择评分：</span></el-col>
                  <el-col :span="5"><el-rate v-model="NewView.vScore" show-score text-color="#ff9900"></el-rate></el-col>
                </el-row>

                <el-input type="textarea" placeholder="请输入您的评价" v-model="NewView.vContext" style="margin-top: 10px"></el-input>
                <el-button type="primary" style="margin-top: 10px;float: right" @click="CreateView">确定</el-button>
              </div>
              <div v-else>您还未观看过该影片，暂无评论资格哦</div>

            </div>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'filmCinema',
    data(){
      return{
        fId:this.$route.params.fId,
        film:null,
        Cinema:[],
        view:[],
        date:null,
        isPurchase:false,/*记得在购票完成后改成true！！！*/
        currentPane:'c1',

        thisUser:null,
        NewView:{
          vScore:0,
          vContext:null,
          user:{
            uId:null,
          },
          film:{
            fId:null
          }
        }
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Film/FindBYFId/fId="+this.fId).then(response=>{
        console.log(response.data);
        this.film=response.data;
      })
      this.$ajax.get("http://localhost:8080/ShowFilm/FindByFilmName/fId="+this.fId).then(response=>{
        console.log(response.data);
        this.Cinema=response.data;
      })
      this.$ajax.get("http://localhost:8080/View/FindByFId/fId="+this.fId).then(response=>{
        console.log(response.data);
        this.view=response.data;
      })
      this.$ajax.get("http://localhost:8080/User/getCurrentUser").then(response=>{
        console.log(response.data);
        this.thisUser=response.data;
        if(this.thisUser===null){
          this.$message.error("您当前还未登录，请先登录！");
        }
        else {//查询是否有购票记录，能否评价。
          this.$ajax.get("http://localhost:8080/Order/FindByUserAndfId/uId="+this.thisUser.uId+"fId="+this.fId).then(res=>{
            if(res.data===null){
              this.isPurchase=false;
            }
            else{
              this.isPurchase=true;
            }
          })
        }
      })
      this.$ajax.get("http://localhost:8080/ShowFilm/FindMinShowTime/fId="+this.fId).then(response=>{
        console.log(response.data);
        this.date=response.data;//首映时间
      })
    },
    methods:{
      CreateView(){
        this.NewView.user.uId=this.thisUser.uId;
        this.NewView.film.fId=this.fId;
        this.$ajax.post("http://localhost:8080/View/CreateView",JSON.stringify(this.NewView),{
          headers:{'Content-Type': 'application/json;charset=UTF-8'}
        }).then(response=>{
          if(response.data){
            this.$message.success("评论创建成功");
            this.view.push({
              film:this.NewView.film,
              user:this.thisUser,
              vContext: this.NewView.vContext,
              vScore:this.NewView.vScore
            });
            this.NewView.vScore=0;
            this.NewView.vContext=null;
          }
          else{
            this.$message.error("评论创建失败，请重试");
          }
        })
      },
      jumpCinema(c){
        window.location="http://localhost:8081/#/CinemaPage/"+c.cId;
      }
    }
  }
</script>

<style scoped>
  .Headcontainer{
    background-image: url(/static/background_看图王.png);
    height: 410px;
    width: 100%;

    /*border: 1px solid #d3d3d3;*/
  }
  .container{
    margin-left: 15%;
    margin-right: 15%;
    margin-top: 2%;
    border: 1px solid #d3d3d3;
  }
  .head{
    border-left: 6px solid red;
    padding-left: 1%;
  }
  .cinemaMain{
    margin-top: 2%;
  }
  .hr{
    border: 1px dashed #d3d3d3;
    margin-top: 2%;
  }
</style>
