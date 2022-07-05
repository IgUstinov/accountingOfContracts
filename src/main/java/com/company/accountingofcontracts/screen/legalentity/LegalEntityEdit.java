package com.company.accountingofcontracts.screen.legalentity;

import io.jmix.ui.screen.*;
import com.company.accountingofcontracts.entity.LegalEntity;

import java.awt.*;

@UiController("LegalEntity.edit")
@UiDescriptor("legal-entity-edit.xml")
@EditedEntityContainer("legalEntityDc")
public class LegalEntityEdit extends StandardEditor<LegalEntity> {
}