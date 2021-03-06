<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>${name}'s Todos:</title>
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
            rel="stylesheet"></link>
    </head>

    <body>
        <div class="container">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is it done?</th>
                    <th>Update?</th>
                    <th>Delete?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">UPDATE</a> </td>
                        <td><a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">DELETE</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <div><a class="button" href="/add-todo">Add Todo</a></div>

        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>