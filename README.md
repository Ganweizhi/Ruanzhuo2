# api_v1.4              
params:前端传给后端
response:后端返回数据
## 1. 人员管理
**/list --人员列表**  #finsh by superlgc
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
         department, //部门
         degree,    //学历
         search,    //姓名
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
**/outlist --导出人员数据** #finsh by superlgc
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
**/delete --离职人员**     #finsh by superlgc
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
**/add --添加人员**     #finsh by superlgc
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
params:{
         wid
}
response:{
	success,   //1成功，0失败
}
```
##  2.薪酬管理
**/xclist --薪酬列表**            #finsh by superlgc
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
	    wid,      //工号
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
**/init --新wid**
```javascript
response:{
//返回最新wid
	wid
}
```
**/sfzz --上传身份证正面**     
```javascript
params:{
	wid
	file,       //文件
}
response:{
	success,   //1成功，0失败
}
```
**/sfzf --上传身份证反面**     
```javascript
params:{
	wid
	file,       //文件
}
response:{
	success,   //1成功，0失败
}
```
**/yhkz --上传银行卡正面**     
```javascript
params:{
	wid
	file,       //文件
}
response:{
	success,   //1成功，0失败
}
```
**/yhkf --上传银行卡反面**     
```javascript
params:{
	wid
	file,       //文件
}
response:{
	success,   //1成功，0失败
}
```
## 5. 日志管理   
**/loglist --日志列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    time:时间
    id:账号
    ip: ip
    name: 姓名
    currentPage: 当前页数
}
response:{
	data:[
		{
            date: "2019-01-01 12:46:25",
            id: "215869874",
            name: "admin",
            ip: "127.0.0.1",
            action: "修改员工资料"
        },
        {
            date: "2019-02-02 13:25:55",
            id: "236541555",
            name: "tset",
            ip: "127.123.202.111",
            action: "删除员工"
        },
	],
	totalPage   //数据总条数
}
```
## 6. 管理员列表
**/gllist --管理员列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    gid:账号
    name: 姓名
    currentPage: 当前页数
}
response:{
	data:[
        {
			gid: "12345",
			name: "admin",
  			role: ["超级管理员"],
 			state: 1,
		},
		{
			gid: "233333",
			name: "kkk",
			role: ["部门1管理员",",","部门2管理员"],
			state: 1,
		},
	],
	totalPage   //数据总条数
}
```
**/roleLists --角色列表(无需分页)**          
```javascript
params:{
}
response:{
	[
        {
			rid: "12345",
			name: "sfg",
			pagePower: "fffff0f0",
  			depPower: "01010101",
		},
		{
			rid: "12345",
			name: "sfg",
			pagePower: "fffff0a0",
  			depPower: "1010101",
		},
	],
}
```
**/gledit --管理员编辑**      
```javascript
params:{
    from:{
		gid
		name
		roleLists:["name1","name2","name3"]
		state
	}
}
response:{
	success,   //1成功，0失败
}
```
## 7. 角色管理
**/rolelist --角色列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    rid:账号
    name: 姓名
    currentPage: 当前页数
}
response:{
	data:[
        {
			rid: "6",
			name: "日志管理员",
			pagePower: "00f0",
			depPower: "000"
		},
 		{
			rid: "7",
			name: "角色管理员",
			pagePower: "f000",
			depPower: "000"
		}
	],
	totalPage   //数据总条数
}
```
**/roledelete --删除角色**     
```javascript
params:{
	rid,        //角色编号
}
response:{
	success,   //1成功，0失败
}
```
**/roleadd --添加角色**     
```javascript
params:{
	qxForm: {
        name: "",
        pagePower: "",
        depPower: ""
                }
}
response:{
	success,   //1成功，0失败
}
```
## 8. 角色-权限
**/qxedit --角色权限修改**     
```javascript
params:{
	qxForm: {
        rid: "",
        name: "",
        pagePower: "",
        depPower: ""
                }
}
response:{
	success,   //1成功，0失败
}
```
**/gladd --给某管理员添加某角色**     
```javascript
params:{
	rid,
	gid
}
response:{
	success,   //1成功，0失败
}
```
**/gllists --给某管理员移除某角色**     
```javascript
params:{
	rid,
	gid
}
response:{
	success,   //1成功，0失败
}
```
**/gldel --获取某角色下的管理员列表**     
```javascript
params:{
   	rid
}
response:{
    //具有改角色的管理员列表
   	[]
}
```

