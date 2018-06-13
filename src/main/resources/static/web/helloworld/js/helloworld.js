var vm = new Vue({
    el: '#app',
    data: {
        message: 'Biu biu biu ...'
    },
    mounted: function () {
        this.message = _aes.encrypt("p@ssw0rd");
    },
    methods: {

    }
});

