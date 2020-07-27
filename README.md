# GameDataWeb
 一个基于Spring-boot和Vue构建的游戏数据后端项目。采用Springboot+mysql+Vue+element-ui构建的一个游戏数据Web管理项目。可以跟据多个数据字段进行联合查询
## 运行配置
### 1. 基础环境配置
#### 1.1 安装Java环境
#### 1.2 安装IDEA开发环境
### 2. 配置运行
#### 2.1 配置application.yml数据库连接，并将game.rar/game.sql文件导入到Mysql数据库中
#### 2.2 项目自动build并运行
#### 2.3 访问http://localhost:8080/

## 完整Web数据管理项目
本项目是山东大学软件学院Web数据管理课程设计完整项目的一部分，整体项目包含游戏数据爬取项目，游戏数据前端web项目，以及游戏数据后端项目。本项目有很好的学习价值运用，主要技术特色和应用：  

#### 1.GameDataSpider： 
Scrapy+selenium+PhantomJS构建出动态页面爬虫程序，爬取了游民星空，Steam,3DM网站的游戏数据并进行星系和集成。https://github.com/SlotherCui/GameDataSpider
#### 2.GameDataManagement： 
采用Vue+ Elementui 搭建出游戏数据web前端展示界面，界面美观操作简洁 https://github.com/SlotherCui/GameDataManagement
#### 3.GameDataWeb： 
采用Spring-boot+ mysql搭建游戏数据管理后端程序，可以实现多种字段的组合检索 https://github.com/SlotherCui/GameDataWeb

## 说明
*  __本项目采用真实爬取的数据，您可以随意使用，修改和扩展__
*  __本项目包含了简单的Spring-boot后端框架的使用，Vue前端Web框架的使用，MongoDB/Mysql数据库的使用，以及通过python构建爬虫轻松祝您成为技术小佬__
*  __我敢保证只要掌握了本项目，至少对于山东大学软件学院软件工程专业的所有课程设计/实验都都可以轻松快速完成(完全可以套模板)，A+在想你召唤（剩下全靠您实验报告中的吹B）。__
*  __期待你的star__