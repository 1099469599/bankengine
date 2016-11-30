<div class="widget-box skin-border">
    <div class="widget-header widget-header-flat skin-bg skin-inverse">
        <i class="ace-icon fa fa-bullhorn bigger-140"></i>
        <h4 class="widget-title">热门推荐</h4>
    </div>

    <div class="widget-body">
        <div class="widget-main">
            <ul class="sidebar-list">
                <li>
                    <a href="${ctx}category/list">
                        <i class="ace-icon fa fa-th dark"></i>
                        全部栏目
                    </a>
                </li>

            <#assign colors=["dark", "purple", "green", "red2"]/>

            <#list app_category.childrens as category>
                <#assign hasChildren=category.childrens?size gt 0>
                <#if hasChildren>
                    <li></li>
                    <#list category.childrens as c>
                        <li>
                            <a href="${ctx}category/list?code=${c.code}">
                                <i class="${c.icon} ${colors[c_index%colors?size]}"></i>
                            ${c.name}
                            </a>
                        </li>
                    </#list>
                <#else>
                    <@shiro.user>
                        <li>
                            <a href="${ctx}user/article/${category.code}">
                                <i class="${category.icon} ${colors[category_index%colors?size]}"></i>
                            ${category.name}
                            </a>
                        </li>
                    </@shiro.user>
                </#if>
            </#list>
            </ul>
        </div>
    </div>
</div>
