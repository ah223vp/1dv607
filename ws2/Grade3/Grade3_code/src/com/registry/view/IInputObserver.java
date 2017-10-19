package com.registry.view;

/**
 * This is done to remove the circular dependency ehn getInput is called.
 */
public interface IInputObserver {
    void notified();
}
