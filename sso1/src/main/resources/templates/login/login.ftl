<html>
<#include "../common/header.ftl">
<body>
<div class="container box">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center text">
                SSO1
            </h1>
            <form class="form-horizontal" role="form" method="post" action="/sso1/user/to_login">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 col-sm-offset-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="name" class="form-control" id="name" name="buName" />
                    </div>
                    <label for="inputEmail3" class="control-label" style="color: red">${namemsg!''}</label>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 col-sm-offset-2 control-label">密码</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="password" name="buPassword" />
                    </div>
                    <label for="inputEmail3" class="control-label" style="color: red">${passwordmsg!''}</label>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-2">
                        <div class="checkbox">
                            <label><input type="checkbox" />Remember me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-1">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>