package org.pogchamp.lolchampions.presentation.util

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
