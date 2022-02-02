package ru.mmteams.dev_intensive_2019

import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.mmteams.dev_intensive_2019.models.Bender
import java.util.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var benderImage: ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendBtn: ImageView
    lateinit var benderObj: Bender


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //benderImage=findViewById(R.id.iv_bender)
        benderImage = iv_bender
        textTxt = tv_text
        messageEt = et_message
        sendBtn = iv_send
        sendBtn.setOnClickListener(this)
        val status = savedInstanceState?.getString("STATUS")?:Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION")?:Bender.Question.NAME.name


        benderObj= Bender(Bender.Status.valueOf(status),Bender.Question.valueOf(question))
        val (r,g,b)=benderObj.status.color
        benderImage.setColorFilter(rgb(r,g,b),PorterDuff.Mode.MULTIPLY)

        textTxt.text=benderObj.askQuestion()
    }

    override fun onClick(p0: View?) {
        if(p0?.id==R.id.iv_send){
            val (phrase,color)=benderObj.listenAnswer(messageEt.text.toString()
                .lowercase(Locale.getDefault()))
            messageEt.setText("")
            val (r,g,b)=color
            benderImage.setColorFilter(rgb(r,g,b),PorterDuff.Mode.MULTIPLY)
            textTxt.text=phrase

        }
    }

    /*   override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }*/


    override fun onSaveInstanceState(outState: Bundle) {
                 super.onSaveInstanceState(outState)



        outState.putString("STATUS",benderObj.status.name)
        outState.putString("QUESTION",benderObj.question.name)
    }
}