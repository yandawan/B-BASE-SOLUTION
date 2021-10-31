<template>
    <div class="product-list">
        <h4>商品列表</h4>
        <div class="iterm" v-for="product in products" :key="product.id">
            <img :src="product.image">
            <p><router-link :to="{name:'productdetail', params:{id:product.id}}">{{product.name}}</router-link></p>
            <p class="price">{{product.price}}</p>
        </div>

    </div>
</template>

<script>
    export default {
        name: 'ProductList',
        mounted() {
          this.getProducts()
        },
        methods:{
          async getProducts(){
              try {
                  const response = await fetch('http://localhost:9000/product/products')
                  const data = await response.json()
                  this.products = data
              } catch (error) {
                  console.error(error)
              }
          }
        },
        data() {
            return {
                products:[]
            }
            // return {
            //     products: [
            //         {
            //             id: 1,
            //             name: '水果便携电脑',
            //             price: '￥6698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvarklf0j319j0u0kjm.jpg'
            //         },
            //         {
            //             id: 2,
            //             name: '商务笔记本',
            //             price: '￥98',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvblmw8uj31950u01kz.jpg'
            //         },
            //         {
            //             id: 3,
            //             name: '银色合金电脑',
            //             price: '￥8698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvc6sc51j319d0u01ky.jpg'
            //         },
            //         {
            //             id: 4,
            //             name: '高性能工作站',
            //             price: '￥16698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvd07jhdj31950u0npd.jpg'
            //         },
            //         {
            //             id: 5,
            //             name: 'FruitBook Pro',
            //             price: '￥7698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjv7vuekij30zk0np78f.jpg'
            //         },
            //         {
            //             id: 6,
            //             name: '国行十代 X',
            //             price: '￥698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvdu1snej319f0u0b2a.jpg'
            //         },
            //         {
            //             id: 7,
            //             name: '畅玩大米8',
            //             price: '￥7698',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjv7vog9tj30zk0npdkg.jpg'
            //         },
            //         {
            //             id: 8,
            //             name: 'Hphone 18',
            //             price: '￥9998',
            //             img: 'https://tva1.sinaimg.cn/large/00831rSTly1gdjvehm2xij31940u0b29.jpg'
            //         },
            //     ],
            // }
        },
    }
</script>

<style scoped>
    .product-list img {
        width: 230px;
        height: 150px;
    }

    .product-list .iterm {
        float: left;
        width: 240px;
        border-bottom: 1px solid #E3E4E5;
        margin-bottom: 10px;
    }

    .product-list p {
        margin: 5px;
        font-size: 14px;
    }

    .product-list .price {
        color: #d33c40;
    }

    .product-list h4 {
        text-align: left;
    }
</style>
