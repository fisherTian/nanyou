/**
 *
 * http配置
 *
 */
// 引入axios以及element ui中的loading和message组件
import axios from 'axios'
import store from '../store'
import router from '../router/router';
import { getToken, setToken, removeToken } from '@/util/auth';
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css'// progress bar style
import { baseUrl,oauthUrl } from '@/config/env';
axios.defaults.timeout = 10000;
axios.defaults.baseURL = baseUrl;
axios.defaults.headers = {
  'Authorization': 'Basic Y2xpZW50OnNlY3VyaXR5'
};
NProgress.configure({ showSpinner: false })// NProgress Configuration
let cfg, msg;
msg = '服务器君开小差了，请稍后再试';
//HTTPrequest拦截
axios.interceptors.request.use(config => {
	NProgress.start() // start progress bar
  if (store.getters.token && (config.url.indexOf(oauthUrl)==-1)) {
    config.headers['Authorization'] = 'Bearer ' + store.getters.token; // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
  }
	return config
}, error => {
	console.log('err' + error)// for debug
	return Promise.reject(error)
})
//HTTPresponse拦截
axios.interceptors.response.use(data => {
	NProgress.done();
	return data
}, error => {
	NProgress.done();
	return Promise.reject(new Error(msg));

})

export default axios
