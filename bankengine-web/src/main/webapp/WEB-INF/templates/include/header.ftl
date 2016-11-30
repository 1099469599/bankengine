<#if user??>
    <#assign app_who="2"/>
    <#if app_user?? && app_user.id == user.id>
        <#assign app_who="1"/>
    </#if>
<#elseif app_user??>
    <#assign user=app_user/>
    <#assign app_who="1"/>
<#else>
    <#assign user=app_author/>
    <#assign app_who="0"/>
</#if>

<#assign avatar=user.largeAvatar/>
<#if user.largeAvatar == ''>
    <#assign avatar='static/ace/dist/avatars/profile-pic.jpg'/>
</#if>

<div class="row">
    <div class="col-xs-12">
        <div id="user-profile-1" class="user-profile row">
            <div class="col-xs-12 col-sm-3 center">
                <div>
                    <span class="profile-picture">
                        <img data-pk="13" src="${ctx}${avatar}" alt="${user.realname}"
                             class="img-responsive editable editable-click editable-empty" id="avatar"
                             style="display: block;"></img>
                    </span>

                    <div class="space-4"></div>

                    <div class="width-80 label label-xlg arrowed-in arrowed-in-right">
                        <div class="inline position-relative">
                            <a href="${ctx}user?id=${user.id}" class="user-title-label skin-inverse">
                                <i class="ace-icon fa fa-circle green"></i>
                                &nbsp;
                            ${user.realname}
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xs-12 col-sm-9">
                <div class="space-16"></div>

                <div class="alert alert-block alert-success">
                    <button type="button" class="close" data-dismiss="alert">
                        <i class="ace-icon fa fa-times"></i>
                    </button>

                    <i class="ace-icon fa fa-leaf green"></i>

                    <strong class="green">
                    <@c.substring str="${user.sign}" len=60 default="懒惰是一种美德"/>
                    </strong>
                </div>

                <div class="space-16"></div>

                <div class="left">
                    <a href="${ctx}category/list?code=picture&userId=${user.id}">
                        <span class="btn btn-app btn-sm btn-light no-hover">
                            <span class="line-height-1 bigger-170 blue" id="picture_header"></span>

                            <br>
                            <span class="line-height-1 smaller-90"> 相册 </span>
                        </span>
                    </a>

                    <a href="${ctx}category/list?code=music&userId=${user.id}">
                        <span class="btn btn-app btn-sm btn-yellow no-hover">
                            <span class="line-height-1 bigger-170" id="music_header"></span>

                            <br>
                            <span class="line-height-1 smaller-90"> 歌曲 </span>
                        </span>
                    </a>

                    <a href="${ctx}category/list?code=video&userId=${user.id}">
                        <span class="btn btn-app btn-sm btn-pink no-hover">
                            <span class="line-height-1 bigger-170" id="video_header"></span>

                            <br>
                            <span class="line-height-1 smaller-90"> 视频 </span>
                        </span>
                    </a>


                    <a href="${ctx}category/list?userId=${user.id}">
                        <span class="btn btn-app btn-sm btn-grey no-hover">
                            <span class="line-height-1 bigger-170" id="other_header"></span>

                            <br>
                            <span class="line-height-1 smaller-90"> 其他 </span>
                        </span>
                    </a>

                    <span class="btn btn-app btn-sm btn-success no-hover">
                        <span class="line-height-1 bigger-170" id="top_header"></span>

                        <br>
                        <span class="line-height-1 smaller-90"> 顶 </span>
                    </span>

                    <span class="btn btn-app btn-sm btn-primary no-hover">
                        <span class="line-height-1 bigger-170" id="low_header"></span>

                        <br>
                        <span class="line-height-1 smaller-90"> 踩 </span>
                    </span>
                </div>

            </div>
        </div>
    </div>
</div>