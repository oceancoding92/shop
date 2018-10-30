<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser==null" >
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<s:property value="#session.existUser.username" ></s:property>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/order_findByUid.action?page=1">我的订单</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/user_quit.action">退出</a>|
				</li>
				</s:else>
		
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a href="${pageContext.request.contextPath }/cart_toCart.action">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>15726607618</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
		
					<li>
						<a href="${pageContext.request.contextPath}/index.action">首页</a>
						|
					</li>
					<s:iterator var="category" value="#session.clist">
					<li>
						<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#category.cid"/>&page=1"><s:property value="#category.cname" /></a>|
					</li>
					</s:iterator>
					
		</ul>
</div>
