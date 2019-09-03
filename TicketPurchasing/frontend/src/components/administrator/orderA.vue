<template>
<div>
  <el-container class="container">
    <el-main>
      <el-tabs type="border-card">
        <el-tab-pane label="订单查询">
          <div>
            <el-row>
              <el-col :span="5">
                <el-input placeholder="输入查询id" v-model.number="context"></el-input>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-select v-model="value" placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
              <el-col :span="3" :offset="1">
                <el-button type="primary" @click="orderSearch">查询</el-button>
              </el-col>
            </el-row>
          </div>

          <div style="margin-top: 30px;border: 1px solid #eeeeee">
            <el-table :data="order" height="500px" stripe>
              <el-table-column prop="oId" label="id" width="50px" ></el-table-column>
              <el-table-column prop="user.uId" label="用户id" width="180px"></el-table-column>
              <el-table-column prop="showFilm.film.fId" label="影片id" width="180px"></el-table-column>
              <el-table-column prop="showFilm.cinema.cId" label="影院id" width="180px"></el-table-column>
              <el-table-column prop="sId" label="座位号" width="180px"></el-table-column>
              <el-table-column prop="num" label="总金额" width="180px"></el-table-column>


              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" @click="deleto(scope.row)">删除</el-button>

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
    name: 'orderA',
    data(){
      return{
        value:'all',
        options:[
          {
            value: 'all',
            label: '全部'
          },
          {
            value: 'uId',
            label: '用户id'
          },
          {
            value: 'fId',
            label: '影片id'
          },
          {
            value: 'cId',
            label: '影院id'
          },
          {
            value: 'oId',
            label: '订单id'
          },
        ],
        order:[],
        context:'',
      }
    },
    mounted () {
      this.$ajax.get("http://localhost:8080/Order/FindByall/all=1").then(response=>{
        this.order=response.data;
      })
    },
    methods:{
      orderSearch(){
        this.$ajax.get("http://localhost:8080/Order/FindBy"+this.value+"/"+this.value+"="+this.context).then(response=>{
          if(this.value==='oId'){
            this.order=[];
            if(response.data){
              this.order.push(response.data);
            }
          }
          else{
            this.order=response.data;
          }
          this.context='';
        })
      },
      deleto(current){
        this.$ajax.get("http://localhost:8080/Order/DeleteOrder/oId="+current.oId).then(response=>{
          this.$message.success("删除成功");
          this.$ajax.get("http://localhost:8080/Order/FindByall/all=1").then(response=>{
            this.order=response.data;
          })
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
