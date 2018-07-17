<%@ page import="com.sbt.fraud.client.data.GuiGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sbt.fraud.client.data.Gui" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    java.lang.String pageId = request.getAttribute("page").toString();
    List<GuiGroup> guiList = (List<GuiGroup>) request.getAttribute("guiList");
    GuiGroup gr1 = guiList.get(0);
    List<Gui> guiGroup = gr1.getGuiList();
%>
<html>
<head>
    <title>FRAUD</title>

    <style>
        .content {
            /*background-color: aliceblue;*/
            font-size: 14px;
            font-family: Tahoma;
        }

        .menu {
            font-family: Tahoma;
            font-size: 16px;

        }

        ul {
            /*background-color: aqua;*/
            list-style: none;
            padding: 5px 0 10px 0;
        }

        .menu a {
            color: blue;
            margin: 15px;
        }
    </style>
</head>
<body>
<table width="100%" style="height: 400px;" border="0">
    <tbody>
    <tr>
        <td colspan="2" align="center">
            <h1>FRAUD</h1>
        </td>
    </tr>
    <tr>
        <td width="10%" class="menu">
            <ul>
                <c:forEach var="item" items="<%=guiGroup%>">
                    <li><a href="/client/modules/${item.getGuiName()}" class="small">${item.getGuiName()}</a></li>
                </c:forEach>
            </ul>
        </td>
        <td width="90%" align="center" class="content">
            <jsp:include page="<%=pageId%>"/>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
