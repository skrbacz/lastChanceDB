
package com.example.lastchancedb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lastchancedb.popups.AddVaccinationRecordFragment
import com.example.lastchancedb.popups.CalendarFragmentPopUp
import com.example.lastchancedb.popups.QuestionScheduleAppointmentFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_animation)}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_animation)}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_animation)}
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_animation)}

    private var addButton: FloatingActionButton?=null
    private var addVaccinationBtn: FloatingActionButton?=null
    private var scheduleVaccinationBtn: FloatingActionButton?=null
    private var goToAdmin: Button?=null

    private var clicked = false
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            addButton= findViewById(R.id.addBtn)
            addVaccinationBtn= findViewById(R.id.addVaccinationBtn)
            scheduleVaccinationBtn= findViewById(R.id.scheduleVaccinationBtn)
            goToAdmin= findViewById(R.id.goToMainAdmin)

            goToAdmin?.setOnClickListener {
                val intent= Intent(this@MainActivity, AdminMainActivity::class.java)
                startActivity(intent)
            }


            addButton?.setOnClickListener {
                onAddButtonClicked()
            }

            scheduleVaccinationBtn?.setOnClickListener {
                val showPopUp= QuestionScheduleAppointmentFragment()
                showPopUp.show(supportFragmentManager,"QuestionScheduleAppointmentFragment")
            }


            addVaccinationBtn?.setOnClickListener {
                val showPopUp= AddVaccinationRecordFragment()
                showPopUp.show(supportFragmentManager,"CalendarPopUp")
            }

        }




//        executeBTN = findViewById(R.id.executeBTN)
//        vaccNameED = findViewById(R.id.vaccNameED)
//        daysUntilNextDoseED = findViewById(R.id.daysUntilNextDoseED)
//        descriptionED = findViewById(R.id.descriptionED)
//
//        executeBTN?.setOnClickListener {
//
//            val vaccName = vaccNameED?.text.toString()
//            val daysUntilNextDose = daysUntilNextDoseED?.text.toString().toInt()
//            val description = descriptionED?.text.toString()
//            val vacc= Vaccination(vaccName,daysUntilNextDose,description)
//
//            couritineScoupe.launch {
//                insertVacc(vacc)
//            }
//        }
//    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked:Boolean) {
       if(!clicked){
           addVaccinationBtn?.visibility= View.VISIBLE
           scheduleVaccinationBtn?.visibility= View.VISIBLE
       }else{
           addVaccinationBtn?.visibility= View.INVISIBLE
           scheduleVaccinationBtn?.visibility= View.INVISIBLE
       }
    }
    private fun setAnimation(clicked:Boolean) {
        if(!clicked){
            addButton?.startAnimation(rotateOpen)
            scheduleVaccinationBtn?.startAnimation(fromBottom)
            addVaccinationBtn?.startAnimation(fromBottom)
        }else{
            addButton?.startAnimation(rotateClose)
            scheduleVaccinationBtn?.startAnimation(toBottom)
            addVaccinationBtn?.startAnimation(toBottom)
        }
    }
}
