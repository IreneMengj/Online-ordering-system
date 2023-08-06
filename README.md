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
    <th>User Type</th>
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
  

<h2>4. Development environment construction</h2>  

- Install the following software:
  - JDK8
  - Redis
  - Mysql
  - Maven
  - Intellij (recommended）
- Setting up the database environment
- The construction of Maven project
![image](https://github.com/IreneMengj/Online-ordering-system/assets/88880169/5d0822cd-269a-4ada-a141-207c43b5c5a8)


<h2>5. Project access</h2>

- system management background: localhost:8080/backend/index.html
- Login steps
  - Username & password displayed, click login.
  - username: admin
  - password: 123456

- mobile application: localhost:8080/front/index.html
- Login steps
  - Enter phone: 18508295860
  - Click verification code button
  - Wait for the code to appear in the corresponding location
  - Click login to proceed

<h2>6. Software preview</h2>

System management background:  

Login

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/f9ff79ba-6155-4888-b95e-d26c8e8ff9aa">

Employee Management  

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/90f64728-45ef-4dbe-8002-fac0027817df">

Catogory Management

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/3b43ca69-ee3f-423a-871d-88ddf998da20">

Dish Management

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/393ba08c-714f-4df0-b465-42a4dec87cd1">

Setmeal Management

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/33ac21fa-452c-4db0-9c68-30bc8d37f79e">

Order management

<img width="433" alt="image" src="https://github.com/IreneMengj/Online-ordering-system/assets/88880169/7b7312ca-da91-4fc2-a1f6-81e944c1b516">


<h2>Reference tutorial</h2>

"Video Tutorial: Black Horse Programmer - Regie Takeaway Project" (https://www.bilibili.com/video/BV13a411q753)



