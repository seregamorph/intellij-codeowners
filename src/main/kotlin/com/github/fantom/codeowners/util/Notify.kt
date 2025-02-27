package com.github.fantom.codeowners.util

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationListener
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project

/**
 * Wrapper function for showing notification.
 */
object Notify {

    private const val NOTIFICATION_GROUP_ID = ".ignore"

    /**
     * Shows notification.
     *
     * @param project  current project
     * @param title    notification title
     * @param content  notification text
     * @param type     notification type
     * @param listener optional listener
     */
    fun show(project: Project, title: String, content: String, type: NotificationType, listener: NotificationListener? = null) {
        val notification = NotificationGroupManager.getInstance()
            .getNotificationGroup(NOTIFICATION_GROUP_ID)
            .createNotification(title, content, type, listener)
        Notifications.Bus.notify(notification, project)
    }
}
