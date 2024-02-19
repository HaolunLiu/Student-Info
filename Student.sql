CREATE TABLE Student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    weight INT NOT NULL,
    height INT NOT NULL,
    hair_color VARCHAR(50),
    gpa DECIMAL(3, 2),
    favorite_subject VARCHAR(255),
    graduation_year INT,
    email VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE,
    enrollment_date DATE,
);