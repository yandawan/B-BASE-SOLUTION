<template>
    <div class="order-list">
        <h4>个人中心
            <button id="btn-order">我的订单</button>
            <button class="muted-button" id="btn-score" @click="goScore()">我的积分</button>
        </h4>
        <div class="iterm" v-for="order in orders" :key="order.id">
            <div class="flex-row line-one"><span class="order-date">{{order.createTime}}</span><span class="order-no">订单号： {{order.orderNo}}</span>
            </div>
            <div class="flex-row line-two">
                <div class="flex-large "><img class="product-img" :src="order.productImage"/></div>
                <div class="flex-large padding-top-25">{{order.productName}}</div>
                <div class="flex-large padding-top-25">数量：{{order.productNum}}</div>
                <div class="flex-large padding-top-25 username">{{order.userName}}</div>
                <div class="flex-large padding-top-25">总金额 ￥{{order.amount}}</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'OrderList',
        mounted() {
            this.getOrders()
        },
        methods: {
            async getOrders() {

                try {
                    var _this = this;
                    const token = this.getToken();
                    this.$axios.get("http://localhost:9000/order/orders", {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    }).then(function (result) {
                        console.log(result);
                        _this.orders = result.data;
                    });
                    // const data = await response.json()
                    // this.orders = data
                } catch (error) {
                    console.error(error)
                }
            },
            goScore() {
                this.$router.push("/scorelist");
            },
            getToken()
            {
                var name = "Token=";
                var ca = document.cookie.split(';');
                for(var i=0; i<ca.length; i++)
                {
                    var c = ca[i].trim();
                    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
                }
                return "";
            }
        },
        data() {
            return {
                orders: []
            }
            // return {
            //     orders: [
            //         {
            //             id: 1,
            //             date: "2020-04-02 15:35:30",
            //             no: "116480227524",
            //             img: "https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg",
            //             productname: "水果便携电脑",
            //             num: 11,
            //             username: "小郭",
            //             total: "6698"
            //         },
            //         {
            //             id: 2,
            //             date: "2020-04-02 15:35:30",
            //             no: "116480227524",
            //             img: "https://tva1.sinaimg.cn/large/00831rSTly1gdjvblmw8uj31950u01kz.jpg",
            //             productname: "商务笔记本",
            //             num: 2,
            //             username: "小王",
            //             total: "66980"
            //         },
            //         {
            //             id: 3,
            //             date: "2020-04-02 15:35:30",
            //             no: "116480227524",
            //             img: "https://tva1.sinaimg.cn/large/00831rSTly1gdjvc6sc51j319d0u01ky.jpg",
            //             productname: "银色合金电脑",
            //             num: 3,
            //             username: "小王",
            //             total: "6690"
            //         },
            //     ]
            // }
        }
    }
</script>

<style scoped>
    .product-img {
        margin-top: 5px;
        width: 100px;
    }

    .icon-user {
        width: 12px;
    }

    .flex-row {
        margin: 0;
    }

    .padding-top-25 {
        padding-top: 25px;
    }

    .line-one {
        background-color: #F5F5F5;
        height: 31px;
    }

    .order-date {
        margin-top: 5px;
        margin-left: 20px;
        color: #aaa;
        font: 12px/150% tahoma, arial, Microsoft YaHei, Hiragino Sans GB, "\u5b8b\u4f53", sans-serif;
    }

    .order-no {
        margin-top: 5px;
        margin-left: 100px;
        color: #333;
        font: 12px/150% tahoma, arial, Microsoft YaHei, Hiragino Sans GB, "\u5b8b\u4f53", sans-serif;
    }

    .line-two {

        /*padding-top: 5px;*/
        color: #333;
        font: 12px/150% tahoma, arial, Microsoft YaHei, Hiragino Sans GB, "\u5b8b\u4f53", sans-serif;
    }

    .flex-large {
        text-align: left;
    }

    .iterm {
        border: 1px solid #E5E5E5;
        margin-bottom: 20px;
    }

    .username {
        border-left: 1px solid #E5E5E5;
        border-right: 1px solid #E5E5E5;
        padding-left: 30px;
    }

    h4 {
        text-align: left;
    }

    .order-list button {
        height: 20px;
        font-size: 14px;
        margin-bottom: 0px;
    }

    #btn-order {
        margin-left: 50px;
        height: 30px;
        padding: 5px 10px;
        background-color: #E3231B;
        border: 0px;
    }

    #btn-score {
        height: 30px;
        padding: 5px 10px;
        margin-left: 10px;
    }
</style>
