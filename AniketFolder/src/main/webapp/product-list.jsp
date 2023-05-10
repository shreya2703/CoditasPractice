<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>

  <header>
          <nav class="navbar navbar-expand-md navbar-dark"
             style="background-color: #ADD8E6">
             <div>
                <h3>Products<h3>
             </div>



          </nav>
      </header><br><br><br>

   <div class="row">


      <div class="container">
      <a href="product-list.jsp" ><button class="btn btn-primary btn-md"></button></a>

         <h3 class="text-center">List of product</h3>
         <hr>

         <br>
         <table class="table table-bordered">
            <thead>
               <tr>
                  <th>Product ID</th>
                  <th>Product Name</th>
                  <th>Product Price</th>
                  <th>Product Quantity</th>

               </tr>
            </thead>
            <tbody>
               <!--   for (Todo todo: todos) {  -->
               <c:forEach var="cust" items="${custList}">

                  <tr>
                     <td><c:out value="${cust.productId}" /></td>
                     <td><c:out value="${cust.productName}" /></td>
                     <td><c:out value="${cust.productPrice}" /></td>
                     <td><c:out value="${cust.productQuantity}" /></td>

                  </tr>
               </c:forEach>
               <!-- } -->
            </tbody>

         </table>
      </div>
   </div>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    <form action="displayCustomer" method="get">
        		<input type="submit" value="Display Customer">
        </form>
        <form action="DeleteCustomer.jsp" method="get">
                <input type="submit" value="Delete Customer">
        </form>
        <form action="purchaseproduct.jsp" method="get">
                        <input type="submit" value="Purchase Product">
                </form>
  </body>
</html>