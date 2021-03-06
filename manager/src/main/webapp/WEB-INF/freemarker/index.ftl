<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap-theme.css'/>"/>
    <style>
        body {
            height: 100%;
            margin: 0;
            background-size: 1440px 800px;
            background: url("<@s.url '/img/books.jpg'/>") no-repeat;
            display: compact;
        }
    </style>
</head>
<body>
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
            <li class="active"><a href="#">Home</a></li>
            <li><a href="signup">Signup</a></li>
            <li><a href="login">Login</a></li>
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
            <h1>Welcome to Online Student Enrollment!</h1>

            <p>To get started, you need to enter your details to enroll with
                us. Or login to access your details, if you are already enrolled.</p>
        </div>

        <a class="btn btn-primary" href="signup">Signup</a>
        <a class="btn btn-primary" href="login">Login</a>
    </div>
</div>
<script type="text/javascript" src="<@s.url '/js/jquery-2.1.3.js'/>"></script>
<script type="text/javascript" src="<@s.url '/js/bootstrap.js'/>"></script>
</body>
</html>
