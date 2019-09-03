<template>
<div>
  <el-container class="container">
    <el-main>
      <el-tabs type="border-card" >

        <el-tab-pane label="电影上架">
          <div>
            <el-row>
              <el-col :span="5">
                <el-input placeholder="输入电影名" v-model="filmname"></el-input>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="search">查询</el-button>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="jumpFunction">添加</el-button>
              </el-col>
            </el-row>
          </div>

          <!--<el-dialog :visible.sync="addVisible" width="50%" title="添加影片">
            <el-form :model="newFilm" label-width="80px">
              <el-container>
                <el-aside width="40%">
                  <el-form-item>
                    <img :src="current" width="200px" height="300px">
                  </el-form-item>
                  <form action="http://localhost:8080/Film/UpdatePost" method="post" enctype="multipart/form-data">

                    <el-upload :file-list="filelist" :auto-upload="false">
                      <el-button style="margin-left: 65%;margin-top: 10%" slot="trigger" type="primary">点击上传海报</el-button>
                      <input style="margin-left: 32%;margin-top: 10%;width: 60px;height: 35px;" type="submit" value="确定">
                      <div slot="tip" style="margin-left: 93px;font-size: small">
                        大小不超过1M
                      </div>
                    </el-upload>

                  </form>
                </el-aside>
                <el-container>
                  <el-main>
                    <el-form-item label="影片名">
                      <el-input v-model="newFilm.fName" placeholder="输入影片名"></el-input>
                    </el-form-item>
                    <el-form-item label="类型">
                      <el-input v-model="newFilm.fType" placeholder="输入类型"></el-input>
                    </el-form-item>
                    <el-form-item label="国家">
                      <el-input v-model="newFilm.fCountry" placeholder="输入国家"></el-input>
                    </el-form-item>
                    <el-form-item label="票价">
                      <el-input v-model="newFilm.fPrice" placeholder="输入票价"></el-input>
                    </el-form-item>
                    <el-form-item label="时长">
                      <el-input v-model="newFilm.fLast" placeholder="输入时长"></el-input>
                    </el-form-item>
                    <el-form-item label="演职人员">
                      <el-input v-model="newFilm.fAct" placeholder="输入演职人员"></el-input>
                    </el-form-item>
                    <el-form-item label="简介">
                      <el-input v-model="newFilm.fDes" placeholder="输入简介"></el-input>
                    </el-form-item>
                    <el-form-item style="margin-left: 40%;margin-bottom:auto">
                      <el-button @click="addVisible=false">取消</el-button>
                      <el-button type="primary" @click="add">确定</el-button>
                    </el-form-item>
                  </el-main>
                </el-container>
              </el-container>

            </el-form>
          </el-dialog>-->

          <div style="margin-top: 30px;border: 1px solid #eeeeee">
            <el-table :data="film" height="500px" stripe>
              <el-table-column prop="fId" label="id" width="50px" ></el-table-column>
              <el-table-column prop="fName" label="名称"></el-table-column>
              <el-table-column prop="fPrice" label="票价" width="200px"></el-table-column>
              <el-table-column prop="fType" label="类型" width="200px"></el-table-column>
              <el-table-column prop="fState" label="是否上映" width="150px"></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" @click="delete(scope.row.fId)">删除</el-button>
                  <el-button style="width: 100px" @click="changeVisible=scope.row.fId,changeState=scope.row.fState">修改信息</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>

        <el-tab-pane label="管理排档">
          <div>
            <el-row>
              <el-col :span="5">
                <el-input placeholder="输入正在上映的电影名" v-model="filmname"></el-input>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="searchOnShow">查询</el-button>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="addShowVisible=true">添加</el-button>
              </el-col>
            </el-row>
          </div>

          <div style="margin-top: 30px;border: 1px solid #eeeeee">
            <el-table :data="filmOnShow" height="500px" stripe>
              <el-table-column prop="sfId" label="id" width="50px" ></el-table-column>
              <el-table-column prop="showTime" label="日期" width="150px"></el-table-column>
              <el-table-column prop="showHour" label="时间" width="150px"></el-table-column>
              <el-table-column prop="cinema.cName" label="影院名" width="150px"></el-table-column>
              <el-table-column prop="hhId" label="影厅号" width="150px"></el-table-column>
              <el-table-column prop="film.fName" label="电影名" width="280px"></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" @click="deleteShow(scope.row.sfId)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>

      </el-tabs>

      <el-dialog :visible.sync="changeVisible" title="修改信息" width="30%">
        <el-form label-width="80px">
          <el-form-item label="影片号">
            <el-input v-model="changeVisible" disabled style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="当前状态">
            <el-input v-model="changeState" disabled style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="切换状态">
            <el-select v-model="value">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item style="margin-left: 40%;margin-bottom:auto">
            <el-button @click="changeVisible=0">取消</el-button>
            <el-button type="primary" @click="changetoState">确定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <el-dialog :visible.sync="addShowVisible" title="添加放映时间" width="30%">
        <el-form label-width="80px" :model="newShowFilm">
          <el-form-item label="影片号">
            <el-input v-model="newShowFilm.film.fId" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="影院号">
            <el-input v-model="newShowFilm.cinema.cId" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="影厅号">
            <el-input v-model="newShowFilm.hhId" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="日期">
            <el-date-picker v-model="newShowFilm.showTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="时间">
            <el-time-picker v-model="newShowFilm.showHour" :picker-options="{selectableRange: '6:30:00 - 23:30:00'}" placeholder="选择时间" value-format="HH:mm:ss"></el-time-picker>
          </el-form-item>


          <el-form-item style="margin-left: 40%;margin-bottom:auto">
            <el-button @click="addShowVisible=false">取消</el-button>
            <el-button type="primary" @click="addShow">确定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

    </el-main>
  </el-container>
