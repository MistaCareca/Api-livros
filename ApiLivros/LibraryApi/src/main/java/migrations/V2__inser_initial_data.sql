-- Inserção de dados iniciais na tabela book
INSERT INTO book (title, author, isbn, publication_year, available, category)
VALUES
    ('Clean Code', 'Robert Martin', '9780132350884', 2008, TRUE, 'Programming'),
    ('The Pragmatic Programmer', 'Andrew Hunt', '9780135957059', 2019, TRUE, 'Programming'),
    ('Design Patterns', 'Erich Gamma', '9780201633610', 1994, FALSE, 'Software Engineering');

-- Inserção de dados iniciais na tabela user
INSERT INTO "user" (username, password, email, full_name)
VALUES
    ('john_doe', '$2a$10$exampleHashedPassword', 'john.doe@example.com', 'John Doe'),
    ('jane_smith', '$2a$10$exampleHashedPassword', 'jane.smith@example.com', 'Jane Smith');

-- Inserção de dados iniciais na tabela loan
INSERT INTO loan (user_id, book_id, loan_date, due_date, return_date, fine)
VALUES
    ((SELECT id FROM "user" WHERE username = 'john_doe'),
     (SELECT id FROM book WHERE isbn = '9780201633610'),
     '2025-07-01 10:00:00', '2025-07-15 23:59:59', NULL, NULL);

-- Inserção de dados iniciais na tabela review
INSERT INTO review (user_id, book_id, rating, comment, created_at)
VALUES
    ((SELECT id FROM "user" WHERE username = 'john_doe'),
     (SELECT id FROM book WHERE isbn = '9780132350884'),
     5, 'Excellent book on writing clean code!', '2025-07-10 14:30:00');
