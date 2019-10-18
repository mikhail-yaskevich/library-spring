<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<div class="header-logo">--%>
    <a href=""><img class="header-logo" src="resources/img/logo.ico"/></a>
<%--</div>--%>
<div class="header-user">
    <a href="login"><fmt:message bundle="${requestScope.language}" key="main.enter"/></a>
    /
    <a href="registration"><fmt:message bundle="${requestScope.language}" key="main.sign-up"/></a>
</div>
<h1>Библиотека "Давай почитаем"</h1>
<%--<c:import url="/WEB-INF/jsp/common/locale.jsp" charEncoding="utf-8"/>--%>