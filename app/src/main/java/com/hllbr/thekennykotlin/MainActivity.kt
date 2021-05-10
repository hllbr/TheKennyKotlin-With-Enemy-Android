package com.hllbr.thekennykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    var runnable = Runnable { }
    var handler = Handler()
    var score = 0
    var ımageArrayList = ArrayList<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      ımageArrayList.add(imageView)
        ımageArrayList.add(imageView1)
        ımageArrayList.add(imageView2)
        ımageArrayList.add(imageView3)
        ımageArrayList.add(imageView4)
        ımageArrayList.add(imageView5)
        ımageArrayList.add(imageView6)
        ımageArrayList.add(imageView7)
        ımageArrayList.add(imageView8)

        ımageArrayList.add(enemy)
        ımageArrayList.add(enemy1)
        ımageArrayList.add(enemy2)
        ımageArrayList.add(enemy3)
        ımageArrayList.add(enemy4)
        ımageArrayList.add(enemy5)
        ımageArrayList.add(enemy6)
        ımageArrayList.add(enemy7)
        ımageArrayList.add(enemy8)


        hideImages()


        //CountDown Timer
        object : CountDownTimer(15700, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time : ${millisUntilFinished / 1000}"

            }

            override fun onFinish() {
                timeText.text = "Time : 0"
                handler.removeCallbacks(runnable)
                for (image in ımageArrayList) {
                    image.visibility = View.INVISIBLE
                }

                var alert = AlertDialog.Builder(this@MainActivity)//applicationContext appi çökertti
                alert.setTitle("Game Over !")
                alert.setMessage("Restart the Game?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    //Restart
                    val intent = intent
                    finish()//Destroyed flag
                    startActivity(intent)
                }
                alert.setNegativeButton("No") { dialog, which ->
                    //Destroyed or game information show
                    Toast.makeText(this@MainActivity, "Game Over!", Toast.LENGTH_LONG).show()

                }
                alert.show()
            }

        }.start()
    }

    fun clicked(view: View) {
        score++
        scoreText.text = "Score : ${score}"

    }
    fun sub(view : View) {
        score--
        scoreText.text= "Score : ${score}"

    }
    fun hideImages() {
        runnable = object : Runnable {
            override fun run() {
                for (image in ımageArrayList) {
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(18)
                ımageArrayList[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable, 300)
            }

        }
        handler.post(runnable)

    }





    }
