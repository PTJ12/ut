package com.company.ut.entity;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private DataManager dataManager;

    public User findLeastBusyUser() {
        User leastBusyUser = dataManager.loadValues("select u, count(t.id) " +
                        "from User u left outer join Task_ t " +
                        "on u = t.assignee " +
                        "group by u order by count(t.id)")
                .properties("user", "tasks")
                .list().stream().map(e -> e.<User>getValue("user"))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
        return leastBusyUser;
    }
}