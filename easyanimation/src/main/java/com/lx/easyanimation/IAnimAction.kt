package com.lx.easyanimation

import android.view.animation.Interpolator

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：EasyAnimationTest
 * 包名:com.lx.easyanimation
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/3/19 下午2:03
 * 修改人：LX
 * 修改时间：2018/3/19 下午2:03
 * 修改备注：
 */
interface IAnimAction {
    fun translateTo(fromX:Float,fromY:Float,toX:Float,toY:Float):IAnimAction//移动

    fun rotate(fromRotation:Float,toRotation:Float):IAnimAction//绕Z轴旋转

    fun rotateX(fromRotation:Float,toRotation: Float):IAnimAction//绕X轴旋转

    fun rotateY(fromRotation: Float,toRotation: Float):IAnimAction//绕Y轴旋转

    fun alpha(fromAlpha:Float,toAlpha:Float):IAnimAction//透明度改变

    fun scale(fromScaleX:Float,fromScaleY:Float,toScaleX:Float,toScaleY:Float):IAnimAction//缩放动画

    fun build(duration:Long):IAnimStart

    fun build(duration: Long,interpolator:Interpolator?):IAnimStart
}