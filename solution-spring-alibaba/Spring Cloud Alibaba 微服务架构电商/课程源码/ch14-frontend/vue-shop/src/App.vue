<template>
    <div id="app" class="medium-container">
        <header>
            <strong @click="goHome()">Shop+ 电商平台</strong>
            <router-link to="/login" class="lk_login">登录</router-link>
            <router-link to="/logout" class="lk_login">退出</router-link>
        </header>
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        methods:{
            goHome(){
                this.$router.push("/");
            }
        }
    }
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }
    header{
        background-color: #E3231B;
        height: 40px;
        text-align: left;
        vertical-align: middle;
        color: white;
        padding-top: 8px;
        padding-left: 10px;
        font: 16px/150% tahoma,arial,Microsoft YaHei,Hiragino Sans GB,"\u5b8b\u4f53",sans-serif;
    }
    .lk_login{
        float: right;
        margin-right: 10px;
        color: white;
    }
    .lk_login:visited {
        color: white;
    }
</style>
