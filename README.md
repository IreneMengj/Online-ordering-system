# Online ordering system
<h2>1. Introduction</h2>

DeliverEase is an online food ordering system built as a reference to Black Horse Programmer's "Regie Takeaway" tutorial on Bilibili. It is developed using the Spring Boot + MybatisPlus + MySQL technology stack. The tutorial video is cited in the reference section.    

DeliverEase is an online food ordering software product, which includes two parts: system management background and mobile application. The system management background is designed for internal staff of catering enterprises, enabling them to efficiently manage and maintain dishes, packages, and restaurant orders. On the other hand, the mobile application is aimed at consumers, providing them with the ability to browse dishes, add items to their shopping carts, and place orders conveniently through their mobile devices.  

Compared to the original tutorial, I expanded the functionality by introducing batch processing for dish and setmeal management, features that were not included in the original tutorial. Additionally, I created a comprehensive set of functions for order details, which were not present in the original tutorial. Moreover, in the mobile application, I added the capability for users to view their own orders and implemented the user logout functionality.  

Furthermore, to make the project universally accessible in the Dublin area, I also converted the original Chinese pages into English, ensuring broader usability and ease of navigation for English-speaking users.   

The project is divided into three phases:
- The first phase mainly realizes the development of the system management background.
- The second phase mainly realizes the development of mobile applications.
- The third phase is mainly to optimize and upgrade the system to improve the access performance of the system.

<h2>2. Technology Selection</h2>

<table>
  <tr>
    <th>Layer</th>
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
    <th>User Type/th>
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
    <td>management background(employees)</td>
    <td>dish management;<br>
      setmeal management;<br>
      category management;<br>
      employee management;<br>
      order management.
    </td>
  </tr>
  </table>
  

Development environment construction
- Setting up the database environment
- The construction of Maven project
JDK8 本项目由JDK8构建，请在运行本项目前确保您的电脑已安装JDK8，若您使用的是IntelliJ IDEA，您可以很方便的在Project Structure中配置JDK版本。
MySQL 本项目使用MySQL数据库，请在运行本项目前确保您可以顺利连接到MySQL数据库。
Redis 本项目使用Redis缓存，请在运行本项目前确保您可以顺利连接到Redis数据库，如果实在不愿意使用Redis，请下载v1.0版本 的代码， 或在本项目的release/basic-functionality 分支中下载代码，该分支为本项目的基础功能分支，不包含Redis缓存功能。 Windows用户使用和配置可以参考:在 windows 上安装 Redis。
Maven 本项目使用Maven构建，初次打开项目时，IntelliJ IDEA会自动下载Maven依赖，若您的IntelliJ IDEA没有识别到Maven，请右键项目，选择Add Framework Support，选择Maven，然后点击OK。

<h2>Project Access</h2>
The default local addresses are as follows: 

- mobile application: localhost:8080/front/index.html  

- system management background: localhost:8080/backend/index.html

<h2>Reference tutorial</h2>

"Video Tutorial: Black Horse Programmer - Regie Takeaway Project" (https://www.bilibili.com/video/BV13a411q753)

