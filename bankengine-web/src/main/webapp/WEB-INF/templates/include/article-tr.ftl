<div class="widget-main no-padding-bottom">
    <div>
        <div>
            <a href="${ctx}user?id=${article.userId}">
            <#if article.smallAvatar == ''>
                <img class="pull-left user-avator"
                     src="${ctx}static/ace/dist/avatars/avatar5.png"/>
            <#else>
                <img class="pull-left user-avator" src="${ctx}${article.smallAvatar}"/>
            </#if>
            </a>
            <h4>
                <a class="dark" href="${ctx}user?id=${article.userId}"> ${article.realname} </a>
                <small><@c.substring str="${article.sign}" len=30 default="懒惰是一种美德"/></small>
            </h4>
            <small>
                <div class="time">
                    <i class="ace-icon fa fa-clock-o bigger-110"></i>
                ${article.createdTime?datetime}
                </div>
            </small>
        </div>
        <div class="space-6"></div>
    </div>

    <div class="row">
        <div class="col-xs-12 text-article">
        <#if article.categoryCode=="word">
            <h4>
                <a href="${ctx}article?id=${article.id}" class="dark no-text-decoration body-img article-link">
                    <#if article.password != ''>
                        <i class="fa fa-lock bigger-120 need-password skin-color"></i>
                    </#if>
                ${article.body}
                </a>
            </h4>
        <#else>
            <h4>
                <a href="${ctx}article?id=${article.id}" class="dark no-text-decoration article-link">
                    <#if article.password != ''>
                        <i class="fa fa-lock bigger-120 need-password skin-color"></i>
                    </#if>
                ${article.title}
                </a>
            </h4>
        </#if>
            <div class="space-16"></div>
        </div>

        <div class="article-action">
            <div class="article-buttons">
            <#include "article-buttons.ftl"/>
            </div>
        </div>
    </div>
</div>