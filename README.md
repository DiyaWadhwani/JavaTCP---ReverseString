# Java TCP Reverse String

This project implements a simple TCP client-server application in Java that communicates over a network. The client sends a string to the server, which processes it by reversing the characters and changing the capitalization. The processed string is then sent back to the client.

## Components

- **Client**: Sends a string to the server and receives the processed string.
- **Server**: Listens for client connections, processes the received string, and sends back the result.

## Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Basic understanding of Java programming and command-line usage.

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd JavaTCP-ReverseString
```

### 2. Start the Server

```bash
java Server <port>
```

Example:

```bash
java Server 32000
```

### 3. Start the Client

```bash
java Client <server IP> <port>
```

Example:

```bash
java Client 127.0.0.1 32000
```

### 4. Enter Your Text
When prompted, enter a string (up to 80 characters) to be processed by the server.

### 5. View the Response
The client will display the processed string received from the server.

### Input String Validation
The client prompts for input and ensures that the user input is taken correctly. Make sure the string does not exceed 80 characters.

