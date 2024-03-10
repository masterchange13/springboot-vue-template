import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/views/Login.vue'
import Count from '@/views/test/Count.vue'
import ViewVue from '@/views/master/View.vue'
import UserManagementVue from '@/views/master/UserManagement.vue'

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        // name: 'login',
        path: '/login',
        component: Login,
    },
    {
        path: '/count', component: Count
    },
    {
        path: '/master',
        component: ViewVue, 
        children: [
            {
                path: '/master/category',
                component: UserManagementVue
            }
        ]
    }
];

const router = createRouter ({
    history: createWebHistory(),
    routes: routes
})

export default router;




