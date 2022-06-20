package fr.isen.roussel.nicolasdroidburger

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val buttonSend = findViewById<Button>(R.id.SendMail)
        buttonSend.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,"marc.mollinari@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"Confirmation commande")
            intent.putExtra(Intent.EXTRA_TEXT,"Votre commande a bien été enregistrée")
        }
        startActivity(intent)
    }


}
