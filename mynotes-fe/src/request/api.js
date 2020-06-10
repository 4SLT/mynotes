import {get, post} from './http';
import {request} from './http'

// 测试
export const test = {
  getHello: body => get('/hello', body),
  // postList:body=>post('/user/getList', body),
  requestGetPeople: body => request('/getPeople', body, 'get'),
  requestSearchTest: body => request('/searchTest', body, 'get'),
}

// 文件夹
export const folder = {
  getFolderList: body => request('/notesFolder/getFolderList', body, 'get'),
}


// 文件
export const file = {
  getFolderList: body => request('/notesFile/getFileList', body, 'get'),
}
