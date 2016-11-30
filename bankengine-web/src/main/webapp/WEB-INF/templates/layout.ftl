<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>${appName} - ${title}</title>
    <link rel="icon" type="image/ico" href="${ctx}static/app/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/jquery.gritter.min.css"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/ace-fonts.min.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/ace-part2.min.css" class="ace-main-stylesheet"/>
    <![endif]-->

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}static/ace/dist/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->
    <link rel="stylesheet" href="${ctx}static/app/css/app.css"/>

    <!-- ace settings handler -->
    <script>var ctx = '${ctx}';</script>
    <script src="${ctx}static/ace/dist/js/ace-extra.min.js"></script>
    <script src="${ctx}static/ace/dist/js/jquery.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${ctx}static/ace/dist/js/html5shiv.min.js"></script>
    <script src="${ctx}static/ace/dist/js/respond.min.js"></script>
    <![endif]-->

    <!--加载皮肤-->
    <script src="${ctx}static/app/js/skin.js"></script>
<@block name="app-style"/>
</head>
<@app_category>
    <@current_user>
    <body>

        <#include "include/navbar.ftl">

    <div id="main-container" class="main-container">
        <div class="main-content">
            <div class="main-content-inner">
                <div class="page-content">
                    <#include "include/settings.ftl">
                <@block name="app-content"/>
                </div>
            </div>
        </div>
    </div>

        <#include "include/footer.ftl">

        <#include "include/modal.ftl">

    <script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=&amp;style=3&amp;fs=4&amp;textcolor=#fff&amp;bgcolor=#000&amp;text=分享到"></script>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>

    <script src="${ctx}static/ace/dist/js/bootstrap.min.js"></script>
    <script src="${ctx}static/libs/jquery/jquery.bootstrap.min.js"></script>
    <script src="${ctx}static/ace/dist/js/jquery.gritter.min.js"></script>
    <script src="${ctx}static/libs/jquery/jquery.form.min.js"></script>
    <script src="${ctx}static/libs/jquery/jquery.validate.min.js"></script>
    <script src="${ctx}static/libs/jquery/jquery.validate.extends.js"></script>
    <script src="${ctx}static/ace/dist/js/ace-extra.min.js"></script>
    <script src="${ctx}static/ace/dist/js/ace-elements.min.js"></script>
    <script src="${ctx}static/ace/dist/js/ace.min.js"></script>
    <script src="${ctx}static/app/js/app.js"></script>
        <@block name="app-script"/>

    </body>
    </@current_user>
</@app_category>
</html>
