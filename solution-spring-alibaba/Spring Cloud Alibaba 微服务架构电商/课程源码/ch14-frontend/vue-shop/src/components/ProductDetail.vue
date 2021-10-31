<template>
    <div class="product-detail">
        <h4>商品详情</h4>
        <div class="iterm">
            <img :src="product.image">
        </div>
        <div class="iterm">
            <p class="name">{{product.name}}</p>
            <p class="price">{{product.price}}</p>
            <p class="desc" v-html="product.description"></p>
            <p>
                <button @click="buy()">立即购买</button>
            </p>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'ProductList',
        data() {
            return {
                product: ''
            }
            // return {
            //     productId: -1,
            //     productImg: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg',
            //     productName: '水果便携电脑',
            //     productPrice: '￥6698',
            //     productDesc: 'CPU型号：其他<br/>' +
            //         '运行内存：8GB<br/>' +
            //         '机身存储：256GB<br/>' +
            //         '存储卡：支持MicroSD(TF)<br/>' +
            //         '分辨率：1920 x 1080<br/>' +
            //         '屏幕比例：16:9'
            // }
        },
        mounted() {
            this.productId = this.$route.params.id;
            console.log(this.productId);
            this.getProduct()
        },
        methods: {
            async getProduct() {
                try {
                    const response = await fetch('http://localhost:9000/product/product?id=' + this.productId)
                    const data = await response.json()
                    this.product = data
                } catch (error) {
                    console.error(error)
                }
            },
            buy() {
                const info = {
                    "productImage": this.product.image,
                    "productName": this.product.name,
                    "productNum": 1,
                    "amount": this.product.price,

                };
                console.log("buy ", info);
                const token = this.getToken();
                var _this= this;
                this.$axios.post("http://localhost:9000/order/order", info,{
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                })
                .then(function (result) {
                    console.log(result);
                    _this.$router.push("/buyok");
                });


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
        }
    }
</script>

<style scoped>
    .product-detail img {
        width: 390px;
    }

    .product-detail .iterm {
        float: left;
        width: 400px;
    }

    .product-detail p {
        margin-left: 20px;
        font-size: 14px;
        text-align: left;
    }

    .product-detail .name {
        font: 700 16px Arial, "microsoft yahei"
    }

    .product-detail .price {
        font-size: 22px;
        font-family: "microsoft yahei";
        color: red;
    }

    .product-detail .desc {
        font-size: 14px;
        font-family: "microsoft yahei"
    }

    h4 {
        text-align: left;
    }

    .product-detail button {
        background-color: #E3231B;
        border: 0px;
    }
</style>
