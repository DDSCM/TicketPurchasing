<template>
  <div>
    <el-container class="container">
      <el-main>
        <el-row>
          <el-col :span="5">
            <el-input placeholder="请输入要搜索的影片名称" v-model="filmname"></el-input>
          </el-col>

          <el-col :span="3" style="margin-left: 1%">
            <el-button type="primary" @click="searchforfilm()">搜索</el-button>
          </el-col>
        </el-row>

        <el-container style="margin-top: 3%;border: 1px solid #d3d3d3;">
          <el-main>
            <div>

              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag>状态</el-tag>
                  </el-col>
                  <el-col :span="20">
                    <el-checkbox-group v-model="checkState" :max="1" size="small">
                      <label v-for="(s,index) in State">
                        <el-checkbox-button :label="index" :key="index" class="button">{{s.state}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>

              <hr style="border: 1px dashed #d3d3d3">

              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag>类型</el-tag>
                  </el-col>
                  <el-col :span="20">
                    <el-checkbox-group v-model="checkType" :max="1" size="small">
                      <label v-for="(t,index) in Type">
                        <el-checkbox-button :label="t.type" :key="t.type" class="button">{{t.type}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>

              <hr style="border: 1px dashed #d3d3d3">

              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag>国家</el-tag>
                  </el-col>
                  <el-col :span="20">
                    <el-checkbox-group v-model="checkCountry" :max="1" size="small">
                      <label v-for="(c,index) in Country">
                        <el-checkbox-button :label="c.country" :key="c.country" class="button">{{c.country}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>

              <hr style="border: 1px dashed #d3d3d3">

              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag>时间</el-tag>
                  </el-col>
                  <el-col :span="20">
                    <el-checkbox-group v-model="checkTime" :max="1" size="small">
                      <label v-for="(t,index) in Time">
                        <el-checkbox-button :label="t.time" :key="t.time" class="button">{{t.time}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>

              <hr style="border: 1px dashed #d3d3d3">

              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag>评分</el-tag>
                  </el-col>
                  <el-col :span="20">
                    <el-checkbox-group v-model="checkRank" :max="1" size="small">
                      <label v-for="(r,index) in Rank">
                        <el-checkbox-button :label="r.rank" :key="r.rank" class="button">{{r.rank}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>

            </div>
            <el-button type="primary" @click="seniorSearch" v-if="checkState[0]!=null&&checkType[0]!=null&&checkCountry[0]!=null&&checkRank[0]!=null&&checkTime[0]!=null" style="margin-top: 2%">搜索</el-button>
          </el-main>

        </el-container>

        <el-container>
          <el-main>
            <div>
              <div v-for="(vi, index) in film.slice((currentPage-1)*pageSize,currentPage*pageSize)">

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
            </div>
          </el-main>
        </el-container>



           <div style="text-align: center">
             <el-pagination
               background
               layout="prev, pager, next"
               :current-page="currentPage"
               :page-size="pageSize"
               @current-change="handleCurrentChange"
               :total="totalPage">
             </el-pagination>
           </div>



      </el-main>

    </el-container>


  </div>
</template>

<script>
  export default {
    name: 'film',
    data(){
      return{
        filmname:null,
        currentPage:1,
        pageSize:10,
        totalPage:0,
        checkState:[],
        checkType:[],
        checkCountry:[],
        checkTime:[],
        checkRank:[],
        State:[
          {state:'经典影片'},
          {state:'正在热映'},
          {state:'即将上映'}
        ],
        Type:[
          {type:'全部'},
          {type:'爱情'},
          {type:'喜剧'},
          {type:'动画'},
          {type:'剧情'},
          {type:'悬疑'},
          {type:'科幻'},
          {type:'动作'},
          {type:'犯罪'},
          {type:'战争'},
          {type:'冒险'},
          {type:'其他'},
        ],
        Country:[
          {country:'全部'},
          {country:'中国'},
          {country:'美国'},
          {country:'日本'},
          {country:'泰国'},
          {country:'英国'},
          {country:'法国'},
          {country:'德国'},
          {country:'韩国'},
          {country:'印度'},
          {country:'其他'},
        ],
        Time:[
          {time:'全部'},
          {time:'2019'},
          {time:'2018'},
          {time:'2017'},
          {time:'2016'},
          {time:'2015'},
          {time:'2014'},
          {time:'更早'},
        ],
        Rank:[
          {rank:'全部'},
          {rank:'10'},
          {rank:'9'},
          {rank:'8'},
          {rank:'7'},
          {rank:'6'},
          {rank:'5及以下'},
        ],
        film:[],
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Film/FindAll").then(response=>{
        console.log(response.data);
        this.film=response.data;
        this.totalPage=Math.ceil(this.film.length/10)*10;
      })
    },
    methods:{
      handleCurrentChange(val) {
        this.currentPage = val;
      },
      searchforfilm(){
        if(this.filmname===null){
          this.filmname='';
        }
        this.$ajax.get("http://localhost:8080/Film/FindByFName/fName="+this.filmname).then(response=>{
          this.film=response.data;
          this.totalPage=Math.ceil(this.film.length/10)*10;
        })
      },
      jump(vi){
        window.location="http://localhost:8081/#/filmCinema/"+vi.fId;
      },
      seniorSearch(){
        var state=this.checkState[0];
        var type=this.checkType[0]===null? '':this.checkType[0]==='全部'? '':this.checkType[0];
        var country=this.checkCountry[0]===null? '':this.checkCountry[0]==='全部'? '':this.checkCountry[0];
        var time=this.checkTime[0]===null? '':this.checkTime[0]==='全部'? '':this.checkTime[0]==='更早'? 'other':this.checkTime[0];
        var rank=this.checkRank[0]===null? '':this.checkRank[0]==='全部'? '':this.checkRank[0];
        this.$ajax.get("http://localhost:8080/Film/FindByAll/fState="+state+"fType="+type+
          "fCountry="+country+
          "fTime="+time+
          "rank="+rank).then(response=>{
          this.film=response.data;
          this.totalPage=Math.ceil(this.film.length/10)*10;
        })
      }
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
  .button{
    margin-left: 1%;
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
</style>
