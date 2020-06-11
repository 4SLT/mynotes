import {get, post} from './http';
import {request} from './http'


// 文件夹
export const folder = {
  getFolderList: body => request('/notesFolder/getFolderList', body, 'get'),
}


// 文件
export const file = {
  getFolderList: body => request('/notesFile/getFileList', body, 'get'),
  getNoteInfoById: body => request('/notesFile/getNoteInfoById', body, 'get'),
}

// 笔记内容
export const content = {
  getContentList: body => request('/notesContent/getContentList', body, 'get'),
}
