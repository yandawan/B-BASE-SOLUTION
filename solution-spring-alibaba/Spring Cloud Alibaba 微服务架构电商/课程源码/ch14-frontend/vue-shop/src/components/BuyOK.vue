<template>
    <div class="buyok">
        <h4>购买成功</h4>
        <img src="https://tva1.sinaimg.cn/large/00831rSTly1gdk71becgij30ac0e8t9k.jpg">
        <br/>
        <button @click="jump()">订单列表</button>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        methods:{
            jump(){
                this.$router.push("/orderlist");
            }
        }
    }
</script>

<style scoped>
    .buyok form {
        width: 600px;
        margin: 0 auto;
    }
    .buyok img{
        height: 300px;
    }
    .buyok button {
        background-color: #E3231B;
        border: 0px;
    }
</style>
