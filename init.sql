
-- Conectar a la db para comenzar a ejecutar comandos.
\c OkaneDev;

-- Crear la tabla Expenses
CREATE TABLE Expenses (
    Id INTEGER,
    Amount INTEGER,
    Category VARCHAR(255),
    Description TEXT,
    CreatedAt TIMESTAMP,
    InvoiceUrl TEXT,
    UpdatedAt TIMESTAMP

);

-- Para no tener la db vacia
INSERT INTO Expenses (Id, Amount, Category, Description, CreatedAt, InvoiceUrl, UpdatedAt)
VALUES (1,7500, 'Diversion', 'Tomar cerveza en el Hacker and founder', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'http://www.hackerAndFounders.com/invoice1');


