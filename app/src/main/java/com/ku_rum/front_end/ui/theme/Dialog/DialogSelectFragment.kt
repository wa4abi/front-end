package com.example.ku_rum.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ku_rum.front_end.R


class DialogSelectFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_select, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            val builder = AlertDialog.Builder(it)
            builder.setTitle("네")
                .setMessage(" 님에게 친구요청을 보냈습니다.")
                .setPositiveButton("확인"){ dialog, _ ->
//                    sendNotificationToUser("사용자 토큰 또는 사용자 아이디")
                }
                .setNegativeButton("아니요"){dialog, id->

                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null!")
    }

//    private fun sendNotificationToUser(userTokenOrId: String) {
//        val db = FirebaseFirestore.getInstance()
//        val notificationData = mapOf(
//            "title" to "새로운 알림",
//            "message" to "확인 버튼을 눌러 알림이 전송되었습니다.",
//            "timestamp" to System.currentTimeMillis(),
//            "userTokenOrId" to userTokenOrId
//        )
//
//        // Firestore에 알림 데이터를 저장
//        db.collection("notifications")
//            .add(notificationData)
//            .addOnSuccessListener {
//                // 알림 저장 성공 시 처리
//            }
//            .addOnFailureListener { e ->
//                // 알림 저장 실패 시 처리
//            }
//    }


}