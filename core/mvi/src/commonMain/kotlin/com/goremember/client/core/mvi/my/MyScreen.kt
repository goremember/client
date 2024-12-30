package com.goremember.client.core.mvi.my

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.goremember.client.core.mvi.MVI
import pro.respawn.flowmvi.compose.dsl.subscribe
import pro.respawn.flowmvi.essenty.compose.subscribe

@Composable
fun MyScreen(mvi: MVI<MyState, MyIntent, MyAction>, log: (string: String) -> Unit) {
    val state = mvi.subscribe { action ->
        when (action) {
            is MyAction.Failure -> TODO()
            MyAction.NavigateToConfirmation -> TODO()
            MyAction.TooManyAttempts -> TODO()
        }
    }

    Column {
        Button(
            onClick = {
                log.invoke("mvi.store.intent(MyIntent.OnButtonClick)")
                mvi.store.intent(MyIntent.OnButtonClick)
            }
        ) {
            Text(text = "Hello world")
        }

        Text("Button was clicked ${state.value.clickedTimes} times")
    }
}