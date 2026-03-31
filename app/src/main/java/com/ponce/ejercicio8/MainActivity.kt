package com.ponce.ejercicio8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD1E8D1)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // Logo + Nombre + Título
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.xd),
                contentDescription = "Android Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Jennifer Doe",
                fontSize = 48.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFF1A1A2E)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Sección de contacto
        Column(
            modifier = Modifier.padding(bottom = 48.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ContactRow(icon = Icons.Filled.Phone, text = "+11 (123) 444 555 666")
            ContactRow(icon = Icons.Filled.Share, text = "@AndroidDev")
            ContactRow(icon = Icons.Filled.Email, text = "jen.doe@android.com")
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF2E7D32),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF1A1A2E)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBusinessCard() {
    MaterialTheme {
        BusinessCard()
    }
}