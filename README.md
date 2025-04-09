# Download Manager

A full-featured, multithreaded Download Manager built in Java. This desktop application offers concurrent download execution, scheduling, persistent storage of session data, blacklist filtering, and a custom Swing-based graphical interface. It was developed over three phases with increasing complexity, following object-oriented design and modular principles.

---

## Features

- Multithreaded downloads using `HttpURLConnection`
- Configurable limit for simultaneous downloads
- Persistent session state with `.jdm` file storage
- Download scheduling: delayed or timed
- Full queue management: pause, resume, remove, cancel
- Sorting and filtering by file name, size, and date
- Search functionality within active and queued downloads
- GUI with menu bar, toolbar, settings window, and system tray support
- Blacklist management for unwanted download links
- Multi-language support (English and Persian)
- Export all session data to a compressed `.zip` archive

---

## Technologies

- Java (Swing for GUI, core libraries for networking and I/O)
- Multithreading with thread-safe execution
- File I/O for persistent `.jdm` format
- HTTP/HTTPS protocol handling

---

## Project Structure

This project was developed across three structured phases:

### Phase 1 – GUI and Basic Controls
- Custom Swing interface
- Toolbar and menu bar with essential actions
- Download list with live progress bar and speed display
- Tray icon integration
- Basic settings (download location, concurrent download limit, look-and-feel)
- Support for scheduling future downloads

### Phase 2 – Persistence and Extended Functionality
- Save/load session state (`list.jdm`, `queue.jdm`, `removed.jdm`, `settings.jdm`, `filter.jdm`)
- Blacklist filtering system
- Search and sort within the GUI
- Export project state to `.zip`
- Language toggle with external translation files

### Phase 3 – Multithreading and Networking
- Fully concurrent download logic with thread pool
- Respect user-defined limits on simultaneous downloads
- Graceful recovery after failures or restarts
- HTTP/HTTPS protocol support
- Queued downloads processed intelligently as slots free up

