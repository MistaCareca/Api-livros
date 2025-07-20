-- Criação da tabela book
CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    available BOOLEAN DEFAULT true,
    category VARCHAR(50)
    CONSTRAINT uk_book_isbn UNIQUE (isbn)
);

-- Criação da tabela user
CREATE TABLE "user" (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    CONSTRAINT uk_user_username UNIQUE (username),
    CONSTRAINT uk_user_email UNIQUE (email)
);

-- Criação da tabela loan
CREATE TABLE loan (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    loan_date TIMESTAMP NOT NULL,
    due_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP,
    fine DECIMAL(10,2),
    CONSTRAINT fk_loan_user FOREIGN KEY (user_id) REFERENCES "user"(id),
    CONSTRAINT fk_loan_book FOREIGN KEY (book_id) REFERENCES book(id)
);

-- Criação da tabela review
CREATE TABLE review (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <= 5),
    comment VARCHAR(500),
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES "user"(id),
    CONSTRAINT fk_review_book FOREIGN KEY (book_id) REFERENCES book(id)
);