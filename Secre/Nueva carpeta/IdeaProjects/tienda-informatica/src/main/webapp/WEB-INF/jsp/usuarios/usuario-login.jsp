<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Fabricante" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.dao.FabricanteDTO" %>
<%@ page import="org.iesbelen.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesion</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }
    </style>
</head>

<%@ include file="/WEB-INF/jsp/formato/header.jspf" %>
<body>
<form action="${pageContext.request.contextPath}/tienda/login/" method="post">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Iniciar Sesion</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">
                <input type="hidden" name="__method__" value="login">
                <input type="submit" id="botonLogin"/>
            </div>

        </div>
    </div>

    <div class="clearfix">
        <hr/>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            Usuario
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="usuario"/>
        </div>
    </div>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            Password
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input name="password"/>
        </div>
    </div>
</form>
</body>
</html>
