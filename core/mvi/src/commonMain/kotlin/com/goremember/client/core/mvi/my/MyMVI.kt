package com.goremember.client.core.mvi.my

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.ComponentContext
import com.goremember.client.core.mvi.MVI
import pro.respawn.flowmvi.api.MVIAction
import pro.respawn.flowmvi.api.MVIIntent
import pro.respawn.flowmvi.api.MVIState
import pro.respawn.flowmvi.api.Store
import pro.respawn.flowmvi.dsl.state
import pro.respawn.flowmvi.dsl.store
import pro.respawn.flowmvi.essenty.api.DelicateRetainedApi
import pro.respawn.flowmvi.essenty.dsl.retainedStore
import pro.respawn.flowmvi.plugins.init
import pro.respawn.flowmvi.plugins.reduce

data class MyState(
    val clickedTimes: Int = 0,
) : MVIState

sealed interface MyIntent : MVIIntent {
    data object OnButtonClick : MyIntent
}

sealed interface MyAction : MVIAction {
    data object TooManyAttempts : MyAction
    data object NavigateToConfirmation : MyAction
    data class Failure(val throwable: Throwable) : MyAction
}

class MyComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, MVI<MyState, MyIntent, MyAction> {
    @OptIn(DelicateRetainedApi::class)
    override val store: Store<MyState, MyIntent, MyAction> = retainedStore(initial = MyState()) {
        reduce { intent ->
           updateState {
               when(intent) {
                   MyIntent.OnButtonClick -> copy(clickedTimes = clickedTimes + 1)
               }
           }
        }
    }
}