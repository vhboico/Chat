package com.example.chat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.chat.itemLista.UsuarioLista
import com.example.chat.model.Usuario
import com.example.chat.ui.theme.ChatTheme
import com.example.chat.ui.theme.greenDark
import com.example.chat.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                LayoutChat()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LayoutChat(){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = greenDark,
                title = {
                    Text(text = "Chat",
                        color = white,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                },
            )
        },
        backgroundColor = white
    ) {
        ListaUsuario()
    }
}

@Composable
fun ListaUsuario(){

    val context = LocalContext.current

    val listaUsuario: MutableList<Usuario> = mutableListOf(
        Usuario("Victor Boico", R.drawable.homem),
        Usuario("Taina Distadio", R.drawable.mulher),
        Usuario("Jonathan Calleri", R.drawable.homem),
        Usuario("Marta da Silva", R.drawable.mulher),
        Usuario("Victor Boico", R.drawable.homem),
        Usuario("Taina Distadio", R.drawable.mulher),
        Usuario("Jonathan Calleri", R.drawable.homem),
        Usuario("Marta da Silva", R.drawable.mulher),
        Usuario("Victor Boico", R.drawable.homem),
        Usuario("Taina Distadio", R.drawable.mulher),
        Usuario("Jonathan Calleri", R.drawable.homem),
        Usuario("Marta da Silva", R.drawable.mulher)
    )

    LazyColumn{
        itemsIndexed(listaUsuario){position,_ ->
            UsuarioLista(listaUsuario = listaUsuario, position = position, context = context)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatTheme {
        LayoutChat()
    }
}