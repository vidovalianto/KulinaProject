package com.github.mhanifsp.sainsmanajemen;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanif on 10/29/2017.
 */
public class Input {
    public static List<Customer> getCcustomerInput(Context context){
        String customerFileName = "customer.in";
        String line = null;
        List<Customer> list = new ArrayList<>();

        try {
            final InputStream file = context.getResources().openRawResource(R.raw.costumer);

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(file));

            while((line = bufferedReader.readLine()) != null) {

                String[] splitted = line.split(" ");

                Customer c = new Customer(splitted[0],Double.parseDouble(splitted[2]),Double.parseDouble(splitted[1]),Integer.parseInt(splitted[3]));
                list.add(c);

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            customerFileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + customerFileName + "'");
        }

        return list;
    }

    public static List<Dapur> getDapurInput(Context context){
        String dapurFileName = "raw/dapur.txt";
        String line;

        List<Dapur> list = new ArrayList<>();

        try {
            final InputStream file = context.getResources().openRawResource(R.raw.dapur);

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(file));

            while((line = bufferedReader.readLine()) != null) {

                String[] splitted = line.split(",");

                Dapur d = new Dapur(splitted[0],Double.parseDouble(splitted[2]),Double.parseDouble(splitted[1]),Integer.parseInt(splitted[3]),Integer.parseInt(splitted[4]));
                list.add(d);

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            dapurFileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + dapurFileName + "'");
        }

        return list;
    }
}
