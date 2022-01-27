package com.example.myapplication1;


import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

    public class ShellExecuter {

        public ShellExecuter() {

        }

        public String Executer(String command) {

            StringBuffer output = new StringBuffer();

            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";
                while ((line = reader.readLine())!= null) {
                    output.append(line + "n");
                    Log.e("Hello",   line );
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Hello","     error: ");
            }
            String response = output.toString();
            return response;

        }
    }

