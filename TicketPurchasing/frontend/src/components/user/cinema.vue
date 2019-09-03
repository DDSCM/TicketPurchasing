<template>
  <div>
    <el-container class="container">
      <el-main>
        <el-row>
          <el-col :span="5">
            <el-input placeholder="请输入要搜索的影院名称" v-model="cinemaname"></el-input>
          </el-col>

          <el-col :span="3" style="margin-left: 1%">
            <el-button type="primary" @click="search">搜索</el-button>
          </el-col>
        </el-row>

        <el-container style="margin-top: 3%;border: 1px solid #d3d3d3;">
          <el-main>
            <div>
              <div>
                <el-row>
                  <el-col :span="1">
                    <el-tag style="margin-top: 23%">区域</el-tag>
                  </el-col>
                  <el-col :span="23">
                    <el-checkbox-group v-model="checkArea" :max="1" size="small">
                      <label v-for="(a,index) in Area">
                        <el-checkbox-button :label="a.area" :key="a.area" class="button">{{a.area}}</el-checkbox-button>
                      </label>
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </div>
            </div>
            <el-button type="primary" v-if="checkArea[0]!=null" style="margin-top: 2%" @click="seniorsearch">搜索</el-button>
          </el-main>
        </el-container>

        <el-container>
          <el-main>
            <div>
              <h2 class="cinemaHead">影院列表</h2>
              <div v-for="(c,index) in Cinema" class="cinemaMain">
                <div style="float: left">
                  {{c.cName}}<br><span style="font-size: 85%;color: red">{{c.cAddress}}</span>
                </div>
                <div style="margin-left: 90%">
                  <el-button type="primary" @click="show(c.cId)">查看详情</el-button>
                </div>
                <hr class="hr">
              </div>
            </div>
          </el-main>
        </el-container>

      </el-main>
    </el-container>
  </div>

</template>

<script>
  export default {
    name: 'cinema',
    data(){
      return{
        checkArea:[],
        Area:[
          {area:'全部'},
          {area:'松江区'},
          {area:'静安区'},
          {area:'宝山区'},
          {area:'浦东新区'},
          {area:'闵行区'},
          {area:'嘉定区'},
          {area:'徐汇区'},
          {area:'青浦区'},
          {area:'黄埔区'},
          {area:'杨浦区'},
          {area:'普陀区'},
          {area:'奉贤区'},
          {area:'长宁区'},
          {area:'金山区'},
          {area:'虹口区'},
          {area:'崇明区'},
        ],
        Cinema:[],
        cinemaname:null,
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Cinema/FindAll").then(response=>{
        console.log(response.data);
        this.Cinema=response.data;
      })
    },
    methods:{
      show(cId){
        window.location="http://localhost:8081/#/CinemaPage/"+cId;
      },
      search(){
        if(this.cinemaname===null){
          this.cinemaname='';
        }
        this.$ajax.get("http://localhost:8080/Cinema/FindByCNameLike/cName="+this.cinemaname).then(response=>{
          this.Cinema=response.data;
        })
      },
      seniorsearch(){
        var area=this.checkArea[0]==='全部'? '':this.checkArea[0];
        this.$ajax.get("http://localhost:8080/Cinema/FindByCAddressLike/cAddress="+area).then(response=>{
          this.Cinema=response.data;
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
    margin-top: 1%;
  }
  .cinemaHead{
    font-size: 18px;
    border-left:4px solid red;
    padding-left: 1%
  }
  .cinemaMain{
    margin-top: 2%;
  }
  .hr{
    border: 1px dashed #d3d3d3;
    margin-top: 2%;
  }
</style>
