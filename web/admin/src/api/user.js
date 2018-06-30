import request from '@/router/axios'
import { userInfo, tableData } from '@/mock/user'
import { menu, menuAll } from '@/mock/menu'
import { baseUrl } from '@/config/env'
import apiServ from '@/router/axios'
export const loginByUsername = (username, password) => {
  return apiServ.request({
    method: 'post',
    url: '/oauth/token',
    params: {
      username: username,
      password: password,
      grant_type : 'password'
    }
  })
};

export const getUserInfo = () => {
  return apiServ.request({
    method: 'get',
    url: '/user/info',
    params: {}
  })
};

export const getMenu = (parentId) => {
    return new Promise((resolve, reject) => {
        if (parentId != 1) parentId = 0;
        resolve({ data: menu[parentId] });
    })
}
export const getMenuAll = () => {
    return new Promise((resolve, reject) => {
        resolve({ data: menu[0] });
    })
}

export const getTableData = (page) => {
    return new Promise((resolve, reject) => {
        resolve({ data: tableData });
    })
}
export const logout = () => {
    return new Promise((resolve, reject) => {
        resolve();
    })
}



