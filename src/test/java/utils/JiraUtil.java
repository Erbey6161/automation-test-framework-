package utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class JiraUtil {

    public static void createBug(String summary) {

        try {
            String url = "https://erenqa.atlassian.net/rest/api/3/issue";

            String email = "erenbodur64@gmail.com";
            String token = "ATATT3xFfGF0V8lzaIoInMSVXza5JxXJrcW-TrppHb06hZdBbwtKLDRj0GO6U_huIbUYG134xoEZctPSCBTly6iYZep6WMO2yA--S2wtLci8nte1w-1b7qWOkEyII1MIkcBs9nDhqnVTg7L1v4PAluX7c1cWgZ3pKPuL6eeTAC8MFMm40fc5vgA=BE24D0E1";

            String auth = Base64.getEncoder().encodeToString(
                    (email + ":" + token).getBytes()
            );

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + auth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String body = "{\n" +
                    "  \"fields\": {\n" +
                    "    \"project\": {\"key\": \"QA\"},\n" +
                    "    \"summary\": \"" + summary + "\",\n" +
                    "    \"issuetype\": {\"name\": \"Bug\"}\n" +
                    "  }\n" +
                    "}";

            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();

            int responseCode = conn.getResponseCode();

            if (responseCode == 201) {
                System.out.println("✅ Jira bug created");
            } else {
                System.out.println("❌ Failed: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
