<!doctype html>
<html lang="pt-br" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="TRP"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <asset:image src="logo_trp_final_barra.gif"/>
                    </i> TRP
                </a>

            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
		    <li> <g:pageProperty name="page.nav" /><li>
                </ul>
            </div>
        </div>
    </div>

    <g:layoutBody/>
<div id="telaInteira">
    </div>
    <div class="footer" role="contentinfo" <p align="center">COPYRIGHT 2016, CVIEIRA & RLOURENCO COMPANY.</p></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

<asset:javascript src="application.js"/>

</body>
</html>
