package com.company.ut.security;

import com.company.ut.entity.Attachment;
import com.company.ut.entity.Project;
import com.company.ut.entity.Task;
import com.company.ut.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "CustomRole", code = "custom-role")
public interface CustomRole {
    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.ALL)
    void project();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.ALL)
    void task();

    @EntityAttributePolicy(entityClass = User.class, attributes = {"firstName", "lastName", "email"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = User.class, attributes = {"id", "version", "password", "active", "timeZoneId", "username"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void user();

    @MenuPolicy(menuIds = {"Project.browse", "Task_.browse", "User.browse", "Attachment.browse"})
    @ScreenPolicy(screenIds = {"User.browse", "Project.browse", "Task_.browse", "Project.edit", "Task_.edit", "User.edit", "Attachment.browse", "Attachment.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = Attachment.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Attachment.class, actions = EntityPolicyAction.ALL)
    void attachment();
}