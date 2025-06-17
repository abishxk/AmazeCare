<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="bootstrap_links.jsp" />
<jsp:include page="menu.jsp" />
<body>
<div class="container mt-5">
    <div class="text-center">
        <h2>Welcome, ${sessionScope.loggedInPatient.fullName} 👋</h2>
        <p class="lead text-secondary">You are successfully logged in.</p>
    </div>

    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title text-primary">Your Info</h5>
                    <p><strong>Email:</strong> ${sessionScope.loggedInPatient.email}</p>
                    <p><strong>Mobile:</strong> ${sessionScope.loggedInPatient.mobileNumber}</p>
                    <p><strong>Gender:</strong> ${sessionScope.loggedInPatient.gender}</p>
                    <p><strong>DOB:</strong> ${sessionScope.loggedInPatient.dob}</p>
                    <p><strong>Address:</strong> ${sessionScope.loggedInPatient.address}</p>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
