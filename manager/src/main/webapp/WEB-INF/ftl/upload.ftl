<#include "template/layout.ftl">
<@layoutHead title="社团"></@layoutHead>

<@layoutBody>

        <div class="container" id="headerwrap" id="home" name="home" style="background:url('${ctx.getContextPath()}/resources/img/bg/divider3.jpg') no-repeat center top; background-size: cover;">
            <form id="formUpload" method="post" action="${ctx.getContextPath()}/file/upload"
                              enctype="multipart/form-data">
                            <label><font size="6" color="#ffffff">文件上传</font></label>
                            <input type="text" class="form-control" name="name" placeholder="另存为文件名">
                            </br>
                            <input type="file" name="file" multiple>
                            <input type="submit" id="btnUpload" class="btn btn-primary pull-right" value="单个文件上传">
                        </form>
        </div>

</@layoutBody>
<@layoutFooter></@layoutFooter>