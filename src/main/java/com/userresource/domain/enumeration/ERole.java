package com.userresource.domain.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum ERole {
    ROLE_USER,
    ROLE_MANAGER,
    ROLE_ADMIN,
    ROLE_SUPER_ADMIN;

    public static Optional<ERole> getErole(String erole) {
        return Arrays.stream(ERole.values())
                .filter(it -> it.name().equals(erole))
                .findFirst();
    }
}
