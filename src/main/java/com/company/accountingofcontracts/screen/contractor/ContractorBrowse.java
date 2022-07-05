package com.company.accountingofcontracts.screen.contractor;

import com.company.accountingofcontracts.entity.Contract;
import com.company.accountingofcontracts.entity.Individual;
import com.company.accountingofcontracts.entity.LegalEntity;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.Contractor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@UiController("Contractor.browse")
@UiDescriptor("contractor-browse.xml")
@LookupComponent("contractorsTable")
public class ContractorBrowse extends StandardLookup<Contractor> {
    @Autowired
    private ScreenBuilders screenBuilders;

    @Autowired
    private CollectionContainer<Contractor> contractorsDc;

    @Autowired
    private GroupTable<Contractor> contractorsTable;

    @Subscribe("createBtn.createInd")
    public void onCreateBtnCreateInd(Action.ActionPerformedEvent event) {
        final Screen editor = screenBuilders.editor(Individual.class, this)
                .newEntity()
                .withOpenMode(OpenMode.DIALOG)
                /*
                in case you need to have type as stored parameter
                .withInitializer(entity -> entity.setType(Type.ROOM))
                 */
                .build();
        editor.addAfterCloseListener(e -> {
            if (!Objects.equals(e.getCloseAction(), WINDOW_COMMIT_AND_CLOSE_ACTION)) {
                return;
            }

            final Individual edited = ((StandardEditor<Individual>) e.getSource()).getEditedEntity();
            contractorsDc.getMutableItems().add(0, edited);
            contractorsTable.setSelected(edited);
            contractorsTable.focus();
        });
        editor.show();
    }

    @Subscribe("createBtn.createLeg")
    public void onCreateBtnCreateLeg(Action.ActionPerformedEvent event) {
        final Screen editor = screenBuilders.editor(LegalEntity.class, this)
                .newEntity()
                .withOpenMode(OpenMode.DIALOG)
                /*
                in case you need to have type as stored parameter
                .withInitializer(entity -> entity.setType(Type.THING))
                 */
                .build();
        editor.addAfterCloseListener(e -> {
            if (!Objects.equals(e.getCloseAction(), WINDOW_COMMIT_AND_CLOSE_ACTION)) {
                return;
            }

            final LegalEntity edited = ((StandardEditor<LegalEntity>) e.getSource()).getEditedEntity();
            contractorsDc.getMutableItems().add(0, edited);
            contractorsTable.setSelected(edited);
            contractorsTable.focus();
        });
        editor.show();
    }

    @Subscribe("checkBtn.checkInd")
    public void onCheckBtnCheckInd(Action.ActionPerformedEvent event) {
        final Screen check = screenBuilders.lookup(Individual.class, this)
                .withOpenMode(OpenMode.DIALOG)
                /*
                in case you need to have type as stored parameter
                .withInitializer(entity -> entity.setType(Type.ROOM))
                 */
                .build();
        check.show();
    }

    @Subscribe("checkBtn.checkLeg")
    public void onCheckBtnCheckLeg(Action.ActionPerformedEvent event) {
        final Screen check = screenBuilders.lookup(LegalEntity.class, this)
                .withOpenMode(OpenMode.DIALOG)
                /*
                in case you need to have type as stored parameter
                .withInitializer(entity -> entity.setType(Type.ROOM))
                 */
                .build();
        check.show();
    }
}