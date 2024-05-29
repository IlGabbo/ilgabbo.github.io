-- Inserimento dei dati

-- Generi
INSERT INTO genre (name) VALUES 
('Action'),
('Comedy'),
('Drama'),
('Horror'),
('Sci-Fi');

-- Film
INSERT INTO movie (title, synopsys, releaseYear) VALUES 
('Action Movie 1', 'An action-packed adventure.', 2020),
('Comedy Movie 1', 'A hilarious comedy.', 2019),
('Drama Movie 1', 'A touching drama.', 2018),
('Horror Movie 1', 'A terrifying horror film.', 2021),
('Sci-Fi Movie 1', 'A futuristic sci-fi adventure.', 2022),
('Action Movie 2', 'Another action-packed adventure.', 2021),
('Comedy Movie 2', 'Another hilarious comedy.', 2020);

-- Persone
INSERT INTO person (name, middle_name, surname, bDate, category) VALUES 
('John', NULL, 'Doe', '1980-01-01', 'actor'),
('Jane', 'A.', 'Smith', '1990-02-02', 'actor'),
('Emily', NULL, 'Johnson', '1985-03-03', 'actor'),
('Michael', 'B.', 'Brown', '1975-04-04', 'director'),
('Sarah', NULL, 'Davis', '1988-05-05', 'director'),
('Chris', NULL, 'Evans', '1983-06-06', 'actor'),
('Robert', NULL, 'Downey', '1965-07-07', 'actor'),
('Scarlett', NULL, 'Johansson', '1984-08-08', 'actor');

-- Utenti
INSERT INTO user (name, lastname, email, password) VALUES 
('Alice', 'Wonderland', 'alice@example.com', 'password1'),
('Bob', 'Builder', 'bob@example.com', 'password2'),
('Charlie', 'Chocolate', 'charlie@example.com', 'password3'),
('Dave', 'Developer', 'dave@example.com', 'password4'),
('Eve', 'Hacker', 'eve@example.com', 'password5');

-- Associazioni (Interprets)
INSERT INTO interprets (actor, movie) VALUES 
(1, 1), -- John Doe in Action Movie 1
(2, 2), -- Jane Smith in Comedy Movie 1
(3, 3), -- Emily Johnson in Drama Movie 1
(6, 4), -- Chris Evans in Horror Movie 1
(7, 5), -- Robert Downey in Sci-Fi Movie 1
(8, 6), -- Scarlett Johansson in Action Movie 2
(1, 7), -- John Doe in Comedy Movie 2
(2, 5), -- Jane Smith in Sci-Fi Movie 1
(3, 6); -- Emily Johnson in Action Movie 2

-- Associazioni (Directs)
INSERT INTO directs (director, movie) VALUES 
(4, 1), -- Michael Brown directs Action Movie 1
(5, 2), -- Sarah Davis directs Comedy Movie 1
(4, 3), -- Michael Brown directs Drama Movie 1
(5, 4), -- Sarah Davis directs Horror Movie 1
(4, 5), -- Michael Brown directs Sci-Fi Movie 1
(5, 6), -- Sarah Davis directs Action Movie 2
(4, 7); -- Michael Brown directs Comedy Movie 2

-- Associazioni (Genres)
INSERT INTO genres (genre, movie) VALUES 
(1, 1), -- Action genre for Action Movie 1
(2, 2), -- Comedy genre for Comedy Movie 1
(3, 3), -- Drama genre for Drama Movie 1
(4, 4), -- Horror genre for Horror Movie 1
(5, 5), -- Sci-Fi genre for Sci-Fi Movie 1
(1, 6), -- Action genre for Action Movie 2
(2, 7); -- Comedy genre for Comedy Movie 2

-- Film guardati dagli utenti
INSERT INTO watched_movies (user, movie) VALUES 
(1, 1), -- Alice watched Action Movie 1
(1, 2), -- Alice watched Comedy Movie 1
(2, 2), -- Bob watched Comedy Movie 1
(2, 3), -- Bob watched Drama Movie 1
(3, 3), -- Charlie watched Drama Movie 1
(3, 4), -- Charlie watched Horror Movie 1
(4, 4), -- Dave watched Horror Movie 1
(4, 5), -- Dave watched Sci-Fi Movie 1
(5, 5), -- Eve watched Sci-Fi Movie 1
(5, 6), -- Eve watched Action Movie 2
(1, 6), -- Alice watched Action Movie 2
(2, 7), -- Bob watched Comedy Movie 2
(3, 7), -- Charlie watched Comedy Movie 2
(4, 1), -- Dave watched Action Movie 1
(5, 2); -- Eve watched Comedy Movie 1