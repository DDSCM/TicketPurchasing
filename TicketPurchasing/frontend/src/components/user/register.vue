<template>
  <div>
    <el-container>
      <el-main>



            <el-form :model="register" class="register" :rules="RegisterRule" ref="register">
              <el-form-item label="用户昵称" prop="uName">
                <el-input v-model="register.uName" placeholder="请输入用户名" class="register_input"></el-input>
              </el-form-item>
              <el-form-item label="输入密码" prop="uPwd">
                <el-input v-model="register.uPwd" type="password" placeholder="请输入密码" class="register_input"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkpassword">
                <el-input v-model="register.checkpassword" type="password" placeholder="请确认密码" class="register_input"></el-input>
              </el-form-item>
              <el-form-item label="电话号码" prop="uPhone">
                <el-input v-model.number="register.uPhone" placeholder="请输入电话号码" class="register_input"></el-input>
              </el-form-item>
              <el-form-item>
                <el-checkbox v-model="Agree">我同意用户协议</el-checkbox>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="userRegister" style="width: 10%" :disabled="!Agree">注册</el-button>
              </el-form-item>
            </el-form>

      </el-main>
    </el-container>

  </div>

</template>

<script>
  export default {
    name: 'register',
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
      //两次输入密码需要一致
      var validateCheckPassword=(rule,value,callback)=>{
        if(this.register.uPwd===value){
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
      //用户名不能重复
      var validateNoRepeat=(rule,value,callback)=>{
        var flag=true;
        for(var i=0;this.allUser[i];i++){
          if(this.allUser[i].uName===value){
            flag=false;
            break;
          }
        }
        if(flag){
          callback();
        }
        else{
          callback(new Error("该用户名已被注册，请更换！"));
        }
      };
      return{
        register:{
          uName:null,
          uPwd:null,
          checkpassword:null,
          uPhone:null
        },
        Agree:false,
        allUser:[],
        RegisterRule:{
          uName:[
            {validator:validateNull,trigger:'blur',required: true},
            {validator:validateNoRepeat,trigger:'blur'}
          ],
          uPwd:[
            {validator:validateNull,trigger:'blur',required: true}
          ],
          checkpassword:[
            {validator:validateNull,trigger:'blur',required: true},
            {validator:validateCheckPassword,trigger:'blur'}
          ],
          uPhone:[
            {validator:validateNull,trigger:'blur',required: true},
            {type:'number',message:"电话号码必须是数字！",trigger:'blur'},
            {validator:validateLength,trigger:'blur'}
          ],
        }
      }
    },
    mounted () {
      //获取所有用户，确保新注册用户名不重复
      this.$ajax.get("http://localhost:8080/User/findAll").then(response=>{
        this.allUser=response.data;
        console.log(this.allUser);
      })
    },
    methods:{

      userRegister(){
        this.$refs['register'].validate(valid=>{
          if(!valid){
            this.$message.error("校验未通过，请重新输入!");
          }
          else{
            this.$ajax.post("http://localhost:8080/User/CreateUser",JSON.stringify(this.register),{
              headers:{'Content-Type': 'application/json;charset=UTF-8'}
            }).then(response=>{
              if(response.data){
                this.$message.success("用户注册成功！");
                window.location="http://localhost:8081/#/"
              }
              else{
                this.$message.error("注册失败，请稍后再试");
              }
            })
          }
        })
      }
    }
  }
</script>

<style scoped>

  .register{
    margin-top: 2%;
    margin-left: 20%;
  }
  .register_input{
    width: 30%;
  }

</style>
