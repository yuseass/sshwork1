<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="getAllGoods">继续购物</a>
  <a href="cart!clearCart">清空购物车</a>
  
  
  <s:if test="#session.cart!=null">
  	
	<table border="1">
		<tr>
			<td>物品编号</td>
			<td>物品名称</td>
			<td>物品价格</td>
			<td>物品数量</td>
			<td></td>
		</tr>


		<s:iterator  value="#session.cart" var="item">


			<tr>

				<form action="cart" method="post">

					<input type="hidden" name="goodsId" value="${item.goods.goodsId}"/>
					<td>${item.goods.goodsId}</td>
					<td>${item.goods.goodsName}</td>
					<td>${item.goods.price}</td>
					<td><input type="text" name="quantity" value="${item.quantity}"/></td>
					<td><input type="submit" name="action" value="修改" onclick="modifyGoods(this.form)" />
						<input type="submit" name="action" value="删除" onclick="deleteGoods(this.form)"/></td>
				</form>

			</tr>






		</s:iterator>


  	
  	</table> 
  </s:if>
  	
	

   <s:if test="#session.cart==null">
   	购物车为空，请直接购物！
	</s:if>
  
  
  
  <script type="text/javascript">
	  function modifyGoods(form) {
		  form.action="cart!modifyGoods";
      }
	  function deleteGoods(form) {

		  form.action="cart!delete";
		  
      }
	  
	  
  </script>
  

  </body>
</html>
