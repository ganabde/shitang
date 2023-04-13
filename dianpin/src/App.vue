<script setup>
import Navbar from './components/navbar/index.vue'
import {ref} from "vue";

const data = ref([
    {label: '首页', link: 'https://www.baidu.com'},
    {label: '商家分类', link: '\'/src/assets/banner1.png\'', children: [{label: '首页1', link: 'https://www.baidu.com'}, {label: '首页2', link: 'https://www.baidu.com'}]},
    {label: '', link: 'https://www.baidu.com', children: [{label: '首页3', link: 'https://www.baidu.com'}, {label: '首页4', link: 'https://www.baidu.com'}, {label: '首页5', link: 'https://www.baidu.com'}]}
])
</script>

<template>
    <div class="container">
        <div class="nav-container">
            <navbar :data="data" />
        </div>
        <router-view></router-view>
    </div>
</template>

<style scoped>
.container {
    min-width: 800px;
}
.nav-container {
    position: sticky;
    left: 0;
    top: 0;
    height: 200px;
    //background: url("assets/bg.png") no-repeat;
    background-size: 100% 100%;
    display: flex;
    align-items: flex-end;
    z-index: 999;
}

</style>
