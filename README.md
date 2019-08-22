# api_v1.2 (更新中)     
params:前端传给后端
response:后端返回数据
## 1. 人员管理
**/list --人员列表**              
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         time,       //签约时间
         etime,      //离职时间
         currentPage //当前页数
}
response:{
	data:[
		wid,
		name,
		sex,
		degree,
		department,
		lphone,
		state,
		signingTime,
		departureTime
	],
	totalPage,   //数据总条数
}
```
**/outlist --导出人员数据**
```javascript
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         time,       //签约时间
         etime,      //离职时间
}
response:{
	[],          //所有人员数据
}
```
**/download --下载导入模板**
```javascript
	//下载文件
```
**/delete --离职人员**     
*修改在职状态，添加离职时间*
```javascript
params:{
	wid,        //工号
}
response:{
	success,   //1成功，0失败
}
```
**/inlist --数据导入**
```javascript
params:{
	???
}
response:{
	success,   //1成功，0失败
}
```
**/add --添加人员**     
*详细数据见网页，用javabeen接收？*
```javascript
params:{
	msgForm:{
		wid: "2019500", //工号
		name: "张三", //姓名
		sex: "0", //性别
		nation: "汉族", //民族
		nationality: "中国", //国籍
		origin: "广东省东莞市", //籍贯
		idType: "0", //证件类型
		idNumber: "432503197505028819", //证件号
		education: "3", //学历
		degree: "0", //学位
		department: "0", //部门
		job: "清洁工", //岗位
		title: "工人", //职称
		lPhone: "12547896321", //手机号码
		sPhone: "12345", //短号
		email: "124452@qq.com", //邮箱
	},        //表单数据
}
response:{
	success,   //1成功，0失败
}
```
**/headimg --上传头像**     
```javascript
response:{
	success,   //1成功，0失败
}
```
##  2.薪酬管理
**/xclist --薪酬列表**            
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         currentPage //当前页数
}
response:{
	data[
		wid,
		name,
		sex,
		degree,
		department,
		baseWage
	],
	totalPage,   //数据总条数
}
```
**/xcdelete --删除薪资信息**      
*删除薪酬相关数据*
```javascript
params:{
	wid,        //工号
}
response:{
	success,   //1成功，0失败
}
```
**/xcedit --添加/修改薪酬信息**     
*详细数据见网页，用javabeen接收？*
```javascript
params:{
	xcForm:{
		baseWage: "12345", //基本工资
		bankName: "0", //银行名称
		bankId: "6222020903001483077" //银行账号
	},        //表单数据
}
response:{
	success,   //1成功，0失败
}
```
##  3.合同管理
**/htlist --合同列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
         department, //部门
         degree:,    //学历
         search:,    //姓名
         currentPage //当前页数
}
response:{
	data[
		wid,
		name,
		sex,
		degree,
		department,
		htSum   //合同数量
	],
	totalPage,   //数据总条数
}
```
**/htdelete --删除合同**      
*删除一条合同数据*
```javascript
params:{
	wid,        //工号
	htName      //合同名称
}
response:{
	success,   //1成功，0失败
}
```
**/htfile--上传合同**     
```javascript
params:{
	file,          //合同文件  
	htForm:{
		htName,  //合同名称
		useTime  //合同有效期
	},        //表单数据
}
response:{
	success,   //1成功，0失败
}
```
##  4.数据导入
**/detail --所有数据**
```javascript
params:{
         wid,        //工号
}
response:{
	msgForm = {
		wid: "2019500", //工号
		name: "张三", //姓名
		sex: "0", //性别
		nation: "汉族", //民族
		nationality: "中国", //国籍
		origin: "广东省东莞市", //籍贯
		idType: "0", //证件类型
		idNumber: "432503197505028819", //证件号
		education: "3", //学历
		degree: "0", //学位
		department: "0", //部门
		job: "清洁工", //岗位
		title: "工人", //职称
		lPhone: "12547896321", //手机号码
		sPhone: "12345", //短号
		email: "124452@qq.com", //邮箱
		img: "https://i.loli.net/2019/07/12/5d28410b6a20524513.jpg", //头像
		state: 1 //状态
	},
	xcForm = {
		baseWage: "12345", //基本工资
		bankName: "0", //银行名称
		bankId: "6222020903001483077" //银行账号
	},
	xcTable = [
		{
			time: "2019-09-09",
			baseWage: "6000元"
		},
		{
			time: "2019-08-09",
			baseWage: "6000元"
		}
	],
	htTable = [
		{
			name: "合同1", //合同名称
  			signingTime: "2019-06-20", //签约时间
			useTime: 24, //合同有效期
			state: 1 //状态
		},
		{
 			name: "合同2",
			signingTime: "2019-07-20",
			useTime: 12,
			state: 1
		}
	],
	fileListZ = {
		name: "201945412224zjz.jpg",
		url: "https://demo/201945412224zjz.jpg"
	}, //身份证正面，下同
	fileListF = {}, //身份证反面
	fileListyhkz = {}, //银行卡正面
	fileListyhkf = {} //银行卡证反面
}
```
**/zj --上传证件**     
```javascript
params:{
	data,        //参数：sfzz、zfzf、yhkz、yhkf
	file,       //文件
}
response:{
	success,   //1成功，0失败
}
```



