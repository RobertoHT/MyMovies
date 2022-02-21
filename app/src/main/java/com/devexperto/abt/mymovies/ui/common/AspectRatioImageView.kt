package com.devexperto.abt.mymovies.ui.common

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.devexperto.abt.mymovies.R

class AspectRatioImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatImageView(context, attrs, defStyleAttr) {

    var ratio: Float = 1f

    init {
        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView)
            with(a) {
                ratio = getFloat(R.styleable.AspectRatioImageView_ratio, 1f)
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var width = measuredWidth
        var height = measuredHeight

        if (width == 0 && height == 0) {
            return
        }

        if (width > 0) {
            height = (width * ratio).toInt()
        }
        else if (height > 0) {
            width = (height / ratio).toInt()
        }

        setMeasuredDimension(width, height)
    }
}