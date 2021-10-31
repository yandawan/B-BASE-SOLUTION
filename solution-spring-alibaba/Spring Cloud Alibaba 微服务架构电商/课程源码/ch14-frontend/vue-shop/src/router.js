import Vue from "vue";
import VueRouter from "vue-router";

import productlist from "@/components/ProductList.vue";
import productdetail from "@/components/ProductDetail.vue";
import orderlist from "@/components/OrderList.vue";
import scorelist from "@/components/ScoreList.vue";
import login from "@/components/Login.vue";
import logout from "@/components/Logout.vue";
import buyok from "@/components/BuyOK.vue";

Vue.use(VueRouter);

const routes = [
    {
        path : "/productlist",
        component : productlist
    },
    {
        name: "productdetail",
        path : "/productdetail/:id",
        component : productdetail
    },
    {
        path : "/orderlist",
        component : orderlist
    },
    {
        path : "/scorelist",
        component : scorelist
    },
    {
        path : "/login",
        component : login
    },
    {
        path : "/logout",
        component : logout
    },
    {
        path : "/",
        component : productlist
    },
    {
        path : "/buyok",
        component : buyok
    },
];

var router =  new VueRouter({
    routes
})
export default router;