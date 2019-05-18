package com.eigendaksh.moodtracker.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.eigendaksh.moodtracker.R
import com.eigendaksh.moodtracker.utils.OnSwipeTouchListener
import kotlinx.android.synthetic.main.fragment_mood.*


/**
 * A simple [Fragment] subclass.
 */
class MoodFragment : Fragment() {

    private val TAG = MoodFragment::class.java.simpleName
    private val MOOD_COUNT = 5

    private var currIndex = 3


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeBackground(currIndex)

        setSwipeListener(view)
    }

    private fun setSwipeListener(view: View) {
        context?.let {
            view.setOnTouchListener(object : OnSwipeTouchListener(it) {

                override fun onSwipeTop() {
                    super.onSwipeTop()
                }

                override fun onSwipeBottom() {
                    super.onSwipeBottom()
                }

                override fun onSwipeLeft() {
                    super.onSwipeLeft()
                    Log.i(TAG, "swipe left")
                    if (currIndex < MOOD_COUNT - 1) {
                        currIndex++
                        changeBackground(currIndex)
                    }
                }

                override fun onSwipeRight() {
                    super.onSwipeRight()
                    if (currIndex > 0) {
                        currIndex--
                        changeBackground(currIndex)
                    }
                }
            })

        }
    }

    private fun changeBackground(idx: Int) {
        setBackgroundColor(idx)
        setIcon(idx)
    }


    private fun setBackgroundColor(idx: Int) {
        when(idx) {
            0 -> view?.setBackgroundColor(ContextCompat.getColor(context!!, R.color.faded_red))
            1 -> view?.setBackgroundColor(ContextCompat.getColor(context!!, R.color.warm_grey))
            2 -> view?.setBackgroundColor(ContextCompat.getColor(context!!, R.color.cornflower_blue_65))
            3 -> view?.setBackgroundColor(ContextCompat.getColor(context!!, R.color.light_sage))
            4 -> view?.setBackgroundColor(ContextCompat.getColor(context!!, R.color.banana_yellow))
            else -> Log.i(TAG, "invalid input of color")
        }
    }


    private fun setIcon(idx: Int) {
        when(idx) {
            0 -> iconView.setImageResource(R.drawable.smiley_sad)
            1 -> iconView.setImageResource(R.drawable.smiley_disappointed)
            2 -> iconView.setImageResource(R.drawable.smiley_normal)
            3 -> iconView.setImageResource(R.drawable.smiley_happy)
            4 -> iconView.setImageResource(R.drawable.smiley_super_happy)
            else -> Log.i(TAG, "invalid input of drawable")
        }
    }

}