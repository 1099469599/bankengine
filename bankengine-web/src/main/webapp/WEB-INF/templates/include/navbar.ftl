<div id="navbar" class="navbar navbar-collapse h-navbar skin-bg">
    <script>
        var navbar = ace.storage.get("navbar");
        if (navbar == null || navbar == "on") {
            $("#navbar").addClass("navbar-fixed-top");
        }
    </script>
    <div class="navbar-container skin-bg" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="${ctx}" class="navbar-brand">
                <small class="skin-inverse">
                    <i class="fa fa-leaf"></i>
                ${appName}
                </small>
            </a>

            <button class="pull-right navbar-toggle collapsed" type="button" data-toggle="collapse"
                    data-target=".navbar-menu">
                <span class="sr-only">导航条开关</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <form class="pull-right hidden-lg hidden-md" style="margin-top: 8px" action="${ctx}article/search">
                <input type="text" style="height: 26px;width: 153px;" value="${key!''}" name="key" placeholder="搜一搜...">
            </form>
        </div>
        </div>

        <nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">

            <ul class="nav navbar-nav">
                <li class="visible-xs visible-sm">
                    <a href="#"
                       class="dropdown-toggle skin-inverse" data-toggle="dropdown">
                        <i class="fa fa-th bigger-140"></i>
                        热门推荐
                        &nbsp;
                        <i class="ace-icon fa fa-angle-down bigger-140 skin-inverse"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                        <li>
                            <a href="${ctx}category/list">
                                <i class="ace-icon fa fa-th bigger-120"></i>
                                全部栏目
                            </a>
                        </li>
                    <#list app_category.childrens as category>
                        <#assign hasChildren=category.childrens?size gt 0>
                        <#if hasChildren>
                            <#list category.childrens as c>
                                <li>
                                    <a href="${ctx}category/list?code=${c.code}">
                                        <i class="${c.icon} bigger-120"></i>
                                    ${c.name}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </#list>
                    </ul>
                </li>

            <@shiro.user>
                <#list app_category.childrens as category>
                    <#if category.childrens?size gt 0>
                        <li>
                            <a href="#"
                               class="dropdown-toggle skin-inverse" data-toggle="dropdown">
                                <i class="${category.icon} bigger-140"></i>
                            ${category.name}
                                &nbsp;
                                <i class="ace-icon fa fa-angle-down bigger-140 skin-inverse"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                                <#list category.childrens as c>
                                    <li>
                                        <a href="${ctx}dashboard/category/list?code=${c.code}">
                                            <i class="${c.icon} bigger-120"></i>
                                        ${c.name}
                                        </a>
                                    </li>
                                </#list>
                            </ul>
                        </li>
                    </#if>
                </#list>

                <@app_menu>
                    <#if app_menu??>
                        <#list app_menu.childrens as menu>
                            <#if menu.childrens?size gt 0>
                                <li>
                                    <a href="${ctx}${menu.url}"
                                       class="dropdown-toggle skin-inverse" data-toggle="dropdown">
                                        <i class="${menu.icon} bigger-140"></i>
                                    ${menu.name}
                                        &nbsp;
                                        <i class="ace-icon fa fa-angle-down bigger-140"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                                        <#list menu.childrens as m>
                                            <li>
                                                <a href="${ctx}${m.url}">
                                                    <i class="${m.icon} bigger-120"></i>
                                                ${m.name}
                                                </a>
                                            </li>
                                        </#list>
                                    </ul>
                                </li>
                            </#if>
                        </#list>
                    </#if>
                </@app_menu>
            </@shiro.user>
            </ul>
        </nav>

        <nav role="navigation" class="navbar-menu pull-right collapse navbar-collapse">
            <ul class="nav navbar-nav">
            <@shiro.user>
                <li>
                    <a href="${ctx}user?id=${app_user.id}" class="skin-inverse">${app_user.realname}</a>
                </li>
                <li>
                    <a href="${ctx}logout" class="skin-inverse">
                        <i class="ace-icon fa fa-power-off"></i>
                        退出
                    </a>
                </li>
            </@shiro.user>
            <@shiro.guest>
                <li>
                    <a href="${ctx}login" class="skin-inverse">
                        <i class="ace-icon fa fa-sign-in"></i>
                        登录
                    </a>
                </li>
                <li>
                    <a href="${ctx}register" class="skin-inverse">
                        <i class="ace-icon fa fa-users"></i>
                        注册
                    </a>
                </li>
            </@shiro.guest>
            </ul>
        </nav>

        <form class="navbar-form pull-right visible-lg visible-md" role="search" action="${ctx}article/search">
            <div class="form-group">
                <input type="text" name="key" value="${key!''}" placeholder="搜一搜...">
            </div>
        </form>
    </div>
</div>