package com.example.auto

import android.content.Context
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

fun DatePickerDialog(context: Context, date: MutableState<Date>) {

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = date.value

    val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        context,
        { datePicker: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
             df.parse("$mDayOfMonth/${mMonth+1}/$mYear")?.let {
                 date.value = it
                 Log.d("DatePickerDialog",datePicker.toString())
            }
        }, mYear, mMonth, mDay
    )
    mDatePickerDialog.show()
}
