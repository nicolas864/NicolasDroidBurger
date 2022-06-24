package fr.isen.roussel.nicolasdroidburger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        if(intent.hasExtra("address")){
            var address : TextView = findViewById(R.id.address)
            var address2 = ""
            address2 = intent.getStringExtra("address").toString()
            address.text = "$address2"
        }

        if(intent.hasExtra("name")){
            var name : TextView = findViewById(R.id.printName)
            var name2 = ""
            name2 = intent.getStringExtra("name").toString()
            name.text = "$name2"
        }

        if(intent.hasExtra("burger")){
            var burger : TextView = findViewById(R.id.burgerSelec)
            var burger2 = ""
            burger2 = intent.getStringExtra("burger").toString()
            burger.text = "$burger2"
        }

        if(intent.hasExtra("hour")){
            var hour : TextView = findViewById(R.id.delivery)
            var hour2 = ""
            hour2 = intent.getStringExtra("hour").toString()
            hour.text = "$hour2"
        }


        val buttonSend = findViewById<Button>(R.id.SendMail)
        buttonSend.setOnClickListener{
            val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                setType("text/plain")
                putExtra(Intent.EXTRA_EMAIL,"marc.mollinari@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT,"Confirmation commande")
                putExtra(Intent.EXTRA_TEXT,"Votre commande a bien été enregistrée")
        }
        startActivity(intentMail)
        }
    }
}