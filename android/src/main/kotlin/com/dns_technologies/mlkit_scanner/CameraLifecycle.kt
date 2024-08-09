package com.dns_technologies.mlkit_scanner

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * Custom [LifecycleOwner] realisation.
 *
 * This implementation is needed to manage the camera lifecycle. This is necessary because
 * the [Lifecycle] provided by the parent Activity does not imply the ability to control
 * the camera based on the lifecycle of the flutter components
 */
class CameraLifecycle : LifecycleOwner {
    private var lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.markState(Lifecycle.State.CREATED);
//        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    /** Invoke after initialisation or pause camera */
    fun resume() {
        lifecycleRegistry.markState(Lifecycle.State.RESUMED);
//        lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }

    /**
     * It should be called in cases when the camera is not currently required to be displayed,
     * but it also does not require clearing the camera resources
     */
    fun pause() {
        lifecycleRegistry.markState(Lifecycle.State.CREATED);
//        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    /** Clear camera resources */
    fun dispose() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
//        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry


}