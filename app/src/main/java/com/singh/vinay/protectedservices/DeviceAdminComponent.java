package com.singh.vinay.protectedservices;
import android.app.Dialog;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
public class DeviceAdminComponent extends DeviceAdminReceiver {
	private static final String OUR_SECURE_ADMIN_PASSWORD = "12345";
	public CharSequence onDisableRequested(Context context, Intent intent) {
        ComponentName localComponentName = new ComponentName(context, DeviceAdminComponent.class);
        DevicePolicyManager localDevicePolicyManager = (DevicePolicyManager)context.getSystemService(Context.DEVICE_POLICY_SERVICE );
        if (localDevicePolicyManager.isAdminActive(localComponentName))
        {
            localDevicePolicyManager.setPasswordQuality(localComponentName, DevicePolicyManager.PASSWORD_QUALITY_NUMERIC);
        }
        intent = new Intent(context,NewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        //localDevicePolicyManager.lockNow();
     /*   // resetting user password
        localDevicePolicyManager.resetPassword(OUR_SECURE_ADMIN_PASSWORD, DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY);
        // locking the device
        */
        return super.onDisableRequested(context, intent);
	}
}
