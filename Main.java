package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static String generate(int lenght){
        String lover="abcdefghijklmnopqrstuvwxyz";
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbs="0123456789";
        String special="`~!@#$%^&*()_-+={}[]\\|:;\"'<>,.?/";
        String password="";
        Random rd= new Random();
        for(int i=0;i<lenght*0.3;i++){
            password+=special.charAt(rd.nextInt(special.length()));
        }
        for(int i=0;i<lenght*0.2;i++){
            password+=numbs.charAt(rd.nextInt(numbs.length()));
        }
        while (password.length()<lenght){
            switch (rd.nextInt(4)) {
                case 0:password+=lover.charAt(rd.nextInt(lover.length())); break;
                case 1:password+=upper.charAt(rd.nextInt(upper.length())); break;
                case 2:password+=numbs.charAt(rd.nextInt(numbs.length())); break;
                case 3:password+=special.charAt(rd.nextInt(special.length())); break;
            }
        }
        List<String> str= Arrays.asList(password.split(""));
        Collections.shuffle(str);
        return str.stream().map(n->String.valueOf(n)).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Password generator");
        //set size and location of frame
        f.setSize(390, 300);
        f.setLocation(100, 150);
        //make sure it quits when x is clicked
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set look and feel
        f.setDefaultLookAndFeelDecorated(true);
        JLabel labelM = new JLabel("Such passwords, much wow");
        labelM.setBounds(50, 50, 200, 30);
        JTextField motto1 = new JTextField("Length of password");

        JTextField output = new JTextField("Your password");
       output.setEditable(false);
        //set size of the text box
        motto1.setBounds(50, 100, 200, 30);
        output.setBounds(50, 130, 200, 30);
        //add elements to the frame
        f.add(labelM);
        f.add(motto1);
        f.add(output);
        f.setLayout(null);
        f.setVisible(true);
        JButton b = new JButton("Generate");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(motto1.getText());
               output.setText(generate(Integer.parseInt(motto1.getText())));
            }
        });
        b.setBounds(50, 170, 100, 30);
//add button to the frame
        f.add(b);
    }

    }






