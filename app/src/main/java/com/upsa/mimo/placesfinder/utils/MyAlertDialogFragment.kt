package com.upsa.mimo.placesfinder.utils

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf


class MyAlertDialogFragment : DialogFragment() {

    companion object {
        private const val TITLE = "title"
        private const val MESSAGE = "message"
        private const val POSSITIVE_BUTTON_TEXT = "positive_text"
        private val POSSITIVE_LISTENER = "possitive_listner"

        fun newInstance(
            @StringRes title: Int,
            @StringRes message: Int,
            @StringRes possitiveButtonText: Int,
            positiveListener: () -> Unit = {}

        ) = MyAlertDialogFragment().apply {
            arguments = bundleOf(
                TITLE to title,
                MESSAGE to message,
                POSSITIVE_BUTTON_TEXT to possitiveButtonText,
                POSSITIVE_LISTENER to positiveListener
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var title: Int
        var message: Int
        var positiveButtonText: Int
        lateinit var positiveListener: () -> Unit

        with(checkNotNull(arguments)) {
            title = getInt(TITLE)
            message = getInt(MESSAGE)
            positiveButtonText = getInt(POSSITIVE_BUTTON_TEXT)
            positiveListener = get(POSSITIVE_LISTENER) as () -> Unit
        }

        val alertDialog = AlertDialog.Builder(checkNotNull(context))
            .setTitle(getString(title))
            .setMessage(message)
            .setNegativeButton(android.R.string.cancel) { _, _ -> dialog.dismiss() }
            .setPositiveButton(positiveButtonText) { _, _ ->
                dialog.cancel()
                positiveListener()
            }
            .create()

        return alertDialog
    }
}