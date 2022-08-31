<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <%@include file="/includes/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="includes/style.css">
</head>
<body style="background-color: black">
<%@include file="/includes/navbar.jsp" %>
<br><br><br><br><br>

<div class="container " style="background-color: black;">
    <form action="ShowCtr" method="post">
    <div class="row">
        <div class="col-3">
                <div class="form-group">
                    <br>
                    <select class="form-control form-control-sm" id="pays" name="pays" >
                        <option value="all">All</option>
                        <option value="usa">Etats-Unis</option>
                        <option value="canada">Canadien</option>
                        <option value="recentCanadianTV">More recent canadian TV show</option>
                        <option>4</option>
                        <option>5</option>
                    </select>

                </div>

        </div>
        <div class="col-3">

                <div class="form-group">
                    <br>
                    <select class="form-control form-control-sm" id="type" name="type" >
                        <option value="type">Type</option>
                        <option value="kids">Kids</option>
                        <option value="scPhy">Science Fiction</option>
                        <option value="thrillers">Thrillers</option>
                        <option>4</option>
                        <option>5</option>
                    </select>

                </div>

        </div>



<%--        <div class="col-4 mt-4">--%>
<%--            <div class="form-check form-check-inline">--%>
<%--                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">--%>
<%--                <label class="form-check-label text-light" for="inlineCheckbox1">Francais</label>--%>
<%--            </div>--%>
<%--            <div class="form-check form-check-inline">--%>
<%--                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">--%>
<%--                <label class="form-check-label text-light" for="inlineCheckbox2">Anglais</label>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class=" mt-4">
            <input type="hidden" name="action" value="aucune">
            <button type="submit" class="btn btn-danger">Appliquer</button>
        </div>



    </div>
    </form>
</div>

    <!-- La banière d'acceuil -->
    <section class="cc-menu d-flex justify-content-center align-items-center">

                <div class="mx-auto">



                </div>

    </section>
    <br/>


    <%@include file="/includes/footer.jsp" %>
</body>
</html>