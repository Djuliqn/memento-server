package com.memento.service;

import com.memento.model.Permission;
import com.memento.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getAll();

    Role save(Role role);

    void saveRoles(Set<Role> roles);

    Role findRoleByPermission(Permission permission);
}
