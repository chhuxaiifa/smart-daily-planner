package com.example.smartdailyplanner.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartdailyplanner.presentation.screens.dashboard.DashboardScreen
import com.example.smartdailyplanner.presentation.screens.onboarding.OnboardingScreen
import com.example.smartdailyplanner.presentation.screens.tasks.TasksScreen
import com.example.smartdailyplanner.presentation.screens.calendar.CalendarScreen
import com.example.smartdailyplanner.presentation.screens.analytics.AnalyticsScreen
import com.example.smartdailyplanner.presentation.screens.settings.SettingsScreen

@Composable
fun SmartPlannerNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onNavigateToDashboard = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        
        composable(Screen.Tasks.route) {
            TasksScreen(navController = navController)
        }
        
        composable(Screen.Calendar.route) {
            CalendarScreen(navController = navController)
        }
        
        composable(Screen.Analytics.route) {
            AnalyticsScreen(navController = navController)
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Dashboard : Screen("dashboard")
    object Tasks : Screen("tasks")
    object Calendar : Screen("calendar")
    object Analytics : Screen("analytics")
    object Settings : Screen("settings")
}