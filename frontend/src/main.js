import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import "@fortawesome/fontawesome-free/css/all.css";
import './assets/css/main.css';

Vue.config.productionTip = false;
import axios from 'axios'
import Notifications from 'vue-notification'

import VueLocalStorage from 'vue-localstorage'

import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import '@/helpers/AlertHelper'

Vue.use(VueMaterial)


import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/vue-loading.css';
Vue.use(Loading);
Vue.use(Notifications)
Vue.use(VueLocalStorage)

Vue.use({
  install (Vue) {
    Vue.prototype.$api = axios.create({
      baseURL: 'http://127.0.0.1:8081/api'
    })
  }
})
new Vue({
  vuetify,
  router,
  render: (h) => h(App),
}).$mount("#app");
