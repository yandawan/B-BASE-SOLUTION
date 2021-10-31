<template>
    <div class="login">
        <h4>账户登录</h4>
        <form @submit.prevent="handleSubmit">
            <label for="name">用户名</label>
            <input type="text" id="name" placeholder="Name" v-model="name"/>
            <label for="name">密码</label>
            <input type="password" id="password" placeholder="Password" v-model="password"/>
            <input type="submit" value="登录" class="btn_login"/>
        </form>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data(){
            return {
                name:"",
                password:""
            }
        },
        methods:{
            handleSubmit(){
                const token = Buffer.from(`client1:123456`, 'utf8').toString('base64');
                var _this = this;
                var params = new URLSearchParams();
                params.append('grant_type', 'password');
                params.append('username', this.name);
                params.append('password', this.password);

                this.$axios.post("http://localhost:9000/user/oauth/token", params, {
                    emulateJSON:true,
                    headers: {
                        'Authorization': `Basic ${token}`
                    }
                }).then(function (result) {
                    console.log(result.data.access_token);
                    let d = new Date();
                    d.setTime(d.getTime() + (1*24*60*60*1000));
                    let expires = "expires="+ d.toUTCString();
                    document.cookie = "Token=" + result.data.access_token + ";" + expires + ";path=/";
                    _this.$router.push("/");
                });
                // this.$router.push("/");
            }
        }
    }
</script>

<style scoped>
    .login form {
        width: 600px;
        margin: 0 auto;
    }
    .login .btn_login{
        background-color: #E3231B;
        border: 0px;
        margin-top: 10px;
    }
</style>
