<#--截取字符串, 超出部分用省略号代替-->
<#macro substring str len default=''>
    <#if str?? && str != ''>
        <#if str?length gt len>
        ${str?substring(0, len)}...
        <#else>
        ${str}
        </#if>
    <#else>
    ${default}
    </#if>
</#macro>

<#--分页组件-->
<#macro pagination url param="">
    <#if (page.list)?? && page.total gt 0>
    <#--<div class="pull-right">-->
        <#--<ul class="pagination">-->
            <#--<li><a href="javascript:" class="page-info">第 ${page.startRow}~${page.endRow} 条, 共 ${page.total} 条,-->
                <#--第 ${page.pageNum} 页,-->
                <#--共 ${page.pages} 页</a></li>-->
        <#--</ul>-->
    <#--</div>-->
    <div class="pull-left">
        <ul class="pagination">
            <li>
                <a href="${url}?p=1<#if param?has_content>&${param}</#if>">
                    <i class="ace-icon fa fa-angle-double-left"></i>
                </a>
            </li>
            <li>
                <#if page.hasPreviousPage>
                    <a href="${url}?p=${page.prePage}<#if param?has_content>&${param}</#if>">
                        <i class="ace-icon fa fa-angle-left"></i>
                    </a>
                <#else>
                    <a href="${url}?p=1<#if param?has_content>&${param}</#if>">
                        <i class="ace-icon fa fa-angle-left"></i>
                    </a>
                </#if>
            </li>

            <#list page.navigatepageNums as nav>
                <li <#if nav == page.pageNum>class="active"</#if>>
                    <a href="${url}?p=${nav}<#if param?has_content>&${param}</#if>">${nav}</a>
                </li>
            </#list>

            <li>
                <#if page.hasNextPage>
                    <a href="${url}?p=${page.nextPage}<#if param?has_content>&${param}</#if>">
                        <i class="ace-icon fa fa-angle-right"></i>
                    </a>
                <#else>
                    <a href="${url}?p=${page.lastPage}<#if param?has_content>&${param}</#if>">
                        <i class="ace-icon fa fa-angle-right"></i>
                    </a>
                </#if>
            </li>
            <li>
                <a href="${url}?p=${page.pages}<#if param?has_content>&${param}</#if>">
                    <i class="ace-icon fa fa-angle-double-right"></i>
                </a>
            </li>
        </ul>
    </div>
    </#if>
</#macro>

<#--普通输入框-->
<#macro input id label val="" readonly="false" required="false" empty="">
    <@startInput label required/>
<input type="text" id="${id}" value="${val}" name="${id}" class="form-control" <#if readonly=="true">readonly</#if> placeholder="${empty}">
    <@endInput id />
</#macro>

<#--密码输入框-->
<#macro password id label required="false" empty="">
    <@startInput label required/>
<input type="password" id="${id}" name="${id}" class="form-control" placeholder="${empty}">
    <@endInput id />
</#macro>

<#--下拉选择框-->
<#macro select id label items key val selected="" >
    <@startInput label "false"/>
<select id="${id}" name="${id}" class="form-control">
    <#list items as item>
        <option value="${item[key]}" <#if item[key]==selected>selected</#if>>${item[val]}</option>
    </#list>
</select>
    <@endInput id />
</#macro>

<#--文本域输入框-->
<#macro textarea id label val="" rows="5" required="false" empty="">
    <@startInput label required/>
<textarea id="${id}" rows="${rows}" name="${id}" class="form-control" placeholder="${empty}">${val}</textarea>
    <@endInput id />
</#macro>

<#--显示绿色对号或红色大×-->
<#macro textIcon flag trueText falseText>
    <#if flag>
    ${trueText}
    <i class="ace-icon fa fa-check-circle green"></i>
    <#else>
    ${falseText}
    <i class="ace-icon fa fa-times-circle red"></i>
    </#if>
</#macro>


<#---------------------------------------------------------------------------->
<#--下面全是private, 表示不对外开放, 只供此文件内部调用-->

<#--private输入框前部-->
<#macro startInput label required>
<div class="form-group">
    <label class="col-xs-10 col-xs-offset-1 align-left">${label}<#if required=="true"><span
            class="red">&nbsp;*</span></#if></label>
<div class="col-xs-10 col-xs-offset-1 ">
<span class="block input-icon input-icon-right">
</#macro>

<#--private输入框后部-->
<#macro endInput id>
    <i class="ace-icon fa fa-times-circle hide"></i>
    <label class="error hide" for="${id}"></label>
</span>
</div>
</div>
</#macro>