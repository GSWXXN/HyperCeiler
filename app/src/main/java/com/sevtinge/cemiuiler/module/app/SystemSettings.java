package com.sevtinge.cemiuiler.module.app;

import static com.sevtinge.cemiuiler.utils.devicesdk.SystemSDKKt.isAndroidR;
import static com.sevtinge.cemiuiler.utils.devicesdk.SystemSDKKt.isMoreAndroidVersion;

import com.sevtinge.cemiuiler.module.base.BaseModule;
import com.sevtinge.cemiuiler.module.hook.miinput.UnlockKnuckleFunction;
import com.sevtinge.cemiuiler.module.hook.systemsettings.AddMiuiPlusEntry;
import com.sevtinge.cemiuiler.module.hook.systemsettings.AppsFreezerEnable;
import com.sevtinge.cemiuiler.module.hook.systemsettings.EnableSpeedMode;
import com.sevtinge.cemiuiler.module.hook.systemsettings.InternationalBuild;
import com.sevtinge.cemiuiler.module.hook.systemsettings.NewNFCPage;
import com.sevtinge.cemiuiler.module.hook.systemsettings.NoveltyHaptic;
import com.sevtinge.cemiuiler.module.hook.systemsettings.QuickManageOverlayPermission;
import com.sevtinge.cemiuiler.module.hook.systemsettings.QuickManageUnknownAppSources;
import com.sevtinge.cemiuiler.module.hook.systemsettings.UnLockAreaScreenshot;
import com.sevtinge.cemiuiler.module.hook.systemsettings.UnlockTaplusForSettings;
import com.sevtinge.cemiuiler.module.hook.systemsettings.ViewWifiPasswordHook;
import com.sevtinge.cemiuiler.module.hook.systemsettings.VoipAssistantController;
import com.sevtinge.cemiuiler.module.hook.systemsettings.aiimage.UnlockAi;
import com.sevtinge.cemiuiler.module.hook.systemsettings.aiimage.UnlockMemc;
import com.sevtinge.cemiuiler.module.hook.systemsettings.aiimage.UnlockSuperResolution;

public class SystemSettings extends BaseModule {

    @Override
    public void handleLoadPackage() {
        initHook(new ViewWifiPasswordHook(), mPrefsMap.getBoolean("system_settings_safe_wifi"));
        initHook(new VoipAssistantController(), mPrefsMap.getBoolean("system_settings_voip_assistant_controller"));
        initHook(new AddMiuiPlusEntry(), mPrefsMap.getBoolean("mirror_unlock_miui_plus"));
        initHook(new EnableSpeedMode(), mPrefsMap.getBoolean("system_settings_develop_speed_mode"));
        initHook(new QuickManageOverlayPermission(), mPrefsMap.getBoolean("system_settings_permission_show_app_up"));
        initHook(new QuickManageUnknownAppSources(), mPrefsMap.getBoolean("system_settings_permission_unknown_origin_app"));
        initHook(new InternationalBuild(), mPrefsMap.getBoolean("system_settings_international_build"));
        initHook(new NewNFCPage(), mPrefsMap.getBoolean("system_settings_new_nfc_page"));
        initHook(new AppsFreezerEnable(), mPrefsMap.getBoolean("system_settings_apps_freezer"));

        initHook(new UnlockSuperResolution(), mPrefsMap.getBoolean("system_settings_ai_image_unlock_sr"));
        initHook(new UnlockAi(), mPrefsMap.getBoolean("system_settings_ai_image_unlock_ai"));
        initHook(new UnlockMemc(), mPrefsMap.getBoolean("system_settings_ai_image_unlock_memc"));
        initHook(UnLockAreaScreenshot.INSTANCE, mPrefsMap.getBoolean("system_settings_area_screenshot"));
        initHook(NoveltyHaptic.INSTANCE, mPrefsMap.getBoolean("system_settings_novelty_haptic"));

        if (!isAndroidR()) {
            initHook(UnlockTaplusForSettings.INSTANCE, mPrefsMap.getBoolean("content_extension_unlock_taplus"));
        }

        if (!isMoreAndroidVersion(33)) {
            initHook(UnlockKnuckleFunction.INSTANCE, mPrefsMap.getBoolean("system_settings_knuckle_function"));
        }
    }
}

