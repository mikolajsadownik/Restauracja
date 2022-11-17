# Restauracja
 Projekt realizowany w ramach przedmiotu na Polsko-Japońskiej Akademii Technik Komputerowych o nazwie - programowanie obiektowe i GUI.
 # Projekt wykorzystuje między innymi:
 •Dziedziczenie
 •Kolekcje 
 •Interfejsy 
 •Klasy abstrakcyjne 
 •Lambda-wyrażenia  
 •Strumienie 
 # Szczegółowy opis projektu
Restauracja otrzymuje zamówienia zarówno od klientów stacjonarnych, jak i zamówienia otrzymywane poprzez portal oznaczone jako zamówienia z opcją dostawy. Każde zamówienie posiada określoną liczbę zamówionych pozycji z menu restauracji. Menu restauracji składa się z pozycji, z których każdajest reprezentowana poprzez swój unikalny numer,nazwę,krótki opis dania oraz cenę. Zamówienia stacjonarne posiadają informację o numerze stolika, natomiast zamówienia otrzymane zdalne informację o adresie dostawy. Ponadto każde zamówienie posiada swój własny unikalny numer, zgodny z kolejnością tj. drugie zamówienie w danym dniu posiada numer 2, oraz godzinę wraz z minutami o której zostało złożone. Menu, jest podstawą pomagającą klientom w wyborze zamówienia. Restauracja ma możliwość dodania pozycji do menu, wyrzucenia ich oraz możliwość oznaczenia iż dana pozycja jest aktualnie niedostępna. Program, pomaga restauracji w organizacji zamówień. Zamówienia powinny są realizowane w odpowiedniej kolejności. W pierwszej kolejności realizowane są zamówienia które zostały złożone przez klientów stacjonarnych, a w drugiej kolejności zamówienia złożone zdalnie. Jako drugie kryterium uwzgędnia się kolejność zamówień tzn. w przypadku dwóch zamówień złożonych tą samą drogą, pierwsze złożone zamówienie jest realizowane w pierwszej kolejności. Kuchnia, będzie realizowała przychodzące zamówienia w konkretnych przedziałach czasowych. Przyjmujemy, iż kuchnia jest w stanie w ciągu 30s przygotować jedną pozycję z menu. Każdy kucharz pracujący w kuchni, ma wpływ na czas realizacji zamówień, dlatego każdy pracujący w kuchni kucharz obniża czas realizacji zamówień kuchni o określoną ilość. Funkcjonalności programu jest w pełni obsługiwana za pomocą konsoli CLI. 
# Funkcjonalności programu: 
•Wypisania wszystkich pozycji z aktualnego Menu
•Dodawania/Usuwanie pozycji z aktualnego Menu
•Oznaczenie danej pozycji z Menu jako niedostępnej
•Zapisanie/Wczytanie aktualnego Menu do/z pliku
•Złożenia zamówienia(wraz z wyborem typu oraz zawartych dań)
•Złożenie losowego zamówienia
•Wypisania zamówień które czekają na realizację
•Zatrudnienie nowego pracownika
•Wyrzucenie istniejącego pracownika
•Wylistowanie wszystkich pracowników

