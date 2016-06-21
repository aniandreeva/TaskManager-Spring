<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../shared/header.jsp"/>

<div class="container body-content">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <c:choose>
                    <c:when test="${model.id==0}">Add Task</c:when>
                    <c:otherwise>Edit Task</c:otherwise>
                </c:choose>
            </h3>
        </div>
    </div>

    <div class="jumbotron">
        <form:form method="post" action="edit" modelAttribute="model" class="form-horizontal">

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <form:errors path="*" class="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <form:hidden path="id" value="${model.id}"/>
                <div class="control-label col-md-2"><form:label path="title">title</form:label></div>
                <div class="col-xs-6">
                    <form:input cssClass="form-control" path="title" value="${model.title}" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="content">Content</form:label></div>
                <div class="col-xs-6">
                    <form:input cssClass="form-control" path="content" value="${model.content}" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="status">Status</form:label></div>
                <div class="col-xs-6">
                    <form:select path="status" cssClass="form-control">
                        <form:options items="${TaskStatusEnum.values()}"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 com-md-10">
                    <input type="submit" class="btn btn-success" value="Save"/>
                    <a href="/tasks/list" class="btn btn-default">Back to List</a>
                </div>
            </div>
        </form:form>
    </div>
</div>

<jsp:include page="../shared/footer.jsp"/>