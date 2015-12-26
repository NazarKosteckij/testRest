package com.test.rest.mocks;

import com.test.rest.services.EmailService;

/**
 * Created by Назар on 26.12.2015.
 */
public class MailServiceMock implements EmailService{
    @Override
    public void sendNotification(String email, String message) {

    }

    @Override
    public void sendConfirmation(String email, String link) {

    }
}
