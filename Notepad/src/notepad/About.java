package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 700,600);
        setLayout(null);

        // Adding the Windows logo
        ImageIcon windowsIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image windowsImage = windowsIcon.getImage().getScaledInstance(400, 80, Image.SCALE_DEFAULT);
        ImageIcon scaledWindowsIcon = new ImageIcon(windowsImage);
        JLabel windowsLabel = new JLabel(scaledWindowsIcon);
        windowsLabel.setBounds(150, 40, 400, 80);
        add(windowsLabel);

        // Adding the Notepad logo
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image notepadImage = notepadIcon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon scaledNotepadIcon = new ImageIcon(notepadImage);
        JLabel notepadLabel = new JLabel(scaledNotepadIcon);
        notepadLabel.setBounds(50, 180, 70, 70);
        add(notepadLabel);

        // Adding the text
        JLabel textLabel = new JLabel("<html>Microsoft Windows<br>Version 1.0(Himanshi Dafouty Build 2024)<br>&copy; 2024. All rights reserved.<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        textLabel.setBounds(150, 130, 500, 300);
        textLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(textLabel);

        // Adding the OK button
        JButton okButton = new JButton("OK");
        okButton.setBounds(580, 500, 80, 25);
        okButton.addActionListener(this);
        add(okButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
