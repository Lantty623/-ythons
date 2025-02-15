package com.example.animalstepper.navigation

//import com.chaquo.python.PyException
//import com.chaquo.python.Python
//import com.chaquo.python.android.AndroidPlatform
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalstepper.data.StepManager
import com.example.animalstepper.navigation.screen.StepScreen
import com.example.animalstepper.navigation.screen.StepViewModel
import com.example.animalstepper.navigation.screen.StepViewModelFactory
import com.example.animalstepper.navigation.theme.AnimalStepperTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
             AnimalStepperTheme{
                 val stepManager : StepManager = StepManager(applicationContext)
                 var viewModel : StepViewModel = viewModel(
                     factory = StepViewModelFactory(stepManager = stepManager)
                 )
                 viewModel.initialLoad()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //test_python()
                    //set_layout()

                    StepScreen(steps = viewModel.footsteps.value,
                        lengthUnit = "cm",
                        url = viewModel.url.value,
                        fact = viewModel.fact.value
                    )
                }
            }
        }
    }
}
//
//@Composable
//fun show_steps(steps: Int) {
//    Surface(color = Color.LightGray) {
//        Text(text = "You've walked $steps steps!")
//    }
//}
//
//@Composable
//fun show_animal_steps(animal: String, steps: Int) {
//    var animal_steps = steps * 100
//    Surface(color = Color.Gray) {
//        Text(text = "That's the equivalent to $animal_steps $animal steps!")
//    }
//}
//
//@Composable
//fun test_python() {
//    val py = Python.getInstance()
//    val module = py.getModule("test")
//    val t = module.callAttr("test").toJava(String::class.java)
//
//    Text(text = t)
//}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Composable
//fun set_layout() {
//    Column {
//        val animal =  dropdown_menu()
//        show_steps(2000)
//        show_animal_steps(animal, 2000)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApplication2Theme {
//        //Greeting("Android")
//        //test_python()
//        set_layout()
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun dropdown_menu(): String {
//    val contextForToast = LocalContext.current.applicationContext
//    val listItems = arrayOf("Dog", "Cat", "Moose", "Duck", "Elephant")
//
//    // state of the menu
//    var expanded by remember {
//        mutableStateOf(false)
//    }
//
//    // remember the selected item
//    var selectedItem by remember {
//        mutableStateOf(listItems[0])
//    }
//
//    // box
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = {
//            expanded = !expanded
//        }
//    ) {
//        TextField(
//            value = selectedItem,
//            onValueChange = { selectedItem = it },
//            label = { Text(text = "Choose an animal") },
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(
//                    expanded = expanded
//                )
//            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors()
//        )
//
//        // filter options based on text field value
//        val filteringOptions =
//            listItems.filter { it.contains(selectedItem, ignoreCase = true) }
//
//        if (filteringOptions.isNotEmpty()) {
//            // menu
//            ExposedDropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false }
//            ) {
//                // this is a column scope
//                // all the items are added vertically
//                filteringOptions.forEach { selectionOption ->
//                    // menu item
//                    DropdownMenuItem(
//                        onClick = {
//                            selectedItem = selectionOption
//                            Toast.makeText(contextForToast, selectedItem, Toast.LENGTH_SHORT).show()
//                            expanded = false
//                        }
//                    ) {
//                        Text(text = selectionOption)
//                    }
//                }
//            }
//        }
//    }
//    return selectedItem.lowercase()
//}