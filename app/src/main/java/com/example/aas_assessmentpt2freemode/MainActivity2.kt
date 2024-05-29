package com.example.aas_assessmentpt2freemode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.aas_assessmentpt2freemode.databinding.ActivityMain2Binding
import java.util.Locale

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //TTS Button
        var biography=findViewById(R.id.speakbutton) as Button

        biography.setOnClickListener{
            tts= TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it==TextToSpeech.SUCCESS)
                {
                    tts.language= Locale.UK
                    tts.setSpeechRate(1.05f)
                    tts.speak(binding.chaosbio.text.toString(), TextToSpeech.QUEUE_ADD, null)
                }
            })
        }

        //Page button
        binding.lastbutton.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Inquisition
        val i=findViewById(R.id.information) as Button
        i.setOnClickListener{
            showAlert()
        }
    }
    private fun showAlert(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("ORDER FROM THE INQUISITION")
            .setMessage("This is an information display to summarize the catastrophic civil war from the 31st millennium. Be advised that any further objections or subversive actions against the Emperor and his will shall be executed for Heresy.")
            .setNegativeButton("Emperor protects!"){
                    dialog, which->
                dialog.dismiss()
            }
        val alertDialog: AlertDialog=builder.create()
        alertDialog.show()
    }
}