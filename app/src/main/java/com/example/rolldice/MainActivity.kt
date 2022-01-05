package com.example.rolldice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.buttom)


        rollButton.setOnClickListener {
            val newdice = Dice(6)
            val diceView: ImageView = findViewById(R.id.diceView)
            rollDice(newdice, diceView)

            val diceTwo = Dice(6)
            val diceViewTwo: ImageView = findViewById(R.id.diceView2)
            rollDice(diceTwo, diceViewTwo)
        }

    }

    // gira o dado e faz updade na tela com o resultado
    private fun rollDice(dice: Dice, image: ImageView) {
        //val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = image

        //determina qual imagem vai ser usada baseada no resultado do roll
        val drawaleResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //da um update na descricao do conteudo (para acessibilidade)
        diceImage.contentDescription = diceRoll.toString()

        //da um update no imageview com a imagem correta do dado
        diceImage.setImageResource(drawaleResource)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int = (1..numSides).random()
}