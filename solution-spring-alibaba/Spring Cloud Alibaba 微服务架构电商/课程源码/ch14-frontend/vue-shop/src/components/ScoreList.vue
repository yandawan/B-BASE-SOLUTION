<template>
    <div class="score">
        <h4>个人中心
            <button class="muted-button" id="btn-order" @click="goOrder()">我的订单</button>
            <button id="btn-score">我的积分</button>
        </h4>
        <h5>总积分：<span class="totalscore">{{score.score.score}}</span></h5>
        <table class="striped-table">
            <thead>
            <tr>
                <th>时间</th>
                <th>收入</th>
                <th>订单编号</th>
            </tr>
            </thead>

            <tbody>
            <tr v-for="score in score.scoreDetails" :key="score.id">
                <td>{{score.createTime}}</td>
                <td>{{score.score}}</td>
                <td>{{score.orderNo}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: 'ScoreList',
        mounted() {
            this.getScore()
        },
        methods: {
            goOrder() {
                this.$router.push("/orderlist");
            },

            async getScore() {
                try {
                    // const response = await fetch('http://localhost:8083/score?userId=1')
                    // const data = await response.json()
                    // this.score = data

                    var _this = this;
                    const token = this.getToken();
                    this.$axios.get("http://localhost:9000/score/score", {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    }).then(function (result) {
                        console.log(result);
                        _this.score = result.data;
                    });
                } catch (error) {
                    console.error(error)
                }
            },
            getToken() {
                var name = "Token=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i].trim();
                    if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
                }
                return "";
            }
        },
        data() {
            return {
                score: {}
            }

            // return {
            //     total: 888,
            //     scores: [
            //         {
            //             id: 1,
            //             date: '2020-04-02 11:23:41',
            //             num: 2,
            //             desc: "购买便携电脑奖励"
            //         },
            //         {
            //             id: 2,
            //             date: '2020-04-02 11:23:41',
            //             num: 20,
            //             desc: "购买手机"
            //         },
            //         {
            //             id: 3,
            //             date: '2020-04-02 11:23:41',
            //             num: 200,
            //             desc: "购买笔记本"
            //         }
            //     ]
            // }
        }
    }
</script>

<style scoped>
    .score .totalscore {
        color: #E3231B;
    }

    .score h4 {
        text-align: left;
    }

    .score h5 {
        text-align: left;
        padding-bottom: 5px;
        border-bottom: 1px solid #E5E5E5;
    }

    .score #btn-order {
        margin-left: 50px;
        height: 30px;
        padding: 5px 10px;
        font-size: 14px;
        margin-bottom: 0px;
    }

    .score #btn-score {
        height: 30px;
        padding: 5px 10px;
        font-size: 14px;
        margin-bottom: 0px;
        margin-left: 10px;
        background-color: #E3231B;
        border: 0px;
    }
</style>
