package gst.trainingcourse.customizeUI

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.TextView

class TextViewAnimation{
    companion object{
        lateinit var animate: TranslateAnimation
        fun startChangingNumber(x: Int, y: Int, textView: TextView,view1:TextView,view2:TextView) {
            val animator: ValueAnimator = ValueAnimator.ofInt(x, y)
            animator.duration = 500

            animator.addUpdateListener {
                view1.slideDown()
                view2.slideDown()
                textView.text = animator.animatedValue.toString()
            }

            animator.start()

        }

        fun View.slideDown() {
            animate= TranslateAnimation(
                0F,0F,-this.height.toFloat(),0F)
            animate.duration=1000
            animate.fillAfter=true
            this.startAnimation(animate)
        }
    }
}
