<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>心情墙</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-grid.min.css"><!--CSS RESET-->
    <link rel="stylesheet" type="text/css" href="/static/css/qianka.css">
    <link rel="stylesheet" type="text/css" href="/static/css/cat.css">
    <link type="text/css" rel="stylesheet" href="/static/css/style.css">
    <link type="text/css" rel="stylesheet" href="/static/css/animate.css">
    <link type="text/css" rel="stylesheet" href="/static/icon/iconfont.css">
    <link type="text/css" rel="stylesheet" href="/static/icon2/iconfont.css">
    <link type="text/css" rel="stylesheet" href="/static/css/component.css">
    <link rel="stylesheet" href="/static/css/inputEffect.css">
    <link rel="stylesheet" href="/static/css/swiper.min.css">
    <link href="/static/css/cropper.min.css" rel="stylesheet">
    <link href="/static/css/webuploader.css" rel="stylesheet">
    <link href="/static/css/reveal.css" rel="stylesheet">
<style>
    i:hover {
        transform: scale(1.3);
        transition: all 0.5s ease-out 0s;
    }
</style>
</head>
<body>
<!-- style="background-image: url('/static/img/kawayi.png');background-size:400px 400px;"-->
<div class="demo">
    <div class="container">
        <nav>
        <div>
            <a id="icon2" class="iconmd" href="#slide1"><i class="icon iconfont icon-geren"
                                                           style="display:inline-block;font-size:65px;color:#FFFFFF;"></i></a>
            <a id="icon2" class="iconmd" href="#slide2"><i class="icon iconfont icon-chakantiezizhaopian"
                                                           style="display:inline-block;margin-left:30px;font-size:65px;color:#FFFFFF;"></i></a>
            <a id="icon3" class="iconmd" href="#slide3"><i class="icon iconfont icon-tianjia"
                                                           style="display:inline-block;margin-left:30px;font-size:65px;color:#FFFFFF;"></i></a>
        </div>
        <div class="line" style="left: 0px; width: 67px;"></div>
            </nav>
        <div id="swiper1" class="swiper-container" style="margin-top: 30px;">
          <div class="swiper-wrapper">
            <div class="swiper-slide swiper-1" data-hash="slide2">
              <div class="row" style="padding-right: 18px;">
              <#list cardList as temp>
                  <div class="col-md-3 col-sm-6 animate-box fadeInUp animated" style="margin-bottom: 30px;">
                  <div class="product-grid">
                      <input type="hidden" id="csgid" value="${temp.CSGID}"/>
                      <input type="hidden" id="cardid" value="${temp.ID}"/>
                       <a class="product-image">
                        <div class="pic-1">
                            <img src="http://ecs.chanshiguan365.com/upload/${temp.CARDPHOTO}"/>
                        </div>
                        <div class="pic-2">
                          <div class="pic"><img onerror="javascript this.src='static/img/default.jpg' "src="static/img/${temp.CSGPHOTO}.jpg"></div>
                          <div class="team-content">
                                <h3 class="title">
                                    <#if temp.CSGNAME=='default'>
                                        铲屎官NO.${temp.CSGID}
                                    <#else>
                                        ${temp.CSGNAME}
                                    </#if>
                                </h3>
                                <span class="post" style="font-family:微软雅黑">${temp.CARDNOTE}</span>
                          </div>
                        </div>
                      </a>
                  </div>
                </div>
              </#list>
              </div>
            </div>
          <div class="swiper-slide swiper-2" data-hash="slide1" style="text-align:center;">
            <div id="swiper2" class="swiper-container" style="height:100%;">
              <div class="swiper-wrapper">
                  <div id="csgSection" style="background:#36465d">
                   <div class="pic-2" style="float:left;padding:0px;width:100%;margin-top:20px;margin-bottom:20px;background:#36465d;border-bottom:1px solid;border-color:#FFFFFF;">
                       <div style="position:absolute;right:17px;top:0px;z-index:100;">
                            <a id="icon_shezhi" data-reveal-id="myModal" data-animation="fade" class="iconmd" href="#slide1"><i class="icon iconfont icon-shezhi"
                                                                           style="display:inline-block;font-size:25px;color:#FFFFFF;"></i></a>
                       </div>
                   <div class="pic">
                     <img src="static/img/${csgInfo.CSGPHOTO}.jpg">
                   </div>
   <div class="team-content" style="margin-bottom: 15px;">
        <h3 class="title" style="color:#FFFFFF;">
        <#if csgInfo.CSGNAME=='default'>
            铲屎官NO.${csgInfo.ID}
        <#else>
            ${csgInfo.CSGNAME}
        </#if>
        </h3>
        <span class="post" style="color:#FFFFFF;">${csgInfo.CSGTITLE}</span>
    </div>

                     </div>
                   <div class="row" style="padding-right: 18px;" style="background:#36465d">
                   <#list csgCardList as temp>
                       <div class="col-md-3 col-sm-6 animate-box fadeInUp animated" style="margin-bottom: 30px;">
                <div class="product-grid">
                    <input type="hidden" id="csgid" value="${temp.CSGID}"/>
                    <input type="hidden" id="cardid" value="${temp.ID}"/>
                    <a class="product-image">
                        <div class="pic-1">
                            <img src="http://ecs.chanshiguan365.com/upload/${temp.CARDPHOTO}"/>
                        </div>
                        <div class="pic-2">
                            <div class="pic">
                                <img src="static/img/${csgInfo.CSGPHOTO}.jpg">
                            </div>
                            <div class="team-content">
                                <h3 class="title">${csgInfo.CSGNAME}</h3>
                                <span class="post" style="font-family:微软雅黑">${temp.CARDNOTE}</span>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
                   </#list> </div>
               </div>
          </div>

       </div>
       </div>
       <div class="swiper-slide swiper-3" data-hash="slide3" style="text-align:center">
           <div id="dnd"
                style="margin-top: 60px;width: 1024px;height:200px;border:1px;border-style: solid;border-color: #ffffff;text-align:center;">
               <div id="filePicker" style="margin-top: 70px">请将图片拖拽至此或点击上传</div>
           </div>
           <div id="cropper" class="container"
                style="padding:0px;width: 100%;height:400px;margin-top: 10px;display: none;">
           <div id="remark">
           <span class="input input--juro">
					<input class="input__field input__field--juro" type="text" id="cardnote" maxlength="20">
					<label class="input__label input__label--juro" for="cardnote">
						<span class="input__label-content input__label-content--juro">写一下</span>
					</label>
		   </span>

           </div>
              <img id="conimg" src="">

               <a id="backDrag" class="iconmd" onclick="back()"><i class="icon iconfont icon-icon-shangyibu"
                                                                   style="display:inline-block;margin-left:30px;font-size:65px;color:#FFFFFF;"></i></a>
               <a id="sureCut" class="iconmd" style="margin-left: 3rem;"><i class="icon iconfont icon-xuanze"
                                                                            style="display:inline-block;margin-left:30px;font-size:65px;color:#FFFFFF;"></i></a>
           </div>
       </div>


       </div>

    </div>


