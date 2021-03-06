<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="by.epam.cattery.entity.User"%>
<jsp:useBean id="user" class="by.epam.cattery.entity.User"/>
<jsp:setProperty property="*" name="user"/>

<%@ include file = "../parts/header.jsp" %>

<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${sessionScope.name} ${sessionScope.lastname}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img alt="User Pic" src="/jsp/assets/img/user.png" class="img-responsive"> </div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Some info:</td>
                                    <td>------</td>
                                </tr>
                                <tr>
                                    <td>Some date:</td>
                                    <td>06/23/2013</td>
                                </tr>
                                <tr>
                                    <td>Date of the order maybe?</td>
                                    <td>01/24/1988</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>Discount</td>
                                    <td>${sessionScope.discount} %</td>
                                </tr>
                                <tr>
                                    <td>Colour preference</td>
                                    <td>${sessionScope.colorPreference}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:"${sessionScope.email}>${sessionScope.email}</a></td>
                                </tr>
                                <tr>
                                <td>Phone Number</td>
                                <td>123-4567-890(Landline)</td>
                                </tr>
                                <tr>
                                    <td>Banned</td>
                                    <td>${sessionScope.banned}</td>
                                </tr>

                                </tbody>
                            </table>

                            <a href="#" class="btn btn-primary">My kittens</a>
                            <a href="#" class="btn btn-primary">Something else</a>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                    <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                </div>

            </div>
        </div>
    </div>
</div>

<%@ include file = "../parts/footer.jsp" %>
