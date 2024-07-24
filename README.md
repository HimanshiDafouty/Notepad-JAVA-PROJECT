# Simple Text Editor (Notepad)

## Overview

This Java-based text editor mimics the functionality of Windows Notepad. Built with Swing, it provides essential text-editing features including creating, opening, saving, printing, copying, pasting, cutting, and selecting text.

## Features

- **File Operations**:
  - Create new documents
  - Open existing `.txt` files
  - Save changes
  - Print content
  - Exit the application

- **Editing Operations**:
  - Copy text
  - Paste text
  - Cut text
  - Select all content

- **Help Menu**:
  - Displays an About dialog with version information and a brief description

## User Interface

- **Menu Bar**: Contains File, Edit, and Help menus with relevant actions
- **Text Area**: For text input and editing, with support for line and word wrapping
- **Scroll Pane**: Provides scrolling functionality for large documents

## Technical Details

- **Java Swing**: Uses Swing components like `JFrame`, `JTextArea`, and `JFileChooser`
- **File Handling**: Supports `.txt` file operations with `BufferedReader` and `BufferedWriter`
- **Action Handling**: Manages actions through `ActionListener` for menu interactions
