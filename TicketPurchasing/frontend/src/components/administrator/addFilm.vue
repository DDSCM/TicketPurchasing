<template>
<div>
  <el-container class="container">
    <el-header style="font-weight: bold;font-size: 20px;margin-left: 30px">
      <h1>添加影片信息</h1>
    </el-header>
  </el-container>
  <el-container class="container" style="margin-top: -20px;border: 1px solid #d3d3d3;">
    <el-aside style="margin-top: 30px;margin-left: -60px">
      <img :src="newFilm.post" alt="Film Post" width="200px" style="float: right;height: 280px">

      <form action="http://localhost:8080/Film/UpdatePost" method="post" enctype="multipart/form-data">

        <el-upload :file-list="filelist" :auto-upload="false">
          <el-button style="margin-left: 80%" slot="trigger" type="primary">点击上传海报</el-button>
          <input style="margin-left: 35%;margin-top: 5%;width: 60px;height: 35px;" type="submit" value="确定">
          <div slot="tip" style="margin-left: 100px;font-size: small;color: red">
            请先上传图片，再填写内容
          </div>
        </el-upload>

      </form>


    </el-aside>
    <el-container>
      <el-main>
        <el-form label-width="80px">
          <el-container>
            <el-aside width="380px">
              <el-form-item label="影片名">
                <el-input v-model="newFilm.fName" placeholder="输入影片名" style="width: 300px"></el-input>
              </el-form-item>
              <el-form-item label="类型">
                <el-input v-model="newFilm.fType" placeholder="输入类型" style="width: 300px"></el-input>
              </el-form-item>
              <el-form-item label="国家">
                <el-input v-model="newFilm.fCountry" placeholder="输入国家" style="width: 300px"></el-input>
              </el-form-item>
              <el-form-item label="票价">
                <el-input v-model="newFilm.fPrice" placeholder="输入票价" style="width: 300px"></el-input>
              </el-form-item>
              <el-form-item label="时长">
                <el-input v-model="newFilm.fLast" placeholder="输入时长" style="width: 300px"></el-input>
              </el-form-item>
              <el-form-item label="演职人员">
                <el-input v-model="newFilm.fAct" placeholder="输入演职人员" style="width: 300px"></el-input>
              </el-form-item>
            </el-aside>
            <el-container>
              <el-main>
                <el-form-item label="简介">
                  <el-input type="textarea" v-model="newFilm.fDes" placeholder="输入简介" :rows="10" style="width: 350px"></el-input>
                </el-form-item>
                <el-form-item style="margin-left: 50%;margin-bottom:auto">
                  <el-button type="primary" @click="addFilm">确定</el-button>
                </el-form-item>
              </el-main>
            </el-container>
          </el-container>


        </el-form>
      </el-main>
    </el-container>
  </el-container>
</div>
</template>

<script>
  export default {
    name: 'addFilm',
    data(){
      return{
        newFilm:{
          post:this.$route.params.post,
          fName:null,
          fCountry:null,
          fAct:null,
          fPrice:null,
          fType:null,
          fLast:null,
          fDes:null,
          fState:2,
          fTime:2019,
          fRank:0
        },
        filelist:[],
      }
    },
    mounted () {
    },
    methods:{
      addFilm(){
        this.$ajax.post("http://localhost:8080/Film/CreateFilm",JSON.stringify(this.newFilm),{
          headers:{'Content-Type': 'application/json;charset=UTF-8'}
        }).then(response=>{
          this.$message.success("添加成功");
          window.location="http://localhost:8081/#/filmA";
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

  }
</style>
