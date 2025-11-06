package ro.pub.cs.systems.eim.Colocviu1_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.pub.cs.systems.eim.Colocviu1_1.ui.theme.Colocviu1_1Theme

class Colocviu1_1MainActivity : ComponentActivity() {
    private lateinit var north_button : Button
    private lateinit var east_button : Button
    private lateinit var west_button : Button
    private lateinit var south_button : Button
    private lateinit var directions_text : EditText
    private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)
        north_button = findViewById<Button>(R.id.north_button)
        east_button = findViewById<Button>(R.id.east_button)
        west_button = findViewById<Button>(R.id.west_button)
        south_button = findViewById<Button>(R.id.south_button)
        directions_text = findViewById<EditText>(R.id.directions_edit_text)
        val builder = StringBuilder()
        north_button.setOnClickListener {
            number++
            builder.append("North ")
            directions_text.setText(builder.toString())
        }
        east_button.setOnClickListener {
            number++
            builder.append("East ")
            directions_text.setText(builder.toString())
        }
        west_button.setOnClickListener {
            number++
            builder.append("West ")
            builder.append(number)
            directions_text.setText(builder.toString())
        }
        south_button.setOnClickListener {
            number++
            builder.append("South ")
            directions_text.setText(builder.toString())
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("number", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("number")) {
            number = savedInstanceState.getInt("number")

        }
    }
}
