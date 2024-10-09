<html>
<body>
    <h1>Hello world</h1>
<p> Current Time: <%= new java.util.Date()%></p>
    <form action="/mainServlet" method="get">
        <input type="number" name="max">
        <button type="submit">Submit</button>
    </form>
    <c:if test="${not empty primeRange}"><p>Prime numbers up to ${primeRange}</p> </c:if>
    <c:if test="${not empty primeNumbers}">
        <p>${primeNumbers}</p>
    </c:if>
</body>
</html>

