package com.example.chat.itemLista

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.chat.model.Usuario
import com.example.chat.ui.theme.black
import com.example.chat.ui.theme.white

@Composable
fun UsuarioLista(
    listaUsuario: MutableList<Usuario>,
    position: Int,
    context: Context
){

    val nome = listaUsuario[position].nome
    val fotoUsuario = listaUsuario[position].foto

    ConstraintLayout (
        modifier = Modifier
            .fillMaxWidth()
            .background(white)
    ){
        val (txtName, foto, mensagem, linha) = createRefs()
        
        Image(
            painter = painterResource(id = fotoUsuario!!),
            contentDescription = "Foto do homem usuario",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(foto) {
                    top.linkTo(parent.top, 20.dp)
                    start.linkTo(parent.start, 20.dp)
                },
            contentScale = ContentScale.Crop
        )

        TextButton(
            onClick = {
                Toast.makeText(context, "Usuario: $nome", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.constrainAs(txtName){
                top.linkTo(parent.top, 20.dp)
                start.linkTo(foto.end, 20.dp)
                end.linkTo(parent.end, 20.dp)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = white,
                contentColor = black
            )

        ) {
            Text(
                text = nome!!,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold

            )
        }

        Text(
            text = "Digitando...",
            modifier = Modifier.constrainAs(mensagem){
                top.linkTo(txtName.bottom)
                start.linkTo(foto.end, 20.dp)
                end.linkTo(parent.end, 20.dp)
            },
            fontSize = 12.sp
        )

        Row(
            modifier = Modifier.background(Color.Gray)
                .width(250.dp)
                .height(1.dp)
                .constrainAs(linha){
                    top.linkTo(mensagem.bottom, 10.dp)
                    start.linkTo(foto.end, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }
        ) {

        }

    }
}