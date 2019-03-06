<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jspf/language.jspf" %>
<html lang="${language}" id="">
<head>
    <title><fmt:message key="library_system"/></title>
    <style type="text/css">
        .center, h1 {
            text-align: center;
        }

        input, button {
            margin: 10px;
        }
    </style>
    <script type="text/javascript">
        function addSearchingCondition() {
            let d = document.getElementById("basicInputDiv").cloneNode(true);
            let form = document.searchingForm;
            form.insertBefore(d, form.childNodes[form.childNodes.length - 4]);
        }

        function updateInputName(select) {
            let input = select.parentElement.getElementsByTagName('input')[0];
            input.name = select.selectedOptions[0].value;
        }
    </script>
</head>
<body>
<h1><fmt:message key="welcome_msg"/></h1>
<form action="find" method="get" class="center" id="searchingForm" name="searchingForm">
    <div id="basicInputDiv">
        <select form="searchingForm" id="mainSelect" onchange="updateInputName(this);">
            <option value="allAttributes"><fmt:message key="allAttributes"/></option>
            <option value="title"><fmt:message key="title"/></option>
            <option value="author"><fmt:message key="authors"/></option>
            <option value="tag"><fmt:message key="tags"/></option>
        </select>
        <input type="text" name="allAttributes">
    </div>
    <input type="submit" value="<fmt:message key="search" />">
    <button type="button" onclick="addSearchingCondition()">
        <img src="static/+.png" alt="+" height="15 px" width="15 px">
    </button>
</form>
</body>
</html>