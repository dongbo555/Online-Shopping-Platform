# Online-Shopping-Platform
Online Shopping Platform, shopping, cart ;  jsp ,servlet ,mysql,

安装过程：
1.用Eclipse或者myEclipse导入项目文件
2.有可能缺少相应的jar包，如果缺少的话，修改一下buildpath，或者下载下来放到web-Info下的lib中
3.用mysql创建个shopping数据库，并导入database中的sql文件
4.连接mysql数据库的工具栏在cn.shopping.util.DBhelper中，在里面修改账号或者密码
5.目前已经实现了登录、注册、用户保存到session中、浏览商品、商品详情、加入购物车、浏览购物车等

实现所用到的技术：
jsp、Servlet、mysql
在用Servlet获取方法时，这里用到了反射机制，其他的都比较简单，利用的就是Servlet的技术
