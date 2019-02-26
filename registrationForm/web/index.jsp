<%@ page import="site.asem.model.entities.Record" %>
<%@ page import="site.asem.view.TextConstants" %>
<%@ page import="site.asem.view.RegexConstants" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>
<%--
  Created by IntelliJ IDEA.
  User: asem
  Date: 25.02.19
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%!
    TextConstants getLang(HttpServletRequest request) {
        return (TextConstants) request.getAttribute("lang");
    }

    RegexConstants getRegex(HttpServletRequest request) {
        return (RegexConstants) request.getAttribute("recordRegex");
    }

    Record[] getRecords(HttpServletRequest request) {
        return (Record[]) request.getAttribute("records");
    }

    Record getPrevRecord(HttpServletRequest request) {
        return (Record) request.getAttribute("recordFormValue");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <style>
        .inputForm {
            margin-top: 1%;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;"> Welcome to registration form</h1>
<% if (request.getAttribute("message") != null) {%>
<h1 style="text-align: center; color: red;"><%=(String) request.getAttribute("message")%>
</h1>
<%}%>
<form action="/add" method="post">
    <div class="inputForm">
        <span><%= getLang(request).INPUT_FIRST_NAME %></span>
        <input name="firstName" type="text"
               value='<%=getPrevRecord(request) != null ? getPrevRecord(request).getFirstName() : ""%>'
        >
    </div>
    <div class="inputForm">
        <span><%= getLang(request).INPUT_LAST_NAME %></span>
        <input name="lastName" type="text"
               value='<%=getPrevRecord(request) != null ? getPrevRecord(request).getLastName() : ""%>'>
    </div>
    <div class="inputForm">
        <span><%= getLang(request).INPUT_PATRONYMIC %></span>
        <input name="patronymic" type="text"
               value='<%=getPrevRecord(request) != null ? getPrevRecord(request).getPatronymic() : ""%>'>
    </div>
    <div class="inputForm">
        <span><%= getLang(request).INPUT_NICKNAME %></span>
        <input name="nickname" type="text"
               value='<%=getPrevRecord(request) != null ? getPrevRecord(request).getNickname() : ""%>'>
    </div>
    <div class="inputForm">
        <span><%= getLang(request).INPUT_MOBILE_PHONE %></span>
        <input name="mobilePhone" type="text"
               value='<%=getPrevRecord(request) != null ? getPrevRecord(request).getMobilePhone() : ""%>'>
    </div>
    <div class="inputForm">
        <input type="submit">
    </div>

</form>
<hr style="height: 2px; color: black; background-color: black;">
<%
    if (getRecords(request).length == 0) {
        out.println("<h1 style=\"text-align: center;\">Phone book is empty</h1>");
    } else { %>
<h1 style="text-align: center;">Phone book content</h1>
<table border="1px" width="80%" style="border-collapse: collapse; text-align: center; margin: auto;">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Patronymic</th>
        <th>Mobile phone</th>
        <th>Nickname</th>
    </tr>
    <%
        for (Record r : getRecords(request)) { %>
    <tr>
        <td><%=r.getFirstName()%>
        </td>
        <td><%=r.getLastName()%>
        </td>
        <td><%=r.getPatronymic()%>
        </td>
        <td><%=r.getMobilePhone()%>
        </td>
        <td><%=r.getNickname()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
