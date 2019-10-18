<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<div align="center">

<%--    <spring:form method="post" modelAttribute="user" action="addUser">--%>

<%--        Name: <spring:input path="login"/> <br/>--%>
<%--        Password: <spring:input path="password"/>   <br/>--%>
<%--        Passport number: <spring:input path="passportNumber"/>   <br/>--%>
<%--        Full Name: <spring:input path="fullName"/>   <br/>--%>
<%--        Address: <spring:input path="address"/>   <br/>--%>
<%--        E-mail: <spring:input path="email"/>   <br/>--%>
<%--        <spring:button>Next Page</spring:button>--%>

<%--    </spring:form>--%>


    <spring:form modelAttribute="user" action="registration" method="post">
        <table>
            <tr>
                <th colspan="2" class="head"><fmt:message bundle="${requestScope.language}" key="registration.header"/></th>
            </tr>
            <c:if test="${not empty requestScope.registrationError}">
                <tr>
                    <td colspan="2" class="error center"><c:out value="${requestScope.registrationError}"/></td>
                </tr>
            </c:if>
            <tr>
                <td class="right"><fmt:message bundle="${requestScope.language}" key="registration.login"/><b class="required">*</b>:</td>
                <td>
                    <spring:input path="login"/>
                </td>
            </tr>
            <tr>
                <td class="right"><fmt:message bundle="${requestScope.language}" key="registration.password"/><b class="required">*</b>:</td>
                <td>
                    <spring:input path="password"/>
                </td>
            </tr>
            <tr>
                <td class="right"><fmt:message bundle="${requestScope.language}" key="registration.email"/><b class="required">*</b>:</td>
                <td>
                    <spring:input path="email"/>
                </td>
            </tr>

            <tr>
                <td class="right"><fmt:message bundle="${requestScope.language}" key="registration.name"/><b class="required">*</b>:</td>
                <td>
                    <spring:input path="firstName"/>
                </td>
            </tr>
            <tr>
                <td class="right"><fmt:message bundle="${requestScope.language}" key="registration.last-name"/><b class="required">*</b>:</td>
                <td>
                    <spring:input path="lastName"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input class="link-lookalike" type="submit" value="<fmt:message bundle="${requestScope.language}" key="registration.enter"/>"/></td>
            </tr>
        </table>
    </spring:form>
</div>