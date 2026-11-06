package org.example.demo.view.core;

import org.example.demo.view.core.contract.Role;

public final class Session {
    private static Role role;

    public static void start(Role role) {
        Session.role = role;
    }

    public static Role role() {
        return role;
    }

    public static void end() {
        role = null;
    }
}
