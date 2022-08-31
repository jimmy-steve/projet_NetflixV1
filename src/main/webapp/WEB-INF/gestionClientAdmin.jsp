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

<h1 class="text-center text-light" style="margin:auto;margin-top:100px">Liste de shows netflix Administration</h1>


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


        <div class="col-4">
            <div class="card border border-dark" style="width:600px;margin:auto;margin-top:50px ">
                <h2 class="bg-warning text-light card-header text-center text-dark ">Modification d'un client</h2>
                <form class="form" action="" method="get">
                    <table class="table table-hover table-striped table-bordered">

                        <thead>
                        <tr>
                            <th scope="col">Information</th>
                            <th scope="col">Donnée</th>
                        </tr>
                        </thead>
                        <tbody>
                        <form action="" method="post">
                            <tr>
                                <th scope="row">Id Client :</th>
                                <td>${requestScope.client.idClient}</td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="prenom">Prénom :</label></th>
                                <td><input type="text" id="prenom" name="prenom" value="${requestScope.client.prenom}"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="nom">Nom :</label></th>
                                <td><input type="text" id="nom" name="nom" value="${requestScope.client.nom}"/></td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="email">Email :</label></th>
                                <td><input type="email" id="email" name="email" value="${requestScope.client.email}"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="adresse">Adresse :</label></th>
                                <td><input type="text" id="adresse" name="adresse"
                                           value="${requestScope.client.adresse}"/></td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="telephone">Téléphone :</label></th>
                                <td><input type="text" id="telephone" name="telephone"
                                           value="${requestScope.client.telephone}"/>
                                </td>
                            </tr>


                            <tr class="bg-dark">
                                <th scope="row" class="text-light">IdUser :</th>
                                <td class="text-light">${requestScope.user.idUser}</td>
                            </tr>
                            <tr class="bg-dark">
                                <th scope="row" class="text-light"><label for="userName">Username:</label></th>
                                <td><input type="text" id="userName" name="userName"
                                           value="${requestScope.user.username}"/></td>
                            </tr>
                            <tr class="bg-dark">
                                <th scope="row" class="text-light"><label for="password">Password :</label></th>
                                <td><input type="text" id="password" name="password"
                                           value="${requestScope.user.hashPassword}"/></td>
                            </tr>


                        </form>
                        </tbody>


                        <tr class="text-center">

                            <td>
                                <button type="submit" class="btn btn-outline-success">Submit</button>
                            </td>
                            <td>
                                <button type="reset" class="btn btn-outline-danger">Reset</button>
                            </td>

                        </tr>
                    </table>
                </form>
            </div>


        </div>
        <div class="card border border-dark" style="margin:auto;margin-top:50px">
            <h2 class="bg-primary text-light card-header text-center text-dark">Liste des Clients</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nom Complet</th>
                    <th scope="col">Email</th>
                    <th scope="col">UserName</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${sessionScope.listUsers}">
                    <c:forEach var="client" items="${sessionScope.listClients}">

                        <tr>


                            <th scope="row">${client.idClient}</th>
                            <td>${client.prenom} ${client.nom}</td>
                            <td>${client.email}</td>
                            <td>${user.username}</td>
                            <td><a class="btn btn-outline-danger" href="GetClient?id=${client.idClient}">Modifié</a>
                            </td>
                        </tr>

                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<br><br>

<%@include file="/includes/footer.jsp" %>
</body>
</html>






