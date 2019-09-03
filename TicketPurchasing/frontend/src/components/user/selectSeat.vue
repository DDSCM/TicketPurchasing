<template>
    <div>
      <el-container class="container">
        <el-aside class="border" width="350px">

          <div>
            <el-container style="margin-left: 10px;margin-top: 10px">
              <el-aside style="width: 140px;">
                <img :src="thisFilm.post" height="200px" style="width: 140px;">
              </el-aside>
              <el-main style="margin-left: 10px">
                <div><span style="font-weight: bold;font-size: 20px">{{thisFilm.fName}}</span></div>
                <div style="margin-top: 10px"><span style="color: #8C939D">类型：</span><span>{{thisFilm.fType}}</span></div>
                <div style="margin-top: 10px"><span style="color: #8C939D">时长：</span><span>{{thisFilm.fLast}}</span></div>
              </el-main>
            </el-container>
          </div>
          <div style="margin-left: 10px">
            <div style="margin-top: 10px"><span style="color: #8C939D">影院：</span><span>{{thisCinema.cName}}</span></div>
            <br>
            <div style="margin-top: -12px"><span style="color: #8C939D">影厅：</span><span>{{hhId}}号厅</span></div>
            <br>
            <div style="margin-top: -12px"><span style="color: #8C939D">票价：</span><span>{{thisFilm.fPrice}}元</span></div>
            <br>
            <div style="margin-top: -12px"><span style="color: #8C939D">座位：</span><span style="font-size: 13px">一次最多可以选择十个座位</span><br>
              <span>{{Seat}}</span></div>
            <br>

            <div style="margin-top: -12px"><span style="color: #8C939D">总价格：</span><span style="color: red;font-size: 25px">{{Seat.length*thisFilm.fPrice}}</span>元</div>
            <br>
            <el-button type="primary" v-if="Seat[0]!=null" @click="select">确认选座</el-button>
          </div>
        </el-aside>

        <el-container>
          <el-main>
            <div style="text-align: center">
              屏幕中央
            </div>

              <el-container>
                <el-aside class="main_aside" width="50px">
                  <div style="margin-top: 35px;text-align: center">
                    <div v-for="num in 9" style="margin-top: 21.5px">
                      {{num}}
                    </div>
                  </div>
                </el-aside>
                <el-container>
                  <el-main class="main_main">
                    <el-checkbox-group v-model="Seat" :max="10" size="small" >
                      <label v-for="(num,index) in 9*10+9"><!--[1,10,20,30,40,50].indexOf(num)>=0-->
                        <el-checkbox-button class="button" :label="num" :key="num" :disabled="isSelected.indexOf(num)>=0">{{index%11+1}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-main>
                </el-container>

              </el-container>

          </el-main>
        </el-container>
      </el-container>
    </div>
</template>

<script>
  export default {
    name: 'selectSeat',
    data(){
      return{
        Seat:[],
        cId:this.$route.params.cId,
        fId:this.$route.params.fId,
        hhId:this.$route.params.hhId,
        sfId:this.$route.params.sfId,
        showTime:this.$route.params.showTime,
        showHour:this.$route.params.showHour,
        thisFilm:null,
        thisCinema:null,
        thisUser:null,
        isSelected:[],

        create:{
          sId:null,
          num:null,
          user:{
            uId:null,
          },
          showFilm:{
            film:{
              fId:null,
            },
            cinema:{
              cId:null,
            },
            sfId:null,
            showTime:null,
            showHour:null,
            hhId:null,
          }
        }
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Film/FindBYFId/fId="+this.fId).then(response=>{
        this.thisFilm=response.data;
      })
      this.$ajax.get("http://localhost:8080/Cinema/FindByCId/cId="+this.cId).then(response=>{
        this.thisCinema=response.data;
      })
      this.$ajax.get("http://localhost:8080/Order/FindOrderInDay/cId="+this.cId+"fId="+this.fId+"showTime="+this.showTime+"showHour="+this.showHour).then(response=>{
        this.isSelected=response.data;
      })
      this.$ajax.get("http://localhost:8080/User/getCurrentUser").then(response=>{
        this.thisUser=response.data;
      })
    },
    methods:{
      select(){
        this.create.num=this.thisFilm.fPrice;
        this.create.user.uId=this.thisUser.uId;
        this.create.showFilm.film.fId=this.fId;
        this.create.showFilm.cinema.cId=this.cId;
        this.create.showFilm.showTime=this.showTime;
        this.create.showFilm.showHour=this.showHour;
        this.create.showFilm.hhId=this.hhId;
        this.create.showFilm.sfId=this.sfId;
        for(var i=0;i<this.Seat.length;i++){
          this.create.sId=this.Seat[i];
          this.$ajax.post("http://localhost:8080/Order/CreateOrder",JSON.stringify(this.create),{
            headers:{'Content-Type': 'application/json;charset=UTF-8'}
          });
        }
        this.$message.success("购票成功");
        /*this.Seat=[];*/

      }
    }
  }
</script>

<style scoped>
  .container{
    margin-left: 15%;
    margin-right: 15%;
    margin-top: 2%;
    border: 1px solid #d3d3d3;
  }
  .border{
    border: 2px solid #eee;
    background-color: rgba(247, 225, 244, 0.3);
  }
  .main_aside{
    /*border: 2px solid #eee;*/
    font-family: 张海山草泥马体;
    margin-left: 10%;
  }
  .main_main{
    /*border: 2px solid #eee;*/
    margin-right: 60px;
  }
  .button{
    margin-left: 2%;
    margin-top: 1.5%;
  }

/*  .button.is-disabled{
    color: red;
    background-color: red;
  }*/
</style>
