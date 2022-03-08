package com.example.appnote.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appnote.R
import com.example.appnote.components.noteButton
import com.example.appnote.components.noteInputText
import com.example.appnote.data.NotesDataSource
import com.example.appnote.model.Note

@Composable
fun noteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
){

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                    Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "AppNotesIcon")
            },
            backgroundColor = Color(0xFF6C6E70)
        )

        //Contenido de la columna de la app
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            noteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })
            noteInputText(
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Add a Note",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })
            noteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()){
                        title = ""
                        description = ""
                    }
                })
        }
        
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(notes){note ->
                Text(text = note.title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun noteScreenPreview(){
    noteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}