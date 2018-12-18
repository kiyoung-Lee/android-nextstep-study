// IRemoteService.aidl
package com.example.luke.myapplication;

// Declare any non-default types here with import statements

interface IRemoteService {
    boolean validCalendar(long calendarId, String calendarType);
}
