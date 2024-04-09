package com.atifqamar.smsdefaulthandler;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atifqamar.smsdefaulthandler.SmsRecycler.MyRecyclerAdapter
import com.atifqamar.smsdefaulthandler.SmsRecycler.SMSItem
import com.atifqamar.smsdefaulthandler.databinding.ActivityMainBinding
import com.atifqamar.smsdefaulthandler.sqlite.ChatPartner
import com.atifqamar.smsdefaulthandler.sqlite.DBHelper


class SMSActivity : AppCompatActivity() {
        lateinit var db: DBHelper
        var chatPartners = ArrayList<ChatPartner>()
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                var mRecyclerView = findViewById<RecyclerView>(R.id.sms_recycler_view)

                /* initiate adapter */
                val mRecyclerAdapter = MyRecyclerAdapter()
                /* initiate recyclerview */
                mRecyclerView.setAdapter(mRecyclerAdapter)

                mRecyclerView.setLayoutManager(LinearLayoutManager(this))

                /* adapt data */
                var mfriendItems: ArrayList<SMSItem> = ArrayList()
                for (i in 1..10) {
                        if (i % 2 == 0) mfriendItems.add(
                                SMSItem(
//                                        R.drawable.ic_woman,
                                        i.toString() + "번째 사람",
                                        i.toString() + "번째 상태메시지"
                                )
                        ) else mfriendItems.add(
                                SMSItem(
//                                        R.drawable.ic_man,
                                        i.toString() + "번째 사람",
                                        i.toString() + "번째 상태메시지"
                                )
                        )
                }
                mRecyclerAdapter.setSMSList(mfriendItems)
//
                var mSMSItems: ArrayList<SMSItem> = ArrayList()

                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                db = DBHelper(this)

                for (i in 1..10) {
                        db.addPartner(
                                ChatPartner(
                                        i.toString(),
                                        i.toString() + "번째 상대",
                                )
                        )
                }
                chatPartners.clear()
                chatPartners = db.allChatPartners as ArrayList<ChatPartner>
                Log.d("SMSItems", chatPartners.get(0).name)

                var i = 0
                for (chatPartner in chatPartners) {
                        mSMSItems.add(SMSItem(chatPartner.name, i.toString()))
                        i += 1
                }
                mRecyclerAdapter.setSMSList(mSMSItems)
        }
}


