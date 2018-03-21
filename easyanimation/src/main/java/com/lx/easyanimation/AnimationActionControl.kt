package com.lx.easyanimation

import android.animation.ObjectAnimator
import android.view.View
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
 * 类描述：动画动作处理
 * 创建人：LX
 * 创建时间：2018/3/19 下午2:00
 * 修改人：LX
 * 修改时间：2018/3/19 下午2:00
 * 修改备注：
 */
class AnimationActionControl(private var mView: View) : IAnimAction {

    var mAnimList = ArrayList<ObjectAnimator>()
    var mConnectedControl: AnimationStartControl? = null//连接动画

    override fun translateTo(fromX: Float, fromY: Float, toX: Float, toY: Float): IAnimAction {
        val animX = ObjectAnimator.ofFloat(mView, "translationX", fromX, toX)
        val animY = ObjectAnimator.ofFloat(mView, "translationY", fromY, toY)
        mAnimList.add(animX)
        mAnimList.add(animY)
        return this
    }

    override fun rotate(fromRotation: Float, toRotation: Float): IAnimAction {
        val animR = ObjectAnimator.ofFloat(mView, "rotation", fromRotation, toRotation)
        mAnimList.add(animR)
        return this
    }

    override fun rotateX(fromRotation: Float, toRotation: Float): IAnimAction {
        val animRX = ObjectAnimator.ofFloat(mView, "rotationX", fromRotation, toRotation)
        mAnimList.add(animRX)
        return this
    }

    override fun rotateY(fromRotation: Float, toRotation: Float): IAnimAction {
        val animRY = ObjectAnimator.ofFloat(mView, "rotationY", fromRotation, toRotation)
        mAnimList.add(animRY)
        return this
    }

    override fun alpha(fromAlpha: Float, toAlpha: Float): IAnimAction {
        val animA = ObjectAnimator.ofFloat(mView, "alpha", fromAlpha, toAlpha)
        mAnimList.add(animA)
        return this
    }

    override fun scale(fromScaleX: Float, fromScaleY: Float, toScaleX: Float, toScaleY: Float): IAnimAction {
        val animSX = ObjectAnimator.ofFloat(mView, "scaleX", fromScaleX, toScaleX)
        val animSY = ObjectAnimator.ofFloat(mView, "scaleY", fromScaleY, toScaleY)
        mAnimList.add(animSX)
        mAnimList.add(animSY)
        return this
    }

    /**
     *  构建动画组
     *  @duration 动画组共享动画时长
     */
    override fun build(duration: Long): IAnimStart {
        return build(duration, null)
    }

    /**
     * 构建动画组
     * @duration 动画组共享动画时长
     * @interpolator 动画组共享插值器
     */
    override fun build(duration: Long, interpolator: Interpolator?): IAnimStart {
        if(mAnimList.size==0)
        mAnimList.forEach {
            it.duration = duration
            it.interpolator = interpolator
        }

        if (mConnectedControl != null) {
            mConnectedControl!!.mDuration = duration
            return mConnectedControl!!
        }
        return AnimationStartControl(this, duration)
    }
}