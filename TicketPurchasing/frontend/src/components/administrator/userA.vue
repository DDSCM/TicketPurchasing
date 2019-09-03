<template>
<div>
  <el-container class="container">
    <el-main>
      <el-tabs type="border-card">
        <el-tab-pane label="用户管理">
          <div>
            <el-row>
              <el-col :span="5">
                <el-input placeholder="输入用户名" v-model="username"></el-input>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="search">查询</el-button>
              </el-col>
            </el-row>
          </div>

          <div style="margin-top: 30px;border: 1px solid #eeeeee">
            <el-table :data="user" height="500px" stripe>
              <el-table-column prop="uId" label="id" width="50px" ></el-table-column>
              <el-table-column prop="uName" label="用户名"></el-table-column>
              <el-table-column prop="uSex" label="性别" width="200px"></el-table-column>
              <el-table-column prop="uPhone" label="电话号码" width="200px"></el-table-column>

              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" @click="deletu(scope.row)">删除</el-button>

                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>
        <el-tab-pane label="评论管理">
          <div>
            <el-row>
              <el-col :span="5">
                <el-input placeholder="输入关键词" v-model="context"></el-input>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="viewSearch">查询</el-button>
              </el-col>
            </el-row>
          </div>

          <div style="margin-top: 30px;border: 1px solid #eeeeee">
            <el-table :data="cont" height="500px" stripe>
              <el-table-column prop="vId" label="id" width="50px" ></el-table-column>
              <el-table-column prop="vScore" label="评分" width="60px"></el-table-column>
              <el-table-column prop="vContext" label="内容" width="850px"></el-table-column>

              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" @click="deletv(scope.row)">删除</el-button>

                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
</div>
</template>

<script>
  export default {
    name: 'userA',
    data(){
      return{
        username:'',
        context:'',
        user:[],
        cont:[],
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/User/findAll").then(response=>{
        this.user=response.data;
        for(var i=0;i<this.user.length;i++){
          this.user[i].uSex= this.user[i].uSex==='f'? '女':'男';
        }
      })
      this.$ajax.get("http://localhost:8080/View/FindAll").then(response=>{
        this.cont=response.data;
        /*for(var i=0;i<this.user.length;i++){
          this.user[i].uSex= this.user[i].uSex==='f'? '女':'男';
        }*/
      })
    },
    methods:{
      search(){
        this.$ajax.get("http://localhost:8080/User/FindByNameLike/uName="+this.username).then(response=>{
          this.user=response.data;
          this.username='';

        })
      },

      deletu(current){
        this.$ajax.get("http://localhost:8080/User/DeleteUser/uId="+current.uId).then(response=>{
          this.$message.success("删除成功");
          window.location.reload();
        })
      },
      deletv(current){
        this.$ajax.get("http://localhost:8080/View/DeleteView/vId="+current.vId).then(response=>{
          this.$message.success("删除成功");
          window.location.reload();
        })
      },
      viewSearch(){
        this.$ajax.get("http://localhost:8080/View/FindByContextLike/vContext="+this.context).then(response=>{
          this.cont=response.data;
          this.context='';

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
