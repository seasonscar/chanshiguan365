/* eslint no-unused-vars: "off", wrap-iife: "off", one-var: "off", no-unused-expressions: "off", no-unneeded-ternary: "off", no-caller: "off" */

/**
 * 按照宽高比例设定html字体, width=device-width initial-scale=1版
 * @param {Window} win 窗口window对象
 * @param {Object} option
 *  - designWidth: 设计稿宽度，必须
 *  - designHeight: 设计稿高度，不传的话则比例按照宽度来计算，可选
 *  - designFontSize: 设计稿宽高下用于计算的字体大小，默认20，可选
 *  - callback: 字体计算之后的回调函数，可选
 * @return Boolean
 */
!function (win, option) {
  var count = 0,
    designWidth = option.designWidth,
    designHeight = option.designHeight || 0,
    designFontSize = option.designFontSize || 20,
    callback = option.callback || null,
    root = document.documentElement,
    body = document.body,
    rootWidth, newSize, t, self
  // 返回root元素字体计算结果
  function _getNewFontSize () {
    var scale = designHeight !== 0 ? Math.min(win.innerWidth / designWidth, win.innerHeight / designHeight) : win.innerWidth / designWidth
    return parseInt(scale * 10000 * designFontSize) / 10000
  }
  !function () {
    rootWidth = root.getBoundingClientRect().width
    self = self ? self : arguments.callee
    // 如果此时屏幕宽度不准确，就尝试再次获取分辨率，只尝试20次，否则使用 win.innerWidth 计算
    if (rootWidth !== win.innerWidth && count < 20) {
      win.setTimeout(function () {
        count++
        self()
      }, 0)
    } else {
      newSize = Math.floor(_getNewFontSize())
      if (newSize > 100) {
        newSize = 100
      }
      // 如果css已经兼容当前分辨率就不管了
      if (newSize + 'px' !== root.style.fontSize) {
        root.style.fontSize = newSize + 'px'
        return callback && callback(newSize)
      }
    }
  }()
  // 横竖屏切换的时候改变fontSize，根据需要选择使用
  win.addEventListener('onorientationchange' in window ? 'orientationchange' : 'resize', function () {
    clearTimeout(t)
    t = setTimeout(function () {
      self()
    }, 200)
  }, false)
}(window, {
  designWidth: 1440,
  designHeight: 900,
  designFontSize: 100,
  callback: function () {}
})

$(function () {
  $('.swiper-wrapper').css('height', window.innerHeight);
  $(".loading-container").show();
  var swiper = new Swiper('.swiper-container', {
      pagination: '.swiper-pagination',
      paginationClickable: true,
      direction: 'vertical',
      mousewheelControl : true,
      mousewheelForceToAxis : false      
  })

  function loadingPercent() {
    var currentCounter = 1;
    var time = 10;

    var timer = setInterval(function(time) {
      var currentVal = currentCounter++;
      $(".percent").text(currentVal + "%");
      time = Math.floor(Math.random()*10);
      if(currentVal == 99) {
        clearInterval(timer);
        $(".percent").text('好了');
        $(".loading-desc").text('DONE!');
        

        setTimeout(function() {
          $(".swiper-container").css('visibility', 'visible');
          $(".loading-container").hide();
        }, 1000)
       }
    }, time)
  }

  function isAndroid(){
    var u = navigator.userAgent;
    return u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
  }

  function isIOS(){
    var u = navigator.userAgent;
    return !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
  }


  loadingPercent();

  $('.btn').on('click', function() {
    swiper.slideTo(5, 900);
  })

  $(window).resize(function() {
    setTimeout(function() {
      $('.swiper-wrapper').css('height', window.innerHeight);  
      $('.swiper-slide').css('height', window.innerHeight);
      swiper.onResize();
    }, 10)
  })
})
