<div class="widget-box skin-border">
    <div class="widget-header widget-header-flat skin-bg skin-inverse">
        <i class="ace-icon fa fa-lightbulb-o bigger-140"></i>
        <h4 class="widget-title">常用导航</h4>
    </div>

<@app_page>
    <div class="widget-body">
        <div class="widget-main">
            <ul class="sidebar-list">
                <#list app_public_pages as page>
                    <li>
                        <a href="${page.url}" target="_blank">
                            <i class="${page.icon}"></i>
                        ${page.name}
                        </a>
                    </li>
                </#list>
                <#if app_pages?? && app_pages?size gt 0>
                    <li></li>
                    <#list app_pages as page>
                        <li>
                            <a href="${page.url}" target="_blank">
                                <i class="${page.icon}"></i>
                            ${page.name}
                            </a>
                        </li>
                    </#list>
                </#if>
            </ul>
        </div>
    </div>
</@app_page>
</div>
