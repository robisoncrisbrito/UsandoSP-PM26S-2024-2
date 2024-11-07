package br.edu.utfpr.usandosp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var ligado = false

    private lateinit var ivStatus : ImageView

    private lateinit var sharedPreference : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivStatus = findViewById( R.id.ivStatus )

        sharedPreference = getSharedPreferences( "PREFERENCE_NAME", Context.MODE_PRIVATE)

        ligado = sharedPreference.getBoolean( "ligado", false )

        when ( ligado ) {
            true -> ivStatus.setImageResource( android.R.drawable.btn_star_big_on )
             false ->   ivStatus.setImageResource( android.R.drawable.btn_star_big_off )
        }



    }

    fun btOnOffOnClick(view: View) {
        when ( ligado ) {
            true -> {
                ivStatus.setImageResource( android.R.drawable.btn_star_big_off)
                ligado = false
            }
            false -> {
                ivStatus.setImageResource( android.R.drawable.btn_star_big_on)
                ligado = true
            }
        }

        var editor = sharedPreference.edit()
        editor.putBoolean( "ligado", ligado )
        editor.commit()
    }

    fun btSettingOnClick(view: View) {
        val  intent = Intent( this, SettingsActivity::class.java  )
        startActivity( intent )
    }
}