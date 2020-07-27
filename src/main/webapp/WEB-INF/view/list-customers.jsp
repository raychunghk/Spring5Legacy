<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/style.css"/>
</head>

<body>

<div id="wrapper">

</div>

<div id="container" class="container black">

    <div id="content" class="card white center-align center">
        <div id="header card-header">
            <h3>CRM - Customer Relationship Manager</h3>

        </div>
        <!--  add our html table here -->

        <table class="center center-align responsive striped" style="width:700px; margin:0 auto;">
            <thead>
            <tr class="card-title">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">

                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td>
                        <span> <a href="showformforupdate?id=${tempCustomer.id}" class="indigo-text">Update Customer</a></span>
                        |
                        <span> <a onclick="deleteclick(${tempCustomer.id})"
                                  class="indigo-text">Delete Customer</a></span>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
        <div class="card-action">
            <input type="button" class="btn indigo white-text" value="Add" id="btnadd">
        </div>
    </div>

</div>


</body>

<script
        src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
<script>
    $.ready(
        $('#btnadd').on('click', function () {
            window.location.href = 'addcustomer';
            //  return false;
        })
    )

    function deleteclick(id) {
        if (confirm("Are you sure to delete?")) {
            window.location.href = "deletecustomer?id=" + id;
            return true;
        } else {
            return false;
        }
    }
</script>
</html>









