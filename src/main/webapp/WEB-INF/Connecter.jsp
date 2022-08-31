<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Connected</title>
    <%@include file="/includes/head.jsp" %>
</head>
<body style="background-color: black">
<%@include file="/includes/navbarAdmin.jsp" %>
<br>
<%--<div class="alert alert-secondary alert-dismissible fade show container"--%>
<%--     style="margin-top: 150px" role="alert">--%>
<%--    <strong> Bonjour ${user.username} </strong>, vous êtes maintenant connecter--%>
<%--    <button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
<%--        <span aria-hidden="true">&times;</span>--%>
<%--    </button>--%>
<%--</div>--%>

<h1 class="text-center text-light mb-3" style="margin:auto;margin-top:100px; margin-left: 100px">Liste de shows netflix Administration</h1>


<div class="container-fluid">
    <div class="row">


        <div class="col-2">
            <nav class="navbar">
                <ul class="nav navbar-nav mt-5">
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn-outline-danger btn" href="GestionAdmin?src=home"> Home </a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn btn-outline-warning" href="GestionAdmin?src=client">Gestion Client</a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn-outline-danger btn" href="GestionAdmin?src=abonnement">Gestion
                            Abonnement</a>
                    </li>
                    <li class="nav-item mb-4 mr-2">
                        <a class="nav-link btn btn-outline-warning" href="GestionAdmin?src=show"> Gestion Show </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-10">
            <div class="card-group">
                <div class="card">
                    <img class="card-img-top" src="./images/photo31.webp" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="./images/photo21.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This card has supporting text below as a natural lead-in to additional
                            content.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="./images/photo11.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This card has even longer content than the first to show that equal
                            height action.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<div class="col-12 " style="margin-right: auto; margin-left: auto">--%>
<%--    <div class="card">--%>
<%--        <table class="table table-hover table-striped">--%>
<%--            <thead class="thead-light">--%>

<%--            <tr>--%>
<%--                <th scope="col">#</th>--%>
<%--                <th scope="col">Type</th>--%>
<%--                <th scope="col">Title</th>--%>
<%--                &lt;%&ndash;                        <th scope="col">Director</th>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                        <th scope="col">Cast</th>&ndash;%&gt;--%>
<%--                <th scope="col">Country</th>--%>
<%--                <th scope="col">date Added</th>--%>

<%--                <th scope="col">Release year</th>--%>
<%--                <th scope="col">rating</th>--%>
<%--                <th scope="col">duration</th>--%>
<%--                <th scope="col">listed_in</th>--%>
<%--                &lt;%&ndash;                        <th scope="col">description</th>&ndash;%&gt;--%>
<%--                <th scope="col">Action</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach var="show" items="${sessionScope.listeShows}">--%>
<%--                <form action="" name="forms2" method="post">--%>
<%--                    <tr>--%>

<%--                        <td>${show.showId}</td>--%>
<%--                        <td>${show.type}</td>--%>
<%--                        <td>${show.title}</td>--%>
<%--                            &lt;%&ndash;                                <td>${show.director}</td>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                <td>${show.cast}</td>&ndash;%&gt;--%>
<%--                        <td>${show.country}</td>--%>

<%--                        <td>${show.dateAdded}</td>--%>
<%--                        <td>${show.releaseYear}</td>--%>
<%--                        <td>${show.rating}</td>--%>
<%--                        <td>${show.duration}</td>--%>
<%--                        <td>${show.listedIn}</td>--%>
<%--                            &lt;%&ndash;                                <td>${show.description}</td>&ndash;%&gt;--%>


<%--                        <td>--%>

<%--                            <a href="DetailShow?id=${show.id}"--%>
<%--                               class=" btn btn-success ">Modifié</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </form>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>

<%--        </table>--%>
<%--    </div>--%>
<%--</div>--%>


<%@include file="/includes/footer.jsp" %>
</body>
</html>
