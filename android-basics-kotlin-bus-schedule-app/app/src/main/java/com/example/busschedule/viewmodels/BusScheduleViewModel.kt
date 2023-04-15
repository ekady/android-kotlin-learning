package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import com.example.busschedule.database.schedule.ScheduleDao

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule() = scheduleDao.getAll()

    fun scheduleForStopName(stopName: String) = scheduleDao.getByStopName(stopName)
}