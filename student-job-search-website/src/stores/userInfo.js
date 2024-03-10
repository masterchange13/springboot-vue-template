import {defineStore} from 'pinia'
import {ref} from 'vue'
const useUserInfoStore = defineStore('userInfo',()=>{
    //定义状态相关的内容

    const info = ref({})

    const setInfo = (newInfo)=>{
        info.value = newInfo
    }


    const removeInfo = ()=>{
        info.value = {}
    }

    const nickname = 'mao'

    return {info,setInfo,removeInfo}

},{persist:true})

export default useUserInfoStore;


const nickname = 'mao'