</div>

</div>
<div id="popup-article" class="popup">
  <div class="popup__block" style="background-color: #f7f5ec;box-shadow:2px 0px 6px 12px rgba(0,0,0,.3);">
  </div>
    <a href="#" class="popup__close">关闭</a>
</div>
<div>
</div>
<div id="myModal" class="reveal-modal" style="top: 100px; opacity: 1; visibility: hidden;">
    <form action="" method="post" class="login-form">
        <div class="username">
            <input type="text" name="username" placeholder="emma.watson@gmail.com" autocomplete="on">
            <span class="user-icon icon">u</span>
        </div>
        <div class="password">
            <input type="password" name="password" placeholder="*******">
            <span class="password-icon icon">p</span>
        </div>
        <div class="account-control">
            <input type="checkbox" name="Remember me" id="Remember me" value="Remember me" checked="checked">
            <label for="Remember me" data-on="c" class="check"></label>
            <label for="Remember me" class="info">Remember me</label>
            <button type="submit">Login</button>
        </div>
        <p class="not-registered">Not a registered user yet?<a>Sign up now!</a></p>
    </form>
    </div></div>
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/swiper.min.js"></script>
<script src="/static/js/zyupload-1.0.0.min.js"></script>
<script src="/static/js/cropper.js"></script>
<script src="/static/js/webuploader.js"></script>
<script src="/static/js/classie.js"></script>
<script src="/static/js/jquery.reveal.js"></script>
<script>
    $(function () {
        if (!String.prototype.trim) {
            (function () {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function () {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call(document.querySelectorAll('input.input__field')).forEach(function (inputEl) {
            // in case the input is already filled..
            if (inputEl.value.trim() !== '') {
                classie.add(inputEl.parentNode, 'input--filled');
            }

            // events:
            inputEl.addEventListener('focus', onInputFocus);
            inputEl.addEventListener('blur', onInputBlur);
        });

        $("#sureCut").bind("click", function () {
            if ($("#conimg").attr("src") == null) {
                return false;
            } else {
                var cas = $('#conimg').cropper('getCroppedCanvas');// 获取被裁剪后的canvas
                var base64 = cas.toDataURL('image/jpeg'); // 转换为base64
                uploadFile(encodeURIComponent(base64))//编码后上传服务器
            }
        });

        $("#conimg").cropper({
            aspectRatio: 1 / 1,
            modal: true,
            dragCrop: false,
            zoomable: false,
            background: false,
            crop: function (data) {
                // Output the result data for cropping image.
            }

        });

        $(".iconmd").bind('click', function () {
            $(".iconmd").find("i").css("color", "#FFFFFF")
            $(this).find("i").css("color", "#f7f5ec");
        })

        var mySwiper = new Swiper('#swiper1', {
            direction: 'horizontal', // 水平切换选项
            hashnav: true,
            hashnavWatchState: true,
            loop: false, // 循环模式选项
        })

        var mySwiper2 = new Swiper('#swiper2', {
            direction: 'vertical', // 水平切换选项
            hashnav: true,
            hashnavWatchState: true,
            loop: false, // 循环模式选项
            // 如果需要分页器
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
                clickableClass: 'my-pagination-clickable',
            },
        })

        $(".product-grid").bind('click', function () {
            var t = $.ajax({
                url: "/card.htm",
                data: {
                    "csgId": $(this).find("#csgid").val(),
                    "cardId": $(this).find("#cardid").val()
                },
                type: "POST",
                async: false
            });
            $(".popup__block").html(t.responseText);
            window.location.href = "index.htm#popup-article"
        })

        $("#csgIcon").bind('click', function () {
            var t = $.ajax({
                url: "/csg.htm",
                data: {
                    "csgId": ${csgId}
                },
                type: "POST",
                async: false
            });
            $(".popup__block").html(t.responseText);
            window.location.href = "index.htm#popup-article"
        })

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: '/static/js/Uploader.swf',

            // 文件接收服务端。
            server: '/upload.htm',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#filePicker',
            dnd: '#dnd',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/jpg,image/jpeg,image/png'
            }
        });

        uploader.on('fileQueued', function (file) {
            uploader.makeThumb(file, function (error, src) {
                if (error) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }
                $("#conimg").cropper("replace", src);
                $("#dnd").hide();
                $("#cropper").show();
            }, 1, 1);

        });


    });

    function back() {
        $("#cropper").hide();
        $("#dnd").show();
    }

    //ajax请求上传
    function uploadFile(file) {
        var cardnote = $("#cardnote").val();
        $.ajax({
            url: '/upload.htm',
            type: 'POST',
            data: "cardnote=" + cardnote + "&croperImgCode=" + file,
            async: true,
            success: function (data) {
                if ("true" == data) {
                    window.location.href = "index.htm"
                }
                console.log(data)
            }
        });
    }

    function showCsg(csgId) {
        var t = $.ajax({
            url: "/csg.htm",
            data: {
                "csgId": csgId
            },
            type: "POST",
            async: false
        });
        $(".popup__block").html(t.responseText);
        window.location.href = "index.htm#popup-article"
    }

    function onInputFocus(ev) {
        classie.add(ev.target.parentNode, 'input--filled');
    }

    function onInputBlur(ev) {
        if (ev.target.value.trim() === '') {
            classie.remove(ev.target.parentNode, 'input--filled');
        }
    }

</script>
</body>
</html>