package com.registry.view2;

/**
 * This is done to remove the circular dependency ehn getInput is called.
 */
public interface IInputObserver {
    void notified();
}
