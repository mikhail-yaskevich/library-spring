<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language.title"/>
<%--<div class="header-logo">--%>
<a href="main"><img class="header-logo" src="resources/img/logo.ico"/></a>
<%--</div>--%>
<div class="header-user">
    <c:if test="${not empty user }">
        <b>
            <c:if test="${empty user.getFirstName() or empty user.getLastName()}">
                <a class="without-underline" href="mailto:${user.getEmail()}">
                    <c:out value="${user.getLogin()}"/>
                </a>
            </c:if>
            <c:if test="${not empty user.getFirstName() and not empty user.getLastName()}">
                <a class="without-underline" href="mailto:${user.getEmail()}">
                    <c:out value="${user.getFirstName()}"/>
                    <c:out value=" "/>
                    <c:out value="${user.getLastName()}"/>
                </a>
            </c:if>
        </b>
        <a href="logout"><fmt:message key="main.logout"/></a>
    </c:if>
</div>
<h1>Библиотека "Давай почитаем"</h1>
<%--<c:import url="/WEB-INF/jsp/common/locale.jsp" charEncoding="utf-8"/>--%>