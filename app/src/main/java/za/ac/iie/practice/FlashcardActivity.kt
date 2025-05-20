package za.ac.iie.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashcardActivity : AppCompatActivity() {
val questions = arrayOf(
    "The Cold War a direct military conflict between the United States and the Soviet Union.",
    "The Berlin Wall was built to prevent East Germans from fleeing to West Berlin.",
    "The Cuban Missile Crisis occurred in 1962 and brought the world close to a nuclear war.",
    "The NATO was formed by the Soviet Union and its Allies.",
    "The Space Race was a significant part of the Cold War rivalry between the U.S and the USSR."
)
private val answers = booleanArrayOf(false, true, true, false, true)
private var currentQuestionIndex = 0
private var score = 0

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_flashcard)


    displayQuestion()

    val trueButton = findViewById<Button>(R.id.trueButton)
    val falseButton = findViewById<Button>(R.id.falseButton)
    val nextButton = findViewById<Button>(R.id.nextButton)

    trueButton.setOnClickListener {
        checkAnswer(true)
    }

    falseButton.setOnClickListener {
        checkAnswer(false)
    }

    nextButton.setOnClickListener {
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            // All questions answered, go to score screen
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL_QUESTIONS", questions.size)
            startActivity(intent)
            finish()
        }
    }
}

         fun displayQuestion() {
             val questionText = findViewById<TextView>(R.id.questionText)
             questionText.text = questions[currentQuestionIndex]
             }

         fun checkAnswer(userAnswer: Boolean) {
            val isCorrect = userAnswer == answers[currentQuestionIndex]

             if (isCorrect) {
             score++
             Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
             }
            }
    }