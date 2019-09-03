<template>
  <div id="head">
    <el-container>
      <el-header style="height: 55px;">


        <el-col :span="4" :offset="3" >
          <div class="title">
            东华管理
          </div>
        </el-col>

        <el-col :span="2">
          <div class="menu">
            <a href="http://localhost:8081/#/filmA">电影管理</a>
          </div>
        </el-col>

        <el-col :span="2" >
          <div class="menu">
            <a href="http://localhost:8081/#/userA">用户管理</a>
          </div>
        </el-col>

        <el-col :span="2" >
          <div class="menu">
            <a href="http://localhost:8081/#/orderA">订单管理</a>
          </div>
        </el-col>

        <!--<el-col :span="2" >
          <div class="menu">
            <a href="http://localhost:8081/#/rank">排行榜</a>
          </div>
        </el-col>-->

        <el-col :span="3" class="login">
          <el-button type="primary" @click="jumpback">返回客户端</el-button>
        </el-col>

        <!--<el-dialog :visible.sync="loginVisible" title="用户登录" width="30%">
          <el-form :model="login" label-width="80px">
            <el-form-item label="用户名">
              <el-input v-model="login.username" placeholder="请输入用户名" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="login.password" placeholder="请输入密码" type="password" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item>
              <div style="color: red">
                还没有账号？<a href="http://localhost:8081/#/register" @click="loginVisible=false">点击</a> 注册
              </div>
            </el-form-item>
            <el-form-item style="margin-left: 40%;margin-bottom:auto">
              <el-button @click="loginVisible=false">取消</el-button>
              <el-button type="primary" @click="userLogin">确定</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>-->

        <!--<el-col :span="2" class="userCenter">
          <el-dropdown style="font-size: 15px">
            <span class="el-dropdown-link">
               个人中心<i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>
            </span>
            <el-dropdown-menu v-if="islogin">
              <el-dropdown-item><a href="http://localhost:8081/#/userInformation">用户信息</a></el-dropdown-item>
              <el-dropdown-item><a href="http://localhost:8081/#/userInformation">购票记录</a></el-dropdown-item>
              <el-dropdown-item>
                <el-button type="text" @click="logoutVisible=true">用户注销</el-button>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>-->

        <!--<el-dialog :visible.sync="logoutVisible" title="用户注销" width="15%">
          您确实要注销当前用户吗？
          <el-row style="margin-top: 15%">
            <el-button @click="logoutVisible=false">取消</el-button>
            <el-button type="primary" @click="userLogout">确定</el-button>
          </el-row>
        </el-dialog>-->
        <div>
          <label class="red_line"></label>
        </div>
      </el-header>
    </el-container>

    <!--子界面在此处显示-->
    <el-container>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>

  </div>
</template>

<script>
  export default {
  name: 'head',
  data () {
    return {
      loginVisible:false,
      logoutVisible:false,
      islogin:false,//只有登录成功后才置为true
      login:{
        username:null,
        password:null,
      }
    }
  },
  mounted () {
    //每次刷新时都查看当前有无用户，并修改islogin值。
    this.$ajax.get("http://localhost:8080/User/getCurrentUser").then(response=>{
      if(response.data!=null){
        this.islogin=true;
      }
      else{
        this.islogin=false;
      }
    })
  },
  methods: {
    jumpback(){
      window.location="http://localhost:8081/#/";
    },
    userLogin(){
      this.$ajax.get("http://localhost:8080/User/LoginUser/uName="+this.login.username+"uPwd="+this.login.password).then(response=>{
        if(response.data){
          this.login.username=null;
          this.login.password=null;
          this.loginVisible=false;
          this.islogin=true;
          this.$message.success("登录成功");
        }
        else{
          this.$message.error("登录失败");
        }
      })
    },
    userLogout(){
      this.$ajax.get("http://localhost:8080/User/LogoutUser").then(response=>{
        this.logoutVisible=false;
        this.islogin=false;
        this.$message.success("注销成功");
      })
    }
  }
}
</script>

<style scoped>
  a{text-decoration:none;
    color: black;}
  a:visited{color:black}
  .title{
    color: red;
    font-family:"方正北魏楷书简体";
    font-size: 40px;
    text-align: center;
    margin-top: 8%;
  }
  .menu{
    /*display: block;*/
    text-align: center;
    font-size: 20px;
    margin-top: 30px;
  }
  .menu a:hover{
    color: red;
  }
  .login{
    text-align: right;
    margin-top: 25px;
  }
  .userCenter{
    text-align: center;
    margin-top: 35px;
  }
  .red_line {
    background: red;
    width: 100%;
    height: 2px;
    float: left;
    margin-top: 15px;
  }
</style>
