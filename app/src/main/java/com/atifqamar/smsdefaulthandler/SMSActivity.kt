package com.atifqamar.smsdefaulthandler;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atifqamar.smsdefaulthandler.SmsRecycler.MyRecyclerAdapter
import com.atifqamar.smsdefaulthandler.SmsRecycler.SMSItem


class SMSActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_sms)

                var mRecyclerView = findViewById<RecyclerView>(R.id.sms_recycler_view)

                /* initiate adapter */
                val mRecyclerAdapter = MyRecyclerAdapter()
                /* initiate recyclerview */
                mRecyclerView.setAdapter(mRecyclerAdapter)

                mRecyclerView.setLayoutManager(LinearLayoutManager(this))

                /* adapt data */
                var mfriendItems : ArrayList<SMSItem> = ArrayList()
                for (i in 1..10) {
                        if (i % 2 == 0) mfriendItems.add(
                                SMSItem(
//                                        R.drawable.ic_woman,
                                        i.toString() + "번째 사람",
                                        "[ 최근에 보낸 메시지 ]"
                                )
                        ) else mfriendItems.add(
                                SMSItem(
//                                        R.drawable.ic_man,
                                        i.toString() + "번째 사람",
                                        "[ 최근에 보낸 메시지 ]"
                                )
                        )
                }
                mRecyclerAdapter.setSMSList(mfriendItems)
        }
}


