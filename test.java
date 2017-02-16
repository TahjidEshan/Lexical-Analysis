/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lexicalanalysis;

import java.io.*;

/**
 *
 * @author eshan
 */
public class test {

    BufferedReader reader;
    FileInputStream fin = null;

    boolean inKeywords(String token) throws IOException {
        try {
            fin = new FileInputStream("keywords.txt");
        } catch (Exception e) {
        }
        reader = new BufferedReader(new InputStreamReader(fin));
        String s = reader.readLine();
        while (s != null) {
            if (token.equals(s)) {
                return true;
            }
            s = reader.readLine();
        }
        return false;
    }

    boolean inOperators(String token) throws IOException {
        try {
            fin = new FileInputStream("operators.txt");
        } catch (Exception e) {
        }
        reader = new BufferedReader(new InputStreamReader(fin));
        String s = reader.readLine();
        while (s != null) {
            if (token.equals(s)) {
                return true;
            }
            s = reader.readLine();
        }
        return false;
    }

    boolean inLogics(String token) throws IOException {
        try {
            fin = new FileInputStream("logics.txt");
        } catch (Exception e) {
        }
        reader = new BufferedReader(new InputStreamReader(fin));
        String s = reader.readLine();
        while (s != null) {
            if (token.equals(s)) {
                return true;
            }
            s = reader.readLine();
        }
        return false;
    }

    boolean inOthers(String token) throws IOException {
        try {
            fin = new FileInputStream("others.txt");
        } catch (Exception e) {
        }
        reader = new BufferedReader(new InputStreamReader(fin));
        String s = reader.readLine();
        while (s != null) {
            if (token.equals(s)) {
                return true;
            }
            s = reader.readLine();
        }
        return false;
    }
}
