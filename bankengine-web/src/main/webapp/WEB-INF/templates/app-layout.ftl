<@override name="app-style">
    <@block name="style"/>
</@override>

<@override name="app-content">

    <#include "include/header.ftl">

<div class="space-6"></div>

<div class="row">
    <#if no_right??>
        <#if no_left??>
            <div class="col-lg-10 col-md-10 col-xs-12 col-lg-offset-1 col-md-offset-1">
                <@block name="content"/>
            </div>
        <#else>
            <div class="col-lg-9 col-md-10 col-xs-12 pull-right">
                <@block name="content"/>
            </div>
            <div class="col-lg-3 col-md-2 hidden-sm hidden-xs">
                <#include "include/sidebar-left.ftl">
            </div>
        </#if>
    <#else>
        <div class="col-lg-3 col-md-2 hidden-sm hidden-xs">
            <#include "include/sidebar-left.ftl">
        </div>

        <div class="col-lg-3 col-md-2 hidden-sm hidden-xs pull-right">
            <#include "include/sidebar-right.ftl">
        </div>

        <div class="col-lg-6 col-md-8 col-xs-12">
            <@block name="content"/>
        </div>
    </#if>
</div>
</@override>

<@override name="app-script">
<script>
    var app_who = "${app_who}";
    var headerUserId = '${user.id}';
</script>
<script src="${ctx}static/ace/dist/js/x-editable/bootstrap-editable.min.js"></script>
<script src="${ctx}static/ace/dist/js/x-editable/ace-editable.min.js"></script>
<script src="${ctx}static/app/js/include/header.js"></script>
<script src="${ctx}static/app/js/include/item-status.js"></script>
<script src="${ctx}static/app/js/include/article.js"></script>
    <@block name="script"/>
</@override>

<@extends name="layout.ftl"/>
