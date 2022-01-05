<%--
  Created by IntelliJ IDEA.
  User: Manh Do
  Date: 09.12.2021
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <style>
        #bd{
            min-height: 100vh;
        }
        #header{
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
        }
        .text-dark{
            color: #999 !important
        }
        .text-dark:hover{
            color: #666 !important
        }
        .active-text-dark{
            color: #333 !important
        }
        .logo-text-dark{
            color: #666 !important
        }



    </style>
</head>
<body>
<div id="bd" class="uk-flex uk-flex-column uk-child-width-1-1">

    <div id="header" uk-sticky="top: 100; animation: uk-animation-slide-top">
        <nav class="uk-navbar-container uk-visible@s" uk-navbar>
            <div class="uk-navbar-center">
                <div class="uk-navbar-center-left ">
                    <a href="/home/" class="uk-navbar-item uk-logo">EMPRERO</a>
                </div>
                <div class="uk-margin-large-left uk-margin-large-right">
                    <ul class="uk-navbar-nav">

                        <li class="uk-active"><a href="products-grid" uk-scroll>Товары</a></li>


                        <li><a href="/us/">О нас</a></li>


                        <li><a href="/contacts/">Контакты</a></li>

                    </ul>
                </div>
                <div class="uk-navbar-center-right uk-flex">
                    <div>

                        <a href="/cart/" class="uk-navbar-item uk-navbar-toggle uk-margin-small-right"
                           uk-icon="icon: cart; ratio: 1.5"></a>

                    </div>
                    <div>
                        <a class="uk-navbar-toggle uk-navbar-item uk-padding-remove" href="/login/">
                            <div class="uk-text-large">Войти</div>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
        <nav class="uk-navbar-container uk-hidden@s" uk-navbar>
            <div class="uk-navbar-left">
                <a href="/home/" class="uk-navbar-item uk-logo">EMPRERO</a>
            </div>
            <div class="uk-navbar-right">
                <a class="uk-navbar-toggle uk-navbar-item uk-hidden@s" uk-navbar-toggle-icon
                   uk-toggle="target: #menu"></a>
            </div>
        </nav>
    </div>
    <div id="menu" uk-offcanvas="flip:true; mode:reveal; overlay:true">
        <div class="uk-offcanvas-bar uk-flex uk-flex-column uk-background-muted">
            <button class="uk-offcanvas-close" type="button" uk-close></button>
            <div class="uk-nav-center">
                <a href="/home/" class="uk-logo logo-text-dark">EMPRERO</a>
            </div>
            <div class="uk-nav-center uk-margin-large">
                <ul class="uk-nav uk-nav-primary">

                    <li><a class="text-dark uk-text-large" href="/login/">Войти</a></li>

                </ul>
            </div>
            <ul class="uk-nav uk-nav-primary uk-nav-center uk-margin-auto-vertical">

                <li><a class="active-text-dark">Товары</a></li>


                <li><a class="text-dark" href="/us/">О нас</a></li>


                <li><a class="text-dark" href="/contacts/">Контакты</a></li>

            </ul>
        </div>
    </div>

    <div class="uk-container uk-margin-large">

        <div class="uk-flex uk-flex-center uk-margin-medium">
            <ul class="uk-pagination" uk-margin>

                <li class="uk-active uk-text-bold">
                    <a href="?page=1">1</a>
                </li>

                <li>
                    <a href="?page=2">2</a>
                </li>



                <li>
                    <a href="?page=3">3</a>
                </li>





                <li>
                    <a href="?page=2"><span uk-pagination-next></span></a>
                </li>


            </ul>
        </div>

    </div>

    <div class="uk-margin-auto-top">
        <nav class="uk-navbar-container uk-visible@s" uk-navbar>
            <div class="uk-navbar-center">
                <div class="uk-navbar-center-left">
                    <a href="/home/" class="uk-navbar-item uk-logo">EMPRERO</a>
                </div>
                <div class="uk-margin-large-left uk-margin-large-right uk-navbar-item">
                    <div class="uk-margin-small-right">
                        <a href="#" class="uk-icon-button" uk-icon="icon: instagram; ratio: 1.5"></a>
                    </div>
                    <div class="uk-margin-small-left uk-margin-small-right">
                        <a href="#" class="uk-icon-button" uk-icon="icon: youtube; ratio: 1.5"></a>
                    </div>
                    <div class="uk-margin-small-left">
                        <a href="#" class="uk-icon-button" uk-icon="icon: google; ratio: 1.5"></a>
                    </div>
                </div>
                <div class="uk-navbar-center-right">
                    <div>
                        <ul class="uk-navbar-nav">
                            <li><a href="#" class="uk-padding-remove">All right reserved.</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <nav class="uk-navbar-container uk-hidden@s" uk-navbar>
            <div class="uk-navbar-left">
                <a href="/home/" class="uk-navbar-item uk-logo">EMPRERO</a>
            </div>
            <div class="uk-navbar-right">
                <div class="uk-navbar-item">
                    <div class="uk-margin-small-right">
                        <a href="#" class="uk-icon-button" uk-icon="icon: instagram; ratio: 1.5"></a>
                    </div>
                    <div class="uk-margin-small-left uk-margin-small-right">
                        <a href="#" class="uk-icon-button" uk-icon="icon: youtube; ratio: 1.5"></a>
                    </div>
                    <div class="uk-margin-small-left">
                        <a href="#" class="uk-icon-button" uk-icon="icon: google; ratio: 1.5"></a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>

<script src="/static/main/js/uikit.js"></script>
<script src="/static/main/js/uikit-icons.js"></script>
</body>
</html>
