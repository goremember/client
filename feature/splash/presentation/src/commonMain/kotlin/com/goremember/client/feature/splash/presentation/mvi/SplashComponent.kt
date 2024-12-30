package com.goremember.client.feature.splash.presentation.mvi

import com.arkivanov.decompose.ComponentContext
import com.goremember.client.core.mvi.MVI
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent.Action
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent.Intent
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent.State
import pro.respawn.flowmvi.api.MVIAction
import pro.respawn.flowmvi.api.MVIIntent
import pro.respawn.flowmvi.api.MVIState
import pro.respawn.flowmvi.api.Store
import pro.respawn.flowmvi.essenty.api.DelicateRetainedApi
import pro.respawn.flowmvi.essenty.dsl.retainedStore
import pro.respawn.flowmvi.plugins.init

@OptIn(DelicateRetainedApi::class)
class SplashComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext, MVI<State, Intent, Action> {
    override val store: Store<State, Intent, Action> = retainedStore(initial = State) {
        init {
            action(Action.NavigateToAuth)
            //TODO action(Action.NavigateToMainScreen)
        }
    }

    data object State : MVIState
    data object Intent : MVIIntent

    sealed interface Action : MVIAction {
        data object NavigateToAuth : Action
        data object NavigateToHome : Action
    }
}