package com.example.psp.ut03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.psp.ut03.data.remote.models.AlertsApiModel
import com.example.psp.ut03.data.remote.models.RetroFitApiClient


class Ut03Ex01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiClient = RetroFitApiClient()

        Thread {
            //ALL ALERTS IN API
            val alerts = apiClient.getAlerts()
            if (alerts != null) {
                Log.d("@dev", "Status code: ${alerts.statusCode}")
                Log.d(
                    "@dev",
                    "------------------------------------------------------------------------------------------"
                )
            }
            travelAlerts(alerts)
            Log.d(
                "@dev",
                "------------------------------------------------------------------------------------------"
            )

            //ONE ALERT WITH ID FROM THE FULL LIST
            val alert = apiClient.getAlertFromList("2078195", apiClient.getAlerts())
            Log.d("@dev", "Alerta: $alert")

            //ONE ALERT DIRECTLY FROM ALERT_ID
            Log.d(
                "@dev",
                "------------------------------------------------------------------------------------------"
            )
            val idAlert = apiClient.getAlert("2078195")
            Log.d("@dev", "Alerta: $idAlert")

        }.start()
    }

    fun travelAlerts(alerts: AlertsApiModel?) {
        alerts?.let {
            Log.d("@dev", it.data.toString())
        }
    }

}