<%@ page import="Sprint1.model.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint1.model.Brands" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/28/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <%@include file="bootstr.jsp"%>
</head>
<body>
<%@include file="sprint.navbar.jsp"%>
<div class="bg-white">
    <h2 class="text-center mt-4">Admin Panel</h2>
    <p class="text-black-50 text-center"></p>
    <div class="container">
        <div class="row mt-3 mx-auto">
            <div class="col-12">
                <button type="button" class="btn btn-success btn-sm"
                        data-bs-toggle="modal" data-bs-target="#addModal">+ADD NEW</button>
            </div>
            <div class="col-12">
                <table class="table table-striped table-hover col-12">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BRAND</th>
                        <th>PRICE</th>
                        <th>DESCRIPTION</th>
                        <th>DETAILS</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("all_items");
                        if (items != null) {
                            for (Items item : items) {
                    %>
                    <tr>
                        <td><%=item.getId()%></td>
                        <td><%=item.getName()%></td>
                        <td><%=item.getBrand().getName() + " - " + item.getBrand().getCountry()%></td>
                        <td><%=item.getPrice()%></td>
                        <td><%=item.getDescription()%></td>
                        <td>
                            <a href="/sprint_items_details?items_id=<%=item.getId()%>"
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
            <!-- Modal Add Item -->
            <div class="modal fade" id="addModal" data-bs-backdrop="static" data-bs-keyboard="false"
                 tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add New Product</h5>
                            <button type="button" class="btn-close"
                                    data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action="/sprint_add_items" method="post">
                            <div class="modal-body">
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>NAME: </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="item_name"
                                               required placeholder="Insert name">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>BRAND: </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <select name="brand_id" class="form-select" required>
                                            <%
                                                ArrayList<Brands> brands = (ArrayList<Brands>)
                                                        request.getAttribute("all_brands");
                                                if (brands != null) {
                                                    for (Brands brand : brands) {
                                            %>
                                            <option value="<%=brand.getId()%>">
                                                <%=brand.getName() + " - " + brand.getCountry()%>
                                            </option>
                                            <%
                                                    }
                                                }
                                            %>>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>PRICE: </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="number" step="0.01" max="100000000" min="0"
                                               class="form-control" name="item_price"
                                               required placeholder="Insert price">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>DESCRIPTION: </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                            <textarea type="text" class="form-control" name="item_description"
                                                      required placeholder="Insert description"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer align-content-end">
                                <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">CANCEL</button>
                                <button class="btn btn-success ms-2">ADD PRODUCT</button>
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
