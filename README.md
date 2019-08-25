# 数据库（ER图）       
https://www.processon.com/view/link/5d0228bae4b0a65d809943d6
https://www.processon.com/view/link/5cb9c14ce4b09a3e45a36d42
# api_v3.0              
params:前端传给后端
response:后端返回数据
## 1. 人员管理
**/list --数据列表**  
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
         department:"部门",
         degree:"学历",
         search:"姓名",
         time:"签约时间",
         etime:"离职时间",
         currentPage:'当前页数"
}
response:{
	data:[
		{
			wid:"工号",
  			name: "姓名",
  			sex: "性别",
  			nation: "民族",
  			nationality: "国籍",
  			origin: "籍贯",
  			idType: "证件类型",
  			idNumber: "证件号",
  			education: "学历",
  			degree: "学位",
  			department: "部门",
  			job: "岗位",
  			title: "职称",
  			lPhone: "手机长号",
  			sPhone: "短号",
  			email: "邮箱",
  			baseWage: "基本工资",
  			bankName: "银行名称",
  			bankId: "银行账号",
			htSum: "合同数量",
  			signingTime:"签约时间"
  			departureTime:"离职时间",
			state: "状态",
			img: "头像",
			sfzz:"身份证正面",
			sfzf:"身份证反面",
			yhkz:"银行卡正面",
			yhkf:"身份证正面"
		},
		{}
	],
	totalPage:"数据总条数"
}
```
**/outlist --导出人员数据** #finsh by superlgc
```javascript
params:{
         department:"部门",
         degree:"学历",
         search:"姓名",
         time:"签约时间",
         etime:"离职时间"
}
response:{
        //所有人员数据
	[
		{
			wid:"工号",
  			name: "姓名",
  			sex: "性别",
  			nation: "民族",
  			nationality: "国籍",
  			origin: "籍贯",
  			idType: "证件类型",
  			idNumber: "证件号",
  			education: "学历",
  			degree: "学位",
  			department: "部门",
  			job: "岗位",
  			title: "职称",
  			lPhone: "手机长号",
  			sPhone: "短号",
  			email: "邮箱",
  			baseWage: "基本工资",
  			bankName: "银行名称",
  			bankId: "银行账号",
			htSum: "合同数量",
  			signingTime:"签约时间"
  			departureTime:"离职时间"
		},
		{}
	] 
}
```
**/download --下载导入模板**
**/delete --离职人员**     #finsh by superlgc
*修改在职状态，添加离职时间*
```javascript
params:{
	wid:"工号"
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/inlist --数据导入**
```javascript
params:{
	[
		{
			wid:"工号",
  			name: "姓名",
  			sex: "性别",
  			nation: "民族",
  			nationality: "国籍",
  			origin: "籍贯",
  			idType: "证件类型",
  			idNumber: "证件号",
  			education: "学历",
  			degree: "学位",
  			department: "部门",
  			job: "岗位",
  			title: "职称",
  			lPhone: "手机长号",
  			sPhone: "短号",
  			email: "邮箱",
  			baseWage: "基本工资",
  			bankName: "银行名称",
  			bankId: "银行账号",
			htSum: "合同数量",
  			signingTime:"签约时间"
  			departureTime:"离职时间"
		},
		{}
	] 
}
response:{
	success:"状态"   //1成功，0失败
}
```
## 2. tabs
**/init --新wid**
```javascript
response:{
	wid:"工号" //返回最新wid
}
```
**/add --添加人员**     #finsh by superlgc
*详细数据见网页，用javabeen接收*
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
	}        //表单数据
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/headimg --上传头像**     
```javascript
params:{
         wid:"工号"
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/xcedit --添加/修改薪酬信息**     #finsh by superlgc
*详细数据见网页，用javabeen接收？*
```javascript
params:{
	xcForm:{
		baseWage: "12345",             //基本工资
		bankName: "0",                 //银行名称
		bankId: "6222020903001483077"  //银行账号
	},        //表单数据
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/htdelete --删除合同**      
*删除一条合同数据*
```javascript
params:{
	wid:"工号",
	hid:"合同id"
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/htdelete --下载合同**      
```javascript
params:{
	wid:"工号"
	hid:"合同id"
}
```
**/htfile--上传合同**     
```javascript
file          //合同文件  
params:{
	htForm:{
		wid:"工号",
		htName:"合同名称"
		signingTime:"签约时间"
		useTime:"合同有效期"
	}        //表单数据
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/xctable--显示工资发放table**     
```javascript
params:{
	wid:"工号"
}
response:{
	[
		{
			time: "2019-09-09",
			baseWage: "6000元"
		},
		{
			time: "2019-08-09",
			baseWage: "6000元"
		}
	]
}
```
**/httable --显示合同table**     
```javascript
params:{
	wid:"工号"
}
response:{
	[
		{
			hid: "", //id
			htName: "合同1", //合同名称
  			signingTime: "2019-06-20", //签约时间
			useTime: 24, //合同有效期
			htUrl:""， //文件下地址(点了能直接下载)
			state: 1 //状态
		},
		{
			hid: "", //id
 			htName: "合同2",
			signingTime: "2019-07-20",
			useTime: 12,
			htUrl:""， //文件下地址(点了能直接下载)
			state: 1
		}
	],
}
```
**/sfzz --上传身份证正面**     
```javascript  
file       //文件
params:{
	wid:"工号"
}
response:{
	type: "sfzz",
	name: "2019500_sfz_zm.jpg", //命名wid+"_sfz_zm"
	url: "" //文件下地址(点了能直接下载)
}
```
**/sfzf --上传身份证反面**     
```javascript
file       //文件
params:{
	wid:"工号"
}
response:{
	type: "sfzf",
	name: "2019500_sfz_fm.jpg", //命名wid+"_sfz_fm"
	url: "" //文件下地址(点了能直接下载)
}
```
**/yhkz --上传银行卡正面**     
```javascript
file       //文件
params:{
	wid:"工号"
}
response:{
	type: "yhkz",
	name: "2019500_yhk_zm.jpg", //命名wid+"_yhk_zm"
	url: "" //文件下地址(点了能直接下载)
}
```
**/yhkf --上传银行卡反面**     
```javascript
file       //文件
params:{
	wid:"工号"
}
response:{
	type: "yhkf",
	name: "2019500_yhk_fm.jpg", //命名wid+"_yhk_fm"
	url: "" //文件下地址(点了能直接下载)
}
```
## 3. 日志管理   
**/loglist --日志列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    time:"时间",
    id:"账号",
    ip: "ip",
    name: "姓名",
    currentPage: "当前页数",
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
	totalPage:"数据总条数"
}
```
## 4. 管理员列表
**/gllist --管理员列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    gid:"账号",
    name: "姓名",
    currentPage: "当前页数"
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
	totalPage:"数据总条数"
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
			pagePower: "f000f",
  			depPower: "01010101",
		},
		{
			rid: "12345",
			name: "sfg",
			pagePower: "f001f",
  			depPower: "1010101",
		},
	]
}
```
**/gledit --管理员编辑**      
```javascript
params:{
    from:{
		gid:"管理员id",
		name:"名字",
		roleLists:["name1","name2","name3"],
		state:"状态"
	}
}
response:{
	success:"状态"   //1成功，0失败
}
```
## 5. 角色管理
**/rolelist --角色列表**          
*根据传参查询数据并分页返回(一页7条)*
```javascript
params:{
    rid:"账号",
    name: "姓名",
    currentPage: "当前页数"
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
	totalPage:"数据总条数"
}
```
**/roledelete --删除角色**     
```javascript
params:{
	rid:"角色编号"
}
response:{
	success:"状态"   //1成功，0失败
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
	success:"状态"   //1成功，0失败
}
```
## 6. 角色-权限
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
	success:"状态"   //1成功，0失败
}
```
**/gladd --给某管理员添加某角色**     
```javascript
params:{
	rid:"角色编号",
	gid:"管理员id"
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/gllists --给某管理员移除某角色**     
```javascript
params:{
	rid:"角色编号",
	gid:"管理员id"
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/gldel --获取某角色下的管理员列表**     
```javascript
params:{
   	rid:"角色编号"
}
response:{
	//所有具有该角色的管理员
   	[
		{
			gid:"管理员id",
			name:"名字"
		},
	]
}
```
## 7. 其他
**/department --获取部门列表**     
```javascript
response:{
    [
        {
        label: "部门1",
        value: "0"
        },
        {
        label: "部门2",
        value: "1"
        },
    ]
}
```
**/edit --查(用于权限控制)**
检测当前登录账号是否有编辑的权限
```javascript
params:{
   	index:"0或12" //对应人员和角色的编辑
}
response:{
	success:"状态"   //1成功，0失败
}
```
**/ryadd--增(用于权限控制)**
检测当前登录账号是否有添加人员的权限
```javascript
response:{
	success:"状态"   //1成功，0失败
}
```
