package com.example.randomgenerator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.randomgenerator.ui.theme.RandomGeneratorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: Button = findViewById(R.id.buttonGenerate)
        val selNumbers: Button = findViewById(R.id.selectNumbers)
        val numberGenerated: TextView = findViewById(R.id.numberGenerated)
        val numberGenerated2: TextView = findViewById(R.id.numberGenerated2)
        val numberGenerated3: TextView = findViewById(R.id.numberGenerated3)
        val numberGenerated4: TextView = findViewById(R.id.numberGenerated4)
        val numberGenerated5: TextView = findViewById(R.id.numberGenerated5)
        val collectedNumbers: TextView = findViewById(R.id.collectedNumbers)
        var concat: Set<Int> = emptySet()
        //var addBtn: Button? = null
        linearLayout = findViewById(R.id.linearLayout)

        generateButton.setOnClickListener {
            val randomNumbers = generateSequence {
                Random.nextInt(1..70)
            }.distinct().take(5).sorted().toSet()
            val randomNumbers2 = generateSequence {
                Random.nextInt(1..70)
            }.distinct().take(5).sorted().toSet()
            val randomNumbers3 = generateSequence {
                Random.nextInt(1..70)
            }.distinct().take(5).sorted().toSet()
            val randomNumbers4 = generateSequence {
                Random.nextInt(1..70)
            }.distinct().take(5).sorted().toSet()
            val randomNumbers5 = generateSequence {
                Random.nextInt(1..70)
            }.distinct().take(5).sorted().toSet()

            concat = concatenate (randomNumbers, randomNumbers2, randomNumbers3, randomNumbers4, randomNumbers5)


            numberGenerated.text = randomNumbers.toString()
            numberGenerated2.text = randomNumbers2.toString()
            numberGenerated3.text = randomNumbers3.toString()
            numberGenerated4.text = randomNumbers4.toString()
            numberGenerated5.text = randomNumbers5.toString()
        }

        selNumbers.setOnClickListener {
            numberGenerated.text = "none"
            numberGenerated2.text = "none"
            numberGenerated3.text = "none"
            numberGenerated4.text = "none"
            numberGenerated5.text = "none"
            collectedNumbers.text = concat.toString()
            createAndAddView()
        }
    }

    private fun createAndAddView()
    {
        val textView = TextView(this)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)

        textView.layoutParams = params
        textView.text = "HELLLLOOOOOO"
        linearLayout.addView(textView)
    }


}

private fun Random.nextInt(range: IntRange): Int {
    return range.first + nextInt(range.last - range.first)
}

private fun concatenate(randomNumbers: Set<Int>, randomNumbers2: Set<Int>, randomNumbers3: Set<Int>, randomNumbers4: Set<Int>, randomNumbers5: Set<Int>): Set<Int> {
    return randomNumbers + randomNumbers2 + randomNumbers3 + randomNumbers4 + randomNumbers5
}

