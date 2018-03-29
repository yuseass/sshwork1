# sshwork1
大三下ssh第一次实验

实验1  基于Struts2的Shopping项目开发
一　实验目的：
使用Struts2编写运行Shopping2013项目，综合应用Struts2标签，action，拦截器等技术。
二　实验内容：
依据提供的Shopping2013项目，改写一个Struts2Shopping2013项目，完成用户登录，查看商品列表，将商品添加到购物车中等功能。
三  实验步骤： 
1、依据原有的Shopping2013项目，创建使用Struts2改写的Struts2Shopping2013项目，所有页面中必须使用Struts2标签。
2、编写一个userLogin.jsp页面，如下：
 
使用用户名qtech，密码java登录，经名为名myLogin的action处理后显示商品列表界面
 
添加到购物车后：
 
并可进行购物车内的修改数量，删除项目，清空购物车(要求以下action使用实现类action.CartAction.java中的不同方法，添加到购物车addToCart，修改modifyGoods，删除deleteGoods，清空购物车clearCart)
3、参考书4.5.12，创建一个进行权限控制的拦截器authority，实现类为intercepter. AuthorityInterceptor。并在Struts.xml文件中设置新的拦截器栈mydefault作为qtech包的默认拦截器。
4、拦截器只能对所有action进行拦截，但不能对查看jsp文件的请求进行拦截（servlet filter可以对所有请求进行拦截），解决方案是将所有JSP页面放到WEB-INF下，在配置文件最后添加：
<action name="*">
		<result name="success">/WEB-INF/content/{1}.jsp</result>
</action>
这时默认调用系统的ActionSupport类，返回SUCCESS，这样对JSP所有的访问都可以通过action来进行并使用拦截器进行拦截。
依据以上提示，实现拦截器栈mydefault对所有请求的拦截过滤，如在地址栏中输入：
http://localhost:8888/Struts2ShoppingLecture/userCart访问userCart.jsp页面，则显示：
 
5、最后项目的结构如下：
 
 

实验报告附录部分包括：
1.	struts.xml文件
2.	action.CartAction.java类文件
3.	userCart.jsp和goodslist.jsp
