import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

//needed for java stuff

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

//needed to handle getting oauth working with the google sheets api

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

//more dependencies to cover working with the sheets api and services



public class sheetsDatabase {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Game Statistics Database";
    private static String SPREADSHEET_ID = "1tU4Fj2Y30mREPJrYa2z3Cv3Jh5vpxwV-ark-AUqW7i0";

    private static Credential authorize() throws IOException, GeneralSecurityException {
        InputStream in = sheetsDatabase.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("Offline")
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;

    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

    }

    public static ObservableList<PlayerRow> loadBoard() throws IOException, GeneralSecurityException {
        ObservableList<PlayerRow> playerList = FXCollections.observableArrayList();

        sheetsService = getSheetsService();
        // Reads data already written in google sheets
        String range = "Sheet1!A2:L";
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if(values == null || values.isEmpty()) {
            System.out.println("No data found");
        } else {
            System.out.println("Name, Place, Time:");

            for (List row: values) {

                String firstName = (String) row.get(0);
                String lastName = (String) row.get(1);
                String number = (String) row.get(2);
                String assist = (String) row.get(3);
                String crosses = (String) row.get(4);
                String dribbles = (String) row.get(5);
                String goals = (String) row.get(6);
                String passes = (String) row.get(7);
                String shots = (String) row.get(8);
                String tackles = (String) row.get(9);
                String touches = (String) row.get(10);
                String total = (String) row.get(11);

                playerList.add(new PlayerRow(firstName, lastName, number, assist, crosses, dribbles, goals, passes, shots, tackles, touches, total));

            }
        }

        return playerList;
    }

    public static void write(ValueRange appendBody) throws IOException, GeneralSecurityException {
        // To write new data to sheets:
        sheetsService = getSheetsService();

        AppendValuesResponse appendResults = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "Sheet1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        sheetsService = getSheetsService();
        String range = "game!B2:D3"; //don't forget to change this value later for the range

        //read data from spreadsheet

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                System.out.printf("%s %s with number %s\n", row.get(1), row.get(2), row.get(3));
            }
        }

        //insert/write data to spreadsheet

        ValueRange appendBody = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Writing data")
                ));
        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "put in here the range later", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();


        //update data thats in the spreadsheet

        ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("insert the value that is desired to be changed")
                ));
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "range of the value", body)
                .setValueInputOption("desired change of the value")
                .execute();


        //delete data from spreadsheet

        DeleteDimensionRequest deleteRequest = new DeleteDimensionRequest()
                .setRange(
                        new DimensionRange()
                            .setSheetId(0) //needs to be updated after getting spreadsheet
                            .setDimension("Insert value here for what to be deleted")
                            .setStartIndex(0) //row to be delete
                );

        //batch update request, bunch of requests to work sequencionally

        List<Request> requests = new ArrayList<>();
        requests.add(new Request().setDeleteDimension(deleteRequest));

        BatchUpdateSpreadsheetRequest bodyRequest = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID, bodyRequest).execute();

    }



}
