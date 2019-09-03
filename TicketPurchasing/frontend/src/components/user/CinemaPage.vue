<template>
  <div>
    <el-container class="Headcontainer">

      <el-aside style="margin-left: 15%;margin-top: 50px">
        <img src="/static/post/1.jpg" height="330px" style="width: 230px;border: 5px solid white;">
      </el-aside>
      <el-main style="margin-top: 90px;color: white">

        <el-header><!--style="font-size: 35px;font-weight: bold"-->
          <h1>{{cinema.cName}}</h1>
        </el-header>
        <span>地址：{{cinema.cAddress}}</span>
        <br><br>

      </el-main>
    </el-container>
    <el-container class="container" style="border: 1px solid #d3d3d3;">
      <el-main>
        <img src="/static/leftArrow.png" style="float: left;height: 210px" @click="left">

        <div v-for="(vi,index) in filmList.slice((currentPage-1)*6,currentPage*6)" style="float: left">
          <!--:href="'http://localhost:8081/#/CinemaPageFilm/'+cId+'/'+vi.fId"-->
          <a class="img"><img :src="vi.post" style="width: 150px;height: 210px;margin-left: 13px" @click="show(vi)"></a>
        </div>

        <img src="/static/rightArrow.png" style="float: right;height: 210px" @click="right">
      </el-main>
    </el-container>

    <!--子界面在此处显示-->
    <!--<el-container>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>-->

    <el-container class="container">
      <el-main>
        <div v-for="(film,index) in filmList" v-if="Filmindex===film.fId">
          <span style="font-size: 30px">{{detail[0].film.fName}}</span>
          <span style="margin-left: 20px;color: #ffb500;font-size: 20px">评分：{{detail[0].film.fRank}}</span><br><br>
          <span style="color: #8c939d">时长:</span>
          {{detail[0].film.fLast}}
          <span class="attribute">国家:</span>
          {{detail[0].film.fCountry}}
          <span class="attribute">类型:</span>
          {{detail[0].film.fType}}

          <div style="margin-top: 20px">

            <el-tabs type="border-card" v-model="defaultT" style="height: 400px">
              <el-tab-pane label="观影时间" disabled></el-tab-pane>
              <el-tab-pane :label="a.slice(5,10)" :key="a" v-for="(a,index) in showTime" :name="index===0? 'default':'other'+index">
                <div v-for="(s,ind) in showHour">
                  <div v-if="s[0].showHour===a">
                    <div class="head">
                      <span style="margin-left: 100px">放映时间</span>
                      <span style="margin-left: 200px">影厅号</span>
                      <span style="margin-left: 200px">票价</span>
                      <span style="margin-left: 225px">操作</span>
                    </div>
                    <div v-for="(data,i) in s.slice(1,)" class="main" :style="i%2!==0? 'background-color:rgba(211, 175, 217, 0.13)':''">
                      <span class="columnOne">{{data.showHour}}</span>
                      <span class="columnTwo">{{data.hhId}}号厅</span>
                      <span class="columnThree">￥{{data.film.fPrice}}</span>
                      <span style="margin-left: 200px"><el-button type="primary" @click="purchase(data)">点击购票</el-button></span>
                    </div>
                    <!--<el-table :data="s.slice(1,)" stripe height="400px">
                      <el-table-column prop="showHour" label="放映时间" style="font-size: 300px"></el-table-column>
                      <el-table-column prop="hhId" label="影厅号"></el-table-column>
                      <el-table-column prop="film.fPrice" label="票价"></el-table-column>
                      <el-table-column label="操作">
                        <template slot-scope="scope">
                          <el-button type="primary" @click="" style="font-size: 300px">点击购票</el-button>
                        </template>
                      </el-table-column>
                    </el-table>-->
                    <!--<div v-for="(iter,i) in s" v-if="i!==0">
                    </div>-->
                  </div>
                </div>
              </el-tab-pane>
            </el-tabs>
            <!--<el-checkbox-group v-model="checkTime" :max="1" size="small">
              <label v-for="(a,index) in showTime">
                <el-checkbox-button :label="a" :key="a" class="button" change>{{a.slice(5,)}}</el-checkbox-button>
              </label>
            </el-checkbox-group>-->
          </div>

        </div>
      </el-main>
    </el-container>

  </div>
