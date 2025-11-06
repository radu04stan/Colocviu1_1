package ro.pub.cs.systems.eim.Colocviu1_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
    private var builder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)
        north_button = findViewById<Button>(R.id.north_button)
        east_button = findViewById<Button>(R.id.east_button)
        west_button = findViewById<Button>(R.id.west_button)
        south_button = findViewById<Button>(R.id.south_button)
        directions_text = findViewById<EditText>(R.id.directions_edit_text)
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

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result REGISTER", Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.second_activity_button)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
            intent.putExtra("builder", builder.toString())
            activityResultsLauncher.launch(intent)
        }

        val navigateToSecondaryActivityButtonZero = findViewById<Button>(R.id.second_activity_button_zero)
        navigateToSecondaryActivityButtonZero.setOnClickListener {
            val intent = Intent(this, Colocviu1_1SecondaryActivity::class.java)
            intent.putExtra("builder", "")
            builder = StringBuilder()
            number = 0
            directions_text.setText("")
            activityResultsLauncher.launch(intent)
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
