package com.company.ut.screen.project;

import io.jmix.ui.screen.*;
import com.company.ut.entity.Project;


/**
 * @author  PuTongjiao
 * @date  2022/5/21 13:07
*/
@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
public class ProjectEdit extends StandardEditor<Project> {
}