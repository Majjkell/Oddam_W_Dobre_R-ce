<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<section class="help">
    <h2>Komu pomagamy?</h2>

    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>


        <ul class="help--slides-items">

            <c:forEach items="${instytutions}" var="i" varStatus="s">
                    <c:if test="${s.index == 0||s.index == 2}">
                <li>
                    </c:if>
                    <div class="col">
                        <div class="title">Fundacja "${i.name}"</div>
                        <div class="subtitle">Cel i misja: ${i.description}</div>
                    </div>
                        <c:if test="${s.index == 1 ||s.index == 3}">
                </li>
                    </c:if>
            </c:forEach>
        </ul>
    </div>

</section>