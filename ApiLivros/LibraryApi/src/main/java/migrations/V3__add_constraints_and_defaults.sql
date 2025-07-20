-- Torna as colunas obrigatórias (NOT NULL) e ajusta tamanhos máximos
ALTER TABLE book
    MODIFY COLUMN title VARCHAR(100) NOT NULL,
    MODIFY COLUMN author VARCHAR(50) NOT NULL,
    MODIFY COLUMN isbn VARCHAR(13) NOT NULL,
    MODIFY COLUMN category VARCHAR(50),
    MODIFY COLUMN publication_year INT,
    MODIFY COLUMN available BOOLEAN DEFAULT true;

-- Garante que ISBNs sejam únicos
ALTER TABLE book
    ADD CONSTRAINT unique_isbn UNIQUE (isbn);
