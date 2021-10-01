# **RuoYi-Cloud若依系统的环境部署**

为了开发项目，使用了RuoYi-Cloud系统，在前期需要搭建好相应的环境，然后再进行实际开发。下面是综合 [RuoYi 官方在线文档](http://doc.ruoyi.vip/)的相应介绍及自己在搭建中的步骤以及遇到的一些问题处理，总结出下面的文档。

## 前期准备工作

### 1.JDK >=1.8 (推荐1.8版本)

查看版本：命令行（命令提示符）输入"java -version"

安装配置可以参考：

- 2021最新Java JDK1.8的安装教程（帮助理解）[https://blog.csdn.net/qq_43250118/article/details/113324562](https://blog.csdn.net/qq_43250118/article/details/113324562)

- JDK1.8下载、安装和环境配置教程 ：[https://blog.csdn.net/weixin_44084189/article/details/98966787](https://blog.csdn.net/weixin_44084189/article/details/98966787)

### 2.Mysql >= 5.7.0 (推荐5.7版本)

查看版本：命令行（命令提示符）输入"mysql --help"，然后查看第一行内容

安装配置可以参考：

- MySQL 5.7.27详细下载安装配置教程 [https://blog.csdn.net/weixin_43395911/article/details/99702121](https://blog.csdn.net/weixin_43395911/article/details/99702121)

- 关于路径的描述与修改，都应与你电脑的实际安装路径一致
- 注意ini的文件里的路径

### 3.Redis >= 3.0

查看版本：命令行（命令提示符）输入"redis-server -v"

安装配置可以参考：

- Redis下载及安装(windows版) [https://blog.csdn.net/weixin_43527241/article/details/88723408](https://blog.csdn.net/weixin_43527241/article/details/88723408)

### 4.Maven >= 3.0

查看版本：命令行（命令提示符）输入"mvn -version"  *前提是 maven环境变量必须配置好否则无法查看*

安装配置可以参考：

- maven安装及配置（详细版）[https://blog.csdn.net/weixin_43811057/article/details/108235117](https://blog.csdn.net/weixin_43811057/article/details/108235117)

### 5.Node >= 10

查看版本：命令行（命令提示符）输入"node -v"

安装配置可以参考：

- Nodejs超详细安装及环境配置 [https://blog.csdn.net/weixin_43937315/article/details/106901979](https://blog.csdn.net/weixin_43937315/article/details/106901979)
- Node.js的安装及环境配置【超详细】[https://blog.csdn.net/weixin_42881768/article/details/105028164](https://blog.csdn.net/weixin_42881768/article/details/105028164)

### 6.~~nacos >= 1.1.0~~ (==ruoyi-cloud >= 3.0.0需要下载nacos >= 2.x.x版本==)

查看nacos版本: 找到自己安装的文件夹\bin\双击startup.cmd文件，启动nacos，就可以看到版本号，需要大于2.0。

- 另一种启动方式，cmd进入 自己安装的文件夹\bin，输入"startup.cmd -m standalone" 启动nacos，也能看到版本号

安装可以参考：

- windows下安装nacos [https://blog.csdn.net/q15102780705/article/details/102571353](https://blog.csdn.net/q15102780705/article/details/102571353)
- 这里只需要安装好

### 7.sentinel >= 1.6.0

查看版本：查看下载的文件名

安装配置可以参考：

- Sentinel的安装并使用 [https://blog.csdn.net/userdatou/article/details/104825896](https://blog.csdn.net/userdatou/article/details/104825896)

- 执行命令的版本号应与下载的一致。

### 8.Navicat*（为更好使用Mysql）

官网下载，例如 Navicat 15 for MySQL

### 9.IntelliJ IDEA* （若无可运行java的IDE，推荐下载）

官网下载，最新版。



至此，前期准备的软件下载完成。

## 运行系统

### 后端运行

1、前往`Gitee`下载页面([https://gitee.com/y_project/RuoYi-Cloud (opens new window)](https://gitee.com/y_project/RuoYi-Cloud))下载解压到工作目录
2、导入到你的IDE中打开该文件夹。(IDEA)   会自动加载`Maven`依赖包，初次加载会比较慢（根据自身网络情况而定）
3、创建数据库`ry_cloud`并导入数据脚本`ry_2021xxxx.sql`（必须），quartz.sql（可选）
4、创建数据库`ry_config`并导入数据脚本`ry_config_2021xxxx.sql`（必须）
5、配置`nacos`持久化，在你的nacos文件夹里找到`conf/application.properties`文件，以记事本打开在最后添加下面的代码。（其中，最后两行的db.user与db.password该修改为你的mysql用户名和密码）用以增加支持`mysql`数据源配置。

```yml
# db mysql
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://localhost:3306/ry-config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=password
```

- *还应登上nacos做相应修改以适配ruoyi系统。*建议询问项目负责人或自行查询nacos配置文档或[集成nacos配置中心 | RuoYi](http://doc.ruoyi.vip/ruoyi-cloud/cloud/seata.html#集成nacos配置中心)

6、因为前面已经导入ruoyi的文件进入IDE，所以可以在你的IDE中，找到下面的模块并运行（启动没有先后顺序）

- RuoYiGatewayApplication （网关模块 必须）
- RuoYiAuthApplication （认证模块 必须）
- RuoYiSystemApplication （系统模块 必须）
- RuoYiMonitorApplication （监控中心 可选）
- RuoYiGenApplication （代码生成 可选）
- RuoYiJobApplication （定时任务 可选）
- RuoYFileApplication （文件服务 可选）

7、集成`seata`分布式事务（可选配置，默认不启用）

创建数据库`ry-seata`并导入数据脚本`ry_seata_2021xxxx.sql`

8.成果测试

此时，可以测试后端运行成果。运行前需要先启动`nacos`，运行成功可以通过([http://localhost:8080 ](http://localhost:8080/))访问，应能访问成功，但是不会出现静态页面。



### 前端运行

1.在电脑的文件管理中，进入你下载的ruoyi文件里的ruoyi-ui项目里，启动cmd。或者启动cmd然后再进入ruoyi-ui文件夹。cmd命令行要达成如下

![image-20210928132822100](C:\Users\乱想\AppData\Roaming\Typora\typora-user-images\image-20210928132822100.png)

2.通过npm安装依赖

![image-20210928133239054](C:\Users\乱想\AppData\Roaming\Typora\typora-user-images\image-20210928133239054.png)

具体命令可以用 "npm install --registry=https://registry.npm.taobao.org"

- 若你的npm已换好镜像源，也可直接用 "npm install"。而不需用上面的命令

**注意，请不要使用cnpm等脚本。若是此处下载失败，请查看路径，node版本，npm版本，等各种常见处理方法。若还是不行，（1）首先删除你的ruoyi-ui文件夹里的 node_modules文件夹、package.json文件、package-lock.json文件。然后在此文件夹内运行cmd命令 "npm cache clean --force"，清除缓存，（2）可以复制同项目者同ruoyi-ui文件夹里的node_modules文件夹、package.json文件、package-lock.json文件，共三个文件到你的ruoyi-ui文件夹里。****

3.本地开发，启动项目

在同样的路径下的cmd输入命令"npm run dev"

![image-20210928133657470](C:\Users\乱想\AppData\Roaming\Typora\typora-user-images\image-20210928133657470.png)

4、打开浏览器，输入：([http://localhost:80 (opens new window)](http://localhost/)) 默认账户/密码 `admin/admin123`）
若能正确展示登录页面，并能成功登录，菜单及页面展示正常，则表明环境搭建成功。

**后面需要重新开启服务的话，需要开启nacos，Mysql，redis，进IDE启动网关、认证、系统模块，再进入ruoyi-ui目录启动"npm run dev"**

*文中若有错漏，欢迎指出。若有交流建议，欢迎评论告诉。*

