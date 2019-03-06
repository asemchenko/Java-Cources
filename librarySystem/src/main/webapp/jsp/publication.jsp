<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jspf/language.jspf" %>
<html>
<head>
    <title><c:out value="${publication.title}"/></title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }

        table, th, td {
            border: 1px solid black;
        }

        h1, h2, table, th, td {
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <h1><fmt:message key="publication_record"/>"<c:out value="${publication.title}"/>"</h1>
    <tr>
        <th><fmt:message key="title"/></th>
        <td><c:out value="${publication.title}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="udc"/></th>
        <td><c:out value="${publication.udcID}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="authors"/></th>
        <td><c:out value="${publication.authors}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="pages_quantity"/></th>
        <td><c:out value="${publication.pagesQuantity}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="publication_year"/></th>
        <td><c:out value="${publication.publishYear}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="tags"/></th>
        <td><c:out value="${publication.tags}"/></td>
    </tr>
</table>
<h2><fmt:message key="references"/></h2>
<ul>
    <c:forEach var="ref" items="${publication.references}">
        <li>
            <a href="publication?id=<c:out value="${ref.id}" />">
                <c:out value="${ref.title}"/>
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
