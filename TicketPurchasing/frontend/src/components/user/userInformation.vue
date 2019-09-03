<template>
  <div>
    <!--<el-container class="WholeContainer">
      <el-aside class="aside" width="15%">
        <h3 style="text-align: center">个人中心</h3>
        <el-menu
          default-active="2"
          class="Information"


          text-color="#fff"
          active-text-color="#ffd04b">

          <el-menu-item index="1">

            <i class="el-icon-menu"></i>
              <span>购票信息</span>


          </el-menu-item>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">用户信息</span>
          </el-menu-item>
          <el-menu-item index="3">
            <i class="el-icon-menu"></i>
            <span slot="title">更改密码</span>
          </el-menu-item>

        </el-menu>
      </el-aside>

      <el-container>

      </el-container>
    </el-container>-->

    <el-tabs tab-position="left" type="border-card" class="Border-card" v-model="defaultName">
      <el-tab-pane label="个人中心" disabled="true" style="font-size: 20px"></el-tab-pane>
      <el-tab-pane label="用户信息" name="默认">
        <el-container>
          <el-header>
            <div style="color: red;font-size: 20px;font-weight: bold">
              用户信息
            </div>

            <hr style="margin-top: 2%">
          </el-header>
          <el-main>
            <el-container>
              <el-aside style="width: 280px">
                <img :src="current" alt="Smiley face" width="200px" style="float: right;height: 200px">

                <form action="http://localhost:8080/User/UpdatePotrait" method="post" enctype="multipart/form-data">

                  <el-upload :file-list="filelist" :auto-upload="false">
                    <el-button style="margin-left: 65%;margin-top: 10%" slot="trigger" type="primary">点击上传头像</el-button>
                    <input style="margin-left: 32%;margin-top: 10%;width: 60px;height: 35px;" type="submit" value="确定">
                    <div slot="tip" style="margin-left: 93px;font-size: small">
                      规格为200*200,大小不超过1M
                    </div>
                  </el-upload>

                </form>


              </el-aside>
              <el-container style="margin-left: 10%">
                <el-form label-width="80px" :rules="ModifyRule" :model="modify" ref="userInformation">
                  <el-form-item label="用户名">
                    <el-input v-model="modify.username" disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="性别">
                    <el-radio v-model="modify.radio" label="m">男</el-radio>
                    <el-radio v-model="modify.radio" label="f">女</el-radio>
                  </el-form-item>
                  <el-form-item label="电话号码" prop="phone">
                    <el-input v-model.number="modify.phone"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" style="margin-top: 22.5%" @click="UpdateInfo">保存信息</el-button>
                  </el-form-item>
                </el-form>

              </el-container>
            </el-container>
          </el-main>
        </el-container>
      </el-tab-pane>
      <el-tab-pane label="修改密码">
        <el-container>
          <el-header>
            <div style="color: red;font-size: 20px;font-weight: bold">
              修改密码
            </div>

            <hr style="margin-top: 2%">
          </el-header>
          <el-main>
            <el-form label-width="100px" :rules="ModifyRule" :model="modify" ref="userPwd">
              <el-form-item label="原密码" prop="password">
                <el-input type="password" v-model="modify.password" placeholder="请输入原始密码" style="width: 30%"></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="newpassword">
                <el-input type="password" v-model="modify.newpassword" placeholder="请输入新密码" style="width: 30%"></el-input>
              </el-form-item>
              <el-form-item label="确认新密码" prop="checkpassword">
                <el-input type="password" v-model="modify.checkpassword" placeholder="请确认新密码" style="width: 30%"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="UpdatePassword">保存密码</el-button>
              </el-form-item>
            </el-form>
          </el-main>
        </el-container>
      </el-tab-pane>
      <el-tab-pane label="购票记录">
        <el-container>
          <el-header>
            <div style="color: red;font-size: 20px;font-weight: bold">
              购票记录
            </div>

            <hr style="margin-top: 2%">
          </el-header>
          <el-main>
            <el-table :data="history" stripe height="300px">
              <el-table-column prop="oId" label="订单号"></el-table-column>
              <el-table-column prop="showFilm.film.fName" label="电影名"></el-table-column>
              <el-table-column prop="showFilm.cinema.cName" label="影院"></el-table-column>
              <el-table-column prop="showFilm.hhId" label="影厅"></el-table-column>
              <el-table-column prop="sId" label="座位号"></el-table-column>
              <el-table-column prop="showFilm.film.fPrice" label="票价"></el-table-column>
            </el-table>
          </el-main>
        </el-container>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default {
    name: 'userInformation',
    data(){
      //输入不能为空
      var validateNull=(rule,value,callback)=>{
        if(value==null||value===''){
          callback(new Error("该项不能为空！"));
        }
        else{
          callback();
        }
      };
      //原始密码需要正确
      var validateCorrect=(rule,value,callback)=>{
        if(value===this.thisUser.uPwd){
          callback();
        }
        else{
          callback(new Error("原始密码输入不正确！"));
        }
      }
      //两次输入密码需要一致
      var validateCheckPassword=(rule,value,callback)=>{
        if(this.modify.newpassword===value){
          callback();
        }
        else{
          callback(new Error("两次输入密码不一致！"));
        }
      };
      //电话号码为11位
      var validateLength=(rule,value,callback)=>{
        if((value+'').length===11){
          callback();
        }
        else{
          callback(new Error("电话号码位数错误！"));
        }
      };
      return{
        defaultName:'默认',
        modify:{
          username:null,
          password:null,
          radio:null,
          newpassword:null,
          checkpassword:null,
          phone:null
        },
        filelist:[],
        thisUser:null,
        current:null,/*头像*/
        history:null,/*购买记录*/
        ModifyRule:{
          password:[
            {validator:validateCorrect,trigger:'blur',required: true}
          ],
          newpassword:[
            {validator:validateNull,trigger:'blur',required: true}
          ],
          checkpassword:[
            {validator:validateNull,trigger:'blur',required: true},
            {validator:validateCheckPassword,trigger:'blur'}
          ],
          phone:[
            {validator:validateNull,trigger:'blur',required: true},
            {type:'number',message:"电话号码必须是数字！",trigger:'blur'},
            {validator:validateLength,trigger:'blur'}
          ]
        }
      }
    },
    mounted () {
     // this.modify.username=this.thisUser.username;
     // this.modify.phone=this.thisUser.phone;

      this.$ajax.get("http://localhost:8080/User/getCurrentUser").then(response=>{
        console.log(response.data);
        this.thisUser=response.data;
        this.current=response.data.potrait;
        this.modify.username=this.thisUser.uName;
        this.modify.phone=this.thisUser.uPhone;
        this.modify.radio=this.thisUser.uSex;

        this.$ajax.get("http://localhost:8080/Order/FindByUser/uId="+this.thisUser.uId).then(res=>{
          this.history=res.data;
        })

      })

    },
    methods:{
      UpdateInfo(){
        this.$refs['userInformation'].validate(valid=>{
          if(!valid){
            this.$message.error("校验未通过，请重新输入！");
          }
          else{//所有校验都通过后，才能向后台发送请求
            this.$ajax.get("http://localhost:8080/User/UpdateUser/uPhone="+this.modify.phone+"uSex="+this.modify.radio+"uId="+this.thisUser.uId).then(response=>{
              if(response.data){
                this.$message.success("修改成功");
              }
              else{
                this.$message.error("修改失败，请重试");
              }
            })
          }
        })

      },
      UpdatePassword(){
        this.$refs['userPwd'].validate(valid=>{
          if(!valid){
            this.$message.error("校验未通过，请重新输入！");
          }
          else{
            this.$ajax.get("http://localhost:8080/User/UpdatePwd/old_pwd="+this.modify.password+"new_pwd="+this.modify.newpassword+"uId="+this.thisUser.uId).then(response=>{
              if(response.data){
                this.$message.success("修改成功");
                this.modify.password=null;
                this.modify.newpassword=null;
                this.modify.checkpassword=null;
              }
              else{
                this.$message.error("修改失败，请重试");
              }
            })
          }
        })

      }

    }
  }
</script>

<style scoped>

  .WholeContainer{
    border: 1px solid #eee;
    height: 500px;
    margin-left: 17%;
    margin-right: 17%;
    margin-top: 3%;

  }
  .aside{
    /*margin-top: 10%;
    margin-left: 15%;*/
    height: 50vh;
    background-color: red;
  }
  .Information{
    background-color: aqua;

  }
  .Border-card{
    margin-left: 17%;
    margin-right: 17%;
    margin-top: 3%;
    height: 50%;
  }
</style>
