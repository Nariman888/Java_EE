<%@ page import="Sprint1.model.Items" %>
<%@ page import="Sprint1.model.Brands" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 6/1/2022
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <%@include file="bootstr.jsp"%>
</head>
<%@include file="sprint.navbar.jsp"%>
<body>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <div class="col-6 mx-auto">
                <%
                    Items item = (Items) request.getAttribute("one_item");
                    if(item != null){
                %>
                <form action="/sprint_save_items" method="post">
                    <input type="hidden" name="item_id" value="<%=item.getId()%>">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>NAME: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="item_name" required
                                   placeholder="Insert name" value="<%=item.getName()%>">
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
                                <option value="<%=brand.getId()%>" <%=brand.getId()==item.getBrand().getId() ? "selected" : ""%>>
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
                            <input type="number" step="0.01"  max="10000000" min="0"
                                   class="form-control" name="item_price" required
                                   placeholder="Insert price" value="<%=item.getPrice()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>DESCRIPTION: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                <textarea type="text" class="form-control" name="item_description" required
                          placeholder="Insert description"><%=item.getDescription()%></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">SAVE</button>
                            <button type="button" class="btn btn-danger ms-2"
                                    data-bs-toggle="modal" data-bs-target="#deleteModal">
                                DELETE
                            </button>
                        </div>
                    </div>
                </form>
                <!-- Modal Delete Item -->
                <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false"
                     tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Delete Product</h5>
                                <button type="button" class="btn-close"
                                        data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/sprint_delete_items" method="post">
                                <input type="hidden" name="item_id" value="<%=item.getId()%>">
                                <div class="modal-body">
                                    <h5 class="text-center">
                                        Are you sure?
                                    </h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Cancel</button>
                                    <button class="btn btn-primary">Yes</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>

</body>
</html>
