<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <!-- for Bootstrap CSS -->
        <!-- <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>  -->
        <!-- YOUR own local CSS -->
        <link rel="stylesheet" href="/css/style.css"/>
    </head>
<body>
    <header>
        <h1>
            <span>Your Gold:</span><span class="titleCounter generalBorder center">
                <c:out value="${ninja_gold}"/>
            </span>
            <span class="reset">
             <a href="/reset">Reset</a>
            </span>
        </h1>
    </header>
    <main>
        <div class="buildingCard generalBorder">
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="farm" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="cave" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="house" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>Quest</h2>
            <p>(earns 0-50 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="quest" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
    </main>
    <footer>
        <span>Activities</span>
        <div class="activities_chart generalBorder">
            <c:forEach var="elt" items="${activities_texts}">
                    <c:forEach var="entry" items="${elt}">
                        <p class=${entry.key? "true_text" : "false_text" }>
                            <c:out value="${entry.value}" />
                        </p>
                    </c:forEach>
            </c:forEach>
        </div>
    </footer>
  
  <!-- link Js -
  <script type="text/javascript" src="/js/main.js"></script> 
  - For any Bootstrap that uses jquery -
  <script src="/webjars/jquery/jquery.min.js"></script> 
  -For any Bootstrap that uses JS -
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
</body>
</html>
