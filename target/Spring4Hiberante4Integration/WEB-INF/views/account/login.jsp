<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../shared/header.jsp"/>

<div class="container body-content">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">Sign In</h3>
        </div>
    </div>

    <div class="jumbotron">
        <form:form method="post" action="login" modelAttribute="model" class="form-horizontal">

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <form:errors path="*" class="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="username">Username</form:label></div>
                <div class="col-xs-6">
                    <form:input cssClass="form-control" path="username" value="${model.username}" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="password">Password</form:label></div>
                <div class="col-xs-6">
                    <form:input type="password" cssClass="form-control" path="password" value="${model.password}"
                                required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <input type="submit" id="save" class="btn btn-success" value="Sign In"/>
                    <a href="/account/register" class="btn btn-default">Sign Up</a>
                </div>
            </div>
        </form:form>
    </div>
</div>

<jsp:include page="../shared/footer.jsp"/>