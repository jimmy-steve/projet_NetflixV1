<%--
  Created by IntelliJ IDEA.
  User: lafon
  Date: 2022-08-29
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Affichage de card qui tourne</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style3.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>
<br>
<h1 class="text-center text-light" style="margin:auto;margin-top:100px">Format Card Special </h1><br>

<h3 class="text-center text-light">Notre sélection des plus récent Films Canadien </h3><br>
<div class="container-fluid ml-4" style="margin-top: 50px;">
    <div class="row mx-auto">
<c:forEach var="show" items="${requestScope.listeShows}">
        <div class="card-container ml-5 mb-4 mt-5">


            <div class="card">

                <figure class="back" >

                    <img src="${pageContext.request.contextPath}/images/photo11.jpg" class="card-img-top" alt="...">
                </figure>
                <figure class="front bg-light">
                    <div class="card-body">
                        <h5 class="card-title text-center text-dark">${show.title}</h5>
                    </div>

                    <table class="table table-hover text-center">
                        <thead>
                        <tr>
                            <th scope="col">Title</th>
                            <th scope="col">${show.title}</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Year</th>
                            <td>${show.releaseYear}</td>

                        </tr>
                        <tr>
                            <th scope="row">Rating</th>
                            <td>${show.rating}</td>

                        </tr>
                        <tr>
                            <th colspan="2" class="text-center">
                                <a  href="AjouterArticlePanier?id=${show.id}"
                                    class=" btn btn-success ">Ajouter</a>
                                <a  href="DetailShow?id=${show.id}"
                                    class=" btn btn-danger ">Detail</a>
                            </th>
                        </tr>
                        </tbody>
                    </table>
                </figure>
            </div>

        </div>
</c:forEach>

        <div class="card-container ml-5">


            <div class="card">

                <figure class="front">
                    <img src="${pageContext.request.contextPath}/images/photo11.jpg" class="card-img-top" alt="...">
                </figure>
                <figure class="back">
                    <div class="card-body">
                        <h5 class="card-title text-center">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title</p>
                    </div>

                    <table class="table table-hover text-center">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>

                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>

                        </tr>
                        <tr>
                            <th colspan="2" class="text-center">
                                <a type="button" class="btn btn-danger">Danger</a>
                            </th>
                        </tr>
                        </tbody>
                    </table>
                </figure>
            </div>

        </div>


        <div class="card-container ml-5">


            <div class="card">

                <figure class="front">
                    <img src="${pageContext.request.contextPath}/images/photo21.jpg" class="card-img-top" alt="...">
                </figure>
                <figure class="back">
                    <div class="card-body">
                        <h5 class="card-title text-center">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title</p>
                    </div>

                    <table class="table table-hover text-center">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>

                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>

                        </tr>
                        <tr>
                            <th colspan="2" class="text-center">
                                <button type="button" class="btn btn-danger">Danger</button>
                            </th>
                        </tr>
                        </tbody>
                    </table>
                </figure>
            </div>

        </div>


        <div class="card-container ml-5">


            <div class="card">

                <figure class="front">
                    <img src="${pageContext.request.contextPath}/images/photo31.webp" class="card-img-top" alt="...">
                </figure>
                <figure class="back">
                    <div class="card-body">
                        <h5 class="card-title text-center">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title</p>
                    </div>

                    <table class="table table-hover text-center">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>

                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>

                        </tr>
                        <tr>
                            <th colspan="2" class="text-center">
                                <button type="button" class="btn btn-danger">Danger</button>
                            </th>
                        </tr>
                        </tbody>
                    </table>

                </figure>
            </div>

        </div>


    </div>


    <br><br><br><br>
    <div class="container">
        <div class="card-container">
            <div class="card">
                <figure class="front">
                    <h1>PRO TIER</h1>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae
                        repellat optio sunt veniam tempore dignissimos cumque
                    </p>
                </figure>
                <figure class="back">
                    <h1>Price : 20 $</h1>
                    <button>BUY</button>
                </figure>
            </div>
        </div>
    </div>
</div>

<%@include file="/includes/footer.jsp" %>
</body>
</html>
