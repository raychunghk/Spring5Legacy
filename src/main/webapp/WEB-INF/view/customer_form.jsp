<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class="container row ">
    <div class="card col m6 brown lighten-5" style="margin: 0 auto;">

        <div class="card-title indigo white-text "><h5>Add customer</h5></div>
        <form:form action="savecustomer" modelAttribute="customer" method="post">
            <div class="card-content">
                <form:hidden path="id"/>
                <div class="striped">

                    <div class="row">
                        <div class="col-m-6 "><label for="firstName">First Name</label></div>
                        <div class="col-m-6 ">

                            <form:input path="firstName"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-m-6 "><label for="lastName">Last Name</label></div>
                        <div class="col-m-6">
                            <form:input path="lastName"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-m-6"><label for="email">Email</label></div>
                        <div class="col-m-6">
                            <form:input path="email"/>
                        </div>
                    </div>

                </div>
            </div>
            <div class="card-action"><input type="submit" class="btn" value="submit">
                <input type="input" class="btn indigo" value="Back" id="btnback">
            </div>
        </form:form>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
<script>
    $.ready(
        $('#btnback').on('click', function () {
            window.history.back();
            //  return false;
        })
    )
</script>
</body>
</html>