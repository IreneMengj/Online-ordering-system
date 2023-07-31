# Online ordering system
<h2>1. Introduction</h2>
Reggie is an enterprise-level project using <b>SpringBoot + SSM</b> Framework. It was a software product customized for catering enterprises. This system is mainly divided into the management background and the front-end operation. Employees can use the background to manage dishes, set meals, orders, and so on. Customers can browse dishes and place orders through the mobile application.<br>
<br>
This project will be developed in two phases. The first phase is to realize basic functions: 1. Employees can operate the backend system; 2. Customers can log in to the order system and place orders. The second phase is to optimize and upgrade the system and improve system access performance. The first phase has been finished.<br>

<h2>2. Technology Selection</h2>

<table>
  <tr>
    <th></th>
    <th>Technologies</th>
  </tr>
  <tr>
    <td>User Layer</td>
    <td>H5, VUE.js, ElementUI</td>
    
  </tr>
  <tr>
    <td>Gateway Layer</td>
    <td>Nginx</td>
  </tr>
  <tr>
    <td>Application Layer</td>
    <td>SpringBoot, Spring, SpringMvc,lombok, SpringSession</td>
    
  </tr>
  <tr>
    <td>Database Layer</td>
    <td>MySQL, Mybatis, Mybatis Plus, Redis</td>
  
  </tr>
  <tr>
    <td>Tool</td>
    <td>Git, Maven, Junit</td>
    
  </tr>
  
</table>

<h2>3. Function Frame</h2>

<table>
  <tr>
    <th></th>
    <th>Functions</th>
  </tr>
  <tr>
    <td>mobile app(customers)</td>
    <td>
    log in through the phone number;<br>
    browse dishes;<br>
    add to shopping cart;<br>
    browse history orders;<br>
    manage addresses.  
    </td>
    
  </tr>
  <tr>
    <td>management background(enterprise)</td>
    <td>menu management;<br>
      setmeal management;<br>
      category management;<br>
      employee management;<br>
      order management.
    </td>
  </tr>
  </table>

ha

Development environment construction
- Setting up the database environment
- The construction of Maven project
- 
en
JDK8 本项目由JDK8构建，请在运行本项目前确保您的电脑已安装JDK8，若您使用的是IntelliJ IDEA，您可以很方便的在Project Structure中配置JDK版本。
MySQL 本项目使用MySQL数据库，请在运行本项目前确保您可以顺利连接到MySQL数据库。
Redis 本项目使用Redis缓存，请在运行本项目前确保您可以顺利连接到Redis数据库，如果实在不愿意使用Redis，请下载v1.0版本 的代码， 或在本项目的release/basic-functionality 分支中下载代码，该分支为本项目的基础功能分支，不包含Redis缓存功能。 Windows用户使用和配置可以参考:在 windows 上安装 Redis。
Maven 本项目使用Maven构建，初次打开项目时，IntelliJ IDEA会自动下载Maven依赖，若您的IntelliJ IDEA没有识别到Maven，请右键项目，选择Add Framework Support，选择Maven，然后点击OK。
