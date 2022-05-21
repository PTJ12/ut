package com.company.ut.screen.attachment;

import io.jmix.ui.UiComponents;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.LinkButton;
import io.jmix.ui.component.Table;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.screen.*;
import com.company.ut.entity.Attachment;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author  PuTongjiao
 * @date  2022/5/21 22:41
*/
@UiController("Attachment.browse")
@UiDescriptor("attachment-browse.xml")
@LookupComponent("attachmentsTable")
public class AttachmentBrowse extends StandardLookup<Attachment> {

    @Autowired
    private Downloader downloader;
    @Autowired
    private UiComponents uiComponents;

    @Install(to = "attachmentsTable.fileName", subject = "columnGenerator")
    private Component attachmentsTableFileNameColumnGenerator(Attachment attachment) {
        if (attachment.getFile() != null){
            LinkButton linkButton = uiComponents.create(LinkButton.class);
            linkButton.setAction(new BaseAction("download")
                    .withCaption(attachment.getFile().getFileName())
                    .withHandler(actionPerformedEvent ->
                            downloader.download(attachment.getFile())
                    )
            );
            return linkButton;
        }else {
            return new Table.PlainTextCell("<empty>");
        }
    }
}