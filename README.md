# EasyAnimation
An animation util for android . Easy to build complicated animations.<br>

一个快速构建基础动画的工具(Kotlin)。<br>
你是否为了一个view的动画而写复杂的anim xml文件，或者使用多个ObjectAnimator组合成一段复杂的动画。<br>
现在使用EasyAnimation可以帮助你无脑且快速构建复杂的组合动画，如：<br>


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
                      
                      
使用方法:
-----------------

1.集成EasyAnimation到项目中：<br>
                
        implementation 'com.lx.easyanimation:easyanimation:1.0.1'
                
2.使用EasyAnimation.at(view:View)方法关联需要关联的View,并添加相应动画<br>
 
        EasyAnimation.at(tv).rotate(0f, 360f)
   
   
   当然可以添加多个动画，同时播放：<br>
   
        EasyAnimation.at(tv)
                .rotate(0f, 360f)
                .scale(1f,1f,1.6f,1.6f)
                .alpha(0f,1f) //同时播放三个动画，旋转、缩放和透明度改变
                
                
3.使用build(duration:Long)或者build(duration: Long,interpolator:Interpolator?)方法，构建动画组

        EasyAnimation.at(tv)
                .rotate(0f, 360f)
                .scale(1f,1f,1.6f,1.6f)
                .alpha(0f,1f)
                .build(1000,AccelerateDecelerateInterpolator())//构建,1秒动画时长，AccelerateDecelerateInterpolator差值器
                
4.调用start(onEnd:()->Unit)或者delayStart(howLong:Long,onEnd:()->Unit)方法来启动或延时启动动画
 
        EasyAnimation.at(tv)
                .rotate(0f, 360f)
                .scale(1f,1f,1.6f,1.6f)
                .alpha(0f,1f)
                .build(1000,AccelerateDecelerateInterpolator())
                .start{
                 LogUtil.i(TAG,"Done")  //动画结束回调
                 }

5.如需顺序播放多个动画组，在调用build()后使用connect()方法来连接下一个动画组，如：

        EasyAnimation.at(tv)
                .rotate(0f, 360f)
                .scale(1f,1f,1.6f,1.6f)
                .alpha(0f,1f)
                .build(1000,AccelerateDecelerateInterpolator())
                .connect()                 //连接下一个动画组
                .translateTo(0f,0f,100f,100f)
                .build(2000)
                .start{
                LogUtil.i(TAG,"Done")  //动画结束回调 
                }
                
                
<br>
欢迎使用，欢迎反馈。<br>
邮箱：1012025958@qq.com<br>
微信：lx1992lxlx
