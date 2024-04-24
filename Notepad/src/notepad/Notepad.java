package notepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

/**
 * This class represents a simple text editor application similar to Notepad. It
 * provides basic functionalities such as creating, opening, saving, printing,
 * copying, pasting, cutting, and selecting all text. Additionally, it includes
 * a help menu for user assistance.
 */
public class Notepad extends JFrame implements ActionListener {

    //Global defining textArea , text
    private JTextArea textArea;
    private String text="";

    /**
     * Constructing a new instance of the Notepad application.
     */
    public Notepad() {
        // Set title and icon
        setTitle("Notepad");
        setIconImage(new ImageIcon(getClass().getResource("/notepad/icons/notepad.png")).getImage());
        setSize(1950, 1050);
        setLayout(new BorderLayout());

        // Creating Menubar
        JMenuBar menuBar = new JMenuBar();
      

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont( new Font("Arial", Font.BOLD, 14));

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem printMenuItem = new JMenuItem("Print");
        printMenuItem.addActionListener(this);
        printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));

        // Adding menu items to File menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.add(exitMenuItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(this);
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(this);
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(this);
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JMenuItem selectAllMenuItem = new JMenuItem("Select All");
        selectAllMenuItem.addActionListener(this);
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        // Adding menu items to Edit menu
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(selectAllMenuItem);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem helpMenuItem = new JMenuItem("About");
        helpMenuItem.addActionListener(this);
        helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        // Adding menu items to Help menu
        helpMenu.add(helpMenuItem);

        // Adding menus to menuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Creating Text Area
        textArea = new JTextArea();
        textArea.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Creating Scroll Pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Adding Scroll Pane
        add(scrollPane);

        // Setting frame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Overriding the function within ActionListener interface
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("New")) {
            textArea.setText("");
        } else if (ae.getActionCommand().equals("Open")) {
            JFileChooser chooseFile = new JFileChooser();
            chooseFile.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
            chooseFile.addChoosableFileFilter(restrict);

            //Open Dialog box to select required file
            int action = chooseFile.showOpenDialog(this);

            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File file = chooseFile.getSelectedFile();
            try {
                //Read selected file
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.read(reader, null); //Setting it into textArea after reading

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getActionCommand().equals("Save")) {
            JFileChooser saveAs = new JFileChooser();
            saveAs.setApproveButtonText("Save");
            int action = saveAs.showOpenDialog(this);

            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File fileName = new File(saveAs.getSelectedFile() + ".txt");
            BufferedWriter outputFile = null;
            try {
                outputFile = new BufferedWriter(new FileWriter(fileName));
                textArea.write(outputFile);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getActionCommand().equals("Print")) {
            try {
                textArea.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else if (ae.getActionCommand().equals("Copy")) {
            text= textArea.getSelectedText();

        } else if (ae.getActionCommand().equals("Paste")) {
            textArea.insert(text , textArea.getCaretPosition());

        } else if (ae.getActionCommand().equals("Cut")) {
             text= textArea.getSelectedText();  //Copy
             textArea.replaceRange("" , textArea.getSelectionStart(), textArea.getSelectionEnd()); //Paste

        } else if (ae.getActionCommand().equals("Select All")) {
            textArea.selectAll();

        } else if (ae.getActionCommand().equals("About")) {
            new About().setVisible(true);
            

        }

    }

    /**
     * The main method to start the Notepad application.
     */
    public static void main(String[] args) {
        new Notepad();
    }
}
