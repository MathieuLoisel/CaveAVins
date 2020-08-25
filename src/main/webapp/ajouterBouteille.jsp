<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cavino | Ajouter une bouteille à votree cave !</title>
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
            <a href="index.jsp" class="navbar-brand active">
                <span class="glyphicon glyphicon-film"></span>
                <span class="glyphicon glyphicon-film"></span>
            </a>
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
                <li class="active"><a href="#">Ajouter une bouteille</a></li>
                <li><a href="geo.jsp">Qui sommes-nous</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="bleu">Ajout d'un vin</h1>
    <br><br>
    <div>
        <form action="ajouter" method="POST" class="form-horizontal">
            <div class="form-group">
                <label for="nomDuVin" class="col-xs-2 control-label">Nom :</label>
                <div class="col-xs-10">
                    <input id="nomDuVin" name="nomDuVin" placeholder="Nom du vin ..." class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="millesime" class="col-xs-2 control-label">Millesime :</label>
                <div class="col-xs-10">
                    <input id="millesime" name="millesime" placeholder="Millesime du vin ..." class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="petillant" class="col-xs-2 control-label">Pétillant :</label>
                <div class="col-xs-10">
                    <select name="petillant" id="petillant" class="form-control">
                        <option value="false">Non</option>
                        <option value="true">Oui</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="quantite" class="col-xs-2 control-label">Quantité :</label>
                <div class="col-xs-10">
                    <input id="quantite" name="quantite" placeholder="Quantité de bouteilles ..." class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="couleur" class="col-xs-2 control-label">Couleur :</label>
                <div class="col-xs-10">
                    <select name="couleur" id="couleur" class="form-control">
                        <c:forEach items="${listeCouleur}" var="c">
                            <option value="${c.id}">${c.nom}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="region" class="col-xs-2 control-label">Région :</label>
                <div class="col-xs-10">
                    <select name="region" id="region" class="form-control">
                        <c:forEach items="${listeRegion}" var="r">
                            <option value="${r.id}">${r.nom}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">Envoyer</button>
                </div>
            </div>

        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>