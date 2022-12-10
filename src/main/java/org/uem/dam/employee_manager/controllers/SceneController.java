package org.uem.dam.employee_manager.controllers;

import org.uem.dam.employee_manager.MainApplication;
import org.uem.dam.employee_manager.persistence.DBHelper;

public abstract class SceneController {
    private MainApplication mainApplication;

    public void setMainApplication(MainApplication mainApplication) {
        if (this.mainApplication != null) {
            throw new RuntimeException("Trying to set mainApplication, but it has been already defined");
        }
        this.mainApplication = mainApplication;
        onControllerLoaded();
    }

    protected abstract void onControllerLoaded();

    protected final void requestSceneChange(String scene) {
        mainApplication.changeRootScene(scene);
    }

    protected final void requestPopupDialogScene(String scene, String title, String header) {
        mainApplication.popupDialogScene(scene, title, header);
    }

    protected final DBHelper getDbHelper() {
        return mainApplication.getDbHelper();
    }
}