</div>
</template>

<script>
  export default {
    name: 'filmA',
    data(){
      return{
        film:[],
        filmOnShow:[],
        filmname:'',
        addVisible:false,
        addShowVisible:false,
        changeVisible:0,
        changeState:0,
        value:0,
        current:null,
        filelist:[],
        options:[
          {
          value:1,
          label:'正在上映',
        },{
          value:2,
          label:'即将上映',
        },{
          value:0,
          label:'已完映'
        }
        ],

        newShowFilm:{
          film:{
            fId:null,
          },
          cinema:{
            cId:null,
          },
          showTime:null,
          showHour:null,
          hhId:null,
        }
      }
    },
    mounted () {
      this.findAll();
      this.findAllOnShow();
    },
    methods:{

      jumpFunction(){ window.location='http://localhost:8081/#/addFilm/post';},
      findAll(){
        this.$ajax.get("http://localhost:8080/Film/FindAll").then(response=>{
          this.film=response.data;
          for(var i=0;i<this.film.length;i++){
            this.film[i].fState= this.film[i].fState===1? '正在上映':this.film[i].fState===2? '即将上映':'已完映';
          }
        })
      },
      findAllOnShow(){
        this.$ajax.get("http://localhost:8080/ShowFilm/FindAllByTime").then(response=>{
          this.filmOnShow=response.data;
          /*for(var i=0;i<this.filmOnShow.length;i++){
            this.filmOnShow[i].fState= this.filmOnShow[i].fState===1? '正在上映':this.filmOnShow[i].fState===2? '即将上映':'已完映';
          }*/
        })
      },
      search(){
        this.$ajax.get("http://localhost:8080/Film/FindByFName/fName="+this.filmname).then(response=>{
          this.film=response.data;
          this.filmname='';
          for(var i=0;i<this.film.length;i++){
            this.film[i].fState= this.film[i].fState===1? '正在上映':this.film[i].fState===2? '即将上映':'已完映';
          }
        })
      },
      searchOnShow(){
        this.$ajax.get("http://localhost:8080/ShowFilm/FindByFNameLike/fName="+this.filmname).then(response=>{
          this.filmOnShow=response.data;
          this.filmname='';
          /*for(var i=0;i<this.filmOnShow.length;i++){
            this.filmOnShow[i].fState= this.filmOnShow[i].fState===1? '正在上映':this.filmOnShow[i].fState===2? '即将上映':'已完映';
          }*/
        })
      },
      delete(fId){
        this.$ajax.get("http://localhost:8080/Film/DeleteFilm/fId="+fId).then(response=>{
          this.$message.success("删除成功");
          this.findAll();
        })
      },
      deleteShow(sfId){
        this.$ajax.get("http://localhost:8080/Film/DeleteFilm/fId="+fId).then(response=>{
          this.$message.success("删除成功");
          this.findAll();
        })
      },
      changetoState(){
        if(this.changeState==='正在上映'){
          this.$ajax.get("http://localhost:8080/ShowFilm/FindByFId/fId="+this.changeVisible).then(response=>{
            if(response.data){
              this.$message.error("请先删除该影片所有拍片信息");
            }
            else{
              this.$ajax.get("http://localhost:8080/Film/UpdateFState/fState="+this.value+"fId="+this.changeVisible).then(response=>{
                this.$message.success("修改成功");
                this.changeVisible=0;
                this.findAll();
              })
            }
          })
        }
        else{
          this.$ajax.get("http://localhost:8080/Film/UpdateFState/fState="+this.value+"fId="+this.changeVisible).then(response=>{
            this.$message.success("修改成功");
            this.changeVisible=0;
            this.findAll();
          })
        }
      },
      addShow(){
        console.log(this.newShowFilm.showHour)
        console.log(this.newShowFilm.showTime)
        this.newShowFilm.showHour=this.newShowFilm.showHour.slice(0,5);
        console.log(this.newShowFilm.showHour)
        this.$ajax.post("http://localhost:8080/ShowFilm/CreateFS",JSON.stringify(this.newShowFilm),{
          headers:{'Content-Type': 'application/json;charset=UTF-8'}
        }).then(response=>{
          this.$message.success("添加成功");
          this.addShowVisible=false;
          this.findAllOnShow();
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
</style>
