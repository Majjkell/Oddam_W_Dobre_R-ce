<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<form:form modelAttribute="donation" action="/submit" method="POST">
    <div class="tab"><h2>Zaznacz co chcesz oddać</h2>
    <form:checkboxes path="categories" items="${categories}"/>
    </div>
    <div class="tab"><h2>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h2>
<%--        <p>liczba worków 60l</p>--%>
        <form:label path="quantity">liczba worków 60l</form:label>
        <form:input path="quantity"/>
    </div>
    <div class="tab">
    <form:select path="institution" items="${institutions}"/>
    </div>
    <div class="tab">
    <form:input path="zipCode" />
    <form:input path="street" />
    <form:input path="city"/>
    <form:textarea path="pickUpComment"/>
    <form:input type="date" path="pickUpDate"/>
    <form:input type="time" path="pickUpTime" />
    </div>
    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
        </div>
    </div>
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>
</form:form>