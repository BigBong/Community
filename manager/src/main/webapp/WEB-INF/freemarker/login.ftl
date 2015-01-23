<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap-theme.css'/>"/>
    <title>Student Enrollment Login</title>
</head>
<body>
<script type="text/javascript" src="<@s.url '/js/jquery-2.1.3.js'/>"></script>
<script type="text/javascript" src="<@s.url '/js/bootstrap.js'/>"></script>

<div class="navbar navbar-default">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span>
        </button>
    </div>

    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search">
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Home</a></li>
            <li><a href="signup.html">Signup</a></li>
            <li class="active"><a href="login.html">Login</a></li>
            <li class="dropdown"><a href="#" class="dropdown-toggle"
                                    data-toggle="dropdown">Explore<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Contact us</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Further Actions</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- /.nav-collapse -->
</div>

<div class="container">
    <div class="jumbotron">
        <div>
            <h1>Welcome to Online Student Enrollment Login</h1>

            <p>Login to explore the complete features!</p>
        </div>
    </div>

    <div></div>
</div>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post"
                               class="bs-example form-horizontal" commandName="studentLogin">
                        <fieldset>
                            <legend>Student Enrollment Login Form</legend>

                            <div class="form-group">
                                <label for="userNameInput" class="col-lg-3 control-label">User
                                    Name</label>

                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="userName"
                                                id="userNameInput" placeholder="User Name"/>
                                    <form:errors path="userName" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="passwordInput" class="col-lg-3 control-label">Password</label>

                                <div class="col-lg-9">
                                    <form:input type="password" class="form-control"
                                                path="password" id="passwordInput" placeholder="Password"/>
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">
                                <button class="btn btn-default">Cancel</button>

                                <button class="btn btn-primary">Login</button>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>