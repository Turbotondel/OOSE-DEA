package oose.dea.config;

import com.google.inject.servlet.ServletModule;
import oose.dea.presentation.controller.*;
import oose.dea.services.AbonnementService;
import oose.dea.services.DienstService;
import oose.dea.services.local.LocalAbonnementService;
import oose.dea.services.local.LocalDienstService;

public class AppBinding extends ServletModule {
   @Override
    protected void configureServlets() {
        super.configureServlets();
       serve("/Abonnement").with(AbonnementViewPageController.class);
       serve("/Dienstdelen").with(DienstDelenPageController.class);
       serve("/Dienstopzeggen").with(DienstOpzeggenPageController.class);
       serve("/Dienstuitproberen").with(DienstUitproberenPageController.class);
       serve("/Dienstupgraden").with(DienstUpgradenPageController.class);
       serve("/Startdienstdelen").with(StartDienstDelenPageController.class);
       serve("/Zoekdienst").with(ZoekDienstPageController.class);
       bind(AbonnementService.class).to(LocalAbonnementService.class);
       bind(DienstService.class).to(LocalDienstService.class);
    }
}