package com.example.geopdfviewer

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.github.barteksc.pdfviewer.PDFView

class MainActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView
    private lateinit var coordsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pdfView = findViewById(R.id.pdfView)
        coordsText = findViewById(R.id.coordsText)

        // TODO: load your geospatial PDF from assets or storage
        pdfView.fromAsset("sample_geospatial.pdf").load()

        pdfView.setOnTouchListener { _: View, event: MotionEvent ->
            if (event.action == MotionEvent.ACTION_MOVE || event.action == MotionEvent.ACTION_DOWN) {
                val point = PointF(event.x, event.y)
                val latLong = mapPdfPointToLatLong(point)
                coordsText.text = "Lat: ${latLong.first}, Lon: ${latLong.second}"
            }
            true
        }
    }

    private fun mapPdfPointToLatLong(point: PointF): Pair<Double, Double> {
        // TODO: parse geospatial metadata from the PDF and map the point to coordinates
        // Placeholder implementation
        val lat = point.y.toDouble() / 1000.0
        val lon = point.x.toDouble() / 1000.0
        return lat to lon
    }
}
