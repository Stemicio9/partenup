package com.partenupreview.partenup.security;

public enum ApplicationUserPermission {
    COLLABORATOR_READ("collaborator:read"),
    COLLABORATOR_WRITE("collaborator:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
