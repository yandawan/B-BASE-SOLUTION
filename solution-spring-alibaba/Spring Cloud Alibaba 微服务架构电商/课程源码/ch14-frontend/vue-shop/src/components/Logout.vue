<template>

</template>

<script>
    export default {
        name: '',
        mounted() {
            var _this=this;
            const token = this.getToken();
            this.$axios.delete("http://localhost:9000/user/api/logout", {
                emulateJSON: true,
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            }).then(function (result) {
                console.log(result.data.access_token);
                document.cookie = "Token=0;expires=" + new Date().toUTCString();
                _this.$router.push("/");
            });
        },
        methods: {
            getToken() {
                var name = "Token=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i].trim();
                    if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
                }
                return "";
            }
        }
    }
</script>
