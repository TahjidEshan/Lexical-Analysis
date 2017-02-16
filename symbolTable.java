/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lexicalanalysis;

/**
 *
 * @author eshan
 */
import java.io.*;
import java.util.*;

public class symbolTable {

    private BufferedReader reader;

    private ArrayList<String> keywords = new ArrayList();
    private ArrayList<String> operators = new ArrayList();
    private ArrayList<String> logics = new ArrayList();
    private ArrayList<String> identifiers = new ArrayList();
    private ArrayList<String> numericals = new ArrayList();
    private ArrayList<String> others = new ArrayList();
    private test List = new test();

    public symbolTable() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("input.txt");
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(1);
        }
        reader = new BufferedReader(new InputStreamReader(fin));
        try {
            scanTokenss();
        } catch (IOException ex) {
        }

    }

    private void scanTokenss() throws IOException {
        String line = reader.readLine();
        while (line != null) {
            StringTokenizer tokenBucket = new StringTokenizer(line, " ");
            while (tokenBucket.hasMoreTokens()) {
                String currentToken = tokenBucket.nextToken();
                if (List.inKeywords(currentToken)) {
                    keywords.add(currentToken);
                } else if (List.inLogics(currentToken)) {
                    logics.add(currentToken);
                } else if (List.inOperators(currentToken)) {
                    operators.add(currentToken);
                } else if (List.inOthers(currentToken)) {
                    others.add(currentToken);
                } else {
                    if (currentToken.matches("[a-zA-Z]+[a-zA-Z0-9]*")) {
                        identifiers.add(currentToken);
                    } else if (currentToken.matches("[0-9]+.*[0-9]*")) {
                        numericals.add(currentToken);
                    }
                }

            }
            line = reader.readLine();
        }
    }

    public void printKeywords() {
        Set<String> uniqueKey = new HashSet<>(keywords);
        Set<String> uniqueLog = new HashSet<>(logics);
        Set<String> uniqueMat = new HashSet<>(operators);
        Set<String> uniqueOth = new HashSet<>(others);
        Set<String> uniqueNum = new HashSet<>(numericals);
        Set<String> uniqueId = new HashSet<>(identifiers);
        System.out.print("Keyword: ");
        Iterator<String> itk = uniqueKey.iterator();
        while (itk.hasNext()) {
            String s = itk.next();
            System.out.print(s);
            if (itk.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("\nIdentifiers: ");

        Iterator<String> itI = uniqueId.iterator();
        while (itI.hasNext()) {
            String s = itI.next();
            System.out.print(s);
            if (itI.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("\nMathematical Operators: ");
        Iterator<String> itM = uniqueMat.iterator();
        while (itM.hasNext()) {
            String s = itM.next();
            System.out.print(s);
            if (itM.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("\nLogical Operators: ");
        Iterator<String> itL = uniqueLog.iterator();
        while (itL.hasNext()) {
            String s = itL.next();
            System.out.print(s);
            if (itL.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("\nNumericals: ");
        Iterator<String> itN = uniqueNum.iterator();
        while (itN.hasNext()) {
            String s = itN.next();
            System.out.print(s);
            if (itN.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.print("\nOthers: ");
        uniqueOth.stream().forEach((s) -> {
            System.out.print(s + " ");
        });
    }
}
