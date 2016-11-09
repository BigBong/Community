<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@s.url '/css/bootstrap-theme.css'/>"/>
    <title>Upload File Page</title>
</head>
<body>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <div class="col-lg-9">
                            <form id="formUpload" method="post" action="${ctx.getContextPath()}/file/upload"
                                  enctype="multipart/form-data">
                                <label>另存为文件名</label>
                                <input type="text" class="form-control" name="name" placeholder="文件名">
                                <label>File Path</label>
                                <input type="file" name="file" multiple>
                                <input type="submit" id="btnUpload" class="btn btn-primary pull-right" value="单个文件上传">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>