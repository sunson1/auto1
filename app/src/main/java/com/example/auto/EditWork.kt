package com.example.auto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NamedNavArgument
import java.util.*


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun EditWork(navArgument: NamedNavArgument?) {

    val date = remember { mutableStateOf(Date()) }
    val context = LocalContext.current

        if (navArgument == null) {

            Column() {

                Text(text = "Add",
                    modifier=Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    ,horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "date")
                    Text(text = date.value.toString(), modifier = Modifier.clickable {
                        DatePickerDialog(context, date)
                    })
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    ,horizontalArrangement = Arrangement.SpaceAround
                ) {

                    val showClearButton = remember { mutableStateOf(false) }
                    val query = remember {mutableStateOf("")}
                    val label: String = "label"
                    Text(text = "work")

                    val onQueryChanged = @Composable {
                        TODO()
                    }

                    WorknameEdit()

                }

            }
        } else
            TODO("Not yet implemented $navArgument")
    }

@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun PreviewEditWork() {
    EditWork(null)
}