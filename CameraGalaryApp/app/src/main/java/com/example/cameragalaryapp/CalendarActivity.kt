package com.example.cameragalaryapp

import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class CalendarActivity : AppCompatActivity(){
    lateinit var chrono: Chronometer
    lateinit var btnStart: Button
    lateinit var btnSelectEnd: Button
    lateinit var btnStop: Button
    lateinit var btnReset: Button
    lateinit var calendarView: CalendarView
    lateinit var timePicker: TimePicker
    lateinit var resultTextView: TextView

    var selectYear = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        Log.d("d","asdf");

        btnStart = findViewById(R.id.btnStart)
        btnSelectEnd = findViewById(R.id.btnSelectEnd)
        btnStop = findViewById(R.id.btnStop)
        btnReset = findViewById(R.id.btnReset)

        chrono = findViewById(R.id.timerChronometer)
        calendarView = findViewById(R.id.calendarView)
        timePicker = findViewById(R.id.timePicker)
        resultTextView = findViewById(R.id.tvResult)

        btnStart.setOnClickListener{
            chrono.start()
            chrono.setTextColor(android.graphics.Color.MAGENTA)
        }

        btnStop.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(android.graphics.Color.WHITE)
        }

        btnReset.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(android.graphics.Color.WHITE)
            chrono.base= SystemClock.elapsedRealtime()
        }

        btnSelectEnd.setOnClickListener {
            var selectHour = timePicker.hour.toString()
            var selectMinute = timePicker.minute.toString()

            resultTextView.text="${selectYear}년 ${selectMonth}월 ${selectMinute}일 ${selectHour}시 ${selectMinute}분 선택 완료"
        }

            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                selectYear = year
                selectMonth = month+1 // 0~11
                selectDay = dayOfMonth
            }

    }
}
