import {
    baseUrl
} from '@/config/env'
const first = [{
    id: '001',
    label: "官网管理",
    href: '',
    icon: 'icon-iframe',
    meta: {},
    children: [{
      id: '001001',
      label: "测试A",
      href: '/test/a',
      icon: 'icon-dongtai',
      children: []
    }, {
      id: '001002',
      label: "测试B",
      href: '/test/b',
      icon: 'icon-canshu',
      children: []
    }]
}]
export const menu = [first];
