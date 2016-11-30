<@override name="app-content">
<div class="row">
    <div class="col-sm-offset-2 col-sm-8 col-sm-offset-2">
        <div class="error-container">
            <div class="well">
                <h1 class="lighter smaller">
                    <span class="bigger-125 skin-color">
                        <i class="ace-icon fa fa-sitemap"></i>
                        错误
                    </span>
                </h1>

                <hr/>

                <@block name = "error" />

                <hr/>
                <div class="space"></div>

                <div class="center">
                    <a href="javascript:history.back()" class="btn btn-grey">
                        <i class="ace-icon fa fa-arrow-left"></i>
                        返回
                    </a>
                    <a href="${ctx}" class="btn skin-btn">
                        <i class="ace-icon fa fa-home"></i>
                        首页
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</@override>

<@extends name="layout.ftl"/>