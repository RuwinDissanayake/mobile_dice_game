package com.example.cw

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.cw.R.*
import java.util.*

class NewGameActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_new_game)

        val generateButton = findViewById<Button>(id.generate_button)
        val scoreButton = findViewById<Button>(id.scoreButton)
        val computerDice1 = findViewById<ImageView>(id.dice_1)
        val computerDice2 = findViewById<ImageView>(id.dice_2)
        val computerDice3 = findViewById<ImageView>(id.dice_3)
        val computerDice4 = findViewById<ImageView>(id.dice_4)
        val computerDice5 = findViewById<ImageView>(id.dice_5)
        val playerDice1 = findViewById<ImageView>(id.dice_6)
        val playerDice2 = findViewById<ImageView>(id.dice_7)
        val playerDice3 = findViewById<ImageView>(id.dice_8)
        val playerDice4 = findViewById<ImageView>(id.dice_9)
        val playerDice5 = findViewById<ImageView>(id.dice_10)
        val playerScore = findViewById<TextView>(id.playerScore)
        val computerScore = findViewById<TextView>(id.computerScore)
        var newComputerScore = 0
        var newPlayerScore = 0

        var clickCount = 0
        generateButton.setOnClickListener {

            if (clickCount == 0) {

                displayDice(playerDice1, generateRandomNumber())
                displayDice(playerDice2, generateRandomNumber())
                displayDice(playerDice3, generateRandomNumber())
                displayDice(playerDice4, generateRandomNumber())
                displayDice(playerDice5, generateRandomNumber())
                displayDice(computerDice1, generateRandomNumber())
                displayDice(computerDice2, generateRandomNumber())
                displayDice(computerDice3, generateRandomNumber())
                displayDice(computerDice4, generateRandomNumber())
                displayDice(computerDice5, generateRandomNumber())

                scoreButton.setOnClickListener() {
                    val currentPlayerScoreText = playerScore.text.toString()
                    val currentPlayerScore = currentPlayerScoreText.toInt()
                    val currentComputerScoreText = computerScore.text.toString()
                    val currentComputerScore = currentComputerScoreText.toInt()
                    newComputerScore =
                        currentComputerScore + getDiceValue(computerDice1) + getDiceValue(
                            computerDice2
                        ) + getDiceValue(computerDice3) + getDiceValue(computerDice4) + getDiceValue(
                            computerDice5
                        )
                    newPlayerScore =
                        currentPlayerScore + getDiceValue(playerDice1) + getDiceValue(playerDice2) + getDiceValue(
                            playerDice3
                        ) + getDiceValue(playerDice4) + getDiceValue(playerDice5)

                    if (newComputerScore >= 101 && newPlayerScore >= 101) {

                        if (newComputerScore > newPlayerScore){
                            var intent = Intent(this, lose::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }else{
                            var intent = Intent(this, win::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }
                    } else if (newPlayerScore >= 101) {

                        var intent = Intent(this, win::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    } else if (newComputerScore >= 101) {

                        var intent = Intent(this, lose::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    }
                    playerScore.text = newPlayerScore.toString()
                    computerScore.text = newComputerScore.toString()


                    resetDice(computerDice1)
                    resetDice(computerDice2)
                    resetDice(computerDice3)
                    resetDice(computerDice4)
                    resetDice(computerDice5)
                    resetDice(playerDice1)
                    resetDice(playerDice2)
                    resetDice(playerDice3)
                    resetDice(playerDice4)
                    resetDice(playerDice5)

                    clickCount = 0
                }
                clickCount++


            } else if (clickCount < 3) {

                val compReroll = computerReroll()
                if (compReroll == 1){
                    displayDice(computerDice1,generateRandomNumber())
                    displayDice(computerDice2,generateRandomNumber())
                    displayDice(computerDice3,generateRandomNumber())
                    displayDice(computerDice4,generateRandomNumber())
                    displayDice(computerDice5,generateRandomNumber())
                }


                displayDice(playerDice1, generateRandomNumber())
                displayDice(playerDice2, generateRandomNumber())
                displayDice(playerDice3, generateRandomNumber())
                displayDice(playerDice4, generateRandomNumber())
                displayDice(playerDice5, generateRandomNumber())

                scoreButton.setOnClickListener() {
                    val currentPlayerScoreText = playerScore.text.toString()
                    val currentPlayerScore = currentPlayerScoreText.toInt()
                    val currentComputerScoreText = computerScore.text.toString()
                    val currentComputerScore = currentComputerScoreText.toInt()
                    newComputerScore =
                        currentComputerScore + getDiceValue(computerDice1) + getDiceValue(
                            computerDice2
                        ) + getDiceValue(computerDice3) + getDiceValue(computerDice4) + getDiceValue(
                            computerDice5
                        )
                    newPlayerScore =
                        currentPlayerScore + getDiceValue(playerDice1) + getDiceValue(playerDice2) + getDiceValue(
                            playerDice3
                        ) + getDiceValue(playerDice4) + getDiceValue(playerDice5)

                    if (newComputerScore >= 101 && newPlayerScore >= 101) {

                        if (newComputerScore > newPlayerScore){
                            var intent = Intent(this, lose::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }else{
                            var intent = Intent(this, win::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }
                    } else if (newPlayerScore >= 101) {

                        var intent = Intent(this, win::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    } else if (newComputerScore >= 101) {

                        var intent = Intent(this, lose::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    }
                    playerScore.text = newPlayerScore.toString()
                    computerScore.text = newComputerScore.toString()

                    currentComputerScore == 0
                    currentPlayerScore == 0
                    getDiceValue(playerDice1) == 0
                    getDiceValue(playerDice2) == 0
                    getDiceValue(playerDice3) == 0
                    getDiceValue(playerDice4) == 0
                    getDiceValue(playerDice5) == 0
                    getDiceValue(computerDice1) == 0
                    getDiceValue(computerDice2) == 0
                    getDiceValue(computerDice3) == 0
                    getDiceValue(computerDice4) == 0
                    getDiceValue(computerDice5) == 0

                    resetDice(computerDice1)
                    resetDice(computerDice2)
                    resetDice(computerDice3)
                    resetDice(computerDice4)
                    resetDice(computerDice5)
                    resetDice(playerDice1)
                    resetDice(playerDice2)
                    resetDice(playerDice3)
                    resetDice(playerDice4)
                    resetDice(playerDice5)

                    clickCount = 0

                }
                clickCount++
            } else {


                    val currentPlayerScoreText = playerScore.text.toString()
                    val currentPlayerScore = currentPlayerScoreText.toInt()
                    val currentComputerScoreText = computerScore.text.toString()
                    val currentComputerScore = currentComputerScoreText.toInt()
                    newComputerScore =
                        currentComputerScore + getDiceValue(computerDice1) + getDiceValue(
                            computerDice2
                        ) + getDiceValue(computerDice3) + getDiceValue(computerDice4) + getDiceValue(
                            computerDice5
                        )
                    newPlayerScore =
                        currentPlayerScore + getDiceValue(playerDice1) + getDiceValue(playerDice2) + getDiceValue(
                            playerDice3
                        ) + getDiceValue(playerDice4) + getDiceValue(playerDice5)

                    if (newComputerScore >= 101 && newPlayerScore >= 101) {

                        if (newComputerScore > newPlayerScore){
                            var intent = Intent(this, lose::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }else{
                            var intent = Intent(this, win::class.java)
                            intent.putExtra("param1", "value1")
                            startActivity(intent)
                        }
                    } else if (newPlayerScore >= 101) {

                        var intent = Intent(this, win::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    } else if (newComputerScore >= 101) {

                        var intent = Intent(this, lose::class.java)
                        intent.putExtra("param1", "value1")
                        startActivity(intent)
                    }
                    playerScore.text = newPlayerScore.toString()
                    computerScore.text = newComputerScore.toString()


                    resetDice(computerDice1)
                    resetDice(computerDice2)
                    resetDice(computerDice3)
                    resetDice(computerDice4)
                    resetDice(computerDice5)
                    resetDice(playerDice1)
                    resetDice(playerDice2)
                    resetDice(playerDice3)
                    resetDice(playerDice4)
                    resetDice(playerDice5)

                    clickCount = 0
                }
            }

        }

    private  fun computerReroll():Int {
        val random = Random()
        return random.nextInt(2)
    }

    private fun generateRandomNumber(): Int {
        val random = Random()
        return random.nextInt(6) + 1
    }

    private fun displayDice(imageView: ImageView, number: Int) {
        if (number == 1) {
            imageView.setImageResource(R.drawable.die_face_1)
            imageView.tag = R.drawable.die_face_1
        } else if (number == 2) {
            imageView.setImageResource(R.drawable.die_face_2)
            imageView.tag = R.drawable.die_face_2
        } else if (number == 3) {
            imageView.setImageResource(R.drawable.die_face_3)
            imageView.tag = R.drawable.die_face_3
        } else if (number == 4) {
            imageView.setImageResource(R.drawable.die_face_4)
            imageView.tag = R.drawable.die_face_4
        } else if (number == 5) {
            imageView.setImageResource(R.drawable.die_face_5)
            imageView.tag = R.drawable.die_face_5
        } else {
            imageView.setImageResource(R.drawable.die_face_6)
            imageView.tag = R.drawable.die_face_6
        }
    }

    private fun resetDice(imageView: ImageView) {
        imageView.setImageResource(color.gray)


    }

    private fun getDiceValue(imageView: ImageView): Int {
        val currentImageResource = imageView.tag as Int
        if (currentImageResource == R.drawable.die_face_1) {
            return 1
        } else if (currentImageResource == R.drawable.die_face_2) {
            return 2
        } else if (currentImageResource == R.drawable.die_face_3) {
            return 3
        } else if (currentImageResource == R.drawable.die_face_4) {
            return 4
        } else if (currentImageResource == R.drawable.die_face_5) {
            return 5
        } else {
            return 6
        }
    }


}