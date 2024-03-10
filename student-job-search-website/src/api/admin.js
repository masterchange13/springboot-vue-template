import request from '@/utils/request'
import toJson from '@/utils/toJson'

export const adminLogin = (registerData) => {
    registerData = toJson(registerData)
    // const params = new URLSearchParams()
    // for(let key in registerData){
    //     params.append(key,registerData[key]);
    // }
    return request.post('/login', registerData,  {
        headers: {
          "Content-Type": "application/json",
        },
    });
    // return request.post('/login', registerData)
}

export const getUserList = (userInfo) => {
    userInfo = toJson(userInfo)
    return request.post('/search', userInfo,{
        headers: {
          "Content-Type": "application/json",
        },
      });
}