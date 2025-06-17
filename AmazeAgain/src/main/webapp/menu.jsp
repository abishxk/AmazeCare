<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/index.jsp">AmazeCare Hospital</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">

                <c:if test="${empty sessionScope.loggedInPatient}">
                    <li class="nav-item"><a class="nav-link" href="/index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/index.jsp#login-options">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="/index.jsp#signup-options">Register</a></li>
                </c:if>

                <c:if test="${not empty sessionScope.loggedInPatient}">
                    <li class="nav-item"><a class="nav-link" href="/patient_home.jsp">Home</a></li>
                    <li class="nav-item text-light px-2">Welcome, ${sessionScope.loggedInPatient.fullName}</li>
                    <li class="nav-item"><a class="nav-link text-warning" href="/logout">Logout</a></li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
