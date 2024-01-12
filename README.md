# advertisement_system_pzaw

# Termin 05.11.2023 - Wstepny projekt bazy danych

Moja baza danych (pgsql) jest realizowana [migracjami liquibase](backend/SystemOgloszeniowy/src/main/resources/db/changelog/)

Ale przygotowałem 2 zrzuty ekranu [ERD1](backend/SystemOgloszeniowy/ERD1.png) [ERD2](backend/SystemOgloszeniowy/ERD2.png) schematów ERD wygenerowanych w pgAdmin 4 oraz [backup bazy danych](backend/SystemOgloszeniowy/system_ogloszeniowy_db_backup.sql), ale niestety phpmyadmin, go nie trawi.

Dlatego najlepszym źródłem będą schematy ERD

# Termin 03.12.2023 - Widok strony głównej, profilu użytkownika i oferty pracy

[Frontend](https://github.com/aruk3101/advertisement_system_pzaw/tree/0aae4eff5defaf1642af15dd547fafaa75a7c721/frontend/advertisement_system_pzaw_front) jest zrobiony w react + webpack.

Żeby odpalić wymagany jest nodejs i trzeba wpisać komendy npm install oraz npm start.

* Pod linkiem http://localhost:3000/ jest strona główna.
* Pod linkiem http://localhost:3000/user/profile jest strona użytkownika.
* Pod linkiem http://localhost:3000/advertisement/some-uuid jest strona ogłoszenia.
