#FastAndroid 交流平台
* QQ群：263725749
----

#FastAndroid简介 
 FastAndroid是一个借鉴了JavaWeb三大框架优秀思想的移动端android框架，使用FastAndroid可以避开android本身复杂的API逻辑，将更多的时间投入到项目本身的业务逻辑中，从而减少开发成本，解放一定量生产力。

##目前FastAndroid主要有以下模块：

* MVC模块：实现视图与模型的分离。

* ioc模块：完全注解方式就可以进行UI绑定、res中的资源的读取、以及对象的初始化。

* 数据库模块：使用了数据库连接池+JavaBean对sqlite进行操作、并支持自动见表、注解建立约束等。

* http模块：通过httpclient进行封装http数据请求，支持异步及同步方式加载。另外为了使网络通信更快，更简单，更健壮，封装了Google I/O 2013 发布的volley框架，在此强烈建议数据量不大但是通信频繁的场景使用Volley。

* 缓存模块：支持本地缓存和内存缓存，可以选择性的配置。

* 图片模块：imageview加载图片的时候无需考虑图片加载过程中出现的oom和android容器快速滑动时候出现的图片错位等现象。

* 配置器模块：简单易用的配置，通过封装android的SharePreference实现。

* 日志打印模块：可以较快的轻易的是实现日志打印，支持日志打印的扩展，目前支持对sdcard写入本地打印、以及控制台打印

* 下载器模块：可以简单的实现多线程下载、后台下载、断点续传、对下载进行控制、如开始、暂停、删除等等。
	
* 网络状态检测模块：当网络状态改变时，对其进行检测。

* JSON：超级轻量的JSON格式串序列及反序化操作
* 常用工具类：时间、字符串、IO、android版本等工具类

---
## 使用FastAndroid快速开发框架需要有以下权限：


	<!--检查网络状态 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <!-- 通过包名杀死应用 -->
    <uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES" />
    <!-- 访问internet网络 -->
    <uses-permission android:name="android.permission.INTERNET" />
    <!-- 往SDCard写入数据 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- 在SDCard中创建与删除文件 -->
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />

----

#关于使用
* 1.下载FastAndroid到本地
* 2.为自己android项目添加与FastAndroid的依赖关系
* 3.由于视图注解用的是butterknife，需要在eclipse里面进行相关的配置，否则会出现空指针异常，详情参见butterknife网站http://jakewharton.github.io/butterknife/ide-eclipse.html
* 4.具体的API使用请参见FastAndroidDemo

#关于作者
* 一位比普通码农掌握更先进生产方式的码农


