package com.lx.easyanimation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator

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
 * 类描述：动画播放处理
 * 创建人：LX
 * 创建时间：2018/3/19 下午2:19
 * 修改人：LX
 * 修改时间：2018/3/19 下午2:19
 * 修改备注：
 */
class AnimationStartControl(private var mAction: AnimationActionControl, var mDuration: Long) : IAnimStart, AnimatorListenerAdapter() {

    private val mConnectList = ArrayList<AnimEntry>()
    private var mStartingAnimPosition = 0//当前动画播放顺序，-1代表最后一个播放完毕
    private var mOnEnd: () -> Unit = {}//动画停止的回调

    /**
     * 连接两个动画，顺序播放
     */
    override fun connect(): AnimationActionControl {
        val bufferList = ArrayList<ObjectAnimator>()
        bufferList.addAll(mAction.mAnimList)
        mConnectList.add(AnimEntry(bufferList, mDuration))
        mAction.mAnimList.clear()
        mAction.mConnectedControl = this
        return mAction
    }

    /**
     * 延时启动
     */
    override fun delayStart(howLong: Long, onEnd: () -> Unit) {
        whenEnd(onEnd)//动画结束回调

        mConnectList.forEach {
            it.animList[0].addListener(this)//因为时间相同，所以只为第一个Animation添加监听
        }
        mAction.mAnimList[0].addListener(this)//因为时间相同，所以只为第一个Animation添加监听
        //启动动画，如果有衔接动画，则开始执行第一个动画组，如果没有，则启动全部动画。
        when {
            mConnectList.size > 0 -> mConnectList[0].animList.forEach {
                it.startDelay=howLong
                it.start()
                mStartingAnimPosition=1 //播放动画顺序+1
            }
            else -> {
                mAction.mAnimList.forEach { it.start() }
                mStartingAnimPosition = -1
            }
        }
    }

    /**
     * 正常启动
     */
    override fun start(onEnd: () -> Unit) {
        delayStart(0, onEnd)
    }

    /**
     * 当动画结束时,开始下一段动画
     */
    override fun onAnimationEnd(animation: Animator?) {
        when {
            mConnectList.size > mStartingAnimPosition && mStartingAnimPosition != -1 -> {
                mConnectList[mStartingAnimPosition].animList.forEach {
                    it.start()
                }
                mStartingAnimPosition++
            }
            mStartingAnimPosition != -1 -> {
                mAction.mAnimList.forEach { it.start() }
                mStartingAnimPosition = -1
            }
            else -> mOnEnd()
        }
    }


    /**
     * 设置当结束时的回调
     */
    private fun whenEnd(onEnd: () -> Unit) {
        mOnEnd = onEnd
    }



    inner class AnimEntry(var animList: ArrayList<ObjectAnimator>, var duration: Long)
}