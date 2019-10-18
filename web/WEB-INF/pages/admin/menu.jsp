<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<a href="<c:url value="/"/>"><fmt:message bundle="${requestScope.language}" key="main.general"/></a><br>
<a href="admin/readers"><fmt:message bundle="${requestScope.language}" key="main.readers"/></a><br>
<a href="admin/subscriptions"><fmt:message bundle="${requestScope.language}" key="main.subscriptions"/></a><br>
<a href="books"><fmt:message bundle="${requestScope.language}" key="main.books"/></a><br>
<a href="authors"><fmt:message bundle="${requestScope.language}" key="main.authors"/></a><br>
<a href="about"><fmt:message bundle="${requestScope.language}" key="main.about"/></a><br>