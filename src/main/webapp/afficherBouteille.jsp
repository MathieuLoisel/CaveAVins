<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cavino | Votre Vin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/commun.css">

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand active"><img class="bottle" src="img/Bottle32x32.png"/><img
                    class="bottle" src="img/Bottle32x32.png"/> </a>
            <span id="dh"></span>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Accueil</a></li>
                <li><a href="lister">Liste des bouteilles</a></li>
                <li><a href="ajouter">Ajouter une bouteille</a></li>
                <li><a href="geo.jsp">Qui sommes-nous</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="bleu">Votre vin ...</h1>
    <br><br>
    <div>
        <form action="ajouter" method="POST" class="form-horizontal">
            <div class="form-group">
                <label for="id" class="col-xs-2 control-label">Id :</label>
                <div class="col-xs-10">
                    <input disabled id="id" name="id"
                           class="form-control" value="${vin.id}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="nomDuVin" class="col-xs-2 control-label">Nom :</label>
                <div class="col-xs-10">
                    <input disabled id="nomDuVin" name="nomDuVin"
                           class="form-control" value="${vin.nom}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="millesime" class="col-xs-2 control-label">Millesime :</label>
                <div class="col-xs-10">
                    <input disabled id="millesime" name="millesime"
                           class="form-control" value="${vin.millesime}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="petillant" class="col-xs-2 control-label">Pétillant :</label>
                <div class="col-xs-10">
                    <input disabled id="petillant" name="petillant" value="${vin.isPetillant == false ? 'Non' : 'Oui'}">
                </div>
            </div>

            <div class="form-group">
                <label for="quantite" class="col-xs-2 control-label">Quantité :</label>
                <div class="col-xs-10">
                    <input disabled id="quantite" name="quantite"
                           class="form-control" value="${vin.quantite}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="couleur" class="col-xs-2 control-label">Couleur :</label>
                <div class="col-xs-10">
                    <input disabled id="couleur" name="couleur" value="${vin.couleur.nom}">
                </div>
            </div>

            <div class="form-group">
                <label for="region" class="col-xs-2 control-label">Région :</label>
                <div class="col-xs-10">
                    <input disabled id="region" name="region" value="${vin.region.nom}">
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>