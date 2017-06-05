package com.RssList;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


/*
 * add this class to your src and just call "NotificationHelper.notify();" with valid argument.
 */


public class NotificationHelper {

	private static final int MY_NOTIFICATION_ID = 123456;// must be unique
	
	/*
	 *notify method arges
	 *
	 * context-> application context
	 * icon->drawable resource display icon of notification
	 * notificationTitle->title shown on notification
	 * notificationText->description text of notification
	 * myIntent->intent of activity which open when notification is clicked
	 */
	

	public static void notify(Context context, int icon,
			String notificationTitle, String notificationText, Intent myIntent) {

		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification myNotification = new Notification(icon, "Notification!",
				System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				myIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
		myNotification.defaults |= Notification.DEFAULT_SOUND;
		myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
		myNotification.setLatestEventInfo(context, notificationTitle,
				notificationText, pendingIntent);
		notificationManager.notify(MY_NOTIFICATION_ID, myNotification);
	}
}