</template>

<script>
  export default {
    name: 'CinemaPage',
    data(){
      return{
        defaultT:"default",
        cId:this.$route.params.cId,
        cinema:null,
        filmList:[],
        currentPage:1,
        max:0,
        Filmindex:999,
        detail:[],
        checkTime:[],
        showTime:[],
        showHour:[],
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Cinema/FindByCId/cId="+this.cId).then(response=>{
        console.log(response.data);
        this.cinema=response.data;
      })
      this.$ajax.get("http://localhost:8080/ShowFilm/FindByCinemaId/cId="+this.cId).then(response=>{
        console.log(response.data);
        this.filmList=response.data;
        this.max=Math.ceil(this.filmList.length/6);
        console.log(this.max);
      })
    },
    methods:{
      left(){
        if(this.currentPage!==1){
          /*this.$message.success("-1");*/
          this.currentPage--;
        }
      },
      right(){

        if(this.currentPage!==this.max){
          /*this.$message.success("+1");*/
          this.currentPage++;
        }
      },
      show(vi){
        this.Filmindex=vi.fId;
        this.showHour=[];//每次点击后先清空，否则之前push进去的还在
        this.$ajax.get("http://localhost:8080/ShowFilm/FindByFIdAndCId/fId="+vi.fId+"cId="+this.cId).then(response=>{
          console.log(response.data);
          this.detail=response.data;
        })
        this.$ajax.get("http://localhost:8080/ShowFilm/FindShowTime/fId="+vi.fId+"cId="+this.cId).then(response=>{

          this.showTime=response.data;
          //console.log(this.showTime);

          /*this.showHour=this.showTime;*/
          var i=0;
          for(i=0;i<this.showTime.length;i++){
            console.log(this.showTime[i])
            //这个地方不是串行执行的，是并行的，因此要把每天对应上还得费点劲，见上面界面Vue部分
            this.$ajax.get("http://localhost:8080/ShowFilm/FindShowHour/fId="+vi.fId+"cId="+this.cId+"showTime="+this.showTime[i]).then(res=>{

              this.showHour.push(res.data);
              /*this.showHour[i]=res.data;*/

            })
          }

        })

      },
      purchase(data){
        //data当前对应的showFilm
        window.location="http://localhost:8081/#/selectSeat/"+data.cinema.cId+"/"+data.film.fId+"/"+data.hhId+"/"+data.sfId+"/"+data.showTime+"/"+data.showHour;
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
    /*border: 1px solid #d3d3d3;*/
  }
  .img :hover{
    transform: scale(1.1);
    border: 5px solid red;
  }
  .attribute{
    color: #8c939d;
    margin-left: 20px;
  }
  .button{
    margin-left: 1%;
    margin-top: 1%;
  }
  .head{
    background-color: rgba(203,160,193,0.13);
    font-weight: bold;
    font-size: 17px;
    height: 50px;
    width: 1500px;
    /*以下三条为垂直居中*/
    display: table-cell;
    vertical-align: middle;
    align-items:center;
  }
  .main{
    height: 60px;
    /*display: flex;
    text-align: center;*/
    /*width: 1500px;*/
    /*以下三条为垂直居中*/
    display: flex;
    justify-content:center;
    align-items:center;
  }
  .columnOne{
    margin-left: -20px;
    font-size: 20px;
    font-weight: bold;
    font-family: Calibri;
    color: #4b4648;
    /*margin: auto;*/
  }
  .columnTwo{
    margin-left: 220px;
    font-size: 17px;
    font-family: Calibri;
  }
  .columnThree{
    margin-left: 200px;
    color: red;
    font-weight: bolder;
    font-size: 20px;
    font-family: Calibri;
  }
</style>
