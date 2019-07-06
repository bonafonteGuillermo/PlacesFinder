package com.upsa.mimo.placesfinder.ui.settings

import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.RadioButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.data.repository.IRepository
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

    private val repository: IRepository by lazy { injector.repositoryInjector.providesRepository() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(com.upsa.mimo.placesfinder.R.layout.activity_settings)
        setUpActionBar()
        setUpSeekBarBehaviour()
        setUpRadioGroup()

        settings__toolbar.setNavigationOnClickListener {
            repository.saveFilterTypeInSharedPrefs(getSelectedPlaceTypeFilter())
            repository.saveFilterRadiusInSharedPrefs(getSelectedPlaceRadiusFilter())
            finish()
        }
    }

    private fun setUpRadioGroup() {
        val typeFromSharedPrefs = repository.getFilterTypeFromSharedPrefs()
        settings__radio_group.children.forEach { radioButton ->
            if ((radioButton as RadioButton).text.toString().equals(typeFromSharedPrefs, true)) {
                radioButton.isChecked = true
            }
        }
    }

    private fun setUpSeekBarBehaviour() {
        settings__seekbar_radius.progress = repository.getFilterRadiusFromSharedPrefs()
        settings__seekbar_radius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val progressValue = progress * (seekBar.width - 2 * seekBar.thumbOffset) / seekBar.max
                settings__filter_seekbar_value.text = progress.toString()
                settings__filter_seekbar_value.x = seekBar.x + progressValue + seekBar.thumbOffset / 2
            }
        })
    }

    private fun setUpActionBar() {
        setSupportActionBar(settings__toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun getSelectedPlaceTypeFilter(): String {
        val selectedId = settings__radio_group.checkedRadioButtonId
        val radioButton = findViewById<View>(selectedId) as RadioButton
        return radioButton.text.toString()
    }

    private fun getSelectedPlaceRadiusFilter(): Int = settings__seekbar_radius.progress

}
