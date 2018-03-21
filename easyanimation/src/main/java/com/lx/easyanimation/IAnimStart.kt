package com.lx.easyanimation

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
 * 创建时间：2018/3/19 下午2:20
 * 修改人：LX
 * 修改时间：2018/3/19 下午2:20
 * 修改备注：
 */
interface IAnimStart {
    fun connect():IAnimAction//连接上一个动画，当上一个动画结束时播放次动画

    fun delayStart(howLong:Long,onEnd:()->Unit)//延迟启动

    fun start(onEnd:()->Unit)//开始动画

}