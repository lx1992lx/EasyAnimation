# EasyAnimation
An animation util for android . Easy to build complicated animations.<br>

一个快速构建基础动画的工具。<br>
你是否为了一个view的动画而写复杂的anim xml文件，或者使用多个ObjectAnimator组合成一段复杂的动画。<br>
现在使用EasyAnimation可以帮助你快速构建复杂的组合动画，如：<br>


        EasyAnimation.at(tv)                                          //需要动画的View
                      .rotate(0f, 360f)                               //旋转，从0度-360度
                      .alpha(0f,1f)                                   //透明度改变，从完全隐藏到完全显示
                      .build(1000,AccelerateDecelerateInterpolator()) //构建第一个动画组，旋转和透明度改变，1秒的动画时长与加减速差值器
                      .connect()                                      //连接下一个动画，当前一个动画组播放完毕后自动播放下一组动画
                      .scale(1f,1f,1.6f,1.6f)                         //放大1.6倍
                      .build(1000)                                    //构建第二个动画组，1秒动画时长，默认差值器
                      .start {                                        //开始执行动画
                                                                      //所有动画组执行完毕后的回调
                           Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show()
                      }
