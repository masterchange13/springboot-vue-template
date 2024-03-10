import request from '@/utils/request'
import axios from 'axios'

export const getResult = async()=>{
    request.get('/api/login').then(res=>{
        return res
    })
}