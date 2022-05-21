package com.company.ut.screen.attachment;

import io.jmix.ui.screen.*;
import com.company.ut.entity.Attachment;

/**
 * @author  PuTongjiao
 * @date  2022/5/21 22:41
*/
@UiController("Attachment.edit")
@UiDescriptor("attachment-edit.xml")
@EditedEntityContainer("attachmentDc")
public class AttachmentEdit extends StandardEditor<Attachment> {

}