import {get, post} from './http';
import {request} from './http'

// 测试
export const test = {
  getHello: body => get('/hello', body),
  // postList:body=>post('/user/getList', body),
  requestGetPeople: body => request('/getPeople', body, 'get'),
}
