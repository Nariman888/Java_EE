<%@ page import="Sprint1.model.Brands" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 6/1/2022
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brands</title>
  <%@include file="bootstr.jsp"%>
</head>
<body>
<%@include file="sprint.navbar.jsp"%>
<div class="bg-white">
  <h2 class="text-center mt-4">Admin Panel - Brands</h2>
  <p class="text-black-50 text-center"></p>
  <div class="container">
    <div class="row mt-3 mx-auto">
      <div class="col-12">
        <button type="button" class="btn btn-success btn-sm"
                data-bs-toggle="modal" data-bs-target="#addModal">+ADD NEW</button>
      </div>
      <div class="col-12">
        <table class="table table-striped table-hover">
          <thead>
          <tr>
            <th class="col-1">ID</th>
            <th class="col-4">NAME</th>
            <th class="col-4">COUNTRY</th>
            <th class="col-3">DETAILS</th>
          </tr>
          </thead>
          <tbody>
          <%
            ArrayList<Brands> brands = (ArrayList<Brands>) request.getAttribute("all_brands");
            if (brands != null) {
              for (Brands brand : brands) {
          %>
          <tr>
            <td><%=brand.getId()%></td>
            <td><%=brand.getName()%></td>
            <td><%=brand.getCountry()%></td>
            <td>
              <a href="/sprint_brands_details?brand_id=<%=brand.getId()%>"
                 class="btn btn-dark btn-sm">DETAILS</a>
            </td>
          </tr>
          <%
              }
            }
          %>
          </tbody>
        </table>
      </div>
      <!-- Modal Add Brand -->
      <div class="modal fade" id="addModal" data-bs-backdrop="static" data-bs-keyboard="false"
           tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Add New Brand</h5>
              <button type="button" class="btn-close"
                      data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/sprint_add_brand" method="post">
              <div class="modal-body">
                <div class="row mt-3">
                  <div class="col-12">
                    <label>NAME: </label>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-12">
                    <input type="text" class="form-control" name="brand_name"
                           required placeholder="Insert name">
                  </div>
                </div>
                <div class="row mt-3">
                  <div class="col-12">
                    <label>COUNTRY: </label>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col-12">
                    <input type="text" class="form-control" name="brand_country"
                           required placeholder="Insert country">
                  </div>
                </div>
              </div>
              <div class="modal-footer align-content-end">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">CANCEL</button>
                <button class="btn btn-success ms-2">ADD BRAND</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
