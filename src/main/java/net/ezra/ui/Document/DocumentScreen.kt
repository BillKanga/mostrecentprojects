package net.ezra.ui.Document


import android.content.Intent
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_CALENDAR
import net.ezra.navigation.ROUTE_DOCUMENT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SIGNUP



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentScreen(navController: NavHostController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(2.dp)
            .border(1.dp, Color.Blue)
            .padding(2.dp)
            .border(1.dp, Color.Red)
            .padding(1.dp)
    ) {

        item {

            Box {
                Column(

                ) {


                    val context = LocalContext.current.applicationContext
                    TopAppBar(
                        title = {
                            Text(
                                text = "",
                                color = Color.White
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {

                                navController.navigate(ROUTE_HOME) {
                                    popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                                }

                            }) {
                                Icon(imageVector = Icons.Filled.Home, contentDescription = "home")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFFFFFFFF),
                            titleContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        ),
                        actions = {
                            IconButton(onClick = {
                                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
                            },
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ROUTE_HOME) {
                                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                                        }


                                    }

                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "search",
                                    tint = Color(0xFF386FFA)
                                )
                            }
                            IconButton(onClick = {
                                Toast.makeText(context, "Loginr", Toast.LENGTH_SHORT).show()
                            },
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ROUTE_HOME) {
                                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                                        }


                                    }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.MailOutline,
                                    contentDescription = "Add Client",
                                    tint = Color(0xFF386FFA)
                                )
                            }
                            IconButton(onClick = {
                                Toast.makeText(context, "Services", Toast.LENGTH_SHORT).show()
                            },
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ROUTE_HOME) {
                                            popUpTo(ROUTE_DOCUMENT) { inclusive = true }
                                        }


                                    }


                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "person",
                                    tint = Color(0xFF386FFA)
                                )

                            }
                        })
                }
                Image(
                    painter = painterResource(id = R.drawable.kangalogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(90.dp)
                )


            }
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "[Advocates Renumaration Order 2014]",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W900,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "*LEGAL FEES PRESCRIBED*",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Serif

                )

                Spacer(modifier = Modifier.height(10.dp))

            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(9.dp)
            ) {
                Text(
                    text = "LEGAL DRAFTING",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sale Agreement-----> 2% of the value of the land" + "\n" + "Affidavits----->Ksh5000" + "\n" + "Certificate of Urgency plus Appplication---->Ksh50,000",
                    fontSize = 14.5.sp
                )

                Spacer(modifier = Modifier.height(18.dp))
                Column {

                    Text(
                        text = "LITIGATION",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Divorce proceedings-----> Ksh120,000" + "\n" + "Criminal Cases----->100,000Ksh(Plus varrying with the offence)",
                        fontSize = 16.5.sp
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))

                Column {

                    Text(
                        text = "CIVIL LITIGATION",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Land Cases-----> Ksh150,000" + "\n" + "Material Damage Claim----->Ksh80,000" + "\n" + "Personal Injury--->30% of damages granted by the court" + "\n" + "Civil Dispute/Tort--->Ksh100,000" + "\n" + "Petition--->Ksh150,000" + "\n" + "Appeals--->Ksh250,000",
                        fontSize = 16.5.sp
                    )

                }

                Spacer(modifier = Modifier.height(2.dp))


                var comments by rememberSaveable {
                    mutableStateOf("")
                }

Spacer(modifier = Modifier.height(95.dp))
                    Column(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(ROUTE_ADD_STUDENTS) {
                                    popUpTo(ROUTE_DOCUMENT) { inclusive = true }
                                }

                            }
                            .fillMaxWidth()
                            .height(230.dp)
                            .padding(15.dp)
                            , horizontalAlignment = Alignment.CenterHorizontally,
                    )

                    {
                       Text(text = "Feel free to reach out we will be happy to help you litigate your matters[Click Here]"
                                , fontSize = 20.sp,
                           fontFamily = FontFamily.Serif,
                           color = Color(0xFFFFB3B3)



                       )
                    }







                }


            }
        }
    }



@Preview(showBackground = true,)
@Composable
fun HomeScreenPreviewLight() {
   DocumentScreen(navController = rememberNavController())
}


