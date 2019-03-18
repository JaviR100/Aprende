package com.example.javier.aprende.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {



    //Declarando Varibales
    private var Edit_Nombre: EditText? = null
    private var Edit_Edad: EditText? = null
    private var nombre: String? = null
    private var edad : String? = null
    private var nombre_campo : TextView? = null
    private var edad_campo : TextView? = null
    private var boton : Button? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Edit_Nombre = findViewById<EditText>(R.id.editText)
        Edit_Edad = findViewById(R.id.editText2)

        Edit_Nombre!!.addTextChangedListener(this)
        Edit_Edad!!.addTextChangedListener(this)

        nombre_campo = findViewById<TextView>(R.id.campo_nombre)
        edad_campo = findViewById(R.id.campo_edad)
        boton = findViewById(R.id.boton_ejecutar)
        boton!!.setOnClickListener(this)

        //Para mejorar el modo depuracion
        //operacion()

        //Colocar el teclado en mayuscula al iniciar
        Edit_Nombre!!.inputType = InputType.TYPE_CLASS_TEXT  or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
    }
        //Funciones de Interfaces
    override fun afterTextChanged(s: Editable?)
        {
            //Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
        }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
        {
            //Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
        }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
        {
            nombre = Edit_Nombre?.text.toString()

            if (nombre?.equals("") ?: ("" == null))
                {
                    Edit_Nombre!!.inputType = InputType.TYPE_CLASS_TEXT  or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS //Convierte los caracteres del teclado en mayuscula
                }
            else
                {
                   Edit_Nombre!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL // y esta en miniscula
                }



        }
    //Funcion para el boton
    override fun onClick(v: View?)
    {
        operacion()
    }

    private fun operacion()
    {
        nombre = Edit_Nombre?.text.toString()
        edad = Edit_Edad?.text.toString()
        if (nombre?.equals("") ?: ("" == null) )
            {
                Edit_Nombre!!.requestFocus()
            }
        else
            {
                nombre_campo?.text = nombre

                if(edad?.equals("") ?: ("" == null))
                    {
                        Edit_Edad!!.requestFocus()
                    }
                else
                    {
                        edad_campo?.text = edad
                    }
            }
    }
}
