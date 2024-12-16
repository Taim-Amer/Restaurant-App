package utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class SMSService {

    public void sendSMS(String toPhoneNumber, String message) {
        try {
            String twilioAPIUrl = "";

            URL url = new URL(twilioAPIUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String data = "To=" + toPhoneNumber + "&From=your_twilio_number&Body=" + message;

            connection.getOutputStream().write(data.getBytes("UTF-8"));

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("SMS sent successfully!");
            } else {
                System.out.println("Failed to send SMS. Response Code: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//https://api.twilio.com/2010-04-01/Accounts/your_account_sid/Messages.json
