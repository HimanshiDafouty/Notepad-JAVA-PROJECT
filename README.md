Project Description: Simple Text Editor (Notepad)
Overview
This Java-based text editor mimics the functionality of Windows Notepad. Built with Swing, it provides essential text-editing features including creating, opening, saving, printing, copying, pasting, cutting, and selecting text.

Features
File Operations: Create new documents, open existing .txt files, save changes, print content, and exit the application.
Editing Operations: Copy, paste, cut text, and select all content.
Help Menu: Displays an About dialog with version information and a brief description.
User Interface
Menu Bar: Contains File, Edit, and Help menus with relevant actions.
Text Area: For text input and editing, with support for line and word wrapping.
Scroll Pane: Provides scrolling functionality for large documents.
Technical Details
Java Swing: Uses Swing components like JFrame, JTextArea, and JFileChooser.
File Handling: Supports .txt file operations with BufferedReader and BufferedWriter.
Action Handling: Manages actions through ActionListener for menu interactions.
