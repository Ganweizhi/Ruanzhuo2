# api_v1.0 (更新中)

## 1. 人员管理
**/list --人员列表**
```c
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         time,       //签约时间
         etime,      //离职时间
         currentPage //当前页数
}
response：{
	略···,       //人员所有数据
	totalPage,   //数据总条数
}
```
**/outlist --导出人员数据**
```c
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         time,       //签约时间
         etime,      //离职时间
}
response：{
	略···,       //人员所有数据
}
```
**/download --下载导入模板**
```c
下载文件
```
**/delete --离职人员**
*修改在职状态，添加离职时间*
```c
params:{
	wid,        //工号
}
response：{
	success,   //1成功，0失败
}
```
**/inlist --数据导入**
```c
params:{
	？？？
}
response：{
	success,   //1成功，0失败
}
```
##  2.薪酬管理



