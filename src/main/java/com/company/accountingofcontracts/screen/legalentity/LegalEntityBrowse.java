package com.company.accountingofcontracts.screen.legalentity;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.LegalEntity;

@UiController("LegalEntity.browse")
@UiDescriptor("legal-entity-browse.xml")
@LookupComponent("legalEntitiesTable")
public class LegalEntityBrowse extends StandardLookup<LegalEntity> {
}