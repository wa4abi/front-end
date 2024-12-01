package com.example.ku_rum.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class DialogConfirmFragment : DialogFragment() {

    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getString(ARG_MESSAGE)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.setTitle("네")
                .setMessage(message)
                .setPositiveButton("확인"){ dialog, _ ->
                    // 친구 요청 보내기
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null!")
    }

    companion object {
        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(message: String): DialogConfirmFragment {
            val fragment = DialogConfirmFragment()
            val args = Bundle()
            args.putString(ARG_MESSAGE, message)
            fragment.arguments = args
            return fragment
        }
    }
}