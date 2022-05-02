package za.ac.cput.myjourney.ui.theme

sealed class Routes (val route: String) {
    object MainActivity : Routes("mainActivity")
    object StartJourney : Routes("journey")
}