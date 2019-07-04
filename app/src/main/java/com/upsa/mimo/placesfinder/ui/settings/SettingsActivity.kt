package com.upsa.mimo.placesfinder.ui.settings

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.upsa.mimo.placesfinder.app.injector
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.upsa.mimo.placesfinder.R.layout.activity_settings)

        val repository = injector.repositoryInjector.providesRepository()

        settings__seekbar_radius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val `val` = progress * (seekBar.getWidth() - 2 * seekBar.thumbOffset) / seekBar.max
                settings__filter_seekbar_value.text = progress.toString()
                settings__filter_seekbar_value.x = seekBar.getX() + `val` + seekBar.getThumbOffset() / 2
                //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar
            }
        })
    }
}
