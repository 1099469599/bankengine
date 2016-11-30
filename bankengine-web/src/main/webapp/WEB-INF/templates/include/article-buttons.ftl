<a href="${ctx}article/reply?id=${article.id}" class="skin-color article-reply" data-toggle="modal"
   data-target="#myModal">
    <i class="ace-icon fa fa-comment-o"></i>
    评论(${article.reply})
</a>
<span class="split">|</span>
<a href="${ctx}article/top?id=${article.id}" class="skin-color action">
    <i class="ace-icon fa fa-upload"></i>
    顶(<span class="action-count">${article.top}</span>)
</a>
<span class="split">|</span>
<a href="${ctx}article/low?id=${article.id}" class="skin-color action">
    <i class="ace-icon fa fa-download"></i>
    踩(<span class="action-count">${article.low}</span>)
</a>
<span class="split">|</span>
<a href="${ctx}article/star?id=${article.id}" class="skin-color action">
    <i class="ace-icon fa fa-star-o"></i>
    收藏(<span class="action-count">${article.star}</span>)
</a>