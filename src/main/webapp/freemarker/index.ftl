<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>心情墙</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-grid.min.css"><!--CSS RESET-->
    <link rel="stylesheet" type="text/css" href="/static/css/qianka.css">
    <link rel="stylesheet" type="text/css" href="/static/css/cat.css">
    <link type="text/css" rel="stylesheet" href="/static/css/style.css">
    <link type="text/css" rel="stylesheet" href="/static/css/animate.css">
</head>
<body>
<div class="titlebar">
	彼<br/>女<br/>の<br/>猫
    <div class="line top" style="background: linear-gradient(to right, #d481ff, #05f1e1);"></div>
    <div class="line bottom" style="background: linear-gradient(to right, #d481ff, #05f1e1);"></div>
    <div class="line left" style="background: linear-gradient(#d481ff, #05f1e1);"></div>
    <div class="line left2" style="background: linear-gradient(#05f1e1, #d481ff);"></div>
    <div class="line right" style="background: linear-gradient(#d481ff, #05f1e1);"></div>
</div>
<div class="demo">
    <div class="container">
        <div class="row">
        <#list cardList as temp>
            <div class="col-md-3 col-sm-6 animate-box fadeInUp animated" style="margin-bottom: 30px;">
                <div class="product-grid">
                    <a class="product-image">
                        <div class="pic-1">
                            <img src="static/img/${temp.CARDPHOTO}.jpg"/>
                        </div>
                        <div class="pic-2">
                            <div class="pic">
                                <img src="static/img/${temp.CSGPHOTO}.jpg">
                            </div>
                            <div class="team-content">
                                <h3 class="title">${temp.CSGNAME}</h3>
                                <span class="post">${temp.CSGTITLE}</span>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </#list>
        </div>
</div>
</div>
<div id="popup-article" class="popup">
  <div class="popup__block">
  </div>
    <a href="" class="popup__close">关闭</a>
</div>
<div>
</div>
<script src="/static/js/jquery.min.js"></script>
<script>
    $(function () {
        $(".line").each(function () {
            $(this).addClass("move");
        });

        $(".product-grid").bind('click', function () {
            var t=$.ajax({
                url:"/csg.htm",
                data: {
                    "csgId": "1"
                },
                type:"POST",
                async:false
            });
            $(".popup__block").html(t.responseText);
            window.location.href = window.location.href + "#popup-article"
        })
    });
</script>
</body>
</html>