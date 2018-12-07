<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mr.Kobold Login</title>
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
<body ng-app = "myApp">
<div class="generic-container" ng-controller="LoginController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Mr.Kobold Login Form </span></div>
        <div class="formcontainer">
            <form name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.user.id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="uname">Username</label>

                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.name" id="uname"
                                   class="username form-control input-sm" placeholder="Enter your name" required
                                   ng-minlength="3"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="password">Password</label>

                        <div class="col-md-7">
                            <input type="password" ng-model="ctrl.user.password" id="password"
                                   class="form-control input-sm" placeholder="Enter your Password"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <button type = "button" ng-click="login(ctrl.user.name,ctrl.user.password)" class="btn btn-primary btn-sm"
                               ng-disabled="myForm.$invalid">Login</button>
                       
                    </div>
                </div>
                
            </form>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/classes/app.js' />"></script>
<script src="<c:url value='/static/classes/login_controller.js' />"></script>
<script src="<c:url value='/static/classes/login_service.js' />"></script>
</body>
</html>