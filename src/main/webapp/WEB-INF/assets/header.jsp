<% String APP_ROOT=request.getContextPath(); %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF8">
        <title>List des utilisateurs</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">


    </head>

    <body>
    </body>
    <% boolean isConnected=session.getAttribute("utilisateur") !=null; %>
        <header>
            <div class="header">
                <div class="logo1">
                    <img src="img/logo.png" alt="" >
                </div>
                <h1 class="title">Gestion des Utilisateurs</h1>
                <div class="logo2">
                    <img src="img/logo.png" alt="" >
                </div>
            </div>
            <nav class="navbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="<%= APP_ROOT%>" class="nav-link">Accueil</a>
                    </li>
                    <% if(isConnected) { %>

                        <li class="nav-item">
                            <a href="<%= APP_ROOT%>/list" class="nav-link">Lister</a>
                        </li>
                        <li class="nav-item">
                            <a href="<%= APP_ROOT%>/add" class="nav-link">Ajouter</a>
                        </li>
                        <li class="nav-item">
                            <a href="<%= APP_ROOT%>/logout" class="nav-link">Deconnexion</a>
                        </li>
                        <% } else { %>
                            <li class="nav-item">
                                <a href="<%= APP_ROOT%>/login" class="nav-link">Connexion</a>
                            </li>
                            <% } %>
                </ul>

            </nav>

        </header>