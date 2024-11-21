package com.example.ucp1_pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PlayActivity(modifier: Modifier = Modifier){

    var nama by rememberSaveable { mutableStateOf("")}
    var notelp by rememberSaveable { mutableStateOf("")}
    var pilihgender by rememberSaveable { mutableStateOf("") }

    var jeniskelamin = listOf("Laki-laki", "Perempuan")

    var namaUserFix by rememberSaveable { mutableStateOf("") }
    var notelpUser by rememberSaveable {  mutableStateOf("") }
    var pilihgenderUser by rememberSaveable { mutableStateOf("") }

    Column (Modifier.fillMaxSize()) {
        Navbar(namaUser=namaUserFix)

        Text("Yuk lengkapi data dirimu !",
           modifier = Modifier.padding(start = 100.dp),
            fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            placeholder = { Text("Masukkan Nama") },
            leadingIcon ={ Icon(Icons.Filled.Face, contentDescription = "")},
            label = { Text("Nama:") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(
            value = notelp,
            onValueChange = { notelp = it },
            placeholder = { Text("Masukkan No Handphone") },
            leadingIcon ={ Icon(Icons.Filled.Call, contentDescription = "")},
            label = { Text("No Handphone:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Text("Jenis Kelamin",
            modifier = Modifier.padding( 5.dp))
        Row() {
            jeniskelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = pilihgender == item,
                        onClick = {
                            pilihgender = item
                        })
                    Text(item)
                }
            }
        }
        Button( modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(red = 0, green = 191, blue = 255),
            contentColor = Color.White
        ), onClick =  {
            namaUserFix = nama
            notelpUser = notelp
            pilihgenderUser = pilihgender
        })
        {
            Text(text = "Simpan")
        }
        Card(modifier.size(width = 450.dp, height = 180.dp).padding(10.dp) ) {
            CardSection(judulParam = "No Handphone", isiParam = notelpUser)
            CardSection(judulParam = "Jenis Kelamin", isiParam = pilihgenderUser)
        }
    }
}

@Composable
fun Navbar(namaUser:String){
    Box(Modifier.fillMaxWidth().size(150.dp)
        .clip(RoundedCornerShape(bottomEnd = 80.dp))
        .background(color = Color(red = 0, green = 191, blue = 255))){
        Row(modifier = Modifier.padding(top = 10.dp)){

            Column(modifier = Modifier.padding(5.dp)) {
                Icon(
                    Icons.Filled.Menu, contentDescription = "",
                    tint = Color.White
                )
                Text("Hallo,",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)
                Text(namaUser,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(100.dp)){
                Image(
                    painter = painterResource(id = R.drawable.dhf1),
                    contentDescription = "",
                    Modifier.size(100.dp).clip(shape = CircleShape)
                )
            }
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String) {
    Column(modifier = Modifier.padding(10.dp).background(color = Color(red = 0, green = 191, blue = 255))) {

        Spacer(Modifier.padding(2.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, color = Color.White, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = isiParam, modifier = Modifier.weight(0.8f))
        }

    }
}