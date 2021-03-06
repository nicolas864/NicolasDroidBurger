package fr.isen.roussel.nicolasdroidburger


import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputHour: Button = findViewById(R.id.inputHour)

        val validate: Button = findViewById(R.id.validate)
        //validate.setOnClickListener(this)

        validate.setOnClickListener{
            if(validate()){
                val address = findViewById<EditText>(R.id.inputAdresse).text.toString()
                val name = findViewById<EditText>(R.id.inputPrenom).text.toString()
                val burger = findViewById<Spinner>(R.id.inputBurger).selectedItem.toString()
                val hour = findViewById<Button>(R.id.inputHour).text.toString()

                //Toast.makeText(applicationContext,"Done", Toast.LENGTH_LONG).show()
                val pref = getPreferences(Context.MODE_PRIVATE)
                val editor = pref.edit()
                editor.putString("name", findViewById<TextView>(R.id.inputNom).text.toString())
                editor.putString("firstname", findViewById<EditText>(R.id.inputPrenom).text.toString())
                editor.apply()


                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("name", name )
                intent.putExtra("address",address)
                intent.putExtra("burger", burger)
                intent.putExtra("hour", hour)
                startActivity(intent)
            }
        }


        //Spinner
        val spinner: Spinner = findViewById(R.id.inputBurger)
        ArrayAdapter.createFromResource(
            this,
            R.array.burger_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        inputHour.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                inputHour.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }

            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }


        //val validate: Button = findViewById(R.id.validate)



    }

    private fun saveData(view: View) {






        val toast = Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()


    }

    private fun validate(): Boolean {
        val inputNom: TextView = findViewById(R.id.inputNom);
        val inputPrenom: TextView = findViewById(R.id.inputPrenom)
        val inputAdresse: TextView = findViewById(R.id.inputAdresse)
        val inputTel: TextView = findViewById(R.id.inputTelephone)
        val inputHour: Button = findViewById(R.id.inputHour)

        if (inputNom.text.toString().isEmpty()) {
            inputNom.error = "Veuillez rentrer un nom"
            return false
        } else if (inputPrenom.text.toString().isEmpty()) {
            inputPrenom.error = "Veuillez rentrer un pr??nom"
            return false
        } else if (inputAdresse.text.toString().isEmpty()) {
            inputAdresse.error = "Veuillez rentrer une adresse"
            return false
        } else if (inputTel.text.toString().isEmpty()) {
            inputTel.error = "Veuillez rentrer un num??ro"
            return false
        } else if (inputHour.text.toString().isEmpty()) {
            inputHour.error = "Veuillez rentrer une heure"
            return false
        }

        return true
    }


    /*override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.validate->{
                if(validate()){
                    //onSave()


                }
            }
        }

    }*/







}







