package com.enoch02.hngzero

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enoch02.hngzero.ui.theme.HNGZeroTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HNGZeroTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.app_name))
                            }
                        )
                    },
                    content = { innerPadding ->
                        AppContentView(modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}

@Composable
fun AppContentView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                "Interesting Links",
                style = MaterialTheme.typography.headlineLarge
            )

            LinkButton(
                url = "https://telex.im",
                text = "Telex"
            )

            LinkButton(
                url = "https://delve.fun",
                text = "Delve"
            )

            LinkButton(
                url = "https://github.com/Enoch02/HNG-Zero",
                text = "View App Repo"
            )

            LinkButton(
                url = "https://hng.tech/hire/android-developers",
                text = "Hire Android Developers"
            )
        }
    )
}

@Composable
fun LinkButton(url: String, text: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        },
        modifier = modifier.padding(8.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppContentView()
}