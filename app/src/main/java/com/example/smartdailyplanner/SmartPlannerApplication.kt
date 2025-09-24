package com.example.smartdailyplanner

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SmartPlannerApplication : Application() {

    companion object {
        const val TASK_REMINDER_CHANNEL_ID = "task_reminder_channel"
        const val AI_SUGGESTION_CHANNEL_ID = "ai_suggestion_channel"
        const val PRODUCTIVITY_CHANNEL_ID = "productivity_channel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Task Reminder Channel
            val taskReminderChannel = NotificationChannel(
                TASK_REMINDER_CHANNEL_ID,
                "Task Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for upcoming tasks and deadlines"
                enableLights(true)
                enableVibration(true)
            }

            // AI Suggestion Channel
            val aiSuggestionChannel = NotificationChannel(
                AI_SUGGESTION_CHANNEL_ID,
                "AI Suggestions",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "AI-powered productivity suggestions and insights"
                enableLights(true)
            }

            // Productivity Insights Channel
            val productivityChannel = NotificationChannel(
                PRODUCTIVITY_CHANNEL_ID,
                "Productivity Insights",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Daily and weekly productivity reports"
            }

            notificationManager.createNotificationChannel(taskReminderChannel)
            notificationManager.createNotificationChannel(aiSuggestionChannel)
            notificationManager.createNotificationChannel(productivityChannel)
        }
    }
}