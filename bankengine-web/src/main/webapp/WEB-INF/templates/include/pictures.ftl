<div class="row">
    <div class="col-xs-12">
        <div>
            <ul class="ace-thumbnails clearfix">
            <#list attachments as attachment>
                <li>
                    <a href="${ctx}${attachment.path}" title="${attachment.name}"
                       data-rel="colorbox">
                        <img width="${pic_size}" height="${pic_size}" alt="${pic_size}x${pic_size}"
                             src="${ctx}${attachment.path}"/>
                    </a>

                    <#if app_who=="1">
                        <div class="tools tools-bottom">
                            <a href="${ctx}article/attachment/delete?id=${attachment.id}"
                               class="attachment-delete">
                                <i class="ace-icon fa fa-times red"></i>
                            </a>
                        </div>
                    </#if>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</div>