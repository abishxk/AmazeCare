<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="bootstrap_links.jsp" />
<jsp:include page="menu.jsp" />
<body>
<div class="container mt-5">
  <div class="text-center">
    <h2>Welcome Admin, ${sessionScope.loggedInAdmin.fullName} 👋</h2>
    <p class="lead text-secondary">You have successfully logged in as admin.</p>
  </div>

  <div class="row mt-4">
    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body text-center">
          <h5 class="card-title">Manage Patients</h5>
          <a href="#" class="btn btn-outline-primary">View Patients</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body text-center">
          <h5 class="card-title">Manage Doctors</h5>
          <a href="#" class="btn btn-outline-success">View Doctors</a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="card shadow-sm">
        <div class="card-body text-center">
          <h5 class="card-title">Appointments</h5>
          <a href="#" class="btn btn-outline-warning">View Appointments</a>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
