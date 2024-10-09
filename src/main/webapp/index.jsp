<html>
<body>
    <h1>Prime Number Calculator</h1>
    <form action="/mainServlet" method="get">
        <label> Prime number range:
            <input type="number" name="max" min="2" max="2147483647" required>
        </label>
        <button type="submit">Submit</button>
    </form>
    <c:if test="${not empty message}">${message}</c:if>
    <c:if test="${not empty primeRange}"><p>Prime numbers up to ${primeRange}</p> </c:if>
    <c:if test="${not empty primeNumbers}">
        <p>${primeNumbers}</p>
    </c:if>
</body>
</html>

