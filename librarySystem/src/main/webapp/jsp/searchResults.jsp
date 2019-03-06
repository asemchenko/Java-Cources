<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jspf/language.jspf" %>
<html lang="${language}">
<head>
    <title><fmt:message key="searching_engine_results"/></title>
    <style>
        * {
            text-align: center;
            alignment: center;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }

        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;"></h1>
<h1><fmt:message key="founded_results"/> <c:out value="${publications.size()}"/></h1>
<table border="1px">
    <tr>
        <th><fmt:message key="title"/></th>
        <th><fmt:message key="udc"/></th>
        <th><fmt:message key="authors"/></th>
        <th><fmt:message key="year"/></th>
        <th><fmt:message key="tags"/></th>
    </tr>
    <c:forEach var="pub" items="${publications}">
        <tr>
            <td>
                <a href="publication?id=<c:out value="${pub.id}"/>">
                    <c:out value="${pub.title}"/>
                </a>
            </td>
            <td><c:out value="${pub.udcID}"/></td>
            <td><c:out value="${pub.authors}"/></td>
            <td><c:out value="${pub.publishYear}"/></td>
            <td><c:out value="${pub.tags}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
