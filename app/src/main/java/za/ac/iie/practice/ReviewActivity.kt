package za.ac.iie.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val reviewText = findViewById<TextView>(R.id.reviewText)
        val restartButton = findViewById<Button>(R.id.restartButton)

        val questions = arrayOf(
            "The Cold War a direct military conflict between the United States and the Soviet Union.",
            "The Berlin Wall was built to prevent East Germans from fleeing to West Berlin.",
            "The Cuban Missile Crisis occurred in 1962 and brought the world close to a nuclear war.",
            "The NATO was formed by the Soviet Union and its Allies.",
            "The Space Race was a significant part of the Cold War rivalry between the U.S and the USSR.")

        val answers = booleanArrayOf(false, true, true, false, true)


        var reviewContent = "Review Questions and Answers:\n\n"
        for (i in questions.indices) {
            reviewContent += "${i + 1}. ${questions[i]}\n"
            reviewContent += "Correct Answer: ${if (answers[i]) "True" else "False"}\n\n"
        }

        reviewText.text = reviewContent

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}