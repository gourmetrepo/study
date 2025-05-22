# GeoPDF Viewer Android App

This is a simple Android application that demonstrates how to load a geospatial PDF and display latitude/longitude as you move the pointer over the PDF.

## Building

Use Android Studio or the Gradle wrapper to build the project:

```bash
cd GeoPdfViewer
./gradlew assembleDebug
```

You need to place a `sample_geospatial.pdf` file in the `app/src/main/assets` directory (create it if it doesn't exist). The project relies on `android-pdf-viewer` for rendering PDFs. The mapping between PDF coordinates and geographic coordinates is implemented in `MainActivity.mapPdfPointToLatLong` and should be replaced with actual logic based on your PDF's metadata.

## Usage

Run the app on an Android device or emulator. When you open a geospatial PDF, moving your finger over the document will update the on-screen text with latitude and longitude values derived from the PDF coordinates.
