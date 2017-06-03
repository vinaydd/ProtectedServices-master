package com.singh.vinay.protectedservices;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			// Initiate DevicePolicyManager.
			DevicePolicyManager policyMgr = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
			// Set DeviceAdminDemo Receiver for active the component with different option
			ComponentName componentName = new ComponentName(this, DeviceAdminComponent.class);
			if (!policyMgr.isAdminActive(componentName)) {
				// try to become active
				Intent intent = new Intent(	DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,	componentName);
				intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
						"Click on Activate button to protect your application from uninstalling!");
				startActivity(intent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		startService(new Intent(this, BackgroundService.class));
	}
}
