<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="static/css/swiper.min.css">
    <link rel="stylesheet" href="static/css/qianka.css">
    <style>
        body {
            margin: 0px;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="loading-container">
        <div class="percent-container">
            <div class="percent"></div>
            <div class="loading-desc">稍等噢!${csgId}</div>
        </div>
    </div>
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide swiper-1">
                <div class="desc right  animate-box fadeInUp animated">
                    <div class="font144">01</div>
                    <div class="font36">喵空 MioKon</div>
                    <div class="font20">一个有 “情怀” 的铲屎官社区</div>
                    <div class="btn font24 btn-right" href="#login">立即加入</div>
                </div>
            </div>
            <div class="swiper-slide swiper-2" style="color:#8da1ff;">
                <div class="desc left">
                    <div class="font144">02</div>
                    <div class="font36">分享的快乐每一秒都在发生</div>
                    <div class="font20 mb-20">一张图片一句感言,就是这么简单</div>
                    <div class="btn font24 btn-left" href="#login" style="background:#8da1ff;">立即加入</div>
                </div>
            </div>
            <div class="swiper-slide swiper-3">
                <div class="desc right">
                    <div class="font144">03</div>
                    <div class="font36">一起记录与喵咪的点点滴滴吧</div>
                    <div class="font20">成为社区之星,更有免费喵喵礼品赠送</div>
                    <div class="btn font24 btn-right" href="#login">立即加入</div>
                </div>
            </div>
            <div id="login" class="swiper-slide swiper-4" data-hash="login">

            </div>
        </div>
        <!--分页器-->
        <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"></div>
    </div>
</div>
<div>

    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/swiper.min.js"></script>
    <script src="static/js/qianka.js"></script>
    <script>
        $(function () {
            $.get("22.html",function(data){
                $("#login").html(data);
            });
            var mySwiper = new Swiper('.swiper-container', {
                direction: 'vertical', // 垂直切换选项
                loop: false, // 循环模式选项

                // 如果需要分页器
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true,
                    clickableClass: 'my-pagination-clickable',
                },
            })
        });

    </script>
</body>

</html>