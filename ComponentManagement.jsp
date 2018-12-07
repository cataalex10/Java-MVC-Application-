<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New User</title>
    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }

        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }

        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp">
<div class="generic-container" ng-controller="ComponentController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Component Management</span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.component.idcomponent"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="cname">Component Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.component.name" id="cname"
                                   class="username form-control input-sm" placeholder="Enter component name" required
                                   ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.cname.$error.required">This is a required field</span>
                                <span ng-show="myForm.cname.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.cname.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="price">Component Price</label>

                        <div class="col-md-7">
                            <input type="password" ng-model="ctrl.component.price" id="price"
                                   class="form-control input-sm" placeholder="Enter component price"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="description">Component description</label>

                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.component.price" id="price"
                                   class="priviledge form-control input-sm" placeholder="Enter component description"
                                   required/>

                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.description.$error.required">This is a required field</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="{{!ctrl.component.idcomponent ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm"
                               ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="myForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Components </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="c in ctrl.components">
                    <td><span ng-bind="u.idcomponent"></span></td>
                    <td><span ng-bind="u.name"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.idcomponent)" class="btn btn-success custom-width">Edit
                        </button>
                        <button type="button" ng-click="ctrl.remove(u.idcomponent)" class="btn btn-danger custom-width">Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/classes/app.js' />"></script>
<script src="<c:url value='/static/classes/component_service.js' />"></script>
<script src="<c:url value='/static/classes/component_controller.js' />"></script>
</body>
</html>