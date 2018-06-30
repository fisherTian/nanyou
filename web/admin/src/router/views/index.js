const _import = require('../_import');
import Layout from '@/page/index/'
export default [{
    path: '/wel',
    component: Layout,
    redirect: '/wel/index',
    children: [{
        path: 'index',
        name: '首页',
        component: _import('wel')
    }]
}, {
    path: '/test',
    component: Layout,
    children: [{
        path: 'a',
        name: '动态路由',
        component: _import('test/testa', 'views'),
    }, {
        path: 'b',
        name: '参数路由',
        component: _import('test/testb', 'views')
    }]
}]
