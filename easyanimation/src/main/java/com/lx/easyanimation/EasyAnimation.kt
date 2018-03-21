package com.lx.easyanimation

import android.view.View

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
 * 创建时间：2018/3/19 下午1:57
 * 修改人：LX
 * 修改时间：2018/3/19 下午1:57
 * 修改备注：
 */
class EasyAnimation{

    companion object {

        fun at(view: View): AnimationActionControl {
            return AnimationActionControl(view)
        }

    }
}